package day0923;
// 로또 ver 4.0
// 사용자와 컴퓨터가 모두 숫자를 고르고
// 각 결과를 출력한 후에
// 사용자가 몇개를 맞췄는지를 출력하는 프로그램을 작성하시오.
// 사용자는 당연히 수동과 자동이 가능하지만
// 컴퓨터는 자동만 가능합니다.

// 5시 20분까지(쉬는시간 10분 포함)

import java.util.Scanner;
import java.util.Random;

public class Ex06Lotto04 {
    public static void main(String[] args) {
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
                String message = (i+1)+"번 숫자를 입력해주세요.";
                System.out.println(message);
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

        // 5. 컴퓨터 배열을 만든다.
        int[] computerNumbers = new int[LENGTH];

        // 6. 컴퓨터 배열에 중복되지 않는 숫자 6개를 저장한다.
        for (int i = 0; i < computerNumbers.length; ) {
            int number = random.nextInt(NUMBER_MAX) + NUMBER_MIN;
            boolean numberSwitch = true;
            for (int j = 0; j < i; j++) {
                if (number == computerNumbers[j]) {
                    numberSwitch = false;
                }
            }

            if (numberSwitch) {
                computerNumbers[i] = number;
                i++;
            }
        }

        // 7. 컴퓨터 배열을 정렬한다.
        for (int i = 0; i < computerNumbers.length - 1; i++) {
            if (computerNumbers[i] > computerNumbers[i + 1]) {
                int temp = computerNumbers[i];
                computerNumbers[i] = computerNumbers[i + 1];
                computerNumbers[i + 1] = temp;
                i = -1;
            }
        }

        // 8. 출력한다.
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
        System.out.println("\n==========================================");
        System.out.println("컴퓨터 숫자");
        System.out.println("============================================");
        System.out.print("[");
        for (int i = 0; i < computerNumbers.length; i++) {
            System.out.printf("%2d", computerNumbers[i]);

            if (i < computerNumbers.length - 1) {
                System.out.print(", ");
            }

        }
        System.out.println("]");

        // 9. 총 맞은 갯수를 계산한다.
        int count = 0;

        for (int i = 0; i < userNumbers.length; i++) {
            for (int j = 0; j < computerNumbers.length; j++) {
                if (userNumbers[i] == computerNumbers[j]) {
                    count++;
                }
            }
        }

        // 10. 출력한다.
        System.out.println("총 맞은 갯수: " + count);
    }
}
