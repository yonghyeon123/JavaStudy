package dbboard.controller;

import connector.DBConnector;
import dbboard.model.ReplyDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReplyController {
    private Connection connection;

    public ReplyController(DBConnector dbConnector){
        connection = dbConnector.makeConnection();
    }

    //댓글 달기
    public void insert(ReplyDTO r){
        String query = "INSERT INTO `reply` (`writerId`, `boardId`, `content`, `writtenDate`, `updatedDate`) VALUES (?, ?, ?, NOW(), NOW())";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, r.getWriterId());
            pstmt.setInt(2, r.getWriterId());
            pstmt.setString(3, r.getContent());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(ReplyDTO r){
        String query = "UPDATE `reply` SET `content` = ?, `updatedDate` = NOW() WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, r.getContent());
            pstmt.setInt(2, r.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String query = "DELETE FROM `reply` WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
