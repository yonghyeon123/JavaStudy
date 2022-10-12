package datatype;

// 학생 클래스
public class Student {
    // 필드
    private int id;
    private String name;
    private int koreanScore;
    private int englishScore;
    private int mathScore;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setKoreanScore(int koreanScore){
        this.koreanScore = koreanScore;
    }

    public int getKoreanScore(){
        return koreanScore;
    }

    public void setEnglishScore(int englishScore){
        this.englishScore = englishScore;
    }

    public int getEnglishScore(){
        return englishScore;
    }

    public void setMathScore(int mathScore){
        this.mathScore = mathScore;
    }

    public int getMathScore(){
        return mathScore;
    }

    // 메소드
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {

    }

    public int calculateSum() {
        return koreanScore + englishScore + mathScore;
    }

    public double calculateAverage() {
        final int SUBJECT_SIZE = 3;
        return (double) calculateSum() / SUBJECT_SIZE;
    }

    public void printInfo() {
        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", koreanScore, englishScore, mathScore);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", calculateSum(), calculateAverage());
    }

    public boolean equals(Object o) {
        if (o instanceof Student) {
            // 만약 파라미터로 들어온 객체가 Student의 인스턴스가 맞으면
            // o를 명시적 형변환을 통해서 Student 객체로 바꿔준다.
            Student s = (Student) o;

            return this.id == s.id;
        }


        return false;
    }
}













