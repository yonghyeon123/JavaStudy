package day0921;
// 반복문
// while 반복문
// while 반복문은 특정 조건식을 체크하여
// true가 나오면 연결된 코드 블락을 실행시키고
// 다시 조건식을 체크하여 반복 여부를 결정한다.

// while문의 기본 구조
// while(조건식) {
//      조건식이 참이면 실행시킬 코드
// }
public class Ex04While {
    public static void main(String[] args) {
        // 1부터 6까지 출력하는 코드
        // 1. 가장 무식한 방법
//        System.out.println(1);
//        System.out.println(2);
//        System.out.println(3);
//        System.out.println(4);
//        System.out.println(5);
//        System.out.println(6);
        // 2. 조금이나마 더 유식한 방법
        int number;
//        number = 1;
//
//        System.out.println(number);
//        number++;
//        System.out.println(number);
//        number++;
//        System.out.println(number);
//        number++;
//        System.out.println(number);
//        number++;
//        System.out.println(number);
//        number++;
//        System.out.println(number);

        // 3. while 반복문을 사용할 경우
        number = 1;
        while(number <= 6){
            System.out.println(number);
            number++;
        }

    }
}














