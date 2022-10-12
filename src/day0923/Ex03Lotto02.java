package day0923;
// 배열을 사용한 로또

import java.util.Random;

public class Ex03Lotto02 {
    public static void main(String[] args) {
        final int NUMBER_MIN = 1;
        final int NUMBER_MAX = 45;
        final int LENGTH = 6;

        Random random = new Random();

        // 1. 숫자를 저장할 배열 선언 및 초기화
        int[] lottoNumbers = new int[LENGTH];

        // 2. 배열에 각 칸에 1~45 사이의 랜덤한 숫자를 저장
        for (int i = 0; i < lottoNumbers.length; i++) {
            lottoNumbers[i] = random.nextInt(NUMBER_MAX) + NUMBER_MIN;
        }

        // 3. 현재 저장된 내용을 화면에 출력해보자
        System.out.println("------------------------------------");
        System.out.println("중복 제거전 저장된 값들");
        System.out.println("------------------------------------");
        for (int i = 0; i < lottoNumbers.length; i++) {
            System.out.printf("%2d ", lottoNumbers[i]);
        }
        System.out.println();
        System.out.println("====================================\n");

        // 4. 중복을 제거해보자
        for (int i = 0; i < lottoNumbers.length; i++) {
            for (int j = 0; j < lottoNumbers.length; j++) {
                if (i != j && lottoNumbers[i] == lottoNumbers[j]) {
                    System.out.printf("%d번과 %d번째가 중복입니다.\n", i, j);
                    lottoNumbers[i] = random.nextInt(NUMBER_MAX) + NUMBER_MIN;
                    j = -1;
                }
            }
        }

        // 5. 중복이 제거된 후 결과
        System.out.println("------------------------------------");
        System.out.println("중복 제거후 저장된 값들");
        System.out.println("------------------------------------");
        for (int i = 0; i < lottoNumbers.length; i++) {
            System.out.printf("%2d ", lottoNumbers[i]);
        }
        System.out.println();
        System.out.println("====================================\n");

        // 6. 정렬해보기
        for(int i = 0; i < lottoNumbers.length - 1; i++){
            if(lottoNumbers[i] > lottoNumbers[i+1]){
                int temp = lottoNumbers[i];
                lottoNumbers[i] = lottoNumbers[i+1];
                lottoNumbers[i+1] = temp;
                i = -1;
            }
        }

        // 7. 최종 결과
        System.out.println("------------------------------------");
        System.out.println("최종 결과 값들");
        System.out.println("------------------------------------");
        for (int i = 0; i < lottoNumbers.length; i++) {
            System.out.printf("%2d ", lottoNumbers[i]);
        }
        System.out.println();
        System.out.println("====================================\n");
    }
}















