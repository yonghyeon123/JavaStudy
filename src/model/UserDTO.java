package model;

public class UserDTO {
    private int id;             //유저 아이디번호
    private String username;    //유저 아이디
    private int password;       //유저 패스워드
    private String nickname;    //유저 닉네임

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean equals(Object object){
        if(object instanceof UserDTO){
            UserDTO userDTO = (UserDTO) object;
            return id == userDTO.id;
        }

        return false;
    }

    public UserDTO(){

    }

    public UserDTO(UserDTO userDTO){
        id = userDTO.id;
        username = userDTO.username;
        password = userDTO.password;
        nickname = userDTO.nickname;
    }
}
