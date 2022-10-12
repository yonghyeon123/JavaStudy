package day0922;
// 조건문02
// switch 조건문
// switch 조건문은 특이하게도 우리가 조건식을 따로 적어주는 것이 아니라
// 값이 "명확"하게 나뉘는 변수를 선택하여
// 해당 변수의 가능한 값에 대한 결과처리를 하게 된다.

// 값이 명확하게 나뉘는 변수란, 실수가 아닌 데이터타입들을 말한다.
// 즉, 기본형 데이터타입 중에서는 정수형, 논리형, 문자형
// 클래스는 특별히 String을 사용할 수 있게 된다.

// 단, switch는 생각보다 사용을 잘 하지 않는다.
// 왜냐하면, 조건식이 아니라 가능한 값에 대한 결과처리를 하기 때문에
// 만약 가능한 값이 다양하다면, 코드도 늘어나기 때문이다!

// switch의 기본 구조
// switch(값이 명확하게 나뉘는 변수 혹은 결과) {
//      case 값1:
//          값1일때 실행할 코드
//          break;
//      case 값2:
//          값2일때 실행할 코드
//          break;
//      case 값3:
//          값3일때 실행할 코드
//          break;
//      case 값4:
//          값4일때 실행할 코드
//          break;
//      default:
//          그외의 경우일때 실행할 코드
//          break;
public class Ex01Switch {
    public static void main(String[] args){
        int number = 2;

        switch(number){
            case 1:
                System.out.println("1입니다.");
                break;
            case 2:
                System.out.println("2입니다.");
                break;
            case 3:
                System.out.println("3입니다.");
                break;
            case 4:
                System.out.println("4입니다.");
                break;
            default:
                System.out.println("그외입니다.");
                break;
        }
    }
}
















