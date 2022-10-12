package day0922;
// 별찍기 8번

import java.util.Scanner;

public class StarPrinter08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** 별찍기 8번 *****");
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        int height = userNumber * 2 - 1;

        for (int i = 1; i <= height; i++) {
            // i번째 줄에 출력할 내용을 저장할 String 변수
            String content = "";

            if(i < userNumber){
                // 윗부분

                // 공백을 담당하는 j for문
                for(int j = 1; j <= userNumber - i; j++){
                    content += " ";
                }

                // 별을 담당하는 j for문
                for(int j = 1; j <= i; j++){
                    content += "*";
                }

            } else {
                // 아랫부분

                // 아랫부분의 몇번째 줄인지를 저장할 int 변수 lowerI
                int lowerI = i - userNumber + 1;

                // 공백을 담당하는 j for문
                for(int j = 1; j <= lowerI - 1; j++){
                    content += " ";
                }

                // 별을 담당하는 j for문
                for(int j = lowerI; j <= userNumber; j++){
                    content += "*";
                }

            }

            System.out.println(content);
        }
    }
}
