package day0920;

// printf는 우리가 원하는 내용을 원하는 형식에 맞추어 출력하게 해주는 메소드이다.
public class Ex03Printf {
    public static void main(String[] args) {
        System.out.println("1. 10진법 정수('d'ecimal)");
        // 출력에 사용할 int 변수를 선언하고 17을 저장한다.
        int number = 177;
        // A. 10진법 정수를 그대로 출력해라
        System.out.printf("1-A. [%d]\n", number);
        // B. 10진법 정수를 총 4자리 오른쪽 정렬해서 출력해라
        System.out.printf("1-B. [%4d]\n", number);
        // C. 10진법 정수를 총 2자리 오른쪽 정렬해서 출력해라
        System.out.printf("1-C. [%2d]\n", number);
        // 만약 내가 지정한 자릿수보다 출력해야할 내용이 더 길면
        // 지정한 자릿수는 무시된다.
        // D. 10진법 정수를 총 4자리 왼쪽 정렬해서 출력해라
        System.out.printf("1-D. [%-4d]\n", number);
        // E. 10진법 정수를 총 8자리 오른쪽 정렬하되 왼쪽의 빈 공간이 있을 경우 0으로 채워서 출력해라
        System.out.printf("1-E. [%08d]\n", number);
        System.out.println("--------------------------------------------\n");
        System.out.println("2. 16진법 정수(he'x'adecimal)");
        // 참고로 177은 16진법으로 B1이다.
        // A. 16진법 정수를 소문자로 출력해라
        System.out.printf("2-A. [%x]\n", number);
        // B. 16진법 정수를 오른쪽 정렬 4자리 대문자로 출력해라
        System.out.printf("2-B. [%4X]\n", number);
        // C. 16진법 정수를 왼쪽 정렬 4자리 소문자로 출력해라
        System.out.printf("2-C. [%-4x]\n", number);
        // D. 16진법 정수를 오른쪽 정렬 8자리 대문자로 출력하되 왼쪽 빈 공간은 0으로 채워서 출력해라
        System.out.printf("2-D. [%08X]\n", number);
        System.out.println("--------------------------------------------\n");

        System.out.println("3. 실수('f'loat)");
        // 출력에 사용할 double 변수를 선언하고 123.45678987 을 저장한다.
        double d = 123.45678987;
        // A. 실수를 그대로 출력해라
        System.out.printf("3-A. [%f]\n", d);
        // B. 실수를 오른쪽 정렬 20자리로 출력해라
        System.out.printf("3-B. [%20f]\n", d);
        // C. 실수를 소숫점 4번째자리까지 출력해라
        System.out.printf("3-C. [%.4f]\n", d);
        // D. 실수를 오른쪽 정렬 20자리로 맞추되 소숫점은 4번째자리까지 출력해라
        System.out.printf("3-D. [%20.4f]\n", d);
        // E. 실수를 왼쪽 정렬 10자리로 맞추되 소숫점은 1번째자리까지 출력해라
        System.out.printf("3-E. [%-10.1f]\n", d);
        // F. 실수를 오른쪽 정렬 10자리로 맞추되 소숫점은 1번째자리, 왼쪽 빈자리는 0으로 채워서 출력해라
        System.out.printf("3-F. [%010.1f]\n", d);
        System.out.println("--------------------------------------------\n");

        System.out.println("4. 스트링('s'tring)");
        // 출력에 사용할 String 변수
        String str = "abcdEFGH";
        // A. String을 그대로 출력해라
        System.out.printf("4-A. [%s]\n", str);
        // B. String을 모두 대문자로 출력해라
        System.out.printf("4-B. [%S]\n", str);

        System.out.println("--------------------------------------------\n");

        // printf를 사용할 때 알아두어야할 점
        // 1. 우리가 필요하다면 다양한 %문자를 조합하여 출력할 내용을 결정할 수도 있다.
        System.out.printf("%d %s %f\n", 1, "abcd", 3.11);
        // 2. 존재하지 않는 %문자를 사용하면 에러가 발생한다.
        // System.out.printf("%r\n", 33);
        // 3. 만약 %문자와 뒤에 나오는 출력할 값의 타입이 다르면 에러가 발생한다.
        // System.out.printf("%d\n", 3.14);
        // System.out.printf("%f\n", 3);
        // 4. 만약 %문자의 갯수보다 뒤에 출력할 값이 더 많으면? 문제가 없다.
        // 첫번째 출력할 값부터 차례대로 앞의 %문자를 채워나가기 때문이다.
        System.out.printf("1. %d 2. %d\n", 1, 2, 3, 4, 5);
        // 5. 반대로, %문자의 갯수가 뒤에 출력할 값보다 더 많으면?
        // System.out.printf("1. %d 2. %d 3. %d\n", 1);
        // 6. 만약 출력할 내용 안에 백분률을 뜻하는 % 문자가 필요하다면?
        // 그러한 경우에는 %% 라고 적어주면 '%' 가 정상적으로 출력된다.
        System.out.printf("현재 소금물의 농도: %.2f%%입니다.", 12.5);

    }
}















