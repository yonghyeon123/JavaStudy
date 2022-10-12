package day1012;
// 모델
// 모델 클래스는
// 컨트롤러와 뷰어가 서로 통신할 때에
// 데이터들을 담을 틀의 역할을 한다.
// 따라서, 모델 클래스에는 필드, 겟터/셋터, 그리고 java.lang.Object의 오버라이드 메소드만 들어간다.

public class StudentDTO {
    // 필드
    private int id;
    private String name;
    private int korean;
    private int english;
    private int math;

    // 메소드

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public boolean equals(Object object) {
        if (object instanceof StudentDTO) {
            StudentDTO studentDTO = (StudentDTO) object;
            return id == studentDTO.id;
        }

        return false;
    }
}
