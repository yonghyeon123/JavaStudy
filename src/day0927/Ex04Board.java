package day0927;
// 동적 할당 배열을 사용하여
// 게시판 프로그램을 작성하시오.
// 게시판 글에는
// 글 번호, 작성자, 글 제목, 글 내용의 정보가 들어가야 합니다.
// 1시까지
import util.ArrayUtil;
import util.ScannerUtil;

import java.util.Scanner;
public class Ex04Board {
    // 전역 변수
    public static Scanner scanner = new Scanner(System.in);
    public static int[] idArray = new int[0];
    public static String[] writerArray = new String[0];
    public static String[] titleArray = new String[0];
    public static String[] contentArray = new String[0];
    public static int nextId = 1;

    // main
    public static void main(String[] args) {
        showMenu();
    }

    // showMenu
    public static void showMenu() {
        String message = "1. 새 글 작성 2. 글 목록보기 3. 종료";
        while(true){
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if(userChoice == 1){
                writeBoard();
            } else if(userChoice == 2){

            } else if(userChoice == 3){
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public static void writeBoard() {
        idArray = ArrayUtil.add(idArray, nextId++);
        String message;

        message = "글의 제목을 입력해주세요.";
        titleArray = ArrayUtil.add(titleArray, ScannerUtil.nextLine(scanner, message));

        message = "글의 작성자를 입력해주세요.";
        writerArray = ArrayUtil.add(writerArray, ScannerUtil.nextLine(scanner, message));

        message = "글의 내용을 입력해주세요.";
        contentArray = ArrayUtil.add(contentArray, ScannerUtil.nextLine(scanner, message));
    }

    public static void printAll() {
        if(ArrayUtil.isEmpty(idArray)){
            System.out.println("아직 등록된 글이 존재하지 않습니다.");
        } else {
            for(int i = 0; i < ArrayUtil.size(idArray); i++){
                System.out.printf("%d. %s \n", ArrayUtil.get(idArray, i), ArrayUtil.get(titleArray, i));
            }

            String message = "상세보기할 글의 번호나 뒤로 가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            // 상세보기할 글의 번호를 저장할 int 변수
            int index = ArrayUtil.indexOf(idArray, userChoice);

            while(userChoice != 0 && index == -1){
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
                index = ArrayUtil.indexOf(idArray, userChoice);
            }

            if(userChoice != 0){
                printOne(index);
            }

        }
    }

    public static void printOne(int index){
        System.out.println("제목: " + ArrayUtil.get(titleArray, index));
        System.out.println("글번호: " + ArrayUtil.get(idArray, index));
        System.out.println("작성자: " + ArrayUtil.get(writerArray, index)  );
        System.out.println("내용");
        System.out.println(ArrayUtil.get(contentArray, index));
    }

}












