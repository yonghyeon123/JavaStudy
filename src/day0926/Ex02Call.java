package day0926;
// Call By Value vs Call By Reference
// 데이터타입에 따라 파라미터로 넘어가는 값의 처리가 달라지게 된다.

public class Ex02Call {
    public static void main(String[] args) {
        // Call By Value
        // 값에 의한 호출이란, 우리가 파라미터로 특정 변수를 넘겨주게 되면
        // 해당 변수의 값이 복제되어 메소드가 사용하게 된다.
        // 즉, 값만 복제되었으므로 우리가 해당 메소드에서 값을 변경하더라도
        // 호출한 곳의 원본 변수의 값은 변경되지 않는다라는 것이다.
        // 값에 의한 호출은 파라미터로 넘어가는 변수가
        // 기본형 데이터타입일 경우 발생하게 된다.
        int num1 = 10;
        int num2 = 11;
        System.out.println("main num1: " + num1);
        System.out.println("main num2: " + num2);

        sample(num1, num2);

        System.out.println("main num1: " + num1);
        System.out.println("main num2: " + num2);

        // Call By Reference
        // 참조에 의한 호출은 파라미터로 참조형 데이터타입을 넘겨줬을 경우,
        // 해당 메소드가 새로운 주소값을 부여(=새로운 할당 코드)를 하지 않고
        // 내부의 값을 바꾼다고 하면, 메소드를 호출할 때 넘겨주었던 파라미터의 원본들도
        // 그 변경을 똑같이 받게 된다는 것이다.

        int[] arr = new int[4];
        for(int i = 0 ; i< arr.length; i++){
            System.out.println(arr[i]);
        }

        cbr(arr);

        for(int i = 0 ; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void sample(int a, int b){
        System.out.println("a의 현재 값: " + a);
        System.out.println("b의 현재 값: " + b);
        a++;
        b++;
        System.out.println("a의 최종 값: " + a);
        System.out.println("b의 최종 값: " + b);
    }

    public static void cbr(int[] arr){
        arr = new int[4];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i * 10;
        }
    }
}














