package day0919;
// 연산자(Operator)
// 연산이란?
// 일정한 규칙에 따라서 "계산"함

// 연산자란?
// 프로그래밍에서 연산자란, 수학적 기호에 컴퓨터의 실행할 코드가 미리 정의되어있어서
// 우리가 연산자를 실행시키면 내부적으로 해당 코드들이 자동으로 실행되어
// 결과값을 우리가 받게 된다.

// 연산자에는 크게 다섯가지 종류가 있다.
// 1. 산술 연산자
// 2. 할당 연산자
// 3. 비트 연산자 -> 배우지 않는다.
// 4. 비교 연산자
// 5. 논리 연산자

public class Ex08Operator {
    public static void main(String[] args) {
        // 산술연산자
        // 산술연산자란?
        // 기본적인 수학 사칙연산 + 나머지 연산
        // 단, 산술연산자를 사용할때 주의할 점은
        // 결과값은 반드시 데이터손실이 발생하지 않는 데이터타입이 결과값으로 나오게 된다라는 것이다.
        // +: 왼쪽의 값과 오른쪽 값을 더한 결과값을 "연산"한다.
        // -: 왼쪽의 값에서 오른쪽 값을 뺀 결과값을 연산한다.
        // *: 왼쪽의 값과 오른족 값을 곱한 결과값을 연산한다.
        // /: 왼쪽의 값에서 오른쪽 값을 나눈 "몫"을 연산한다.
        // %: 왼쪽의 값에서 오른쪽 값을 나눈 "나머지"를 연산한다.

        // 1. 정수끼리의 산술 연산
        // 정수끼리의 산술 연산의 경우 결과 값이 무조건 정수의 데이터타입을 가지게 된다.

        // 정수 데이터타입 변수 2개를 선언하고 각각 10과 20으로 초기화해보자
        int number1 = 10;
        int number2 = 20;

        // 1. +
        System.out.println(number1 + number2);
        // 2. -
        System.out.println(number1 - number2);
        // 3. *
        System.out.println(number1 * number2);
        // 4. /
        System.out.println(number1 / number2);
        // 5. %
        System.out.println(number1 % number2);

        // 실수와 실수의 산술연산
        // 이 때에는 결과값이 무조건 실수로 나오게 된다.
        // double 데이터타입의 변수를 2개 만들고 각각 10.0과 20.0으로 초기화해보자
        double d1 = 10.0;
        double d2 = 20.0;
        // 1. +
        System.out.println(d1 + d2);
        // 2. -
        System.out.println(d1 - d2);
        // 3. *
        System.out.println(d1 * d2);
        // 4. /
        System.out.println(d1 / d2);
        // 5. %
        System.out.println(d1 % d2);

        // 정수와 실수끼리의 산술 연산
        // 이때에는 결과값이 실수의 데이터타입을 가지게 된다.

        // number1과 d2를 산술연산 시켜보자
        System.out.println(number1 + d2);
        System.out.println(number1 - d2);
        System.out.println(number1 * d2);
        System.out.println(number1 / d2);
        System.out.println(number1 % d2);

        // 번외
        // 아래의 차잇점을 알아맞춰보세요.
        System.out.println(3 + 4);
        System.out.println("3" + 4);
        // 문자의 덧셈 개념은 왼쪽과 오른쪽을 모두
        // 글자로 바꾸어서 왼쪽 글자 끝에 뒤의 글자를 이어붙여라 라는 의미가 된다.
        // 즉 "3" + 4의 경우에는
        // String 값 "3" 뒤에 int 4를 String으로 바꾸어 "4"로 만들어서
        // 이어붙인 결과값 "34"를 만들어내라 라는 의미가 된다.

        // 그렇다면 아래의 결과값은 어떻게 될까?
        System.out.println("3 + 4: " + 3 + 4);
        // 우리가 원하던 출력 값: "3 + 4: 7"
        // 실제 출력 값 : "3 + 4: 34"
        // 프로그래밍에서도 일반적인 사칙연산의 우선순위가 존재한다.
        // 즉 위에처럼 우선순위가 모두 같을 때에는
        // 왼쪽에서 오른쪽으로 차례대로 계산되기 때문에
        // 1. "3 + 4: " 뒤에 3이 글자로 변환되어 덧붙여진 결과값 "3 + 4: 3" 이 연산된다.
        // 2. "3 + 4: 3" 뒤에 4가 글자로 변환되어 덧붙여진 결과값 "3 + 4: 34"가 연산된다.
        // 3. System.out.println()이 위의 "3 + 4: 34" 라는 결과값을 화면에 출력한다.
        // 라는 순서가 되므로 우리가 원하는 값을 얻지 못한다.

        // 만약 우리가 원하는 결과값을 얻을려면?
        // ()로 뒤의 3+4를 묶어주어야 한다.
        System.out.println("3 + 4: " + (3 + 4));

        // ++, --
        // ++, -- 는 1개의 공간에 대한 특수한 산술연산자로써
        // 해당 공간의 값을 1씩 "증"가시키거나 "감"소시키는
        // 증감연산자라고 부른다.
        // 단, 해당 연산자가 공간의 앞에 붙냐 뒤에 붙냐에 따라서 그 의미가 달라지게 된다.

        // 만약 ++ 혹은 -- 가 공간의 앞에 붙는 경우
        // 우리는 전위 증감연산자라고 하며
        // 해당 연산자는 그 줄에서 가장 빠른 우선순위를 가지게 된다.
        System.out.println("number1의 현재 값: " + number1);
        System.out.println("++number1: " + ++number1);
        // 위의 코드는 한줄로 적혀있지만 실제로는 다음과 같은 과정을 가지게 된다.
        // 1. ++number1이 실행되어 number1의 현재 값이 10에서 11로 증가하게 된다.
        // 2. "++number1: " 뒤에 number1의 현재 값이 String으로 이어져서
        // "++number1: 11"이라는 결과값이 연산된다.
        // 3. System.out.println()이 "++number1: 11"을 화면에 출력시킨다.
        System.out.println("number1의 현재 값: " + number1);

        // 반대로 ++ 혹은 -- 가 변수의 뒤에 붙으면
        // 후위 증감 연산자라고 하며
        // 해당 줄에서 가장 느린 우선순위를 가지게 된다.
        System.out.println("number2의 현재 값: " + number2);
        System.out.println("number2--: " + number2--);
        // 1. "number2--: " 뒤에 number2의 현재 값인 20이 String 값으로 변환되어
        // 이어져서 "number2--: 20" 이라는 String 결과값이 나온다.
        // 2. System.out.println()이 "number2--: 20"을 화면에 출력시킨다.
        // 3. number2-- 가 실행되어 number2의 현재 값이 20에서 19로 1 감소된다.
        
        System.out.println("number2의 현재 값: " + number2);
    }
}















