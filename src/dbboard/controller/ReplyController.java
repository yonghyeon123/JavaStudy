package dbboard.controller;

import connector.DBConnector;
import dbboard.model.ReplyDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<ReplyDTO> selectAll(int boardId){
        ArrayList<ReplyDTO> temp = new ArrayList<>();
        String query = "SELECT * FROM `reply` WHERE `boardId` = ? ORDER BY `id` DESC";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, boardId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                ReplyDTO r = new ReplyDTO();
                r.setId(rs.getInt("id"));
                r.setWriterId(rs.getInt("writerId"));
                r.setBoardId(rs.getInt("boardId"));
                r.setContent(rs.getString("content"));
                r.setWrittenDate(rs.getTimestamp("writtenDate"));
                r.setUpdatedDate(rs.getTimestamp("updatedDate"));

                temp.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public ReplyDTO selectOne(int id){
        String query = "SELECT * FROM `reply` WHERE `id` = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                ReplyDTO temp = new ReplyDTO();

                temp.setId(rs.getInt("id"));
                temp.setWriterId(rs.getInt("writerId"));
                temp.setBoardId(rs.getInt("boardId"));
                temp.setContent(rs.getString("content"));
                temp.setWrittenDate(rs.getTimestamp("writtenDate"));
                temp.setUpdatedDate(rs.getTimestamp("updatedDate"));

                return temp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
