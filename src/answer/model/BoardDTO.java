package answer.model;

import datatype.Board;

import java.util.Date;

public class BoardDTO {
    private int id;
    private String title;
    private String content;
    private int writerId;
    private Date writtenDate;
    private Date updatedDate;

    public Date getWrittenDate() {
        return writtenDate;
    }

    public void setWrittenDate(Date writtenDate) {
        this.writtenDate = writtenDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public BoardDTO() {

    }

    public BoardDTO(int id) {
        this.id = id;
    }

    public BoardDTO(BoardDTO origin) {
        id = origin.id;
        title = origin.title;
        content = origin.content;
        writerId = origin.writerId;
        writtenDate = origin.writtenDate;
        updatedDate = origin.updatedDate;
    }

    public boolean equals(Object object) {
        if (object instanceof BoardDTO) {
            BoardDTO b = (BoardDTO) object;

            return id == b.id;
        }

        return false;
    }
}










