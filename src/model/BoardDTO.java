package model;

public class BoardDTO {
    //필드
    private int id;
    private String writer;
    private String title;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean equals(Object object){
        if(object instanceof BoardDTO){
            BoardDTO boardDTO = (BoardDTO) object;
            return id == boardDTO.id;
        }

        return false;
    }

    public BoardDTO(){

    }

    public BoardDTO(BoardDTO boardDTO){
        id = boardDTO.id;
        writer = boardDTO.writer;
        title = boardDTO.title;
        content = boardDTO.content;
    }
}
