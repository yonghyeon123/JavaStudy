package day0920;
// 사용자로부터 나이를 입력받아서
// 5세미만: 영아
// 5세 이상~13세이하: 어린이
// 14~19세 미만: 청소년
// 그외: 성인
// 이 출력되는 프로그램을 작성하시오
// 4시 45분까지

import java.util.Scanner;

public class Ex09AgeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("나이를 입력해주세요.");
        System.out.print("> ");
        int age = scanner.nextInt();

        if (age < 5) {
            System.out.println("영아입니다.");
        } else if (age <= 13) {
            System.out.println("어린이입니다.");
        } else if (age < 19) {
            System.out.println("청소년입니다.");
        } else {
            System.out.println("성인입니다.");
        }
    }
}
