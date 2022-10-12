package day0922;
// 별찍기 9번

import java.util.Scanner;

public class StarPrinter09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** 별찍기 9번 *****");
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        int height = 2 * userNumber - 1;

        for (int i = 1; i <= height; i++) {
            // i번째 줄에 출력할 내용을 저장할 String 변수
            String content = "";

            // 공백의 갯수를 저장할 int 변수
            int spaceWidth = 0;

            // 별의 갯수를 저장할 int 변수
            int starWidth = 0;

            if(i < userNumber){
                // 윗부분

                // 공백의 갯수
                spaceWidth = userNumber - i;
                // 별의 갯수
                starWidth = i * 2 - 1;
            } else {
                // 아랫부분

                // 아랫부분의 몇번째 줄인지를 저장한 int 변수
                int lowerI = i - userNumber + 1;

                // 공백의 갯수
                spaceWidth = lowerI - 1;
                // 별의 갯수
                starWidth = 2 * (userNumber - lowerI) + 1;
            }

            // 공백을 담당하는 j for문
            for(int j = 1; j <= spaceWidth; j++){
                content += " ";
            }

            // 별을 담당하는 j for문
            for(int j = 1; j <= starWidth; j++){
                content += "*";
            }

            System.out.println(content);
        }
    }
}
