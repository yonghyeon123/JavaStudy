package day0921;
// BMI 출력 프로그램.
// 단, 사용자가 잘못된 값을 입력할 경우,
// 올바른 값이 입력될때까지 다시 입력을 받는다.
// 12시까지

import java.util.Scanner;

public class Ex05BmiChecker2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 키 입력
        System.out.println("키를 입력해주세요.");
        System.out.print("> ");
        double height = scanner.nextDouble();

        // 2. 키 검증
        while (height < 0 || height > 2.72) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("키를 입력해주세요.");
            System.out.print("> ");
            height = scanner.nextDouble();
        }

        // 3. 몸무게 입력
        System.out.println("몸무게를 입력해주세요.");
        System.out.print("> ");
        double weight = scanner.nextDouble();

        // 4. 몸무게 검증
        while (!(weight > 0 && weight <= 635)) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("몸무게를 입력해주세요.");
            System.out.print("> ");
            weight = scanner.nextDouble();
        }

        // 5. 결과 출력
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
    }
}
