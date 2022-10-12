package controller;

import model.StudentDTO;
import model.UserDTO;

import java.util.ArrayList;

public class UserController {
    private ArrayList<UserDTO> list;
    private int nextId;

    public UserController(){
        list = new ArrayList<>();
        nextId = 1;
    }

    public void insert(UserDTO userDTO){
        userDTO.setId(nextId++);
        list.add(userDTO);
    }

    public ArrayList<UserDTO> selectAll(){
        ArrayList<UserDTO> temp = new ArrayList<>();
        for(UserDTO u : list){
            temp.add(new UserDTO(u));
        }

        return temp;
    }

    public UserDTO selectOne(int id){
        UserDTO temp = new UserDTO();
        temp.setId(id);
        if(list.contains(temp)){
            int index = list.indexOf(temp);
            return new UserDTO(list.get(index));
        }

        return null;
    }

    public int updateUserIndex(UserDTO userDTO){
        int index = list.indexOf(userDTO);

        return index;
    }

    public void update(UserDTO userDTO){
        int index = list.indexOf(userDTO);
        list.set(index, userDTO);
    }

    public void delete(int id){

    }
}
