package controller;
// 컨트롤러
// 컨트롤러는 뷰어에서 사용자가 보낸 요청을 데이터베이스와 통신하여
// 그 결과를 다시 뷰어에 보내주는 중간다리 역할을 한다고 생각하면 좋다.
// 단, 우리는 현재 데이터베이스나 서버가 없기 때문에
// 이 컨트롤러 안에 ArrayList 필드를 사용해서
// 유사 데이터베이스 역할을 맡길 것이다.

import model.StudentDTO;

import java.util.ArrayList;

public class StudentController {
    private ArrayList<StudentDTO> list;
    private int nextId;

    public StudentController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    // A. 사용자가 입력한 값을 list에 추가하는
    // insert(StudentDTO)
    public void insert(StudentDTO studentDTO) {
        studentDTO.setId(nextId++);

        list.add(studentDTO);
    }

    // B. 현재 어레이리스트의 내용을 리턴해주는
    //    selectAll()
    public ArrayList<StudentDTO> selectAll() {
        ArrayList<StudentDTO> temp = new ArrayList<>();
        for (StudentDTO s : list) {
            temp.add(new StudentDTO(s));
        }

        return temp;
    }

    // C. 특정 id 값을 가진 StudentDTO 객체를 리턴해주는
    //    selectOne(int)
    public StudentDTO selectOne(int id) {
        StudentDTO temp = new StudentDTO();
        temp.setId(id);
        if (list.contains(temp)) {
            int index = list.indexOf(temp);
            StudentDTO origin = list.get(list.indexOf(temp));
            StudentDTO result = new StudentDTO(list.get(list.indexOf(temp)));
            return new StudentDTO(list.get(list.indexOf(temp)));
        }

        return null;
    }

    // D. 사용자가 수정한 값을 가진 StudentDTO 객체를
    //    list에 반영하는
    //    update(StudentDTO)
    public void update(StudentDTO studentDTO) {
        int index = list.indexOf(studentDTO);
        list.set(index, studentDTO);
    }

    // E. 특정 id 값을 가진 객체를 list에서 삭제하는
    //    delete(int)
    public void delete(int id) {
        list.remove(selectOne(id));
    }
}
