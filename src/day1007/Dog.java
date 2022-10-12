package day1007;

// 인터페이스 상속은 implements 라는 키워드를 통하여 이루어진다.

public class Dog implements AnimalInterface{

    public void move() {
        System.out.println("강아지가 네발로 뛰어다닙니다.");
    }

    public void eat() {
        System.out.println("강아지가 갈비뼈를 뜯어먹습니다.");
    }

    public void makeSound() {
        System.out.println("댕댕");
    }
}
