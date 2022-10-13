package dbboard.viewer;

import connector.DBConnector;
import connector.MySqlConnector;
import dbboard.controller.ReplyController;
import dbboard.controller.UserController;
import dbboard.model.ReplyDTO;
import dbboard.model.UserDTO;
import util.ScannerUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ReplyViewer {
    private final String DATE_FORMAT= "yy년 MM월 dd일 HH시 mm분 ss초";
    private Scanner scanner;
    private DBConnector connector;
    private UserDTO logIn;
    private int boardId;

    public ReplyViewer(UserDTO logIn, int boardId){
        scanner = new Scanner(System.in);
        connector = new MySqlConnector();
        this.logIn = logIn;
        this.boardId = boardId;
    }

    public void showMenu(){
        BoardViewer boardViewer = new BoardViewer(logIn);
        String message = "1. 댓글쓰기 2. 댓글 목록 3. 뒤로가기";

        while(true){
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1){
                write();
            }
            else if(userChoice == 2){
                printList();
            }
            else if(userChoice == 3){
                System.out.println("뒤로 돌아갑니다.");
                break;
            }
        }
    }

    private void write(){
        ReplyDTO r = new ReplyDTO();
        r.setWriterId(logIn.getId());
        r.setBoardId(boardId);

        String message = "댓글을 입력하세요.";
        r.setContent(ScannerUtil.nextLine(scanner, message));

        ReplyController replyController = new ReplyController(connector);
        replyController.insert(r);
    }

    private void printList(){
        UserController userController = new UserController(connector);
        ReplyController replyController = new ReplyController(connector);
        ArrayList<ReplyDTO> list = replyController.selectAll();

        for(ReplyDTO r : list){
            if(r.getBoardId() == boardId){
                System.out.printf("%d, %s : %s\n", r.getId(), userController.selectNicknameById(r.getWriterId()), r.getContent());
            }
        }

        String message = "상세보기할 댓글의 번호나 0을 뒤로 가실려면 0을 입력하세요.";
        int userInput = ScannerUtil.nextInt(scanner, message);

        if(userInput != 0 && replyController.selectOne(userInput) == null){
            System.out.println("잘못 입력하셨습니다.");
            userInput = ScannerUtil.nextInt(scanner, message);
        }

        if(userInput != 0){
            printOne(userInput);
        }
    }

    private void printOne(int id){
        UserController userController = new UserController(connector);
        ReplyController replyController = new ReplyController(connector);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        ReplyDTO r = replyController.selectOne(id);

        System.out.println("댓글 번호 : " + r.getId());
        System.out.println("작성자 : " + userController.selectNicknameById(r.getWriterId()));
        System.out.println("댓글 작성일 : " + sdf.format(r.getWrittenDate()));
        System.out.println("댓글 수정일 : " + sdf.format(r.getUpdatedDate()));
        System.out.println("내용");
        System.out.println(r.getContent());

        String message = "1. 수정 2. 삭제 3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if(userChoice == 1){
            update(id);
        }
        else if(userChoice == 2){
            delete(id);
        }
        else if(userChoice == 3){
            System.out.println("뒤로 돌아갑니다.");
        }
    }

    private void update(int id){

    }

    private void delete(int id){

    }
}
