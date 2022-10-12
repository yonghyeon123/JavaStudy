package day0920;
// 사용자로부터 키와 몸무게를 입력받아서
// BMI 를 계산한 후
// 키, 몸무게, BMI, 비만도를 출력하는 프로그램을 작성하시오

// BMI 공식: 몸무게 / 키 / 키
// 단, 몸무게는 KG 단위이고 키는 M 단위입니다.

// 비만도 기준표
// BMI 18.5미만: 저체중
// 18.5이상 23미만: 정상체중
// 23이상 25미만: 과체중
// 25이상: 비만

// 5시 30분까지

import java.util.Scanner;
public class Ex11BmiChecker {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // 키를 입력 받는다.
        System.out.println("키를 M 단위로 입력해주세요.");
        System.out.print("> ");
        double height = scanner.nextDouble();

        // 몸무게를 입력 받는다.
        System.out.println("몸무게를 KG 단위로 입력해주세요.");
        System.out.print("> ");
        double weight = scanner.nextDouble();

        // bmi를 계산한다.
        double bmi = weight / height / height;

        // 키와 몸무게를 출력한다.
        System.out.printf("키: [%.2f]M 몸무게: [%.2f]Kg\n", height, weight);

        // 비만도 결과값을 저장할 String 변수
        String obesity = "비만";

        // BMI에 따른 비만도를 String 변수 obesity에 저장한다.
        if(bmi < 18.5){
           obesity = "저체중";
        } else if(bmi < 23){
            obesity = "정상체중";
        } else if(bmi < 25){
            obesity = "과체중";
        }

        // BMI를 출력한다.
        System.out.printf("BMI: [%.2f] 비만도: [%s]\n", bmi, obesity);


    }
}

















