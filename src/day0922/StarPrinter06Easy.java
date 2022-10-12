package day0922;
// 별찍기 6번
// 쉬운 버젼

import java.util.Scanner;

public class StarPrinter06Easy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** 별찍기 6번 *****");
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        for (int i = userNumber; i >= 1; i--) {
            // i번째 줄에 출력할 내용을 저장할 String 변수
            String content = "";

            // 공백을 담당하는 j for 문
            for (int j = 1; j <= userNumber - i; j++) {
                content += " ";
            }

            // i번째 줄의 별의 갯수를 저장할 int 변수
            int starNumbers = 2 * i - 1;

            // 별을 담당하는 j for 문
            for (int j = 1; j <= starNumbers; j++) {
                content += "*";
            }

            System.out.println(content);
        }
    }
}
