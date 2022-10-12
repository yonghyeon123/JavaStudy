package day0921;
// 사용자로부터 키와 몸무게를 입력 받아서
// BMI를 계산하고 비만도 결과를 출력해주는 프로그램 (=Ex11과 동일한 출력결과가 나온다)
// 단, 사용자가 잘못된 값을 입력할 경우 더이상 입력 없이
// "잘못된 입력으로 프로그램을 종료합니다" 라는 메시지만 출력되게 코드를 작성해보시오.
// 기네스북에 따르면 세계에서 가장 키가 컸던 사람은 2.72M였습니다.
// 기네스북에 따르면 세계에서 가장 무거웠던 사람은 635kg였습니다.

// 10시 45분까지

import java.util.Scanner;

public class Ex02BmiChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("키를 입력해주세요.");
        System.out.print("> ");
        double height = scanner.nextDouble();

        if (height <= 2.72 && height > 0) {
            // 키가 올바른 범위에 속하므로 몸무게를 입력받는다.
            System.out.println("몸무게를 입력해주세요.");
            System.out.print("> ");
            double weight = scanner.nextDouble();

            if (weight > 0 && weight <= 635) {
                // 올바른 몸무게 이므로 BMI 계산 후 결과 출력
                double bmi = weight / height / height;
                System.out.printf("키: [%.2f]M 몸무게: [%.2f]Kg\n", height, weight);

                String obesity = "비만";
                if (bmi < 18.5) {
                    obesity = "저체중";
                } else if (bmi < 23) {
                    obesity = "정상체중";
                } else if (bmi < 25) {
                    obesity = "과체중";
                }

                System.out.printf("BMI: [%.2f] 비만도: [%s]\n", bmi, obesity);

            } else {
                // 몸무게가 올바른 값이 아니므로 경고 메시지 출력
                System.out.println("잘못된 입력으로 프로그램을 종료합니다.");
            }

        } else {
            // 키가 올바른 값이 아니므로 경고 메시지 출력
            System.out.println("잘못된 입력으로 프로그램을 종료합니다.");
        }

    }
}












