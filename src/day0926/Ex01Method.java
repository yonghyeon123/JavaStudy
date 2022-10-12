package day0926;
// 메소드
// 메소드란 우리가 특정 목표를 위해
// 특정 여러줄의 코드를 여러번 사용해야할 경우,
// 그 코드를 하나의 명령어로 압축시키는 방법이다.
// 즉, 우리가 기존에 사용하던
// System.out.println("입력할 값")
// System.out.print("> ")
// 변수 = 스캐너.메소드()
// 의 경우, 굳이 저 위의 3줄을 전부 적는것이 아니라
// 스캐너의 nextInt()와 같이 메소드로 만들면 간단하게
// 실행 가능하게 된다.

// 메소드는 변수처럼 반드시 선언과 정의 가 이루어져야 하는데
// 그 과정은 다음과 같다.

// public static 리턴타입 메소드이름(파라미터) {
//      이 메소드가 호출될때 실행될 코드
// }

// 리턴타입
// 리턴타입이란 해당 메소드가 모든 내용을 실행하고 나서
// 호출된 곳으로 보내줄 값의 데이터타입을 뜻한다.
// 단, 만약 해당 메소드가 호출된 곳으로 아무런 값도 보내주지 않을 때에는
// 우리가 void 라고 적는다.
// 또한 리턴타입이 존재하는 경우, 반드시 해당 메소드 내에서는
// return 이라는 명령어를 통해
// 해당 리턴타입의 값을 호출된 곳으로 보내주어야 한다.

// 메소드 이름
// 소문자로 시작하고 낙타등 표기법을 사용하는 동사

// 파라미터
// 파라미터란 한국 코딩 교과서에는 주로 매개 변수라고 불린다.
// 좀더 쉽게 표현하자면 매개변수란 해당 메소드를 실행시킬 때
// 외부로부터 반드시 받아와야 그 메소드가 정상적으로 돌아갈 경우
// 그 외부로부터 받아올 값을 변수로 처리해서 받는 것을 뜻한다.
// 또한, 파라미터의 경우, 우리가 필요하다면 필요한 만큼을
// 적어줄 수 있는데 각각의 파라미터는 일종의 변수 선언과 똑같은 모습을 가지게 된다.
// 즉, 파라미터는 데이터타입 변수이름 으로 적어주고
// 유효범위는 해당 메소드 전체인 변수와 같다.
// 단, 해당 메소드가 아무런 파라미터를 필요로 하지 않는 경우,
// 아무 파라미터도 안 넣어줘도 된다.

// 메소드 오버로딩(Overloading)
// 오버로딩이란, 파라미터가 다르지만 같은 목적을 지닌 메소드들을 만들 경우,
// 이름을 통일 시켜서 우리가 이름에 대한 고민을 해도 덜하게 만들어주는 방법이다.
// 예를 들어 System.out.println() 의 경우,
// 파라미터가 boolean일때, int일때, char일때, String 일때 등등 다양하게 있지만
// 목적은 모두, 파라미터의 내용을 화면에 출력하고 그 후에 출력위치를 바꾸라 라는 의미가 되는데
// 굳이 메소드 이름을 다 다르게 하는것이 아니라 println()으로 통일시키게 된다.
// 단, 파라미터는 모두다 달라야 하는데 파라미터가 다르다 라는 의미는
// 파라미터의 데이터타입의 등장 순서가 다르다 라는 의미이다.

import java.util.Random;

public class Ex01Method {
    public static void main(String[] args) {
        printMessage();
        printMessage();
        printMessage();

        printBigger(1, 2);
        printBigger(3, 6);
        printBigger(3, 2);
        printBigger(1, 5);

        int x = getRandomNum();
        System.out.println(x);

        System.out.println(getRandomNum());

        printBigger(getRandomNum(), getRandomNum());

        int a = 30;
        int b = 45;

        System.out.println("a / b를 실수로 바꾸면?");
        System.out.println((double) a / b);
    }

    public static void printMessage() {
        System.out.println("a");
        System.out.println("B");
        System.out.println("cdcdc");
    }

    public static void printBigger(int a, int b) {
        if (a > b) {
            System.out.println("첫번째 숫자가 더 큽니다.");
        } else {
            System.out.println("두번째 숫자가 더 큽니다.");
        }
    }

    public static int getRandomNum() {
        int max = 10;
        int min = 1;
        Random random = new Random();
        System.out.println("랜덤 뽑기!!!");
        System.out.println("1~10사이의 랜덤한 숫자를 만들고 있습니다.");
        System.out.println("숫자 완성 1초전!!!");
        System.out.println("당신의 숫자는...!");
        int num = random.nextInt(max) + min;
        return num;
    }

    public static double divideInt(int num, int num2) {
        return (double) num / num2;
    }

}














