package day1012;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {
    private Connection connection;
    // MySQL 서버 접속에 사용할 정보들
    private final String ADDRESS = "jdbc:mysql://localhost:3306/sqlbasic";
    private final String USERNAME = "root";
    private final String PASSWORD = "1111";

    public UserController(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(UserDTO userDTO){
        String query = "INSERT INTO `user` (`username`, `password`, `nickname`) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, userDTO.getUsername());
            pstmt.setString(2, userDTO.getPassword());
            pstmt.setString(3, userDTO.getNickname());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<UserDTO> SelectAll(){
        ArrayList<UserDTO> list = new ArrayList<>();

        String query = "SELECT * FROM `user`";

        return list;
    }
}
