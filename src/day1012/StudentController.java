package day1012;
// 컨트롤러
// 컨트롤러는 뷰어에서 사용자가 보낸 요청을 데이터베이스와 통신하여
// 그 결과를 다시 뷰어에 보내주는 중간다리 역할을 한다고 생각하면 좋다.
// 단, 우리는 현재 데이터베이스나 서버가 없기 때문에
// 이 컨트롤러 안에 ArrayList 필드를 사용해서
// 유사 데이터베이스 역할을 맡길 것이다.

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class StudentController {
    private Connection connection;
    private final String ADDRESS = "jdbc:mysql://localhost:3306/sqlbasic";
    private final String USERNAME = "root";
    private final String PASSWORD = "1111";

    public StudentController() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    // A. 사용자가 입력한 값을 데이터베이스에 추가하는
    // insert(StudentDTO)
    public void insert(StudentDTO studentDTO) {
        String query = "INSERT INTO `student`(`name`, `korean`, `english`, `math`) VALUES(?, ?, ?, ?)";
        try {

            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, studentDTO.getName());
            pstmt.setInt(2, studentDTO.getKorean());
            pstmt.setInt(3, studentDTO.getEnglish());
            pstmt.setInt(4, studentDTO.getMath());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // B. 현재 데이터베이스의 내용을 리턴해주는
    //    selectAll()
    public ArrayList<StudentDTO> selectAll() {
        ArrayList<StudentDTO> temp = new ArrayList<>();

        String query = "SELECT * FROM `student`";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                StudentDTO s = new StudentDTO();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setKorean(rs.getInt("korean"));
                s.setEnglish(rs.getInt("english"));
                s.setMath(rs.getInt("math"));

                temp.add(s);
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

    // C. 특정 id 값을 가진 StudentDTO 객체를 리턴해주는
    //    selectOne(int)
    public StudentDTO selectOne(int id) {
        String query = "SELECT * FROM `student` WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                StudentDTO s = new StudentDTO();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setKorean(rs.getInt("korean"));
                s.setEnglish(rs.getInt("english"));
                s.setMath(rs.getInt("math"));

                return s;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // D. 사용자가 수정한 값을 가진 StudentDTO 객체를
    //    데이터베이스에 반영하는 update(StudentDTO)
    public void update(StudentDTO studentDTO) {
        String query = "UPDATE `student` SET `korean` = ?, `english` = ?, `math` = ? WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, studentDTO.getKorean());
            pstmt.setInt(2, studentDTO.getEnglish());
            pstmt.setInt(3, studentDTO.getMath());
            pstmt.setInt(4, studentDTO.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // E. 특정 id 값을 가진 객체를 데이터베이스에서 삭제하는
    //    delete(int)
    public void delete(int id) {
        String query = "DELETE FROM `student` WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
