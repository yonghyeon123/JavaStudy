package day0923;
// 배열(Array)
// 배열이란, 똑같은 목적을 지닌 값을 여러개 필요로 할때
// 변수를 여러개 만드는 것이 아니라
// 하나의 이름을 가진 변수로 묶고, 대신
// 여러 칸으로 나누어서 각 칸에 그 값들을 넣어주는 데이터타입이다.

// 배열은 기본적으로 다음과 같이 선언과 초기화가 된다.
// 데이터타입[] 배열이름 = new 데이터타입[길이]
// 여기서 여러분들이 눈 여겨 봐야할 것은 바로 길이 이다.
// 길이란, 해당 배열이 총 몇개의 값을 가질 수 있는지를 명시한 정수형 데이터타입의 값이다.

public class Ex02Array {
    public static void main(String[] args){
        // int 4개를 저장할수 있는 int배열 numberArray를 선언과 초기화해보자
        int[] numberArray = new int[4];

        // 배열의 각 칸에 접근할 때에는 우리가 몇번째 칸에 값을 저장 혹은 저장된 값을 불러올지를
        // 명시해야 하는데
        // 이 칸의 번호를 우리가 "인덱스" 라고 부른다.
        // 사람과는 다르게 컴퓨터는 서순(세는 순서)가 1이 아닌 0부터 시작한다.
        // 즉, 인덱스는 0부터 해당 배열의 길이 - 1이 가능한 범위이다.
        // 만약 잘못된 인덱스를 입력하면 당연히 에러가 발생한다!

        //numberArray[2]에 30을 저장해보자
        numberArray[2] = 30;

        //numberArray[2]에 저장된 값을 불러와라
        System.out.println(numberArray[2]);

        // 1. 배열을 초기화할 때 정수형 데이터타입의 변수를 사용하여 초기화해줄 수도 있다.
        int length = 10;
        numberArray = new int[length];

        // 2. 배열의 특정칸을 접근할때에도 우리가 정수형 데이터타입의 변수를 사용하여 접근할 수 있다.
        int idx = 1;
        numberArray[idx] = 7;
        System.out.println(numberArray[idx]);

        // 3. 배열의 길이를 우리가 불러와야하는 경우,
        // 해당배열.length 라는것을 통하여 우리가 불러올 수 있다.
        System.out.println("numberArray의 길이: " + numberArray.length);

        // 4. 사실 우리가 별 찍는데에나 썼던 for문은 배열과 같이 똑같은 데이터타입이
        // 순서에 맞춰서 보관되는 데이터타입을 다루는데 매우 좋다!
        for(int i = 0; i < numberArray.length; i++){
            System.out.printf("numberArray[%d]의 현재 값: %d\n", i, numberArray[i] );
        }

        // 5. 기본형 데이터타입의 배열일 경우, 초기화되는 순간 각 칸에 0 이 저장된다.
        // 참조형 데이터타입의 배열일 경우, 초기화되는 순간 각 칸에 null이 저장된다.
        // null이란, 메모리 주소값은 부여가 되어있지만 해당 메모리 주소값을 가진 heap 영역의 공간이
        // 준비가 안된 상태를 null이라고 한다.
        // null인 상태에서는 해당 공간을 초기화하기 전에는 메소드, 어트리뷰트를 접근하면 에러가 발생한다.

        String[] strArray = new String[3];
        System.out.println("strArray: " + strArray);
        System.out.println("strArray[0]: "+strArray[0]);
        System.out.println("strArray[0].equals(\"a=\"): " + strArray[0].equals("a"));
    }
}













