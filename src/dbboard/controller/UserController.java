package dbboard.controller;

import connector.DBConnector;
import dbboard.model.UserDTO;

import java.sql.*;
import java.util.ArrayList;

public class UserController {
    private Connection connection;

    public UserController(DBConnector connector){
        connection = connector.makeConnection();
    }

    //사용자 추가 메소드
    public boolean insert(UserDTO userDTO){
        String query = "INSERT INTO `user` (`username`, `password`, `nickname`) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, userDTO.getUsername());
            pstmt.setString(2, userDTO.getPassword());
            pstmt.setString(3, userDTO.getNickname());

            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            return false;
        }

        return true;
    }

    //로그인 메소드
    public UserDTO auth(String username, String password){
        String query = "SELECT * FROM `user` WHERE `username` = ? AND `password` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();

            if(resultSet.next()){
                UserDTO u = new UserDTO();
                u.setId(resultSet.getInt("id"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                u.setNickname(resultSet.getString("nickname"));

                return u;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
