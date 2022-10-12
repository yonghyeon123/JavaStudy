package day1007;

public class Cat extends Animal{
    public Cat() {
        System.out.println("Cat Class 생성자 호출");
    }
    public void makeSound(){
        System.out.println("냐옹");
    }

    public void eat() {
        System.out.println("집사야 츄르내놔");
    }
}
