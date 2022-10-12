package day0923;
// 로또게임 03
// 사용자로부터 1. 자동 2. 수동 입력을 받아서
// 자동일 시에는 1~45 사이의 중복되지 않은 숫자 6개,
// 수동일 시에는 사용자가 직접 1~45사이의 숫자 6개를 입력해서
// 정렬하여 출력하는 프로그램을 작성해보시오.
// 2시 40분까지

import java.util.Random;
import java.util.Scanner;

public class Ex04Lotto03 {
    public static void main(String[] args) {
        // 상수
        final int LENGTH = 6;
        final int NUMBER_MIN = 1;
        final int NUMBER_MAX = 45;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 1. 사용자로부터 자동으로 할지 수동으로할지 입력을 받는다.
        System.out.println("1. 자동 2. 수동 ");
        System.out.print("> ");
        int userChoice = scanner.nextInt();

        // 2. 숫자를 저장할 배열을 만든다.
        int[] userNumbers = new int[LENGTH];

        // 3. 사용자가 선택한 자동/수동 옵션에 따라서
        // 숫자를 배열에 저장한다.
        for (int i = 0; i < userNumbers.length; ) {
            // 임시로 숫자를 보관할 변수 temp
            int temp;
            // 자동/수동에 따라서 temp에 값 입력
            if (userChoice == 2) {
                System.out.printf("%d번 숫자를 입력해주세요.\n", i + 1);
                System.out.print("> ");
                temp = scanner.nextInt();

                while (temp < NUMBER_MIN || temp > NUMBER_MAX) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.printf("%d번 숫자를 입력해주세요.\n", i + 1);
                    System.out.print("> ");
                    temp = scanner.nextInt();
                }
            } else {
                temp = random.nextInt(NUMBER_MAX) + NUMBER_MIN;
            }

            // 중복 여부를 저장할 boolean 변수
            boolean numberCheck = true;

            // j for문을 사용하여 우리 배열에
            // temp와 중복인 숫자가 있는지 체크하고
            // 만약 중복이 있으면 numberCheck에 false를 저장해준다.
            for (int j = 0; j < i; j++) {
                if (temp == userNumbers[j]) {
                    numberCheck = false;
                }
            }

            if (numberCheck) {
                // temp가 중복이 아니므로 i번째에 저장하고
                // 그 다음칸에 저장가능하도록 i를 1 증가시킨다.
                userNumbers[i] = temp;
                i++;
            } else {
                // temp가 중복이므로 만약 사용자가 수동입력중이면
                // "중복된 숫자는 입력할수 없습니다." 의 메시지를 출력해준다.
                if (userChoice == 2) {
                    System.out.println("중복된 숫자는 입력할 수 없습니다.");
                }
            }
        }

        // 4. 정렬한다.
        for (int i = 0; i < userNumbers.length - 1; i++) {
            if (userNumbers[i] > userNumbers[i + 1]) {
                int temp = userNumbers[i];
                userNumbers[i] = userNumbers[i + 1];
                userNumbers[i + 1] = temp;
                i = -1;
            }
        }

        // 5. 출력한다.
        System.out.println("\n==========================================");
        System.out.println("사용자 숫자");
        System.out.println("============================================");
        System.out.print("[");
        for (int i = 0; i < userNumbers.length; i++) {
            System.out.printf("%2d", userNumbers[i]);

            if (i < userNumbers.length - 1) {
                System.out.print(", ");
            }

        }
        System.out.println("]");
        System.out.println("============================================");

    }
}
