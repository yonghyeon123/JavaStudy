package day0922;
// 중첩 for문
public class Ex05NestedFor {
    public static void main(String[] args){
        for(int i = 1; i <= 3; i++){
            System.out.println("\ni for문 시작");
            for(int j = 1001; j <= 1004; j++){
                System.out.printf("i: [%d] j: [%d]\n", i, j);
            }
            System.out.println("i for문 종료\n");
        }
    }
}
