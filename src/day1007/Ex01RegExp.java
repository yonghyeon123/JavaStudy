package day1007;
// 정규 표현식(Regular Expression)
// 정규 표현식이란, 어떠한 String 값을 특정 패턴과 일치하는지 확인할 때 쓰이는
// 일종의 대체 문자열이다.
// 정규 표현식을 사용하면 우리가 특정 String이 예를 들어 알파벳 소문자로만 이루어져있는지
// 숫자로만 이루어져있는지, 이메일 형식에 맞는지 등을 확인해 볼 수 있다.
// 특히 이 정규 표현식은 자바에서만 사용되는것이 아니라
// 모든 언어에서 정규 표현식을 지원할 경우 모두 패턴이 같다.
// 그러므로 여러분들이 간단한 예제를 우리가 같이 해보고
// 각자 더 자습을 해야한다!

public class Ex01RegExp {
    public static void main(String[] args) {
        // 1. String이 a로 시작하는지 검사하기
        String pattern = "^a\\w+";
        System.out.println("\"abc\".matches(pattern): " + "abc".matches(pattern));
        System.out.println("\"babc\".matches(pattern): " + "babc".matches(pattern));
        // 2. String이 ~~a로 끝나는지 확인하기
        pattern = "\\w+a$";
        System.out.println("\"abc\".matches(pattern): " + "abc".matches(pattern));
        System.out.println("\"abca\".matches(pattern): " + "abca".matches(pattern));
        // 3. String이 ab와 1글자로 이루어져있는지 확인하기
        pattern = "ab.";
        System.out.println("\"abc\".matches(pattern): " + "abc".matches(pattern));
        System.out.println("\"bbc\".matches(pattern): " + "bbc".matches(pattern));
        System.out.println("\"ab\".matches(pattern): " + "ab".matches(pattern));
        // 4. String이 a가 3번 나오고 다른 값들이 나오는지 확인하기
        pattern = "^a{3}[^a]+";
        System.out.println("\"aaabc\".matches(pattern): " + "aaabc".matches(pattern));
        System.out.println("\"aaa\".matches(pattern): " + "aaa".matches(pattern));
        System.out.println("\"abc\".matches(pattern): " + "abc".matches(pattern));
        // 5. String이 a가 2~4번 나오고 다른 값들이 존재하는지 확인하기
        pattern = "^a{2,4}[^a]+";
        System.out.println("\"abc\".matches(pattern): " + "abc".matches(pattern));
        System.out.println("\"aabc\".matches(pattern): " + "aabc".matches(pattern));
        System.out.println("\"aaabc\".matches(pattern): " + "aaabc".matches(pattern));
        System.out.println("\"aaaabc\".matches(pattern): " + "aaaabc".matches(pattern));
        System.out.println("\"aaaaabc\".matches(pattern): " + "aaaaabc".matches(pattern));

        // 6. String이 앞글자는 a 나 z 뒤에 글자는 b나 y로 이루어져있는지 확인하기
        pattern = "[az][by]";
        System.out.println("\"ab\".matches(pattern): " + "ab".matches(pattern));
        System.out.println("\"zb\".matches(pattern): " + "zb".matches(pattern));
        System.out.println("\"cc\".matches(pattern): " + "cc".matches(pattern));
        System.out.println("\"zxy\".matches(pattern): " + "zxy".matches(pattern));

        // 7. String이 4개 숫자로만 이루어져있는지 확인하기
        pattern = "[0-9]{4}";
        System.out.println("\"1111\".matches(pattern): " + "1111".matches(pattern));
        System.out.println("\"3333\".matches(pattern): " + "3333".matches(pattern));
        System.out.println("\"1\".matches(pattern): " + "1".matches(pattern));
        System.out.println("\"1abc\".matches(pattern): " + "1abc".matches(pattern));

        // 8. String이 핸드폰 번호 형식과 맞는지 확인하기
        pattern = "^010-[1-9]\\d{3}-[1-9]\\d{3}";
        System.out.println("010-1234-1234: " + "010-1234-1234".matches(pattern));
        System.out.println("010-0123-0123: " + "010-0123-0123".matches(pattern));
        System.out.println("010-1-1: " + "010-1-1".matches(pattern));
        System.out.println("02-1234-1234: " + "02-1234-1234".matches(pattern));

        // 9. String이 이메일 주소 형식과 맞는지 확인하기
        pattern = "[A-Za-z]\\w{3,}@[A-Za-z]\\w+[.][A-Za-z][.|\\w]+";
        System.out.println("chojeyungbit@gmail.com: " + "chojeyungbit@gmail.com".matches(pattern));
        System.out.println("1chojeyungbit@gmail.com: " + "1chojeyungbit@gmail.com".matches(pattern));
        System.out.println("chojeyungbit: " + "chojeyungbit".matches(pattern));
        System.out.println("chojeyungbit@gmail: " + "chojeyungbit@gmail".matches(pattern));
        System.out.println("chojeyungbit@gmail.co.kr: " + "chojeyungbit@gmail.co.kr".matches(pattern));

        // 10. String이 생년월일 6자리가 맞는지 확인하기
        pattern = "\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[01])";
        System.out.println("333333: " + "333333".matches(pattern));
    }
}
