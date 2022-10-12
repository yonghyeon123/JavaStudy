package day0920;
// 중첩 if문
// 중첩 if문이란 한개의 커다란 if문 안에
// 새로운 if문 구조가 나오는 형태를 중첩 if문이라고 한다.
// 단, 중첩되는 구조는 if문 뿐만이 아니라 다른 제어문에서도 만들 수 있는 구조이다.
public class Ex12NestedIf {
    public static void main(String[] args){
        int number = 5;

        if(number > 0){
            System.out.println("양의 정수입니다.");

            if(number < 10){
                System.out.println("한자리 양의 정수입니다.");
            } else if(number < 100){
                System.out.println("두자리 양의 정수입니다.");
            } else {
                System.out.println("세자리 이상의 양의 정수입니다.");
            }

        } else {
            System.out.println("양의 정수가 아닙니다.");
        }

    }
}
