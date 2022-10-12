package day0920;
// 자바 콘솔 화면에 출력하는 3가지 방법

public class Ex02Print {
    public static void main(String[] args){
        // 1. print()
        // () 안의 내용을 그대로 출력하고 만약 다음 출력할 내용이 있으면
        // 바로 오른쪽 칸에 이어서 출력한다.
        System.out.print("1");
        System.out.print(2);
        System.out.print("abc");

        // 2. println()
        // () 안의 내용을 그대로 출력하고 만약 다음 출력할 내용이 있으면
        // 그 다음줄의 첫번째칸부터 출력한다.
        System.out.println("DEF");
        System.out.println(4);
        System.out.println(56);

        // 3. printf()
        // () 안의 내용을 지정한 "형식"에 맞추어 출력하고
        // 만약 다음 출력할 내용이 있으면 출력된 내용의 오른쪽에 이어서 출력한다.
        System.out.printf("%s", "abc");
        System.out.printf("%X", 31);

        System.out.println();
        // 4. escape 문자
        // escape 문자란 \ 와 조합되는 여러가지 문자인데 우리가 적을 때는 비록 두 글자로 적지만
        // 실제로는 한개의 char로 취급이 된다.
        // 4-1. 탭 공백
        // 탭 공백이란 스페이스 4개 분량의 커다란 공백을 뜻한다.
        System.out.println("abcd\tefgh");
        // 4-2. 개행 문자(=엔터키)
        System.out.println("abcd\nefgh");
        // 4-3. char '
        System.out.println('\'');
        // 4-4. String "
        System.out.println("\"");
    }
}














