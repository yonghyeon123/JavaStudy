package day0921;
// 사용자로부터 성별, 나이, 신체등급순으로 입력 받아서
// 현역, 공익, 면제 를 출력하는 프로그램.
// 단, 여성의 경우 나이와 신체등급 입력을 하지 않고
// "여성에게는 국방의 의무가 부여되지 않습니다"만 출력된다.
// 단, 남성 미성년자의 경우
// "아직 미성년자는 신체등급이 존재하지 않습니다"만 출력된다.
// 성별의 경우 int로 입력을 받아서 1은 남성 2는 여성 으로 구분한다.
// 10시까지

import java.util.Scanner;

public class Ex01Army {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 성별 입력을 받는다.
        System.out.println("성별을 입력해주세요. (1은 남자 2는 여자)");
        System.out.print("> ");
        int gender = scanner.nextInt();

        // 2. 성별이 남성일 경우 결과 처리를 한다.
        // 2-1. 성인일 경우 신체 등급을 입력을 받는다.
        // 2-1-1. 1~3급일 경우 현역을 출력한다.
        // 2-1-2. 4급일 경우 공익을 출력한다.
        // 2-1-3. 그외는 면제를 출력한다.

        // 2-2. 미성년자일 경우 결과 처리를 한다.

        // 3. 성별이 여성일 경우 결과 처리를 한다.

        if (gender == 1) {
            // 남성이므로 나이를 입력 받는다.
            System.out.println("나이를 입력해주세요.");
            System.out.print("> ");
            int age = scanner.nextInt();

            if (age >= 19) {
                // 성인이므로 신체등급을 입력 받는다.
                System.out.println("신체 등급을 입력해주세요.");
                System.out.print("> ");
                int category = scanner.nextInt();

                if (category <= 3) {
                    System.out.println("현역입니다.");
                } else if (category == 4) {
                    System.out.println("공익입니다.");
                } else {
                    System.out.println("면제입니다.");
                }

            } else {
                // 미성년자이므로 메시지만 출력한다.
                System.out.println("미성년자에게는 아직 신체등급이 존재하지 않습니다.");
            }


        } else {
            // 여성이므로 메시지만 출력한다.
            System.out.println("여성에게는 국방의 의무가 부여되지 않습니다.");
        }
    }
}


















