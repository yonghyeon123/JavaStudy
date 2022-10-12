package hw;
// 9월 23일 숙제 1번
// 학생정보 관리 프로그램을 만드시되
// 국영수 점수를 개별적인 배열로 관리하지 말고
// 점수라는 2차원 배열을 통해 관리하시오
// 0번배열: 국어점수 배열
// 1번배열: 영어점수 배열
// 2번배열: 수학점수 배열

// 그외의 사항은 day0923.Ex05 클래스와 동일합니다.
import java.util.Scanner;
public class Hw01 {
    public static void main(String[] args){
        // 상수
        final int SCORE_MIN = 0;
        final int SCORE_MAX = 100;
        final int SUBJECT_SIZE = 3;
        final int STUDENT_SIZE = 5;
        final int KOREAN_INDEX = 0;
        final int ENGLISH_INDEX = 1;
        final int MATH_INDEX = 2;

        // 변수
        Scanner scanner = new Scanner(System.in);
        // 번호 배열
        int[] idArray = new int[STUDENT_SIZE];
        // 이름 배열
        String[] nameArray = new String[STUDENT_SIZE];
        // 점수 배열
        int[][] scoreArray = new int[SUBJECT_SIZE][STUDENT_SIZE];
        // 다음 입력할 인덱스
        int nextIndex = 0;

        while(true){
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if(userChoice == 1){
                if(nextIndex < STUDENT_SIZE){
                    System.out.printf("%d번 학생 정보 입력\n", nextIndex+1);
                    System.out.println("번호를 입력해주세요.");
                    System.out.print("> ");
                    idArray[nextIndex] = scanner.nextInt();

                    System.out.println("이름을 입력해주세요.");
                    System.out.print("> ");
                    scanner.nextLine();
                    nameArray[nextIndex] = scanner.nextLine();

                    // 출력할 메시지를 저장할 String 변수
                    String message;

                    // 사용자가 입력한 값을 임시로 보관할 int 변수
                    int temp;

                    // 국어 점수 입력
                    message = "국어 점수를 입력해주세요.";

                    System.out.println(message);
                    System.out.print("> ");
                    temp = scanner.nextInt();

                    scoreArray[KOREAN_INDEX][nextIndex] = temp;

                    // 영어 점수 입력
                    message = "영어 점수를 입력해주세요.";

                    System.out.println(message);
                    System.out.print("> ");
                    temp = scanner.nextInt();

                    scoreArray[ENGLISH_INDEX][nextIndex] = temp;

                    // 수학 점수 입력
                    message = "수학 점수를 입력해주세요.";

                    System.out.println(message);
                    System.out.print("> ");
                    temp = scanner.nextInt();

                    scoreArray[MATH_INDEX][nextIndex] = temp;

                } else {
                    System.out.println("더이상 입력하실 수 없습니다.");
                }
            } else if(userChoice == 2){
                if(nextIndex == 0){
                    System.out.println("아직 입력된 정보가 없습니다.");
                } else {
                    for(int i = 0; i < nextIndex; i++){
                        int id = idArray[i];
                        String name = nameArray[i];
                        int koreanScore = scoreArray[KOREAN_INDEX][i];
                        int englishScore = scoreArray[ENGLISH_INDEX][i];
                        int mathScore = scoreArray[MATH_INDEX][i];

                        int sum = koreanScore + englishScore + mathScore;
                        double average = (double)sum / SUBJECT_SIZE;

                        System.out.printf("번호: %d번 이름: %s\n", id, name);
                        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", koreanScore, englishScore, mathScore);
                        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
                    }
                }
            } else if(userChoice == 3){
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }


    }
}















