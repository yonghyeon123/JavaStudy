package day0921;
// 메뉴를 사용한 학생 성적 입출력 프로그램.
// 사용자가 입력 기능을 선택하면
// 학생의 정보를 입력한다.
// 이때 만약 국영수 점수가 잘못되면 올바른 점수가 입력될때까지
// 다시 입력을 받는다.
// 사용자가 출력 기능을 선택하면
// 마지막으로 입력된 학생의 정보를 출력한다.
// 사용자가 종료를 선택하면
// 메시지 출력 후 프로그램을 종료한다.

// 힌트: 변수의 유효범위

// 도전과제: 만약 아무런 입력도 하지 않고 출력을 선택하면
// 아직 입력된 정보가 존재하지 않는다고 알려주기

// 1시 20분까지

import java.util.Scanner;

public class Ex08Gradebook {
    public static void main(String[] args) {
        final int SUBJECT_SIZE = 3;
        final int SCORE_MIN = 0;
        final int SCORE_MAX = 100;

        Scanner scanner = new Scanner(System.in);
        int id = 0;
        String name = "";
        int koreanScore = 0;
        int englishScore = 0;
        int mathScore = 0;
        // 성적이 입력되면 true가 저장되는 boolean 변수
        boolean inputSwitch = false;


        while (true) {
            System.out.println("1. 성적 입력 2. 성적 출력 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();


            if (userChoice == 1) {
                // 성적 입력 기능 구현

                System.out.println("번호를 입력해주세요.");
                System.out.print("> ");
                id = scanner.nextInt();

                System.out.println("학생의 이름을 입력해주세요.");
                System.out.print("> ");
                scanner.nextLine();
                name = scanner.nextLine();

                System.out.println("학생의 국어 점수를 입력해주세요.");
                System.out.print("> ");
                int temp = scanner.nextInt();

                while (!(temp >= SCORE_MIN && temp <= SCORE_MAX)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("학생의 국어 점수를 입력해주세요.");
                    System.out.print("> ");
                    temp = scanner.nextInt();
                }

                koreanScore = temp;

                System.out.println("학생의 영어 점수를 입력해주세요.");
                System.out.print("> ");
                temp = scanner.nextInt();

                while (!(temp >= SCORE_MIN && temp <= SCORE_MAX)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("학생의 영어 점수를 입력해주세요.");
                    System.out.print("> ");
                    temp = scanner.nextInt();
                }
                englishScore = temp;

                System.out.println("학생의 수학 점수를 입력해주세요.");
                System.out.print("> ");
                temp = scanner.nextInt();

                while (!(temp >= SCORE_MIN && temp <= SCORE_MAX)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("학생의 수학 점수를 입력해주세요.");
                    System.out.print("> ");
                    temp = scanner.nextInt();
                }

                mathScore = temp;

                inputSwitch = true;

            } else if (userChoice == 2) {
                // 성적 출력 기능 구현

                if (inputSwitch) {
                    System.out.printf("번호: %02d번 이름: %s\n", id, name);
                    System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", koreanScore, englishScore, mathScore);

                    int sum = koreanScore + englishScore + mathScore;
                    double average = sum / (double) SUBJECT_SIZE;

                    System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
                } else {
                    System.out.println("아직 입력된 정보가 존재하지 않습니다.");
                }


            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }

        }

    }

}
















