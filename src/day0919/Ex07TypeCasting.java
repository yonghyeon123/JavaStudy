package day0919;
// 형변환(Type Casting)
// 형변환이란, 특정 데이터타입의 값을 다른 데이터타입으로 바꾸는 과정을 형변환이라고 한다.
// 형변환에는 크게 암시적 형변환과 명시적 형변환 2가지가 있다.

// 암시적 형변환:
// 더 작은 데이터타입의 값을 더 큰 데이터타입으로 변환하거나
// 정수형 데이터타입의 값을 실수형 데이터타입으로 변환할 때 발생된다.
// 예시: byte를 int로 바꿀때 or byte를 double로 바꿀 때

// 명시적 형변환:
// 더 큰 데이터타입의 값을 더 작은 데이터타입으로 변환하거나
// 실수형 데이터타입의 값을 정수형 데이터타입으로 변환할때 발생된다.
// 예시: int를 byte로 바꿀때 or double을 int로 바꿀 때

public class Ex07TypeCasting {
    public static void main(String[] args) {
        // byte 변수 myByte를 선언하고 20을 저장
        byte myByte = 20;

        // 1. 암시적 형변환
        // 암시적 형변환은 우리가 코드를 별도로 작성하지 않더라도 자동으로 자바가 변환시켜 준다.
        // A. byte의 값을 int로 변환해서 저장해보자
        // int 변수 number를 선언하고 myByte의 현재 값을 저장해보자
        int number = myByte;
        // number의 현재 값을 화면에 출력
        System.out.println(number);

        // B. byte의 값을 double로 변환해서 저장해보자
        // double 변수 myDouble을 선언하고 myByte의 현재 값을 저장해보자
        double myDouble = myByte;
        // myDouble의 현재 값을 화면에 출력
        System.out.println(myDouble);

        // 2. 명시적 형변환
        // 명시적 형변환의 경우 우리가 별도의 코드를 적어주지 않으면
        // 무조건 에러가 발생한다.
        // 명시적 형변환을 하는 방법은
        // 바꿀 값 앞에 (바꿀 데이터타입)을 붙여주면 된다.
        // A. int 값을 byte 공간에 저장해보자
        // number의 현재 값을 myByte에 저장해보자
        myByte = (byte) number;
        // myByte의 현재 값을 화면에 출력해보자
        System.out.println(myByte);

        // B. double 값을 int 공간에 저장해보자
        // number에 3.14를 저장해보자
        number = (int) 3.14;
        // number의 현재 값을 출력해보자
        System.out.println(number);
    }
}
