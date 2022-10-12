package day1012;

import util.ScannerUtil;

import java.sql.*;
import java.util.Scanner;

// 최소한 메소드를 적용시킨
// MySql 사용한 성적 관리 프로그램
public class Ex03GradeBook02 {
    private final static Scanner scanner = new Scanner(System.in);
    private final static String ADDRESS = "jdbc:mysql://localhost:3306/sqlbasic";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "1111";

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
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

    private static void insert() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD);
            String query = "INSERT INTO `student`(`name`, `korean`, `english`, `math`) VALUES(?, ?, ?, ?)";

            String message;

            message = "학생의 이름을 입력해주세요.";
            String name = ScannerUtil.nextLine(scanner, message);
            message = "학생의 국어 점수를 입력해주세요.";
            int korean = ScannerUtil.nextInt(scanner, message, 0, 100);
            message = "학생의 영어 점수를 입력해주세요.";
            int english = ScannerUtil.nextInt(scanner, message, 0, 100);
            message = "학생의 수학 점수를 입력해주세요.";
            int math = ScannerUtil.nextInt(scanner, message, 0, 100);

            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2, korean);
            pstmt.setInt(3, english);
            pstmt.setInt(4, math);

            pstmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printList() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD);

            String query = "SELECT * FROM `student`";

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.printf("%d번. %s\n", id, name);
            }

            String message = "상세보기할 학생의 번호나 뒤로 가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            query = "SELECT * FROM `student` WHERE `id` = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, userChoice);

            rs = pstmt.executeQuery();

            while (userChoice != 0 && !rs.next()) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
                pstmt.setInt(1, userChoice);
                rs = pstmt.executeQuery();
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printOne(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD);

            String query = "SELECT * FROM `student` WHERE `id` = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int korean = rs.getInt("korean");
                int english = rs.getInt("english");
                int math = rs.getInt("math");

                int sum = korean + english + math;
                double average = sum / 3.0;

                System.out.printf("번호: %d번 이름: %s\n", id, name);
                System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
                System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);

                String message = "1. 수정 2. 삭제 3. 뒤로 가기";
                int userChoice = ScannerUtil.nextInt(scanner, message);
                if (userChoice == 1) {
                    update(id);
                } else if (userChoice == 2) {
                    delete(id);
                } else if (userChoice == 3) {
                    printList();
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void update(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD);

            String query = "UPDATE `student` SET `korean` = ?, `english` = ?, `math` = ? WHERE `id` = ?";

            String message;

            message = "새로운 국어 점수를 입력해주세요.";
            int korean = ScannerUtil.nextInt(scanner, message, 0, 100);

            message = "새로운 영어 점수를 입력해주세요.";
            int english = ScannerUtil.nextInt(scanner, message, 0, 100);

            message = "새로운 수학 점수를 입력해주세요.";
            int math = ScannerUtil.nextInt(scanner, message, 0, 100);

            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, korean);
            pstmt.setInt(2, english);
            pstmt.setInt(3, math);
            pstmt.setInt(4, id);

            pstmt.executeUpdate();

            printOne(id);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    private static void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD);
                String query = "DELETE FROM `student` WHERE `id` = ?";
                PreparedStatement pstmt = connection.prepareStatement(query);
                pstmt.setInt(1, id);

                pstmt.executeUpdate();

                printList();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }


        } else {
            printOne(id);
        }
    }

}
