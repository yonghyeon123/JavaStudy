package day0926;
// 로또번호 제작기
// 컴퓨터가 6개의 로또 번호를 뽑아주는 프로그램을 작성하시되
// 해당 숫자가 있는지 체크하는 메소드
// 배열을 정렬해주는 메소드
// 배열을 출력해주는 메소드
// 3개의 메소드를 만들어 사용하는 버젼으로 만들어보시오.
// 12시 10분까지
import java.util.Random;
public class Ex03Lotto01 {
    public static void main(String[] args) {
        final int NUMBER_MIN = 1;
        final int NUMBER_MAX = 45;
        final int LENGTH = 6;

        Random random = new Random();
        int[] array = new int[LENGTH];

        for(int i = 0; i < array.length;){
            int number = random.nextInt(NUMBER_MAX) + NUMBER_MIN;

            // 만약 contains메소드의 결과가 false이면
            // number를 array의 i번 인덱스에 저장하고 i++한다.
            if(!contains(array, number)){
                array[i] = number;
                i++;
            }
        }

        sort(array);

        System.out.println("컴퓨터의 숫자");
        printArray(array);
    }

    public static boolean contains(int[] array, int number){
        for(int i = 0; i < array.length; i++){
            if(array[i] == number){
                return true;
            }
        }

        return false;
    }

    public static void sort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i+1]){
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                i = -1;
            }
        }
    }

    public static void printArray(int[] array){
        System.out.print("[");
        for(int i = 0; i < array.length; i++){
            System.out.printf("%2d", array[i]);
            if(i < array.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
