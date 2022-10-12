package day0919;
// 변수(Variable)
// 변수란, 어떤 특정 공간에 저장된 값을 우리가 임의로 바꿀 수 있는 공간을 변수라고 한다.
// 변수는 우리가 사용하기 전에 반드시 "선언"을 해주어야 하고
// 선언한 후에는 반드시 한번이라도 값이 "초기화"가 되어야 호출할 수 있다.

// 선언(Declaration)
// 선언이란, 해당 공간에 어떤 "종류" 의 값이 저장이 될 것이고
// 해당 공간을 어떤 이름으로 부를지를 지정하는 코드이다.
// 선언은 다음과 같이 이루어진다.
// 데이터타입 변수이름;

// 초기화(Initialization)
// 초기화란 해당 공간에 처음 값을 할당(=저장)하는 코드이다.
// 초기화, 할당, 저장 모두 같은 의미로 사용가능하지만
// 우리는 초기화를 맨 처음에 값이 저장한다라는 의미로만 사용하도록 노력할 것이다.
// 초기화, 저장, 할당은 다음과 같이 이루어진다.
// 이름 = 값;

public class Ex04Variable {
    public static void main(String[] args){
        // int 데이터타입을 가진 변수 number를 선언해보자
        int number;

        // number에 30이라는 값을 저장해보자
        number = 30;

        // number에 저장된 값을 화면에 출력해라
        System.out.println(number);

        // number에 새로운 값 50을 저장해라
        number = 50;

        // number에 저장된 값을 화면에 출력해라
        System.out.println(number);

        // 변수를 다룰 때 주의해야할 점.
        // 똑같은 이름의 변수는 "유효범위"가 같을 때에는 여러개 선언할 수 없다.
        // int number = 40;

        number = 40;

        System.out.println(number);

        // 선언과 초기화는 다음과 같이 한줄로도 해줄 수 있다.
        // int 데이터타입의 변수 number2를 선언하고 25라는 값으로 초기화해라
        int number2 = 25;
    }
}















