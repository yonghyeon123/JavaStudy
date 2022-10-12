package day0923;
// 배열을 사용해서 5명의 학생을 관리하는 프로그램
// 메뉴를 사용해야 하며, 입력을 눌럿을 때,
// 마지막으로 입력된 학생 다음 칸에 정보들이 입력되어야 한다.
// 단, 5명을 입력한 후에는 더이상 입력할 수 없다.
// 출력시에는 만약 입력된 학생이 존재하지 않는다면
// 당연히 경고 메시지만 출력이 되어야 한다.
// 이 프로그램에서 여러분들은
// 학생 번호 배열, 이름 배열, 국어 점수 배열, 영어 점수 배열, 수학 점수 배열을 만들어야 한다.
// 4시까지

import java.util.Scanner;

public class Ex05GradeBook01 {
    public static void main(String[] args) {
        // 상수
        final int SCORE_MIN = 0;
        final int SCORE_MAX = 100;
        final int SUBJECT_SIZE = 3;
        final int ARRAY_LENGTH = 5;

        // 변수
        Scanner scanner = new Scanner(System.in);
        // 학생들의 번호 배열
        int[] idArray = new int[ARRAY_LENGTH];
        // 이름 배열
        String[] nameArray = new String[ARRAY_LENGTH];
        // 국어 점수 배열
        int[] koreanArray = new int[ARRAY_LENGTH];
        // 영어 점수 배열
        int[] englishArray = new int[ARRAY_LENGTH];
        // 수학 점수 배열
        int[] mathArray = new int[ARRAY_LENGTH];
        // 다음 입력할 인덱스를 저장할 int 변수 nextIdx;
        int nextIdx = 0;

        while (true) {
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                // 학생 정보 입력 코드 구현

                if (nextIdx < ARRAY_LENGTH) {
                    // 아직 각 배열에 우리가 직접 입력을 안한 칸이 존재하므로 입력 코드 시작

                    System.out.println("\n----------------------------------------");
                    System.out.printf("%d번째 학생 정보 입력 시작\n", nextIdx + 1);
                    System.out.println("----------------------------------------\n");

                    // 번호 입력
                    System.out.println("학생의 번호를 입력해주세요.");
                    System.out.print("> ");
                    idArray[nextIdx] = scanner.nextInt();

                    // 이름 입력
                    System.out.println("학생의 이름을 입력해주세요.");
                    System.out.print("> ");
                    scanner.nextLine();
                    nameArray[nextIdx] = scanner.nextLine();

                    // 출력에서 사용할 메시지를 저장할 String 변수
                    String message;

                    // 사용자가 입력한 값을 임시로 보관할 int 변수
                    int temp;

                    // 국어 점수 입력
                    message = "국어 점수를 입력해주세요.";

                    System.out.println(message);
                    System.out.print("> ");
                    temp = scanner.nextInt();

                    while (temp < SCORE_MIN || temp > SCORE_MAX) {
                        System.out.println("잘못 입력하셨습니다.");
                        System.out.println(message);
                        System.out.print("> ");
                        temp = scanner.nextInt();
                    }

                    koreanArray[nextIdx] = temp;

                    // 영어 점수 입력
                    message = "영어 점수를 입력해주세요.";

                    System.out.println(message);
                    System.out.print("> ");
                    temp = scanner.nextInt();

                    while (temp < SCORE_MIN || temp > SCORE_MAX) {
                        System.out.println("잘못 입력하셨습니다.");
                        System.out.println(message);
                        System.out.print("> ");
                        temp = scanner.nextInt();
                    }

                    englishArray[nextIdx] = temp;

                    // 수학 점수 입력
                    message = "수학 점수를 입력해주세요.";

                    System.out.println(message);
                    System.out.print("> ");
                    temp = scanner.nextInt();

                    while (temp < SCORE_MIN || temp > SCORE_MAX) {
                        System.out.println("잘못 입력하셨습니다.");
                        System.out.println(message);
                        System.out.print("> ");
                        temp = scanner.nextInt();
                    }

                    mathArray[nextIdx] = temp;

                    // 다음 입력 위치를 1 증가 시킨다.
                    nextIdx++;
                } else {
                    // 각 배열에 모든 칸에 우리가 직접 입력을 하였으므로 경고 메시지만 출력
                    System.out.println("더이상 입력하실 수 없습니다.");
                }


            } else if (userChoice == 2) {
                // 학생 정보 출력 코드 구현
                if (nextIdx == 0) {
                    // 아직 한명도 입력 안됬으므로 경고 메시지만 출력
                    System.out.println("아직 입력된 학생의 정보가 존재하지 않습니다.");
                } else {
                    for (int i = 0; i < nextIdx; i++) {
                        System.out.println("---------------------------------------------------");
                        System.out.printf("%d번 학생 정보\n", i + 1);
                        System.out.println("---------------------------------------------------");
                        System.out.printf("번호: %d번 이름: %s\n", idArray[i], nameArray[i]);
                        int korean = koreanArray[i];
                        int english = englishArray[i];
                        int math = mathArray[i];
                        System.out.printf("국어: %03d점 영어 %03d점 수학: %03d점\n", korean, english, math);
                        int sum = korean + english + math;
                        double average = (double) sum / SUBJECT_SIZE;
                        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
                        System.out.println("====================================================\n");
                    }
                }

            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }
}











