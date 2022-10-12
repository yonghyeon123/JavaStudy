package day0927;
// 학생 정보 관리 프로그램.
// 출력 업그레이드 버젼

import util.ArrayUtil;
import util.ScannerUtil;

import java.util.Scanner;

public class Ex02GradeBook01 {
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
    // 다음 입력될 id
    public static int nextId = 1;

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        String message = "1. 입력 2. 출력 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                insert();
            } else if (userChoice == 2) {
                printAll();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public static void insert() {
        if (nextIndex < STUDENT_SIZE) {
            String message;

            idArray[nextIndex] = nextId++;

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

    public static void printAll() {
        if (nextIndex == 0) {
            System.out.println("아직 입력된 정보가 존재하지 않습니다.");
        } else {
            for (int i = 0; i < nextIndex; i++) {
                System.out.printf("%d. %s 학생\n", i + 1, nameArray[i]);
            }

            String message = "상세보기할 학생의 인덱스나 뒤로 가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message, 0, nextIndex);

            if (userChoice != 0) {
                printOne(userChoice - 1);
            }

        }
    }

    public static void printOne(int index) {
        int id = idArray[index];
        String name = nameArray[index];
        int koreanScore = scoreArray[INDEX_KOREAN][index];
        int englishScore = scoreArray[INDEX_ENGLISH][index];
        int mathScore = scoreArray[INDEX_MATH][index];

        int sum = koreanScore + englishScore + mathScore;
        double average = (double) sum / SUBJECT_SIZE;

        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", koreanScore, englishScore, mathScore);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);

        // 쉬는 시간 10분 포함 11시30분까지
        // 개별보기로 들어왔을 때 해당 학생의 정보를 수정/삭제 기능과 목록으로 돌아가기 기능을 구현하시오.
        // 단 수정의 경우 기존 국영수 정보만 수정
        // 삭제는 정말로 삭제하시겠습니까? 1:예 2: 아니오 를 통해서 진행되도록 코드를 작성하시오
        String message = "1. 수정 2. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
        if (userChoice == 1) {
            update(index);
        } else if (userChoice == 2) {
            printAll();
        }
    }

    public static void update(int index) {
        String message;

        message = "새로운 국어 점수를 입력해주세요.";
        scoreArray[INDEX_KOREAN][index] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        message = "새로운 영어 점수를 입력해주세요.";
        scoreArray[INDEX_ENGLISH][index] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        message = "새로운 수학 점수를 입력해주세요.";
        scoreArray[INDEX_MATH][index] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        printOne(index);
    }
}














