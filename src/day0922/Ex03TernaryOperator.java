package day0922;
// 삼항연산자(Ternary Operator)
// 삼항연산자는 어떠한 "값"을 결정할 때 사용되는
// 일종의 조건 연산자이다.
// 단, 값을 결정하는것이지 어떠한 코드를 실행시킬수는 없다.
// 삼항연산자는 다음과 같은 구조를 가진다.
// 변수 = 조건식 ? 참일때 값 : 거짓일때 값;
public class Ex03TernaryOperator {
    public static void main(String[] args){
        int number = 2;
        String oddEven = number % 2 == 0 ? "짝수" : "홀수";

        // 삼항 연산자도 중첩해서 사용할 수 있다.

        // 연도에 따라서 윤년인지 평년인지 출력하는 코드
        // 윤년의 조건은 다음과 같다.
        // 1. 4로 나누어 떨어져야 한다. -> 1996년, 2020년
        // 2. 100의 배수가 아니다. -> 1900년
        // 3. 100의 배수더라도 400으로 나누어 떨어지면 윤년이다. -> 1600년, 2000년

        int year = 2000;
        String result = year % 4 == 0 ? year % 100 == 0 ? year % 400 == 0 ? "윤년" : "평년" : "윤년" : "평년";
        System.out.println(result);
    }
}













