package day0920;
// if - else if 구조
// if - else if 구조에서는 첫번째 조건식이 false가 나오면
// 그 다음 else if에 있는 조건식을 체크하여 true가 나오는 else if의 코드 블락이나
// 아니면 else가 있다면 else 코드 블락을 실행하게 된다.

// if - else if 구조는 다음과 같다.
// if(조건식1) {
//      조건식1이 참일때 실행할 코드
// } else if(조건식2) {
//      조건식2가 참일때 실행할 코드
// } else if(조건식3) ....
// } else {
//      위 조건식이 모두 false일때 실행할 코드
// }
public class Ex08ElseIf {

    public static void main(String[] args){
        int number = 15;

        // 단, if - else if 구조를 만들때 주의해야할 점은
        // 조건식을 순서를 맞추어야 우리가 원하는 else if로 빠지게 된다라는 점이 있고
        // 또한 else 이후에는 else if가 나올수 없다라는 점이 있다.

        // number에 값에 따라서
        // 2자리 이하의 음의 정수, 1자리 음의 정수, 0, 1자리 양의 정수, 2자리 이상의 양의 정수 가 출력되는 프로그램
        if(number < -9){
            System.out.println("2자리 이하의 음의 정수입니다.");
        } else if(number < 0){
            System.out.println("1자리 음의 정수입니다.");
        } else if(number == 0){
            System.out.println("0입니다.");
        } else if(number < 10){
            System.out.println("한자리 양의 정수입니다.");
        } else {
            System.out.println("2자리 이상의 양의 정수입니다.");
        }
    }

}















