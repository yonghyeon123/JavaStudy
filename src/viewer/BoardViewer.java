package viewer;

import controller.BoardController;
import model.BoardDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardViewer {
    private BoardController boardController;
    private Scanner scanner;

    public BoardViewer(){
        boardController = new BoardController();
        scanner = new Scanner(System.in);
    }

    public void showMenu(){
        String message = "작성자의 이름을 입력하시오.";
        String writer = ScannerUtil.nextLine(scanner, message);

        message = "1. 글쓰기 2. 글 목록 3. 종료";

        while(true){
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1){
                insertBoard(writer);
            }
            else if(userChoice == 2){
                printList();
            }
            else if(userChoice == 3){
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private void insertBoard(String writer){
        BoardDTO boardDTO = new BoardDTO();

        String message;

        boardDTO.setWriter(writer);

        message = "글 제목을 입력하세요.";
        boardDTO.setTitle(ScannerUtil.nextLine(scanner, message));

        message = "글 내용을 입력하세요.";
        boardDTO.setContent(ScannerUtil.nextLine(scanner, message));

        boardController.insert(boardDTO);
    }

    private void printList(){
        ArrayList<BoardDTO> list = boardController.selectAll();

        if(list.isEmpty()){
            System.out.println("아직 글이 등록되지 않았습니다.");
        }
        else{
            for(BoardDTO b : list){
                System.out.printf("%d번 글제목 : %s", b.getId(), b.getTitle());
            }

            String message = "상세보기할 글의 번호나 뒤로 가실거면 0을 입력하세요.";
            int userInput = ScannerUtil.nextInt(scanner, message);

            if(userInput != 0 && boardController.selectOne(userInput) == null){
                System.out.println("잘못 입력하였습니다.");
            }

            if(userInput != 0){
                printOne(userInput);
            }
        }
    }

    private void printOne(int id){
        BoardDTO b = boardController.selectOne(id);

        System.out.println("--------------------------");
        System.out.println(b.getId() + "번째 글정보");
        System.out.println("--------------------------");
        System.out.println(" 작성자 : " + b.getWriter());
        System.out.println("글 제목 : " + b.getTitle());
        System.out.println("글 내용 : " + b.getContent());
        System.out.println("--------------------------\n");

        String message = "1. 수정 2. 삭제 0. 로그아웃";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if(userChoice == 1){
            update(id);
        }
        if(userChoice == 2){
            delete(id);
        }
        else{
            showMenu();
        }
    }

    private void update(int id){

    }

    private void delete(int id){

    }
}
