package day1007;
// 인터페이스
// 인터페이스는 좀 특이한 모양의 데이터타입이다.
// 인터페이스의 가장 큰 특징은 실체가 없다라는 점이다.
// 따라서 인터페이스 변수들은 반드시 실체화가 되어있는 클래스 생성자를 통해서
// 초기화가 되어야 한다.

// 클래스의 상속은 우리가 코드의 재사용성을 높이기 위함이었지만,
// 인터페이스의 상속은 우리가 다형성을 부여하기 위함이다.

// 다형성(多形性, polymorphism)
// poly = 다양한을 뜻하는 접두사
// morph = 형상
// ism = 성격
// 다형성이란, 인터페이스 상속을 통하여, 우리가 메소드의 파라미터로 클래스를 지정해서 해당 클래스의 객체 혹은
// 상속관계인 메소드가 오도록 만들어 주는 것이다.
// 하지만, 우리가 굳이 안해도 그만이던 오버라이드를 인터페이스 상속에서는 반드시 하도록 되기 때문에
// 해당 파라미터의 들어온 객체가 실행할 메소드를 반드시 각각의 클래스가 재정의해서 다양한 모습을 준비하는 방법이다.


import connector.DBConnector;
import connector.MySqlConnector;
import connector.OracleConnector;

public class Ex03Interface {
    public static void main(String[] args) {
        AnimalInterface animal = new ferret();
        //act(animal);

        // 데이터베이스 연결을 위해 MySqlConnector를 사용해서 db랑 연결을 하자
        DBConnector connector = new OracleConnector();
        connector.makeConnection();
    }

    public static void act(AnimalInterface a) {
        a.move();
        a.makeSound();
        a.eat();
    }
}
