package day0922;
// 별찍기 2번

import java.util.Scanner;

public class StarPrinter02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** 별찍기 2번 *****");
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        for (int i = 1; i <= userNumber; i++) {
            // i번째 줄에 출력할 내용을 저장할 String 변수
            String content = "";

            for (int j = i; j <= userNumber; j++) {
                content += "*";
            }

            System.out.println(content);
        }
    }
}
