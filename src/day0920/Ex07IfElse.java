package day0920;
// if - else 구조
// 기존에 Ex05, Ex06에서 배웠던 if문의 경우,
// 만약 조건식이 false가 나오면 아무것도 실행이 되지 않는 구조였다.
// 하지만 else 구조를 덧붙여 주면
// 만약 조건식이 false가 나왔을 때 실행할 코드를 설정해 줄수 있다.

// if - else는 다음과 같은 구조를 가진다.

// if(조건식) {
//     조건식이 참일때 실행할 코드
// } else {
//     조건식이 거짓일때 실행할 코드
// }
public class Ex07IfElse {
    public static void main(String[] args) {
        int number = -3;

        if (number >= 0) {
            System.out.println("자연수입니다.");
        } else {
            System.out.println("자연수가 아닙니다.");
        }

        System.out.println("프로그램 종료");
    }
}












