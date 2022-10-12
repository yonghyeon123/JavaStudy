package day0920;
// Scanner 클래스
// 자바에서 입력을 처리하는 클래스가 여러가지가 있지만
// 우리는 그중에서 가장 간단하게 사용할 수 있는 Scanner 클래스를 배워볼 것이다.
// 단, 자바에서는 같은 패키지에 있는 클래스가 아니거나
// 기본형 데이터타입을 클래스화 시킨 "포장 클래스(Wrapper Class)"가 아닐 경우에는
// 반드시 해당 클래스를 "수입"해와야 한다!
// 외부 클래스를 수입하는 방법은 다음과 같다.
// import 외부클래스;
// 단, 외부 클래스가 어느 패키지에 속해져있는지를 전부 적어주어야 하고
//그리고 import 코드는 반드시 public class ~~~~ 이전에 나와야 한다.
// 또한 상황에 따라서는 여러개의 외부 클래스를 수입해와야할 수도 있는데
// 그 때에는 각각의 외부 클래스에 대한 import 코드를 작성하면 된다.

// Scanner 클래스는 java.util 패키지 안에 있으므로 다음과 같은 방법으로
// import하면 된다.

import java.util.Scanner;

public class Ex01Scanner {
    public static void main(String[] args) {
        // Scanner 클래스는 버퍼 메모리라는 임시 공간에서 값을 읽어오는데
        // 이때 버퍼 메모리가 어디에서 값을 받아올 지를 명시해야한다.
        // 따라서 Scanner 클래스 변수를 초기화할 때에는 다음과 같이 적어준다.
        // Scanner scanner = new Scanner(값을 읽어올 위치)
        // 지금은 우리가 키보드 입력을 받아야 하므로 () 안에
        // System.in 이라고 적어주면 된다.
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 int 입력을 받을 때에는
        // Scanner 클래스 변수의 nextInt() 메소드를 사용하면 된다.
        System.out.println("int 값을 입력해주세요.");
        int number = scanner.nextInt();
        System.out.println("사용자가 입력한 정수값: " + number);

        // 사용자로부터 double 입력을 받을 때에는
        // Scanner 클래스 변수의 nextDouble() 메소드를 사용하면 된다.
        System.out.println("double 값을 입력해주세요.");
        double d = scanner.nextDouble();
        System.out.println("사용자가 입력한 실수값: " + d);

        // String 입력은 Scanner 클래스 변수의 nextLine() 메소드를 사용하면 된다.

        // 단 Scanner 클래스 변수를 사용하여 사용자로부터 String 입력을 받을 때 한가지 주의해야할 점은
        // nextInt() 혹은 nextDouble()과 같은 숫자를 입력한 후에는 반드시
        // 버퍼메모리를 비어주어야 한다.

        // Scanner 클래스의 메소드가 작동하는 방법
        // 1. nextInt()의 경우
        // 1-1. 사용자가 입력한 값이 String의 형태로 버퍼 메모리로 넘어간다.
        //      즉 사용자가 34 라는 값을 입력했을 경우 int 34가 아닌 String "34"가 입력이 되는 것이다.
        //      단, 사용자가 입력을 마친다는 신호로 입력한 엔터키는 넘어가지 않고 남아있게 된다.
        // 1-2. 사용자가 입력한 String 값의 앞 뒤에 있는 공백을 모두 제거한다.
        // 1-3. 사용자가 입력한 값이 int의 형태가 맞는지 확인한다.
        //      int의 형태란 모든 글자가 숫자로만 이루어졌거나 혹은 -로 시작하고 나머지는 숫자로만 이루어진 형태이다.
        // 1-4. 만약 1-2에서 확인한게 문제가 없으면 int의 범위에 속하는지 확인한다.
        // 1-5. 만약 1-3까지 모두 통과하였을 경우 String 값을 int로 변환(=parse)하여 메소드를 실행시킨 곳으로 반환(=return)한다.

        // 즉 우리가 입력을 끝낸다라는 의미로 입력한 enter키가 남아있어서 nextLine()을 사용할 때
        // 버그가 발생하게 되는데 이러한 버그를 우리가 Scanner 버그라고 부른다.
        // Scanner 버그를 해결하는 방법은 매우 간단하다.
        // 버퍼메모리에 남아있는 엔터키를 제거하기 위한 nextLine()을 한번 실행한 후에
        // 실제 값을 입력하는 용도의 nextLine()을 실행하면 된다.


        System.out.println("이름을 입력해주세요.");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("사용자의 이름: [" + name + "]");
    }
}















