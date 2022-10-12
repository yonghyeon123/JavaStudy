package day0921;
// 랜덤 게임
// 랜덤 게임은 컴퓨터가 뽑아낸 1~100 사이의 랜덤한 숫자를
// 사용자가 맞추는것이 목표인 게임이다.
// 예를 들어서 컴퓨터가 50을 뽑아냈을 경우
// 사용자가 50보다 작은 수를 입력하면 "UP"
// 50보다 큰 수를 입력하면 "DOWN" 이라고 출력이 되서
// 최종적으로 사용자가 50을 입력하도록 하는 게임이다.

// 기능설명
// 1. 플레이
// 컴퓨터가 뽑은 숫자를 사용자가 맞추는 것이 목적이 된다.
// 사용자가 입력할 때 마다 점수가 1점씩 오르는데
// 당연히 점수가 낮을 수록 좋은것이다.
// 사용자가 최종적으로 숫자를 맞췄을 경우
// 기존 최고기록과 비교하여 만약 사용자가 새로운 최고기록을 세웠을 경우에는
// 축하메시지와 함께 기존 최고기록을 갱신해준다.

// 2. 최고 기록 보기
// 현재 최고 기록을 본다.
// 단, 한번도 플레이 하지 않았을 경우에는 경고 메시지만 출력한다.

// 3. 종료
// 프로그램을 종료한다.

// 쉬는시간 포함 4시 20분까지

import java.util.Scanner;
import java.util.Random;

public class Ex10RandomGame {
    public static void main(String[] args) {
        // 상수
        final int NUMBER_MIN = 1;
        final int NUMBER_MAX = 100;
        final int SIZE = NUMBER_MAX - NUMBER_MIN + 1;

        // 변수
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int bestScore = 0;

        while (true) {
            System.out.println("1. 플레이하기 2. 최고 점수 보기 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                // 플레이 코드 구현

                // 1. 컴퓨터의 랜덤 숫자 생성
                // 2. 사용자의 점수를 저장할 변수 생성
                // 3. 사용자가 컴퓨터의 랜덤 숫자와 다른 값을 입력하는동안
                //    계속 다시 입력을 받는다.
                // 3-1. 만약 사용자의 숫자가 컴퓨터의 숫자보다 크면 "DOWN"을 출력한다.
                // 3-2. 만약 사용자의 숫자가 컴퓨터의 숫자보다 작으면 "UP"을 출력한다.
                // 3-3. 출력이 끝나면 사용자의 점수를 1 증가 시킨다.
                // 4. 결과를 보기 좋게 한번 출력한다.
                // 5. 필요하다면 기존 최고 기록을 갱신해준다.

                // 랜덤 숫자를 생성하여 int 변수에 저장
                int computerNumber = random.nextInt(SIZE) + NUMBER_MIN;

                // 이번 플레이에서 점수를 저장할 변수
                int currentScore = 1;

                // 사용자로부터 첫번째 입력을 받는다.
                System.out.println("1~100 사이의 숫자를 입력해주세요.");
                System.out.print("> ");
                int userNumber = scanner.nextInt();

                // 사용자가 입력한 숫자가 컴퓨터 숫자와 다른 동안
                // 다시 입력을 받는다.
                while (userNumber != computerNumber) {
                    // 사용자가 입력한 숫자에 따라서
                    // 힌트를 출력해준다.
                    if (userNumber < computerNumber) {
                        System.out.println("UP");
                    } else {
                        System.out.println("DOWN");
                    }

                    // 사용자로부터 새로운 값을 입력받는다.
                    System.out.println("1~100 사이의 숫자를 입력해주세요.");
                    System.out.print("> ");
                    userNumber = scanner.nextInt();
                    // 사용자가 입력을 하였으므로 점수를 1 증가시킨다.
                    currentScore++;
                }

                // 현재 점수를 출력한다.
                System.out.printf("짝짝짝 총 [%d]번만에 맞추셨습니다!\n", currentScore);

                // 만약 필요하다면 기존 최고 기록을 갱신한다.
                if (bestScore == 0) {
                    // 맨 처음 플레이하는 것이므로 현재 점수로 최고 기록을 갱신해준다.
                    System.out.println("처음 플레이하셔서 현재 점수가 새로운 최고 기록이 됩니다.");
                    bestScore = currentScore;
                } else if (bestScore > currentScore) {
                    System.out.println("짝짝짝 새로운 최고 기록입니다!! 짝짝짝");
                    bestScore = currentScore;
                }


            } else if (userChoice == 2) {
                // 최고 점수 보기 코드 구현
                if (bestScore == 0) {
                    System.out.println("아직 플레이 기록이 존재하지 않습니다.");
                } else {
                    System.out.printf("현재 최고 기록: [%d]\n", bestScore);
                }
            } else if (userChoice == 3) {
                // 메시지 출력 후 break 실행
                System.out.println("플레이해주셔서 감사합니다.");
                break;
            }
        }
    }
}















