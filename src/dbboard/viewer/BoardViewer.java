package dbboard.viewer;

import connector.DBConnector;
import connector.MySqlConnector;
import dbboard.controller.BoardController;
import dbboard.model.BoardDTO;
import dbboard.model.UserDTO;
import util.ScannerUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardViewer {
    private Scanner scanner;
    private DBConnector connector;
    private UserDTO logIn;

    public BoardViewer(UserDTO logIn){
        scanner = new Scanner(System.in);
        connector = new MySqlConnector();
        this.logIn = logIn;
    }

    public void showMenu(){
        String message = "1. 새 글 등록 2. 글 목록보기 3. 뒤로가기";

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
            for(BoardDTO b : list){
                System.out.printf("%d, %s - by %s\n", b.getId(), b.getTitle());
            }
        }
    }
}
