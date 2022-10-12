package day0922;
// 별찍기 6번
// 어렵게 풀어보기

import java.util.Scanner;

public class StarPrinter06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** 별찍기 6번 *****");
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        for (int i = 1; i <= userNumber; i++) {
            // i번째 줄에 출력할 내용을 저장할 String 변수
            String content = "";

            // 공백을 담당하는 j for문
            for (int j = 1; j <= i - 1; j++) {
                content += " ";
            }

            // i번째 줄에 별의 갯수를 저장할 int 변수
            int starNum = 2 * (userNumber - i) + 1;

            // 별을 담당하는 j for문
            for (int j = 1; j <= starNum; j++) {
                content += "*";
            }

            System.out.println(content);
        }
    }
}
