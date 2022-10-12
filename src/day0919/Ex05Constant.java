package day0919;
// 상수(Constant)
// 상수란, 한번 값이 저장되면 더이상 새로운 값을 저장하지 못하는 공간을 상수라고 한다.
// 상수는 다음과 같이 선언한다.
// final 데이터타입 상수이름;
// 상수 공간에 값을 저장할 때는 다음과 같이 저장한다.
// 상수이름 = 값;

public class Ex05Constant {
    public static void main(String[] args){
        // int 상수 NUMBER를 선언해보자
        final int NUMBER;

        // NUMBER에 20을 저장해보자
        NUMBER = 20;

        // NUMBER에 현재 저장된 값을 출력해보자
        System.out.println(NUMBER);

        // NUMBER에 새로운 값 30을 저장해보자
        // NUMBER = 30;

        // NUMBER에 20을 저장해보자
        // NUMBER = 20;
        // 기존 상수 공간 NUMBER에 얼마가 있었던 간에
        // 저장하기 위해 = 값; 이라는 코드를 적어주게 되면
        // 해당 공간에 새로운 값을 덮어 씌운다 라는 의미가 되므로 에러가 발생하게 된다.

    }
}
