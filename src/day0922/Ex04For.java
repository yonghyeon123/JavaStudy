package day0922;
// 반복문02
// for 반복문
// 영어 문법적으로 전치사 for와 while은 둘다 시간과 관련된 전치사이지만
// 목적은 서로가 같지 않다.
// for: 명확한 시간을 나타내는 전치사
//      예시 -> I waited you for 5 minutes = 나는 널 5분동안 기달렸어
// while: 명확한 시간을 뜻하지 않는 전치사
//        예시 -> I smoked a cigarette while I was waiting you = 나는 너 기다리는 동안 담배를 폈어

// 프로그래밍적 문법상으로도 2개는 반복문이라는 공통점이 있지만
// 몇번 반복이 될지에 대한 명확성은 차이가 있다.
// while 반복문: 조건식을 만족하는 동안 계속 반복이 된다.
// for 반복문: 비교적 반복횟수가 명확하다.

// for 반복문은 기본적으로 다음과 같은 구조를 가진다.
// for(제어변수의 선언과 초기화; 반복 조건식; 제어변수의 변화식) {
//      반복할 코드
// }
// 단 제어 변수는 반드시 정수형 데이터타입을 가져야 한다.
import java.util.Scanner;
public class Ex04For {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // 1부터 5까지 반복하는 코드
        for(int i = 1; i <= 5; i++){
            //System.out.println(i);
        }

        // for문에 대한 여러가지 팁들
        // 1. 제어변수의 이름은 여러분들이 짓고 싶은대로 지어도 상관 없지만
        // 전통적으로 i부터 시작하여 중첩되는 레벨에 따라서 j, k... 순으로 들어가게 된다.
        // 2. 제어변수의 초기화식이나 반복 조건식에는 다른 변수를 사용할 수 있다.
        // 3. 제어변수의 변화식에는 해당 제어변수의 값을 변경할수 있는 증감연산자나 할당 연산자가 들어오면 된다.
        // 4. 제어변수의 선언 혹은 초기화식까지는 for문 이전에 미리 선언과 초기화를 해줘도 되지만,
        // 해당 방법은 좋은 방법은 아니다.
        // 만약 이 방법을 쓸 때에는 이미 선언과 초기화가 되었다고 해서
        // for문 안의 ;의 갯수가 줄어드는 것이 아니라 해당 칸만 비어두고 ;은 똑같이 2개가 들어간다.
        // 즉, for(i <= 3; i++) 요런 형태가 아니라 for(;i<=3; i++) 의 형태가 된다.
        // 5. 당연히 for문으로도 무한반복문을 만들수 있다.
        // 이때에는 물론 제어변수의 선언과 초기화식과 변화식을 비어두고 반복 조건식만 항상 true가 나오게 만들어줘도 되지만
        // 그냥 for(;;) 이라고 해줘도 된다.

        // 1. 8부터 4까지 출력하시오
        for(int i = 8; i >= 4; i--){
            //System.out.println(i);
        }

        // 2. 1부터 20까지의 홀수를 출력하시오
        for(int i = 1; i <= 20; i+= 2){
            //System.out.println(i);
        }

        // 3. 33부터 54까지의 3의 배수를 출력하시오
        for(int i = 33; i <= 54; i+=3){
            System.out.println(i);
        }

        // 4. 사용자로부터 값을 입력받아서
        // 1부터 그 값까지를 출력하시오
        System.out.println("숫자를 입력해주세요.");
        int num = scanner.nextInt();

        for(int i = 1; i <= num; i++){
            //System.out.println(i);
        }

        // 5. 사용자로부터 숫자를 2개 입력받아서
        // 더 작은수부터 더 큰수까지를 출력하시오
        System.out.println("첫번째 숫자를 입력해주세요.");
        int num1 = scanner.nextInt();

        System.out.println("두번째 숫자를 입력해주세요.");
        int num2 = scanner.nextInt();

        int startNum;
        int endNum;

        if(num1 < num2){
            startNum = num1;
            endNum = num2;
        } else {
            startNum = num2;
            endNum = num1;
        }

        for(int i = startNum; i <= endNum; i++){
            System.out.println(i);
        }

    }
}













