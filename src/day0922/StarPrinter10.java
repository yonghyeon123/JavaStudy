package day0922;
// 별찍기 10번

import java.util.Scanner;

public class StarPrinter10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** 별찍기 10번 *****");
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        int height = 2 * userNumber - 1;

        for (int i = 1; i <= height; i++) {
            // i번째 줄에 출력할 내용을 저장할 String 변수
            String content = "";

            if (i == 1 || i == height) {
                // 첫번째 줄이거나 맨 마지막 줄인 경우
                // 별을 2 * userNubmer - 1(=height)개 만큼 출력한다.
                for (int j = 1; j <= height; j++) {
                    content += "*";
                }
            } else {
                // 그 외의 경우

                // 공백의 갯수를 저장한 int 변수
                int spaceWidth = 0;
                // 별의 갯수를 저장한 int 변수
                int starWidth = 0;

                if (i < userNumber) {
                    // 윗부분
                    // 별의 갯수
                    starWidth = userNumber - i + 1;
                } else {
                    // 아랫부분
                    // 아랫부분 기준점이 될 int 변수
                    int lowerI = i - userNumber + 1;
                    // 별의 갯수
                    starWidth = lowerI;
                }

                spaceWidth = height - 2 * starWidth;

                // 왼쪽 별을 담당하는 j for 문
                for (int j = 1; j <= starWidth; j++) {
                    content += "*";
                }

                // 가운데 공백을 담당하는 j for 문
                for (int j = 1; j <= spaceWidth; j++) {
                    content += " ";
                }

                // 오른쪽 별을 담당하는 j for 문
                for (int j = 1; j <= starWidth; j++) {
                    content += "*";
                }
            }

            System.out.println(content);
        }
    }
}
