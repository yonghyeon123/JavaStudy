package day0919;
// 할당 연산자
// 할당 연산자는 오른쪽 값을 연산한 후 왼쪽 공간에 할당(=저장)하는 연산자이다.

public class Ex09Operator2 {
    public static void main(String[] args){
        int number;
        // 1. =
        // 오른쪽 값을 왼쪽 공간에 할당해라
        // 30을 왼쪽 number 공간에 할당(=저장)해라
        number = 30;
        System.out.println("number: " + number);

        // +=
        // 왼쪽 공간의 현재 값에 오른쪽 값을 더한 결과값을
        // 다시 왼쪽 공간에 저장해라
        number += 10;
        System.out.println("number: " + number);

        // -=
        // 왼쪽 공간의 현재 값에 오른쪽 값을 뺀 결과값을
        // 다시 왼쪽 공간에 저장해라
        number -= 7;
        System.out.println("number: " + number);

        // *=
        // 왼쪽 공간의 현재 값에 오른쪽 값을 곱한 결과값을
        // 다시 왼쪽 공간에 저장해라
        number *= 3;
        System.out.println("number: " + number);

        // /=
        // 왼쪽 공간의 현재 값에 오른쪽 값을 나눈 몫을
        // 다시 왼쪽 공간에 저장해라
        number /= 10;
        System.out.println("number: " + number);

        // %=
        // 왼쪽 공간의 현재 값에 오른쪽 값을 나눈 나머지를
        // 다시 왼쪽 공간에 저장해라
        number %= 5;
        System.out.println("number: " + number);

        // String의 경우 =과 +=을 사용할 수 있다.
        String str = "abc";
        System.out.println("str: " + str);
        str += "DEF";
        System.out.println("str: " + str);
    }
}













