package day0926;
// ScannerUtil을 사용하여
// 학생 1명의 정보를 관리하는 프로그램
import java.util.Scanner;
import util.ScannerUtil;
public class Ex05Gradebook {
    public static void main(String[] args) {
        final int SUBJECT_SIZE = 3;
        final int SCORE_MIN = 0;
        final int SCORE_MAX = 100;

        Scanner scanner = new Scanner(System.in);

        // 각종 출력 메시지를 저장할 String 변수
        String message;

        // 번호 입력
        message = "학생의 번호를 입력해주세요.";
        int id = ScannerUtil.nextInt(scanner, message);

        message = "학생의 이름을 입력해주세요.";
        String name = ScannerUtil.nextLine(scanner, message);

        message = "학생의 국어 점수를 입력해주세요.";
        int koreanScore = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        message = "학생의 영어 점수를 입력해주세요.";
        int englishScore = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        message = "학생의 수학 점수를 입력해주세요.";
        int mathScore = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);



    }
}













