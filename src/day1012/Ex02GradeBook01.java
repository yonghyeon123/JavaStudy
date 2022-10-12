package day1012;

import util.ScannerUtil;

import java.sql.*;
import java.util.Scanner;

// MySql을 단순하게 사용하는 무식한 버젼의
// 학생 관리 프로그램
public class Ex02GradeBook01 {
    public static void main(String[] args) {
        // MySql 서버 접속에 사용할 정보들
        String address = "jdbc:mysql://localhost:3306/sqlbasic";
        String username = "root";
        String password = "1111";

        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(address, username, password);

            String message = "1. 입력 2. 출력 3. 종료";
            while (true) {
                int userChoice = ScannerUtil.nextInt(scanner, message);
                if (userChoice == 1) {
                    // 입력 코드 구현

                } else if (userChoice == 2) {
                    // 출력 코드 구현
                    // 전체를 불러올 쿼리 String
                    String query = "SELECT * FROM student";

                    // 위의 String을 MySql이 알아들을 수 있게
                    // Statement 객체로 변환해준다.
                    Statement statement = connection.createStatement();

                    // Statement 객체를 사용하여 위의 String query를 실행하여
                    // 그 결과값을 ResultSet 객체에 담는다.
                    ResultSet rs = statement.executeQuery(query);

                    // ResultSet 객체는 테이블의 쿼리 결과값이 담겨있는 일종의 배열같은
                    // 객체인데, 우리가 크기가 몇인지 알수 없는 객체이다.
                    // 따라서, while을 사용해서, 그 다음 줄이 존재하는 동안
                    // 그 안의 내용을 꺼내서 출력해야한다.
                    while (rs.next()) {
                        // 만약 다음줄이 존재하면 이 while이 시작되는데
                        // 가장 윗줄부터 차례대로 실행이 된다.
                        // 단, 결과가 단 한줄만 존재하더라도
                        // 반드시 우리가 next() 메소드를 실행시켜서
                        // ResultSet 객체의 안에 읽어올 줄을 첫번째 줄로 맞춰주어야 한다.

                        // 현재 우리가 읽어올 줄의 int 값을 읽어야 할 경우에는?
                        // getInt() 라는 메소드를 사용하는데, 몇번째 컬럼인지를 적거나
                        // 컬럼 이름을 적으면 된다.
                        // 단, 컬럼 이름을 적는게 좀더 정석적인 표현이다.
                        int id = rs.getInt("id");
                        // String 값을 읽어야 할 경우에는?
                        // getString()
                        String name = rs.getString("name");

                        System.out.printf("%d번. %s\n", id, name);
                    }

                    message = "수정할 학생의 번호나 뒤로 가실려면 0을 입력해주세요.";
                    int userInput = ScannerUtil.nextInt(scanner, message);

                    // 우리가 쿼리문에 특정 값을 추가하여 변동성이 있는 쿼리를 만들어야 할 경우
                    // 다음과 같은 방법으로 만들게 된다.
                    query = "SELECT * FROM student WHERE id = ?";

                    // 위와 같이 쿼리가 변동적인 쿼리일 경우에는
                    // 우리가 Statement가 아니라 PreparedStatement 객체를 통하여 쿼리를 준비하게 된다.
                    PreparedStatement pstmt = connection.prepareStatement(query);
                    // 물음표가 나온 순서대로 pstmt에 값을 넘겨준다.
                    pstmt.setInt(1, userInput);

                    rs = pstmt.executeQuery();

                    while (userInput != 0 && !rs.next()) {
                        System.out.println("잘못 입력하셨습니다.");
                        userInput = ScannerUtil.nextInt(scanner, message);
                        pstmt.setInt(1, userInput);
                        rs = pstmt.executeQuery();
                    }

                    rs = pstmt.executeQuery();

                    if (userInput != 0) {
                        rs.next();
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        int korean = rs.getInt("korean");
                        int english = rs.getInt("english");
                        int math = rs.getInt("math");
                        int sum = korean + english + math;
                        double average = sum / 3.0;

                        System.out.printf("번호: %d 이름: %s\n", id, name);
                        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
                        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);

                        message = "1. 수정 2. 삭제 3. 뒤로 가기";


                    }


                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}











