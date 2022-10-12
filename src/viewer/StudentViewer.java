package viewer;
// 뷰어
// 뷰어는 사용자가 직접 보게되는 화면을 뷰어라고 한다.
// 지금은 우리가 콘솔에서 프로그램이 실행되기 때문에
// 뷰어 자바클래스가 존재하지만
// 만약 우리가 웹 프로그래밍으로 들어간다면?
// 뷰어 자바클래스가 아니라 웹페이지가 뷰어를 담당하게 된다!

import controller.StudentController;
import model.StudentDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentViewer {
    // 필드
    private StudentController studentController;
    private Scanner scanner;

    private final int SUBJECT_SIZE = 3;
    private final int SCORE_MIN = 0;
    private final int SCORE_MAX = 100;

    public StudentViewer() {
        studentController = new StudentController();
        scanner = new Scanner(System.in);
    }

    // 1. 메뉴 담당 메소드
    public void showMenu() {
        String message = "1. 학생 등록 2. 학생 목록 보기 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                insertStudent();
            } else if (userChoice == 2) {
                printList();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private void insertStudent() {
        StudentDTO studentDTO = new StudentDTO();

        String message;

        message = "학생의 이름을 입력해주세요.";
        studentDTO.setName(ScannerUtil.nextLine(scanner, message));

        message = "학생의 국어 점수를 입력해주세요.";
        studentDTO.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = "학생의 영어 점수를 입력해주세요.";
        studentDTO.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = "학생의 수학 점수를 입력해주세요.";
        studentDTO.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        studentController.insert(studentDTO);
    }

    private void printList() {
        ArrayList<StudentDTO> list = studentController.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 학생이 존재하지 않습니다.");
        } else {
            for (StudentDTO s : list) {
                System.out.printf("%d번. %s\n", s.getId(), s.getName());
            }

            String message = "상세보기할 학생의 번호나 뒤로 가실려면 0을 입력해주세요.";
            int userInput = ScannerUtil.nextInt(scanner, message);

            while (userInput != 0 && studentController.selectOne(userInput) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userInput = ScannerUtil.nextInt(scanner, message);
            }

            if (userInput != 0) {
                printOne(userInput);
            }
        }
    }

    private void printOne(int id) {
        StudentDTO s = studentController.selectOne(id);

        int sum = s.getKorean() + s.getEnglish() + s.getMath();
        double average = (double) sum / SUBJECT_SIZE;

        System.out.println("\n--------------------------------");
        System.out.println(s.getName() + " 학생 정보");
        System.out.println("--------------------------------\n");
        System.out.printf("번호: %d번 이름: %s\n", s.getId(), s.getName());
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", s.getKorean(), s.getEnglish(), s.getMath());
        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
        System.out.println("================================\n");
        String message = "1. 수정 2. 삭제 3. 목록으로";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice == 1) {
            update(id);
        } else if (userChoice == 2) {
            delete(id);
        } else {
            printList();
        }
    }

    private void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            studentController.delete(id);
            printList();
        } else {
            printOne(id);
        }
    }

    private void update(int id) {
        StudentDTO s = studentController.selectOne(id);

        String message;

        message = "학생의 새로운 국어 점수를 입력해주세요.";
        s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = "학생의 새로운 영어 점수를 입력해주세요.";
        s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        message = "학생의 새로운 수학 점수를 입력해주세요.";
        s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

        studentController.update(s);

        printOne(id);
    }
}














