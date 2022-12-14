package answer.model;

public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String nickname;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserDTO() {

    }

    public UserDTO(int id){
        this.id = id;
    }

    public UserDTO(UserDTO original) {
        id = original.id;
        username = original.username;
        password = original.password;
        nickname = original.nickname;
    }

    public boolean equals(Object object) {
        if (object instanceof UserDTO) {
            UserDTO userDTO = (UserDTO) object;
            return id == userDTO.id;
        }

        return false;
    }
}
