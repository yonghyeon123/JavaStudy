package answer.model;
// 댓글 DTO
// 댓글 번호, 작성자 회원 번호, 댓글이 달린 게시글 번호, 댓글 내용, 댓글의 작성시간, 댓글의 수정시간
// 5시까지

import java.util.Date;

public class ReplyDTO {
    private int id;
    private int writerId;
    private int boardId;
    private String content;
    private Date writtenDate;
    private Date updatedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    public ReplyDTO() {

    }

    public ReplyDTO(int id) {
        this.id = id;
    }

    public ReplyDTO(ReplyDTO replyDTO) {
        id = replyDTO.id;
        writerId = replyDTO.writerId;
        boardId = replyDTO.boardId;
        writtenDate = replyDTO.writtenDate;
        updatedDate = replyDTO.updatedDate;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ReplyDTO) {
            ReplyDTO r = (ReplyDTO) obj;
            return id == r.id;
        }

        return false;
    }
}
