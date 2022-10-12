package datatype;

public class Board {
    // 필드
    private int id;
    private String writer;
    private String title;
    private String content;

    // 메소드
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equals(Object object){
        if(object instanceof Board){
            Board b = (Board)object;
            return id == b.id;
        }
        return false;
    }

    public void printBoard() {
        System.out.println("\n========================================");
        System.out.println("글 제목: " + title);
        System.out.println("글 번호: " + id);
        System.out.println("----------------------------------------");
        System.out.println("작성자: " + writer);
        System.out.println("----------------------------------------");
        System.out.println("내용");
        System.out.println("----------------------------------------");
        System.out.println(content);
        System.out.println("========================================\n");
    }

    public void printShort() {
        System.out.printf("%d번 글: %s\n", id, title);
    }

}











