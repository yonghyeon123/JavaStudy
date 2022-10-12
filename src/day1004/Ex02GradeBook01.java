package day1004;
// StudentStrucnt 구조체를 사용한
// 학생관리 프로그램

import java.lang.reflect.Array;
import java.util.Scanner;

import Struct.StudentStruct;
import util.ScannerUtil;
import util.ArrayUtil;

public class Ex02GradeBook01 {
    // 전역 상수
    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;
    public static final int SUBJECT_SIZE = 3;

    // 전역 변수
    public static Scanner scanner = new Scanner(System.in);
    public static StudentStruct[] array = new StudentStruct[0];
    public static int nextId = 1;

    // 1. main()
    public static void main(String[] args) {
        showMenu();
    }

    // 2. showMenu();
    public static void showMenu() {
        String message = "1. 입력 2. 목록 보기 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                // 입력 메소드 실행
                insert();
            } else if (userChoice == 2) {
                // 목록 출력 메소드 실행
                printList();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public static void insert() {
        StudentStruct s = new StudentStruct();
        s.id = nextId++;

        String message;

        message = "학생의 이름을 입력해주세요.";
        s.name = ScannerUtil.nextLine(scanner, message);

        message = "학생의 국어 점수를 입력해주세요.";
        s.koreanScore = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        message = "학생의 영어 점수를 입력해주세요.";
        s.englishScore = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        message = "학생의 수학 점수를 입력해주세요.";
        s.mathScore = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        array = ArrayUtil.add(array, s);
    }

    public static void printList() {
        if (!ArrayUtil.isEmpty(array)) {
            for (int i = 0; i < ArrayUtil.size(array); i++) {
                System.out.printf("%d번. %s\n", ArrayUtil.get(array, i).id, ArrayUtil.get(array, i).name);
            }

            String message = "상세보기할 학생의 학생번호나 뒤로 가실려면 0을 입력해주세요.";

            int userChoice = ScannerUtil.nextInt(scanner, message);

            StudentStruct temp = new StudentStruct();
            temp.id = userChoice;

            while (userChoice != 0 && !ArrayUtil.contains(array, temp)) {
                System.out.println("해당 학생 번호는 존재하지 않습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
                temp.id = userChoice;
            }

            if (userChoice != 0) {
                printDetail(userChoice);
            }

        } else {
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");
        }
    }

    public static void printDetail(int id) {
        StudentStruct s = selectOneById(id);

        System.out.printf("번호: %d번 이름: %s\n", s.id, s.name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", s.koreanScore, s.englishScore, s.mathScore);
        int sum = s.koreanScore + s.englishScore + s.mathScore;
        double average = (double) sum / SUBJECT_SIZE;
        System.out.printf("총점: %03d점 평균: %03d점\n", sum, average);

        String message = "1. 수정 2. 삭제 3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        if (userChoice == 1) {
            update(id);
        } else if (userChoice == 2) {
            delete(id);
        } else {
            printList();
        }
    }

    public static StudentStruct selectOneById(int id) {
        StudentStruct temp = new StudentStruct();
        temp.id = id;

        if (ArrayUtil.contains(array, temp)) {
            return ArrayUtil.get(array, ArrayUtil.indexOf(array, temp));
        }

        return null;
    }

    public static void update(int id) {
        StudentStruct s = selectOneById(id);

        String message;

        message = "학생의 국어 점수를 입력해주세요.";
        s.koreanScore = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        message = "학생의 영어 점수를 입력해주세요.";
        s.englishScore = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        message = "학생의 수학 점수를 입력해주세요.";
        s.mathScore = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        printDetail(id);
    }

    public static void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            array = ArrayUtil.remove(array, selectOneById(id));
            printList();
        } else {
            printDetail(id);
        }
    }
}













