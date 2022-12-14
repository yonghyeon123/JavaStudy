package day1005;
// 객체 지향 프로그래밍의 5원칙
// 여러분들이 객체 지향적인 프로그래밍을 하기 위해서는 아래의 5가지 원칙을 지켜주어야 한다.
// 이 5가지 원칙은 첫글자를 따서 SOLID 라고 부른다.
// 1. Single Responsibility Principle
//    단일 책임 원칙
// 2. Open Closed Principle
//    개방/폐쇄 원칙
// 3. Liskov Substitution Principle
//    리스코프 치환 원칙
// 4. Interface Segregation Principle
//    인터페이스 분리 원칙
// 5. Dependency Inversion Principle
//    의존성 역전 원칙

// 하지만 여러분들은 2번부터 5번까지는 좀처럼 만나기 힘든 원칙들이다.
// 단, 1번 단일 책임 원칙은 여러분들이 지금부터 반드시 클래스를 설계할 때에
// 지켜야 하는 원칙이 된다.

// 단일 책임 원칙이란, 클래스는 반드시 하나의 책임만 가져야 한다라는 원칙이다.
// 예를 들어, 우리가 GUI를 가진 계산기 프로그램을 구현하였다라고 가정해보자.
// 이때에, 계산기 프로그램은 여러개의 객체를 가지고 있는데
// 그래픽 담당 클래스, 숫자 계산 담당 클래스, 기록 보관 담당 클래스가 있다고 해보자.
// 단일 책임 원칙이 엄격하게 지켜진 경우라면, 당연히 해당 클래스들은 자기가 담당한 기능들만
// 가지고 있어야만 한다.
// 하지만 단일 책임 원칙이 제대로 안지켜져서, 그래픽과 관련한 코드가 그래픽 담당 클래스 뿐만이 아니라
// 기록 보관 담당 클래스에도 들어가있다고 해보자.
// 그렇다면, 우리가 그래픽 관련한 코드를 수정하기 위해서는, 총 2개의 클래스를 건드리는 불상사가 발생하게 된다.

// MVC 패턴
// MVC 패턴이란 프로그램을 크게 3가지 분야로 나누어서 개발하는 디자인 패턴이다.


public class Ex01Principles {
}













