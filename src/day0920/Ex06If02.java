package day0920;
/*
1. int 변수 number가 0이상이면 "자연수입니다" 가 출력되게 코드를 작성하시오
2. int 변수 number가 1이상 10미만이면 "한자리 양의 정수입니다" 가 출력되게 코드를 작성하시오
3. int 변수 number가 짝수이면 "짝수입니다" 가 출력되게 코드를 작성하시오
4. 사용자로부터 숫자를 입력받아서 만약 10이상 99이하일 경우 "두자리 양의 정수입니다" 가 출력되게 코드를 작성하시오
5. 사용자로부터 username과 password를 입력받아서 username이 "admin" 이고 password 가 "111" 이면
   "로그인 성공" 이 출력되게 코드를 작성하시오

3시 30분까지
 */
import java.util.Scanner;
public class Ex06If02 {

    public static void main(String[] args){
        int number;
        System.out.println("1번");
        number = -7;
        if(number >= 0){
            System.out.println("자연수입니다.");
        }

        System.out.println("------------------------------------\n");

        System.out.println("2번");
        number = -6;
        if(number >= 1 && number < 10){
            System.out.println("한자리 양의 정수입니다.");
        }
        System.out.println("------------------------------------\n");

        System.out.println("3번");
        number = 81;
        if(number % 2 != 1){
            System.out.println("짝수입니다.");
        }

        System.out.println("------------------------------------\n");

        Scanner scanner = new Scanner(System.in);

        System.out.println("4번");
        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        number = scanner.nextInt();
        if(number >= 10 && number <= 99){
            System.out.println("두자리 양의 정수입니다");
        }

        System.out.println("------------------------------------\n");

        System.out.println("5번");
        System.out.println("username을 입력해주세요.");
        System.out.print("> ");
        scanner.nextLine();
        String username = scanner.nextLine();

        System.out.println("password를 입력해주세요.");
        System.out.print("> ");
        String password = scanner.nextLine();

        if(username.equals("admin") && password.equals("111")){
            System.out.println("로그인 성공");
        }

        System.out.println("------------------------------------\n");
    }

}
