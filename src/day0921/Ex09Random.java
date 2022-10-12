package day0921;
// Random
// 자바에서는 랜덤한 숫자 (=난수)를 담당하는 Random 이라는 클래스가 있다.
// 이 랜덤 클래스를 사용하면 우리가 확률에 의한 랜덤 이벤트라는 개념을 구현할 수 있다.
// Scanner와 마찬가지로, java.util 패키지에 있는 Random 클래스를 불러와야 한다.

import java.util.Random;

public class Ex09Random {
    public static void main(String[] args) {
        Random random = new Random();

        // 랜덤한 실수를 뽑아낼 때에는
        // Random 클래스 변수의 nextDouble() 메소드를 사용하면 된다.
        System.out.println(random.nextDouble());
        System.out.println(random.nextDouble());
        System.out.println(random.nextDouble());

        // int 범위(+- 20억) 안의 랜덤한 정수를 뽑아낼 때에는
        // Random 클래스 변수의 nextInt() 메소드를 사용하면 된다.
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());

        // 만약 0부터 특정값 - 1까지의 랜덤한 정수가 필요하다면
        // Random 클래스 변수의 nextInt(특정값) 메소드를 실행하면 된다.
        int max = 5;
        System.out.println(random.nextInt(max));
        System.out.println(random.nextInt(max));
        System.out.println(random.nextInt(max));

        // 만약 a 이상 b 이하의 랜덤한 숫자를 뽑아내고 싶다면?
        // 예시: 만약 101 이상 110 이하의 랜덤한 숫자를 뽑아내고 싶다면?

        // 1. 총 뽑아낼 수 있는 숫자의 갯수를 계산한다.
        // 갯수를 계산하는 방법은 (가능한 최댓값 - 가능한 최솟값) + 1 을 하면 된다.

        // 2. random에 위에서 계산한 갯수를 사용해서 0~갯수-1 까지의 랜덤한 숫자를 뽑아낸다.

        // 3. 2번에서 뽑은 랜덤한 숫자에 가능한 최솟값을 더한다.

        // 최소값
        int min = 101;
        // 최대값
        max = 110;
        // 뽑아낼수 있는 숫자의 갯수
        int size = max - min + 1;

        // 0~size-1 까지의 숫자를 뽑아낸다.
        int temp = random.nextInt(size);

        // 얼마가 뽑혔던 간에 temp에 저장된 값에 min을 더한 결과값을
        // 다시 temp에 저장한다.
        temp += min;

        System.out.println(temp);


    }
}













