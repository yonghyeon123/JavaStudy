package dbboard.controller;

import connector.DBConnector;
import dbboard.model.BoardDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardController {
    private Connection connection;

    public BoardController(DBConnector connector){
        connection = connector.makeConnection();
    }

    //1. DB에 글 등록하는 메소드
    public void insert(BoardDTO boardDTO){
        String query = "INSERT INTO `board` (`writerId`, `title`, `content`, `writtenDate`, `updatedDate`) VALUES (?, ?, ?, NOW(), NOW())";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, boardDTO.getWriterId());
            pstmt.setString(2, boardDTO.getTitle());
            pstmt.setString(3, boardDTO.getContent());

            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //2. 글을 수정하는 메소드
    public void update(BoardDTO boardDTO){
        String query = "UPDATE `board` SET `title` = ?, `content` = ?, `updatedDate` = NOW() WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, boardDTO.getTitle());
            pstmt.setString(2, boardDTO.getContent());
            pstmt.setInt(3, boardDTO.getId());

            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //3. 글을 삭제하는 메소드
    public void delete(int id){
        String query = "DELETE FROM `board` WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //4. 글 목록을 불러오는 메소드
    public ArrayList<BoardDTO> selectAll(){
        ArrayList<BoardDTO> list = new ArrayList<>();
        String query = "SELECT * FROM `board` ORDER BY `id` DESC";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                BoardDTO b = new BoardDTO();
                b.setId(rs.getInt("id"));
                b.setWriterId(rs.getInt("writerId"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setWrittenDate(rs.getTimestamp("writtenDate"));
                b.setUpdatedDate(rs.getTimestamp("updatedDate"));

                list.add(b);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    //5. 개별 글을 불러오는 메소드
    public BoardDTO selectOne(int id){
        String query = "SELECT * FROM `board` WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                BoardDTO b = new BoardDTO();

                b.setId(rs.getInt("id"));
                b.setWriterId(rs.getInt("writerId"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setWrittenDate(rs.getTimestamp("writtenDate"));
                b.setUpdatedDate(rs.getTimestamp("updatedDate"));

                return b;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
