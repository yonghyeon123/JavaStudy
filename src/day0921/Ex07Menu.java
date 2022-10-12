package day0921;
// 무한루프를 사용한 메뉴 프로그램

import java.util.Scanner;

public class Ex07Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("메뉴 목록");
            System.out.println("1. 1번 기능 2. 2번 기능 3. 3번 기능 4. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                // 1번 기능에 대한 코드를 적는다.
                System.out.println("\n1번 기능 실행\n");
            } else if (userChoice == 2) {
                // 2번 기능에 대한 코드를 적는다.
                System.out.println("\n2번 기능 실행\n");
            } else if (userChoice == 3) {
                // 3번 기능에 대한 코드를 적는다.
                System.out.println("\n3번 기능 실행\n");
            } else if (userChoice == 4) {
                // 메시지 출력 후 while 반복문을 종료시킨다.
                System.out.println("사용해주셔서 감사합니다.");
                // break 키워드는 실행되는 순간 해당 break 키워드가 속해있는
                // 반복문 혹은 switch 조건문을 종료시킨다.
                break;
            } else {
                // 잘못된 입력이라는 것을 알려준다.
                System.out.println("잘못 입력하셨습니다.");
            }

        }

        System.out.println("프로그램 종료");
    }
}
