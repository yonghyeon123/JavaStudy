package answer.controller;

import answer.model.BoardDTO;

import java.util.ArrayList;
import java.util.Date;

public class BoardController {
    private ArrayList<BoardDTO> list;
    private int nextId;

    public BoardController() {
        list = new ArrayList<>();
        nextId = 1;

        for (int i = 1; i <= 3; i++) {
            BoardDTO b = new BoardDTO();
            b.setWriterId(1);
            b.setTitle("제목 " + i);
            b.setContent("내용 " + i);

            add(b);
        }
    }

    public void add(BoardDTO boardDTO) {
        boardDTO.setId(nextId++);
        boardDTO.setWrittenDate(new Date());
        boardDTO.setUpdatedDate(new Date());
        list.add(boardDTO);
    }

    public ArrayList<BoardDTO> selectAll() {
        ArrayList<BoardDTO> temp = new ArrayList<>();

        for (BoardDTO boardDTO : list) {
            temp.add(new BoardDTO(boardDTO));
        }

        return temp;
    }

    public BoardDTO selectOne(int id) {
        BoardDTO temp = new BoardDTO(id);

        if (list.contains(temp)) {
            return list.get(list.indexOf(temp));
        }

        return null;
    }

    public void update(BoardDTO boardDTO) {
        boardDTO.setUpdatedDate(new Date());
        list.set(list.indexOf(boardDTO), boardDTO);
    }

    public void delete(int id) {
        list.remove(new BoardDTO(id));
    }

    public void deleteByWriterId(int writerId) {
        ArrayList<BoardDTO> temp = new ArrayList<>();

        for (BoardDTO b : list) {
            if (writerId != b.getWriterId()) {
                temp.add(b);
            }
        }

        list = temp;
    }
}
