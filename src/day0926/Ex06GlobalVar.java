package day0926;
// 전역 변수(Global Variable)
// 전역 변수란, 해당 프로그램 전체가 사용할 수 있는 변수를
// 전역 변수라고 한다.
// 전역 변수의 장점: 해당 변수를 굳이 각각의 메소드에서 따로 선언하거나
// 파라미터로 받을 필요 없이 누구든 사용 가능한 변수이기 때문에 편하다.
// 즉 누구든 쓸수 있다.가 장점이 된다.
// 전역 변수의 단점: 누구든 쓸수 있기 때문에 해당 변수가 특정 값을 유지하거나
// 또는 우리가 해당 변수의 값을 감시해야하는 경우, 그 변수를 사용하는 모든 메소드를
// 전부 체크해야한다.

// 자바의 경우, 전역 변수와 지역 변수 이름이 같을 수도 있는데, 만약
// 전역 변수에도 같은 이름의 변수가 있고,
// 메소드에도 같은 이름의 변수가 있을 경우에는
// 우리가 this.변수이름이라고 해야지만 전역 변수를 가리키고
// 그냥 변수이름 이라고 하며는 메소드의 지역 변수를 가리키게 된다.
// 단, 지금 단계에서는 이러한 일이 없도록 지역변수와 전역변수의 이름을 다르게 만들어주면 된다!

public class Ex06GlobalVar {
}