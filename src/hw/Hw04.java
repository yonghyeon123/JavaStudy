package hw;
// datatype.Board를 사용한 게시판 예제 프로그램

import datatype.Board;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Hw04 {
    // 전역 변수
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Board> list = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        String message = "1. 새 글 등록 2. 글 목록보기 3. 종료";
        while(true){
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1){
                writeBoard();
            } else if(userChoice == 2){
                printList();
            } else if(userChoice == 3){
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private static void printList() {
        if(!list.isEmpty()){
            for(Board b : list){
                b.printShort();
            }

            String message = "상세보기할 글의 번호나 뒤로 가실려면 0을 입력해주세요.";
            int userInput = ScannerUtil.nextInt(scanner, message);

            while(userInput != 0 && selectOne(userInput) == null){
                System.out.println("잘못 입력하셨습니다.");
                userInput = ScannerUtil.nextInt(scanner, message);
            }

            if(userInput != 0){
                printOne(userInput);
            }

        } else {
            System.out.println("아직 등록된 글이 존재하지 않습니다.");
        }
    }

    private static void printOne(int id) {
        Board b = selectOne(id);
        b.printBoard();

        String message = "1. 수정 2. 삭제 3. 목록으로";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        if(userChoice == 1){
            update(id);
        } else if(userChoice == 2){
            delete(id);
        } else {
            printList();
        }
    }

    private static void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if(yesNo.equalsIgnoreCase("Y")){
            list.remove(selectOne(id));
            printList();
        } else {
            printOne(id);
        }
    }

    private static void update(int id) {
        Board b = selectOne(id);
        String message;
        message = "새로운 제목을 입력해주세요.";
        b.setTitle(ScannerUtil.nextLine(scanner, message));

        message = "새로운 내용을 입력해주세요.";
        b.setContent(ScannerUtil.nextLine(scanner, message));

        printOne(id);
    }


    private static void writeBoard() {
        Board b = new Board();
        b.setId(nextId++);

        String message;

        message = "글의 제목을 입력해주세요.";
        b.setTitle(ScannerUtil.nextLine(scanner, message));

        message = "글의 작성자를 입력해주세요.";
        b.setWriter(ScannerUtil.nextLine(scanner, message));

        message = "글의 내용을 입력해주세요.";
        b.setContent(ScannerUtil.nextLine(scanner, message));

        list.add(b);
    }

    private static Board selectOne(int id){
        Board temp = new Board();
        temp.setId(id);
        if(list.contains(temp)){
            return list.get(list.indexOf(temp));
        }
        return null;
    }
}















