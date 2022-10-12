package day0926;
// 사원관리 프로그램을 메소드를 활용하여 작성하시오.
// 사원의 정보에는 사원번호, 사원이름, 사원부서, 사원직급, 사원연봉의 정보가 필요합니다.
// 관리할 사원의 숫자는 4명입니다.
// 3시 45분까지

import java.util.Scanner;

import util.ScannerUtil;

public class Ex08Emp {
    public static final int EMPLOYEE_SIZE = 4;

    public static Scanner scanner = new Scanner(System.in);
    public static int[] idArray = new int[EMPLOYEE_SIZE];
    public static String[] nameArray = new String[EMPLOYEE_SIZE];
    public static int[] deptArray = new int[EMPLOYEE_SIZE];
    public static int[] rankArray = new int[EMPLOYEE_SIZE];
    public static int[] salaryArray = new int[EMPLOYEE_SIZE];
    public static int nextIndex = 0;

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        String message = "1. 입력 2. 출력 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                insertEmployee();
            } else if (userChoice == 2) {
                printAll();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public static void printAll() {
        if (nextIndex == 0) {
            System.out.println("아직 입력된 학생의 정보가 없습니다.");
        } else {
            for (int i = 0; i < nextIndex; i++) {
                System.out.println("---------------------------------------");
                System.out.println((i + 1) + "번째 사원 정보");
                printOne(i);
                System.out.println("---------------------------------------");
            }
        }
    }

    public static void printOne(int index) {
        int id = idArray[index];
        String name = nameArray[index];
        String dept = convertToDept(deptArray[index]);
        String rank = convertToRank(rankArray[index]);
        int salary = salaryArray[index];

        System.out.printf("사원 번호: %d 이름: %s\n", id, name);
        System.out.printf("부서: %s 직급: %s\n", dept, rank);
        System.out.printf("연봉: %d만원\n", salary);
    }

    public static String convertToDept(int value) {
        String result = "";
        switch (value) {
            case 1:
                result = "개발부";
                break;
            case 2:
                result = "회계부";
                break;
            case 3:
                result = "사업지원부";
                break;
        }
        return result;
    }

    public static String convertToRank(int value) {
        String result = "";

        switch (value) {
            case 1:
                result = "부장";
                break;
            case 2:
                result = "차장";
                break;
            case 3:
                result = "팀장";
                break;
            case 4:
                result = "대리";
                break;
            case 5:
                result = "사원";
                break;
        }

        return result;
    }

    public static void insertEmployee() {
        if (nextIndex < EMPLOYEE_SIZE) {
            String message;

            // 사원 번호 입력
            message = "사원의 번호를 입력해주세요.";
            idArray[nextIndex] = ScannerUtil.nextInt(scanner, message);

            // 사원 이름 입력
            message = "사원의 이름을 입력해주세요.";
            nameArray[nextIndex] = ScannerUtil.nextLine(scanner, message);

            // 사원 부서 입력
            message = "사원의 부서를 입력해주세요.(1. 개발 2. 회계 3. 사업지원)";
            deptArray[nextIndex] = ScannerUtil.nextInt(scanner, message, 1, 3);

            // 사원 직급 입력
            message = "사원의 직급을 입력해주세요.(1. 부장 2. 차장 3. 팀장 4. 대리 5. 사원)";
            rankArray[nextIndex] = ScannerUtil.nextInt(scanner, message, 1, 5);

            // 사원 연봉 입력
            message = "사원의 연봉을 입력해주세요.";
            salaryArray[nextIndex] = ScannerUtil.nextInt(scanner, message);

            nextIndex++;


        } else {
            System.out.println("더이상 입력하실 수 없습니다.");
        }


    }
}
