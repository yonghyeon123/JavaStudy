package day0926;
// 배열의 동적할당
// 배열의 가장 큰 단점은?
// 길이가 정해져있다.
// 우리가 배열을 선언하고 초기화할때
// new int[길이] 라는 코드를 통하여
// 해당 배열이 총 몇칸으로 이루어져있는지를 먼저 정해놓고 시작하기 때문에
// 만약 그 길이를 벗어날 경우에는 ArrayIndexOutOfBoundsException 이라는 에러가 발생한다.
// 또한, 해당 배열에 실제 값이 입력된 칸이 몇칸인지 알수 없게 된다.
// 이렇게 맨 처음부터 길이가 특정 값으로 고정된 배열을 정적할당된 배열이라고 한다.

// 그에 반해서, 동적할당된 배열은
// 우리가 새로운 것을 추가 하면 길이가 늘어나고, 기존에 있던 무언가를 삭제하면
// 길이가 줄어드는 등 기존에 비해서는 훨씬 더 유연한 배열이 된다.
// 단, 동적할당된 배열을 자바에서는 지원하지 않으므로 우리가 직접 만들어주어야 한다.


import util.ArrayUtil;

public class Ex09DynamicAlloc {
    public static void main(String[] args) {
        System.out.println("--------------------------------------");
        System.out.println("1. int[]");
        int[] intArr = new int[4];
        System.out.println("A. size(intArr): " + ArrayUtil.size(intArr));
        System.out.println("B. isEmpty(intArr): " + ArrayUtil.isEmpty(intArr));
        System.out.println("C. get(intArr, 2): " + ArrayUtil.get(intArr, 2));
        System.out.println("D-1. contains(intArr, 0): " + ArrayUtil.contains(intArr, 0));
        System.out.println("D-2. contains(intArr, 5): " + ArrayUtil.contains(intArr, 5));
        System.out.println("E-1. indexOf(intArr, 0): " + ArrayUtil.indexOf(intArr, 0));
        System.out.println("E-2. indexOf(intArr, 5): " + ArrayUtil.indexOf(intArr, 5));
        System.out.println("F-1. lastIndexOf(intArr, 0): " + ArrayUtil.lastIndexOf(intArr, 0));
        System.out.println("F-2. lastIndexOf(intArr, 5): " + ArrayUtil.lastIndexOf(intArr, 5));
        System.out.println("G. clear() 전 isEmpty(intArr): " + ArrayUtil.isEmpty(intArr));
        intArr = ArrayUtil.clear();
        System.out.println("G. clear() 후 isEmpty(intArr): " + ArrayUtil.isEmpty(intArr));
        System.out.println("H. add() 전 isEmpty(intArr): " + ArrayUtil.isEmpty(intArr));
        intArr = ArrayUtil.add(intArr, 20);
        System.out.println("H. add() 후 isEmpty(intArr): " + ArrayUtil.isEmpty(intArr));
        System.out.println("H. add() 후 get(intArr, 0): " + ArrayUtil.get(intArr, 0));
        System.out.println("I. add() 전 size(intArr): " + ArrayUtil.size(intArr));
        System.out.println("I. add() 전 get(intArr, 0): " + ArrayUtil.get(intArr, 0) );
        intArr = ArrayUtil.add(intArr, 0, 40);
        System.out.println("I. add() 후 size(intArr): " + ArrayUtil.size(intArr));
        System.out.println("I. add() 후 get(intArr, 0): " + ArrayUtil.get(intArr, 0) );

        System.out.println("--------------------------------------\n");
    }
}
