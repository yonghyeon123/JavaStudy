package day0921;

import java.util.Scanner;

// 검증(Validation)
// 검증이란, 사용자가 입력한 값이 올바른지를 확인하는 과정이다.
// 프로그래밍에서는 다양한 방법으로 검증이 가능하지만
// 우리는 그 중에서 두가지 방법을 통한 검증을 해볼 것이다.

public class Ex03Validation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("점수를 입력해주세요.");
        System.out.print("> ");
        int score = scanner.nextInt();

        System.out.println("1. 검증을 안한 경우");

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

        System.out.println("---------------------------------------\n");

        System.out.println("2. 정확한 범위를 통한 결과 통제");
        // 이 검증 방법은
        // 특정 결과가 나오는 조건문의 조건식을 두리뭉실하게 잡는것이 아니라
        // 명확하게 어디서부터 어디까지가 올바른 값이다를 명시하는 방법이다.
        // 이 방법은 올바른 값의 범위가 연속적이지 않을 경우 주로 사용된다.

        if (score >= 90 && score <= 100) {
            System.out.println("A");
        } else if (score >= 80 && score < 90) {
            System.out.println("B");
        } else if (score >= 70 && score < 80) {
            System.out.println("C");
        } else if (score >= 60 && score < 70) {
            System.out.println("D");
        } else if (score >= 0 && score < 60) {
            System.out.println("F");
        } else {
            System.out.println("잘못된 점수입니다.");
        }

        System.out.println("---------------------------------------\n");

        System.out.println("3. 입력 값이 올바른 범위에 속할 때에만 코드 진행하기");
        // 이 검증 방법은 먼저 사용자가 입력한 값이 올바른지 체크하여
        // 올바르면 추가적인 코드를 진행할 수 있도록 중첩 if문을 사용하는 방법이다.
        // 이 방법은 올바른 값의 범위가 연속적일때 주로 사용된다.
        if(score >= 0 && score <= 100){

            if (score >= 90) {
                System.out.println("A");
            } else if (score >= 80) {
                System.out.println("B");
            } else if (score >= 70) {
                System.out.println("C");
            } else if (score >= 60) {
                System.out.println("D");
            } else {
                System.out.println("F");
            }

        } else {
            System.out.println("잘못된 범위의 값입니다.");
        }


        System.out.println("---------------------------------------\n");

    }

}
