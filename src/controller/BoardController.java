package controller;

import model.BoardDTO;

import java.util.ArrayList;

public class BoardController {
    private ArrayList<BoardDTO> list;
    private int nextId;

    public BoardController(){
        list = new ArrayList<>();
        nextId = 1;
    }

    public void insert(BoardDTO boardDTO){
        boardDTO.setId(nextId++);

        list.add(boardDTO);
    }

    public ArrayList<BoardDTO> selectAll(){
        ArrayList<BoardDTO> temp = new ArrayList<>();
        for(BoardDTO b : list){
            temp.add(new BoardDTO(b));
        }

        return temp;
    }

    public BoardDTO selectOne(int id){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(id);

        if(list.contains(boardDTO)){
            int index = list.indexOf(boardDTO);
            return new BoardDTO(list.get(index));
        }

        return null;
    }

    public void update(BoardDTO boardDTO){
        int index = list.indexOf(boardDTO);
        list.set(index, boardDTO);
    }

    public void delete(int id){
        list.remove(selectOne(id));
    }
}
