package day0919;
// 자료형(Data Types)
// 자료형이란 해당 변수 혹은 상수 공간이 어떤 종류의 값을 가질지를 지정한다.
// 자료형에는 크게 기본형과 참조형 데이터타입이 있다.
// 기본형: Primitive Types 라고 하며 해당 공간에 2진법으로 변환된 값이 직접 저장이 된다.
// 기본형 데이터타입에는 정수형, 실수형, 논리형, 문자형 4가지 종류가 있고
// 정수형에는 byte short int long
// 실수형에는 float double
// 논리형에는 boolean
// 문자형에는 char
// 8가지 데이터타입이 존재한다.

// 참조형: Reference Types 라고 하며 해당 공간에는 실제 값이 저장된 공간의 주소 값이 저장된다.
// 참조형에는 배열형, 클래스형, 인터페이스형 세가지 종류가 존재한다.


public class Ex06DataType {
    public static void main(String[] args) {
        // 1. 기본형 데이터타입
        System.out.println("1. 기본형 데이터타입");
        // A. 정수형
        // 정수형 데이터타입에는 byte, short, int, long 4가지 종류가 있고
        // 각각 표현 가능한 범위가 다르다.
        // 하지만 자바에서는 기본적으로 모든 정수를 int 라고 인식하기 때문에
        // 우리는 int 데이터타입을 주로 사용하게 된다.
        // 각 데이터타입의 범위
        // 1. byte: -2^7(-128) 부터 2^7 - 1(127) 까지 총 2^8개의 숫자(=8비트)
        // 2. short: -2^15 (-32678) 부터 2^15 - 1(32677) 까지 총 2^16개의 숫자(=16비트)
        // 3. int: -2^31(-2147483648) 부터 2^31 - 1(2147483647) 까지 총 2^32개의 숫자(=32비트)
        // 4. long: -2^63(엄청나게 작은 수) 부터 2^63 - 1(엄청나게 큰 수) 까지 총 2^64개의 숫자(=64비트)

        System.out.println("A. 정수형");
        // byte 변수 myByte를 선언하고 20을 저장해보자
        byte myByte = 20;
        // myByte의 현재 값을 화면에 출력해보자
        System.out.println(myByte);
        // 만약 byte 변수 myByte에 범위를 벗어난 값을 저장할려고 하면?
        // myByte에 1000을 저장해보자
        // myByte = 1000; -> 에러 발생

        System.out.println("--------------------------");
        System.out.println("B. 실수형");
        // 실수란? 소숫점이 존재하는 숫자
        // 실수에는 크게 float과 double 2가지 데이터타입이 있다.
        // float: 32비트의 실수 공간
        // double: 64비트의 실수 공간
        // 정수형과 마찬가지로, 우리는 double 데이터타입을 사용하게 된다.

        // double 데이터타입의 변수 myDouble을 선언하고 3.14를 저장해보자
        double myDouble = 3.14;
        // myDouble의 현재 값을 화면에 출력해보자
        System.out.println(myDouble);
        // 만약 double 공간에 정수를 저장하면 어떻게 될까?
        // myDouble에 4를 저장해보자
        myDouble = 4;
        // myDouble의 현재 값을 화면에 출력해보자
        System.out.println(myDouble);
        // 만약 정수형 공간에 실수를 저장하면?
        // myByte에 3.0을 저장해보자
        // myByte = 3.0; -> 소숫점 이하가 날라가므로 에러 발생

        System.out.println("--------------------------");
        // 논리형
        System.out.println("C. 논리형");
        // 논리형 데이터타입에는 true 혹은 false라는 2가지 값만 저장 가능하다.
        // 단, 우리가 논리형 데이터타입의 변수 혹은 상수를 직접 선언하고 초기화하여 사용하기 보다는
        // 나중에 배우게 될 연산자 라는 것의 결과값이나 method의 결과값을 그대로 쓰는 경우가 많다.

        // boolean 데이터타입의 변수 isTrue를 선언하고 true를 저장해보자
        boolean isTrue = true;

        // isTrue의 현재 값을 화면에 출력해보자
        System.out.println(isTrue);

        // isTrue에 false를 저장해보자
        isTrue = false;

        // isTrue의 현재 값을 화면에 출력해보자
        System.out.println(isTrue);

        System.out.println("--------------------------");

        System.out.println("D. 문자형");
        // 문자형 데이터타입의 값은 따옴표(')로 감싸지되
        // 한번에 한개의 글자만 저장 가능하다.

        // char 타입의 변수 myChar를 선언하고 대문자 A를 저장해보자
        char myChar = 'A';
        // myChar의 현재 값을 화면에 출력해보자
        System.out.println(myChar);
        // myChar에 'AB'를 저장해보자
        // myChar = 'AB'; -> char 데이터타입은 한번에 1개의 글자만 저장 가능하므로 에러가 발생

        // '' vs ""
        // '': char 데이터타입의 값을 뜻하며 한 번에 1개의 글자만 처리가능하다.
        // "": String 데이터타입의 값을 뜻하며 0개 이상의 글자를 처리 가능하다.

        System.out.println("--------------------------");
    }
}










