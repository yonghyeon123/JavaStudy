package day0926;
// 전역변수와 메소드를 사용한
// 5명의 학생 정보를 관리하는 프로그램
import java.util.Scanner;
import util.ScannerUtil;
public class Ex07GradeBook02 {
    // 전역 상수
    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;
    public static final int INDEX_KOREAN = 0;
    public static final int INDEX_ENGLISH = 1;
    public static final int INDEX_MATH = 2;
    public static final int SUBJECT_SIZE = 3;
    public static final int STUDENT_SIZE = 5;
    // 전역 변수
    // 번호 배열
    public static int[] idArray = new int[STUDENT_SIZE];
    // 이름 배열
    public static String[] nameArray = new String[STUDENT_SIZE];
    // 점수 배열
    public static int[][] scoreArray = new int[SUBJECT_SIZE][STUDENT_SIZE];
    // Scanner
    public static Scanner scanner = new Scanner(System.in);
    // 다음 입력할 index
    public static int nextIndex = 0;

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu(){
        String message = "1. 입력 2. 출력 3. 종료";
        while(true){
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1){
                insert();
            } else if(userChoice == 2){
                printAll();
            } else if(userChoice == 3){
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public static void insert(){
        if(nextIndex < STUDENT_SIZE ){
            String message;

            message = "학생의 번호를 입력해주세요.";
            idArray[nextIndex] = ScannerUtil.nextInt(scanner, message);

            message = "학생의 이름을 입력해주세요.";
            nameArray[nextIndex] = ScannerUtil.nextLine(scanner, message);

            message = "학생의 국어 점수를 입력해주세요.";
            scoreArray[INDEX_KOREAN][nextIndex] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

            message = "학생의 영어 점수를 입력해주세요.";
            scoreArray[INDEX_ENGLISH][nextIndex] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

            message = "학생의 수학 점수를 입력해주세요.";
            scoreArray[INDEX_MATH][nextIndex] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

            nextIndex++;
        } else {
            System.out.println("더이상 입력하실 수 없습니다.");
        }
    }

    public static void printAll(){
        if(nextIndex == 0){
            System.out.println("아직 입력된 정보가 존재하지 않습니다.");
        } else {
            for(int i = 0; i < nextIndex; i++){
                System.out.println("\n=========================================");
                System.out.println((i+1)+"번째 학생의 정보");
                System.out.println("-----------------------------------------");
                printOne(i);
                System.out.println("=========================================\n");
            }
        }
    }

    public static void printOne(int index){
        int id = idArray[index];
        String name = nameArray[index];
        int koreanScore= scoreArray[INDEX_KOREAN][index];
        int englishScore = scoreArray[INDEX_ENGLISH][index];
        int mathScore = scoreArray[INDEX_MATH][index];

        int sum = koreanScore + englishScore + mathScore;
        double average = (double)sum / SUBJECT_SIZE;

        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", koreanScore, englishScore, mathScore);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
    }
}
