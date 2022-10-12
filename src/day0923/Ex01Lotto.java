package day0923;
// 로또 번호 제작기
// 1번 버젼
// 1~45 사이의 랜덤한 숫자 3개를 뽑는 프로그램을 작성하시오.
// 단, 모든 숫자는 중복되지 않아야 하고 오름차순 정렬이 되어야 합니다.
// 11시 5분까지
import java.util.Random;
public class Ex01Lotto {
    public static void main(String[] args){
        // 상수
        final int NUMBER_MIN = 1;
        final int NUMBER_MAX = 45;

        // 변수
        Random random = new Random();
        // 1~45 사이의 랜덤한 정수 3개를 저장할 int 변수들
        int num1, num2, num3;
        // 뽑아낸 숫자들을 정렬하여 저장할 int 변수들
        int sort1, sort2, sort3;

        // 1. num1에 랜덤한 숫자를 저장해주자
        num1 = random.nextInt(NUMBER_MAX) + NUMBER_MIN;
        // 2. num2에 랜덤한 숫자를 저장해주자
        // 단, 만약 num1에 저장된 숫자와 같으면
        // 중복되지 않은 숫자가 나올때까지 랜덤을 계속 돌려준다.
        num2 = random.nextInt(NUMBER_MAX) + NUMBER_MIN;
        while(num1 == num2){
            num2 = random.nextInt(NUMBER_MAX) + NUMBER_MIN;
        }
        // 3. num3에 랜덤한 숫자를 저장해주자
        // 단, 만약 num1이나 num2에 저장된 숫자와 같으면
        // 중복되지 않은 숫자가 나올때까지 랜덤을 계속 돌려준다.
        num3 = random.nextInt(NUMBER_MAX) + NUMBER_MIN;
        while(num1 == num3 || num2 == num3){
            num3 = random.nextInt(NUMBER_MAX) + NUMBER_MIN;
        }

        sort1 = num1;
        if(sort1 > num2){
            sort1 = num2;
            if(num2 > num3){
                // 15 10 5 가 있었을 경우
                sort1 = num3;
                sort2 = num2;
                sort3 = num1;
            } else {
                if(num1 > num3){
                    // 15 5 10 이 있었을 경우
                    sort2 = num3;
                    sort3 = num1;
                } else {
                    // 10 5 15 가 있었을 경우
                    sort2 = num1;
                    sort3 = num2;
                }
            }

        } else if(sort1 > num3){
            sort1 = num3;
            if(sort1 > num2){
                // 15 5 10이 있었을 경우
                sort1 = num2;
                sort2 = num3;
                sort3 = num1;
            } else {
                // 10 15 5가 있었을 경우
                sort2 = num1;
                sort3 = num2;
            }

        } else {
            // num1이 최소값일 경우
            if(num2 < num3){
                sort2 = num2;
                sort3 = num3;
            } else {
                sort2 = num3;
                sort3 = num2;
            }
        }

        System.out.printf("%d %d %d\n", sort1, sort2, sort3);

    }
}













