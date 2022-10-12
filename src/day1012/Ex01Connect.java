package day1012;
// MySQL 과 Java 연결하기
// 우리가 지금까지 배운 MySQL 쿼리를 자바에서 사용하는 가장 기본적인 단계는
// MySQL 서버와 자바 프로그램을 서로 연결시키는 것이다.

// 즉 DB 서버와의 통신을 시작하는 것인데
// 우리가 거기에 앞서서 먼저 MySQL 서버에 접속할 때 사용할
// Java 라이브러리를 우리 프로젝트에 등록을 해주어야 한다.
// 만약, 새로운 프로젝트에서 MySQL 접속을 해야하는 경우,
// 그 프로젝트에서도 해당 라이브러리를 등록해주어야 한다!


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex01Connect {
    public static void main(String[] args) {
        // MySql 서버 접속에 사용할 주소
        String address = "jdbc:mysql://localhost:3306/sqlbasic";

        // MySql 서버 접속에 사용할 username
        String username = "root";

        // MySql 서버 접속에 사용할 password
        String password = "1111";

        // MySql 드라이버를 메소드에 등록한다.
        // 단, Class.forName() 메소드의 경우, 해당 파라미터로 들어온 String 값과 일치하는
        // 이름을 가진 클래스를 찾지 못하면 에러가 발생하게 된다.
        // 따라서 자바에서는 그러한 경우를 어떻게 처리할지를 코드에 명시하지 않으면 에러가 발생 되도록
        // 만들어놨다.
        // 이러한 에러를 우리는 Exception(=예외) 라고 하고, 그러한 예외를 어떻게 처리할 지를 결정하는 것이
        // 바로 예외처리가 된다.

        // 예외처리를 하는 방법은 2가지가 있는데
        // 1. 해당 예외를 여기서 직접 처리하는 것이 아니라
        //    현재 메소드를 사용하는 다른 메소드가 처리하도록
        //    메소드 선언 옆에 "throws 예외이름" 을 적어주는 방법
        // 2. try/catch 구조를 사용하여 exception을 직접 처리해주는 방법.
        //    try/catch 구조란, try 부분에서는 exception이 발생할 수 있는
        //    코드를 적어주고, catch에서는 만약 해당 exception이 발생할 때에
        //    실행할 코드를 적어준다.
        //    만약 특정 코드를 exception의 발생 유무와 상관없이 실행시켜야 한다면
        //    catch 코드 블락 이후에 finally 코드 블락을 만들어서 그 안에 적어주면 된다.

        Connection conn = null;
        try {
            System.out.println("MySql 연결 시작");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(address, username, password);
            System.out.println("MySql 연결 성공!");
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("MySql 연결 종료");
        }


        System.out.println("프로그램을 종료합니다.");
    }
}














