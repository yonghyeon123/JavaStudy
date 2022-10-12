package day1004;
// 구조체(Struct)
// 구조체란, 2세대언어에서 우리가 필요한 데이터타입을 새롭게
// 만들어서 사용하는 새로운 하나의 데이터타입이다.
// 기본적으로 구조체는
// struct 데이터타입이름 {
//     데이터타입 이름1;
//     데이터타입 이름2;
// }
// 의 형태로 만들면 되지만 자바는 3세대 언어이므로 구조체를 지원하지 않는다!
// 하지만 우리가 클래스 자체를 사용해서 일종의 구조체를 만들수 있으므로
// 직접 체험을 해보자

import Struct.StudentStruct;

public class Ex01Struct {
    public static void main(String[] args) {
        // 구조체가 없던 시절
        int id = 1;
        String name = "김철수";
        int koreanScore = 80;
        int englishScore = 80;
        int mathScore = 81;

        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", koreanScore, englishScore, mathScore);

        // 구조체를 사용하면?
        StudentStruct s1 = new StudentStruct();
        s1.id = 1;
        s1.name = "조재영";
        s1.koreanScore = 80;
        s1.englishScore = 80;
        s1.mathScore = 81;


    }
}












