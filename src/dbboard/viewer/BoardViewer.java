package dbboard.viewer;

import com.mysql.cj.protocol.x.XMessage;
import connector.DBConnector;
import connector.MySqlConnector;
import dbboard.controller.BoardController;
import dbboard.controller.UserController;
import dbboard.model.BoardDTO;
import dbboard.model.UserDTO;
import util.ScannerUtil;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardViewer {
    private final String DATE_FORMAT = "yy년 MM월 dd일 HH시 mm분 ss초";
    private Scanner scanner;
    private DBConnector connector;
    private UserDTO logIn;

    public BoardViewer(UserDTO logIn){
        scanner = new Scanner(System.in);
        connector = new MySqlConnector();
        this.logIn = logIn;
    }

    public void showMenu(){
        String message = "\n1. 새 글 등록 2. 글 목록보기 3. 뒤로가기";

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
        BoardDTO b = new BoardDTO();
        b.setWriterId(logIn.getId());

        String message = "글의 제목을 입력해주세요.";
        b.setTitle(ScannerUtil.nextLine(scanner, message));

        message = "글의 내용을 입력해주세요.";
        b.setContent(ScannerUtil.nextLine(scanner, message));

        BoardController boardController = new BoardController(connector);

        boardController.insert(b);
    }

    private void printList(){
        BoardController boardController = new BoardController(connector);

        ArrayList<BoardDTO> list = boardController.selectAll();

        if(list.isEmpty()){
            System.out.println("아직 등록된 글이 없습니다.");
        }
        else{
            UserController userController = new UserController(connector);

            System.out.println("\n--------------------------------");
            for(BoardDTO b : list){
                System.out.printf("%d, %s - by %s\n", b.getId(), b.getTitle(), userController.selectNicknameById(b.getWriterId()));
            }
            System.out.println("--------------------------------\n");

            String message = "상세보기할 글의 번호나 뒤로 가실려면 0을 입력해주세요.";
            int userInput = ScannerUtil.nextInt(scanner, message);

            while(userInput != 0 && boardController.selectOne(userInput) == null){
                System.out.println("잘못 입력하셨습니다.");
                userInput = ScannerUtil.nextInt(scanner, message);
            }

            if(userInput != 0){
                printOne(userInput);
            }
        }
    }

    private void printOne(int id){
        BoardController boardController = new BoardController(connector);
        UserController userController = new UserController(connector);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        BoardDTO b = boardController.selectOne(id);

        System.out.println("\n--------------------------------");
        System.out.println("제목 : " + b.getTitle());
        System.out.println("글 번호 : " + b.getId());
        System.out.println("작성자 : " + userController.selectNicknameById(b.getWriterId()));
        System.out.println("작성일 : " + sdf.format(b.getWrittenDate()));
        System.out.println("수정일 : " + sdf.format(b.getUpdatedDate()));
        System.out.println("내용");
        System.out.println(b.getContent());
        System.out.println("--------------------------------");
        System.out.println("댓글");

        ReplyViewer replyViewer = new ReplyViewer(logIn);
        replyViewer.printList(id);

        String message;
        if(logIn.getId() == b.getId()){
            message = "\n1. 수정 2. 삭제 3. 댓글 이동 4. 뒤로가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1){
                update(id);
            }
            else if(userChoice == 2){
                delete(id);
            }
            else if(userChoice == 3){
                replyViewer.showMenu(id);
                printOne(id);
            }
            else if(userChoice == 4){
                printList();
            }
        }
        else{
            message = "1. 댓글 메뉴 2. 뒤로 가기";
            int userchoice = ScannerUtil.nextInt(scanner, message);

            if(userchoice == 1){

            }
            else if(userchoice == 2){
                printOne(id);
            }
        }
    }

    private void update(int id){
        BoardController boardController = new BoardController(connector);
        BoardDTO b = boardController.selectOne(id);

        String message;
        message = "글의 새로운 제목을 입력해주세요.";
        b.setTitle(ScannerUtil.nextLine(scanner, message));
        message = "글의 새로운 내용을 입력해주세요.";
        b.setContent(ScannerUtil.nextLine(scanner, message));

        boardController.update(b);

        printOne(id);
    }

    private void delete(int id){
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if(yesNo.equalsIgnoreCase("Y")){
            BoardController boardController = new BoardController(connector);
            boardController.delete(id);
            printList();
        }
        else{
            printOne(id);
        }
    }
}
