package answer.controller;

import answer.model.UserDTO;

import java.util.ArrayList;

public class UserController {
    private ArrayList<UserDTO> list;
    private int nextId;

    public UserController() {
        list = new ArrayList<>();
        nextId = 1;

        UserDTO u = new UserDTO();
        u.setUsername("a");
        u.setPassword("a");
        u.setNickname("사용자1");

        insert(u);
    }

    public void insert(UserDTO userDTO) {
        userDTO.setId(nextId++);
        list.add(userDTO);
    }

    public boolean validateUsername(String username) {
        for (UserDTO u : list) {
            if (username.equalsIgnoreCase(u.getUsername())) {
                return true;
            }
        }

        return false;
    }

    public UserDTO auth(String username, String password) {
        for (UserDTO u : list) {
            if (username.equalsIgnoreCase(u.getUsername()) && password.equals(u.getPassword())) {
                return new UserDTO(u);
            }
        }

        return null;
    }

    public void update(UserDTO userDTO) {
        int index = list.indexOf(userDTO);
        list.set(index, userDTO);
    }

    public void delete(int id) {
        UserDTO temp = new UserDTO();
        temp.setId(id);
        list.remove(temp);
    }

    public UserDTO selectOne(int id) {
        UserDTO temp = new UserDTO(id);
        if (list.contains(temp)) {
            return list.get(list.indexOf(temp));
        }
        return null;
    }
}









