package day0926;
// 로또번호 제작기
// 사용자로부터 총 몇번의 게임을 할지 입력을 받아
// 각 게임의 결과를 출력해주는 프로그램.

import java.util.Random;
import java.util.Scanner;

public class Ex04Lotto02 {
    public static void main(String[] args) {
        final int NUMBER_MIN = 1;
        final int NUMBER_MAX = 45;
        final int LENGTH = 6;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[LENGTH];

        // 사용자로부터 총 몇게임을 할지 입력을 받는다.
        System.out.println("총 몇게임 하시겠습니까?");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        int[][] userNumbers = new int[userNumber][LENGTH];

        for (int i = 0; i < userNumbers.length; i++) {
            System.out.println("------------------------------------");
            System.out.println((i + 1) + "번째 게임");
            System.out.println("------------------------------------");
            System.out.println("1. 자동 2. 수동");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if (userChoice == 2) {
                for (int j = 0; j < userNumbers[i].length; ) {
                    System.out.println((i + 1) + "번째 숫자를 입력해주세요");
                    System.out.print("> ");
                    userNumber = scanner.nextInt();

                    while (userNumber < NUMBER_MIN || userNumber > NUMBER_MAX) {
                        System.out.println("잘못 입력하셨습니다.");
                        System.out.println((i + 1) + "번째 숫자를 입력해주세요.");
                        System.out.print("> ");
                        userNumber = scanner.nextInt();
                    }

                    if (!contains(userNumbers[i], userNumber)) {
                        userNumbers[i][j] = userNumber;
                        j++;
                    } else {
                        System.out.println("중복된 숫자는 입력하실 수 없습니다.");
                    }
                }
            } else {
                setAuto(userNumbers[i]);
            }

            sort(userNumbers[i]);
        }

        setAuto(array);

        sort(array);

        System.out.println("컴퓨터의 숫자");
        printArray(array);
        System.out.println();
        System.out.println("결과");
        for (int i = 0; i < userNumbers.length; i++) {
            printArray(userNumbers[i]);
            System.out.printf("- 총 맞은 갯수: %d개\n", findSame(array, userNumbers[i]));
        }


    }

    public static void setAuto(int[] array) {
        Random random = new Random();
        final int NUMBER_MAX = 45;
        final int NUMBER_MIN = 1;

        for (int i = 0; i < array.length; ) {
            int number = random.nextInt(NUMBER_MAX) + NUMBER_MIN;

            // 만약 contains메소드의 결과가 false이면
            // number를 array의 i번 인덱스에 저장하고 i++한다.
            if (!contains(array, number)) {
                array[i] = number;
                i++;
            }
        }
    }

    public static boolean contains(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return true;
            }
        }

        return false;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                i = -1;
            }
        }
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%2d", array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static int findSame(int[] array1, int[] array2) {
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    count++;
                }
            }
        }

        return count;
    }

}
