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
    private final String DATE_FORMAT= "yy-MM-dd HH:mm:ss";
    private Scanner scanner;
    private DBConnector connector;
    private UserDTO logIn;
    private int boardId;

    public ReplyViewer(UserDTO logIn){
        scanner = new Scanner(System.in);
        connector = new MySqlConnector();
        this.logIn = logIn;
    }

    public void showMenu(int boardId){
        BoardViewer boardViewer = new BoardViewer(logIn);
        String message = "1. 댓글 등록 2. 댓글 수정 3. 댓글 삭제 3. 뒤로가기";

        while(true){
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1){
                write(boardId);
                printList(boardId);
            }
            else if(userChoice == 2){
                message = "수정할 댓글의 번호나 뒤로 가실려면 0을 입력해주세요.";
                userChoice = ScannerUtil.nextInt(scanner, message);

                if (userChoice != 0){
                    update(userChoice, boardId);
                }
                printList(boardId);
            }
            else if(userChoice == 3){
                message = "삭제할 댓글의 번호나 뒤로 가실려면 0을 입력해주세요.";
                userChoice = ScannerUtil.nextInt(scanner, message);

                if (userChoice != 0){
                    delete(userChoice, boardId);
                }
                printList(boardId);
            }
            else if(userChoice == 4){
                message = "다시 해당 게시글로 이동합니다.";
                break;
            }
        }
    }

    public void printList(int boardId){

        ReplyController replyController = new ReplyController(connector);
        ArrayList<ReplyDTO> list = replyController.selectAll(boardId);

        if(list.isEmpty()){
            System.out.println("아직 등록된 댓글이 없습니다.");
        }
        else{
            UserController userController = new UserController(connector);

            System.out.println("--------------------------------");
            for(ReplyDTO r : list){
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                String date = r.getWrittenDate().compareTo(r.getUpdatedDate()) == 0 ?
                        sdf.format(r.getWrittenDate()) : sdf.format(r.getUpdatedDate());

                System.out.printf("%d, %s - by [%s] at [%s]\n", r.getId(), r.getContent(),
                        userController.selectNicknameById(r.getWriterId()), date);
            }
            System.out.println("--------------------------------");
        }
    }

    private void write(int boardId){
        ReplyDTO r = new ReplyDTO();
        r.setWriterId(logIn.getId());
        r.setBoardId(boardId);

        String message = "댓글을 입력하세요.";
        r.setContent(ScannerUtil.nextLine(scanner, message));

        ReplyController replyController = new ReplyController(connector);
        replyController.insert(r);
    }

    private void update(int id, int boardId){
        ReplyController replyController = new ReplyController(connector);
        ReplyDTO r = replyController.selectOne(id);

        if(r != null && r.getWriterId() == logIn.getId() && r.getBoardId() == boardId){
            String message = "새로운 댓글 내용을 입력해주세요.";
            r.setContent(ScannerUtil.nextLine(scanner, message));

            replyController.update(r);
        }
        else{
            System.out.println("해당 작업을 진행할 수 없습니다.");
        }
    }

    private void delete(int id, int boardId){
        ReplyController replyController = new ReplyController(connector);
        ReplyDTO r = replyController.selectOne(id);

        if(r != null && r.getWriterId() == logIn.getId() && r.getBoardId() == boardId){
            String message = "해당 댓글을 정말 삭제하시겠습니까? Y/N";
            String yesNo = ScannerUtil.nextLine(scanner, message);

            if(yesNo.equalsIgnoreCase("Y")){
                replyController.delete(id);
            }
        }
        else{
            System.out.println("해당 작업을 진행할 수 없습니다.");
        }
    }
}
