package day1007;

public class ferret implements AnimalInterface{

    @Override
    public void move() {
        System.out.println("네 발로 낮게 뛰어다닙니다.");
    }

    @Override
    public void eat() {
        System.out.println("야생의 다른 동물을 먹습니다.");
    }

    @Override
    public void makeSound() {
        System.out.println("패럿은 꾹꾹하고 웁니다.");
    }
}
