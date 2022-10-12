package day0927;
// ArrayUtil을 사용한 로또 번호 추첨기
import java.util.Random;
import util.ArrayUtil;
public class Ex01Lotto {
    public static void main(String[] args) {
        // 1. 동적할당을 위한 int 배열
        int[] numbers = new int[0];
        // 2. numbers의 size()가 6 미만일동안
        // while을 사용하여 중복되지 않는 랜덤 숫자를 추가해준다.
        Random random = new Random();
        while(ArrayUtil.size(numbers) < 6){
            int num = random.nextInt(45) + 1;
            if(!ArrayUtil.contains(numbers, num)){
                numbers = ArrayUtil.add(numbers, num);
            }
        }
        // 3. 결과를 정렬한다.

        // 4. 출력한다.
    }
}

















