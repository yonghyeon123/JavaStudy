package day1004;
// 어레이리스트와 datatype.Student를 사용한 학생관리 프로그램을
// 작성해보시오
// 4시까지

import java.util.Scanner;
import java.util.ArrayList;

import util.ScannerUtil;
import datatype.Student;

public class Ex05GradeBook02 {
    // 상수
    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;
    // 변수
    public static ArrayList<Student> list = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static int nextId = 1;

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        String message = "1. 입력 2. 목록 출력 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                insert();
            } else if (userChoice == 2) {
                printList();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public static void insert() {
        Student s = new Student();
        s.setId(nextId++);

        String message;

        message = "학생의 이름을 입력해주세요.";
        s.setName(ScannerUtil.nextLine(scanner, message));

        message = "학생의 국어 점수를 입력해주세요.";
        s.setKoreanScore(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = "학생의 영어 점수를 입력해주세요.";
        s.setEnglishScore(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = "학생의 수학 점수를 입력해주세요.";
        s.setMathScore(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        list.add(s);
    }

    public static void printList() {
        if (list.isEmpty()) {
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                Student s = list.get(i);
            }
            // forEach란?
            // 어레이리스트, 배열과 같이 특정 데이터타입이 모여있는 변수의 경우
            // 우리가 맨 앞의 인덱스부터 차례대로 특정 이름의 변수로 불러라
            // 하는 식의 구문을 만들 수 있다.
            // 즉 위의 i for문을 축약해서 쓰는 방법이 forEach 라는 방법인데
            // 대신, 어레이리스트나 배열의 크기가 변경되면 에러가 발생한다.
            // 즉 단순 출력을 사용할 때에 쓰면 편하지만
            // 만약 for문이 진행되면서 크기나 길이가 변하면 에러가 발생한다는 점을 유의하자!

            // forEach는 다음과 같이 사용한다
            // for(모여있는 데이터타입 임시이름 : 어레이리스트) {
            //
            // }
            for (Student s : list) {
                System.out.printf("%d번. %s\n", s.getId(), s.getName());
            }

            String message = "상세보기할 학생의 번호나 뒤로 가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            Student s = new Student();
            s.setId(userChoice);

            while (userChoice != 0 && !list.contains(s)) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
                s.setId(userChoice);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }

    public static void printOne(int id) {
        Student s = selectOneById(id);
        s.printInfo();

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

    public static Student selectOneById(int id) {
        Student temp = new Student();
        temp.setId(id);
        if (list.contains(temp)) {
            return list.get(list.indexOf(temp));
        }
        return null;
    }

    public static void update(int id) {
        Student s = selectOneById(id);
        String message;

        message = "학생의 새로운 국어 점수를 입력해주세요.";
        s.setKoreanScore(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = "학생의 새로운 영어 점수를 입력해주세요.";
        s.setEnglishScore(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = "학생의 새로운 수학 점수를 입력해주세요.";
        s.setMathScore(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        printOne(id);
    }

    public static void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            list.remove(selectOneById(id));
            printList();
        } else {
            printOne(id);
        }
    }
}















