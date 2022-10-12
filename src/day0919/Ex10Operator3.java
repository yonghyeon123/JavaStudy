package day0919;

// 비교 연산자
// 비교 연산자의 경우에는 왼쪽과 오른쪽을 비교하여
// 해당 연산자가 맞는지 틀리는지 연산한다.
// 즉 결과값이 true/false의 boolean이 나오게 된다.
public class Ex10Operator3 {
    public static void main(String[] args) {
        // 비교 연산자를 사용하기 위해 2개의 int 변수를 선언하고 각각 4, 5를 저장한다.
        int number1 = 4;
        int number2 = 5;

        // >, <
        System.out.println("number1 > number2: " + (number1 > number2));
        System.out.println("number1 > 0: " + (number1 > 0));
        System.out.println("number1 > 4: " + (number1 > 4));

        // >=, <=
        System.out.println("number1 > 4: " + (number1 > 4));
        System.out.println("number1 >= 4: " + (number1 >= 4));

        // ==, !=
        // ==은 2개의 값이 같으면 true, 다르면 false가 나온다.
        // !=은 2개의 값이 같으면 false, 다르면 true가 나온다.
        System.out.println("number1 == 4: " + (number1 == 4));
        System.out.println("number1 != 4: " + (number1 != 4));

        // 단, 비교 연산자를 사용할때 한가지 주의할 점은
        // 기본형 데이터타입의 값 혹은 공간에는 결과가 정확하게 나오지만
        // 참조형 데이터타입일 때에는 결과값이 부정확할 수도 있다 라는 점이다.

        // String 클래스타입
        // String 클래스타입은 여러개의 문자를 한번에 처리하기 위한 클래스로써
        // 우리가 "" 이라고 쓰면 String 클래스 타입의 값을 만들게 된다.

        // String 클래스 타입의 값을 초기화하는 3가지 방법

        String str1 = "abc";
        String str2 = str1;
        String str3 = new String("abc");

        // 정말로 위의 String 변수가 "abc"라는 글자가 있는지 확인하기 위해
        // []에 넣어서 출력해보자

        System.out.println("str1: [" + str1 + "]");
        System.out.println("str2: [" + str2 + "]");
        System.out.println("str3: [" + str3 + "]");

        System.out.println("==을 통한 String 변수의 값 비교");
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1 == str3: " + (str1 == str3));
        System.out.println("str2 == str3: " + (str2 == str3));

        // 비교 연산자는 해당 공간에 저장된 값을 토대로 하여 같은지/다른지를 비교하게 되는데
        // 참조형 데이터타입의 경우 해당 공간에는 주소값이 저장된다.
        // 즉, 우리가 실제로 원했던 것은 str1의 실제 저장값인 "abc"와 str2의 실제 저장값인
        // "abc"를 비교하여 같으면 true, 다르면 false를 확인하고 싶었지만
        // 비교연산자를 사용하였기 때문에 실제 값이 아니라 해당 공간에 저장된 주소값을 토대로하여
        // 비교하였기 때문에 str1과 str2는 같은 주소값을 갖도록 코드를 작성하여서 true가 나왔지만
        // str3은 나머지와 다른 주소값을 가지고 있으므로 false가 나오게 된다.
        // 따라서 참조형 데이터타입의 값 비교는 비교연산자를 통하여 하면 안된다.

        // 따라서 참조형 데이터타입 중 클래스형 혹은 인터페이스형 데이터타입의 값 또는 공간안의 저장된
        // 값을 비교할 때에는
        // 비교연산자가 아닌
        // equals() 라는 메소드를 통하여 비교를 해야한다.
        System.out.println("str1.equals(str2): " + str1.equals(str2));
        System.out.println("str1.equals(str3): " + str1.equals(str3));
        System.out.println("str2.equals(str3): " + str2.equals(str3));

    }
}













