package day0922;
// 별찍기 1번
import java.util.Scanner;
public class StarPrinter01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("출력할 줄 수를 입력해주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        for(int i = 1; i <= userNumber; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
