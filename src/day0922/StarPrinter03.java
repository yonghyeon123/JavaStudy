package day0922;
// 별찍기 3번

import java.util.Scanner;

public class StarPrinter03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** 별찍기 3번 *****");
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        for (int i = 1; i <= userNumber; i++) {
            // i번째 줄에 출력할 내용을 저장할 String 변수
            String content = "";
            
            // 공백을 담당하는 j for문
            for(int j = 1; j <= userNumber - i; j++){
                content += " ";
            }
            
            // 별을 담당하는 j for문
            for(int j = 1; j <= i; j++){
                content += "*";
            }

            System.out.println(content);
        }
    }
}
