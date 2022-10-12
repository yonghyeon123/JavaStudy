package day0919;
// 논리연산자
// 논리연산자는 boolean 값에 대한 연산을 한다.

// &&: AND 연산자
// 왼쪽과 오른쪽 모두 true일 때에만 true가 나온다.

// ||: OR 연산자
// 왼쪽과 오른쪽 둘 중 하나라도 true이면 true가 나온다.

// !: NOT 연산자
// 해당 boolean값의 반대 값을 연산한다.
public class Ex11Operator4 {
    public static void main(String[] args) {
        // 1. AND 연산자
        System.out.println("true && true: " + (true && true));
        System.out.println("true && false: " + (true && false));
        System.out.println("false && true: " + (false && true));
        System.out.println("false && false: " + (false && false));

        // 2. OR 연산자
        System.out.println("true || true: " + (true || true));
        System.out.println("true || false: " + (true || false));
        System.out.println("false || true: " + (false || true));
        System.out.println("false || false: " + (false || false));

        // 3. NOT 연산자
        boolean isTrue = true;
        System.out.println("isTrue: " + isTrue);
        System.out.println("!isTrue: " + !isTrue);
        System.out.println("isTrue: " + isTrue);

        // AND 연산자 혹은 OR 연산자를 다룰 때 주의해야할 점
        // AND 연산자와 OR 연산자는 만약 왼쪽의 값이 결정적인 값이면
        // 뒤쪽의 값은 계산 되지 않는다.

        // int 변수 2개를 만들어 각각 5와 6을 넣고 출력
        int number1 = 5;
        int number2 = 6;

        System.out.println("number1: " + number1);
        System.out.println("number2: " + number2);

        // number1이 5보다 크고 그리고 number2+=3 의 값이 6보다 크면 true가 출력되게 코드를 작성해보자
        System.out.println("number1 > 5 && number2+=3 > 6 : " + (number1 > 5 && (number2 += 3) > 6));
        System.out.println("number1: " + number1);
        System.out.println("number2: " + number2);

        // 특정 변수의 값이 특정 범위에 속하는지 체크할 때에도 우리는
        // 반드시 논리 연산자를 사용해야 한다.
        // 예시: number1의 현재 저장된 값이 0이상 10 이하이면 true가 출력되게 코드를 작성해보자
        // 0 <= number1 <= 10

        System.out.println("number1이 0 이상 10이하입니까? " + (0 <= number1 && number1 <= 10));

        // 비록 이것은 문법적으로 옳다/그르다 라는 개념은 아니지만
        // 격식을 차린(=formal) 표현식의 경우 변수가 연산자의 왼쪽, 비교대상이 연산자의 오른쪽에
        // 나오게 된다.
        // 즉 위의 0 <= number1은 틀린 표현식은 절대로 아니지만
        // 격식을 차린 표현식은 number1 >= 0 으로 쓰는 경우가 대부분이다.

    }
}



















