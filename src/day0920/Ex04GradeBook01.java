package day0920;
// 사용자로부터 학생의 번호, 이름, 국어, 영어, 수학 점수를 차례대로 입력 받아서
// 다음과 같은 형식으로 출력되는 프로그램을 작성하시오
// 결과)
// 번호: 0#번 이름: ###
// 국어: 0##점 영어: 0##점 수학: 0##점
// 총점: 0##점 평균: 0##.##점
// 단, 입력을 받을 때에는 한번에 1개씩 입력을 받습니다.
// 1시 10분까지

// 1. Scanner 클래스 변수를 사용할수 있도록 import한다.
// 2. Scanner 클래스 변수를 만든다.
// 3. 사용자로부터 번호를 입력받아서 int 변수에 저장한다.
// 4. 사용자로부터 이름을 입력받아서 String 변수에 저장한다.
// 5. 사용자로부터 국어 점수를 입력받아서 int 변수에 저장한다.
// 6. 사용자로부터 영어 점수를 입력받아서 int 변수에 저장한다.
// 7. 사용자로부터 수학 점수를 입력받아서 int 변수에 저장한다.
// 8. 번호와 이름을 출력한다.
// 9. 국어 영어 수학 점수를 출력한다.
// 10. 총점을 계산한다.
// 11. 평균을 계산한다.
// 12. 총점과 평균을 출력한다.

import java.util.Scanner;

public class Ex04GradeBook01 {
    public static void main(String[] args) {
        // 과목의 갯수를 저장할 int 상수
        final int SUBJECT_SIZE = 3;

        Scanner scanner = new Scanner(System.in);

        System.out.println("학생의 번호를 입력해주세요.");
        System.out.print("> ");
        int id = scanner.nextInt();

        System.out.println("학생의 이름을 입력해주세요.");
        System.out.print("> ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.println("학생의 국어 점수를 입력해주세요.");
        System.out.print("> ");
        int koreanScore = scanner.nextInt();

        System.out.println("학생의 영어 점수를 입력해주세요.");
        System.out.print("> ");
        int englishScore = scanner.nextInt();

        System.out.println("학생의 수학 점수를 입력해주세요.");
        System.out.print("> ");
        int mathScore = scanner.nextInt();

        System.out.printf("번호: %02d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", koreanScore, englishScore, mathScore);

        int sum = koreanScore + englishScore + mathScore;
        double average = sum / (double) SUBJECT_SIZE;

        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
    }

}
