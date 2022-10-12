package day0921;
// 무한 반복문(Infinite Loop)
// 무한 반복문이란, 우리가 강제적으로 종료하지 않으면
// 영원히 반복되는 반복문을 무한 반복문이라고 한다.
// 우리는 무한 반복문을 만드는 대표적인 3가지 방법을 알아볼 것이다.

public class Ex06InfiniteLoop {
    public static void main(String[] args){
        // 1. 값이 변하지 않는 변수를 사용하는 조건식
//        int number = 3;
//        while(number > 0){
//            System.out.println("무한반복문 1번");
//        }

        // 2. 굳이 변수를 안써도 항상 true가 나오는 조건식
//        while( 1 == 1){
//            System.out.println("무한루프 2번");
//        }

        // 3. 뭐하러 식을 만드나...
        while(true){
            System.out.println("무한루프 3번");
        }

    }
}

















