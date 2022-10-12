package connector;

import java.sql.Connection;

public class MySqlConnector implements DBConnector {
    @Override
    public Connection makeConnection() {
        System.out.println("MySQL 연결 시작!");
        System.out.println("서버랑 접속 성공!");
        System.out.println("아이디 비번 입력 완료!");
        System.out.println("MySQL 서버에 연결되었습니다.");
        return null;
    }
}
