package day0922;
// 1부터 100까지의 소수를 구하는 프로그램
// 1. 소수란 무엇인가
// 1과 자기자신만이 약수인 숫자
// = 약수의 갯수가 2개인 숫자
// 2. 약수란 무엇인가
// 어떤 수를 나눴을때 나누어 떨어지는 숫자
// = 어떤 수를 나눴을때 나머지가 0인 숫자
// 3. 어떤 숫자의 가장 큰 약수는?
// = 자기 자신이다.

public class Ex06PrimeNumber {
    public static void main(String[] args) {
        // 먼저 i for문을 만들것인데
        // i는 소수인지 아닌지를 검사할 숫자가 된다.
        // 그렇다면 i의 시작값은?
        // 1
        // i의 반복 조건식은?
        // i <= 100

        for (int i = 1; i <= 100; i++) {
            // i의 약수의 갯수를 저장할 int 변수 count
            int count = 0;

            // j for문의 j는 i의 약수인지 아닌지를 검사할 숫자가 된다.
            // 그렇다면 j의 시작값은?
            // 1
            // j for문의 반복 조건식은?
            // j <= i

            for (int j = 1; j <= i; j++) {
                // j가 i의 약수가 맞다면
                // count를 1 증가시킨다.
                if (i % j == 0) {
                    count++;
                }
            }

            // j for문이 끝나면 i의 약수의 갯수가 count에 저장된다.
            if (count == 2) {
                System.out.println(i + "는 소수입니다.");
            }

        }
    }
}

















