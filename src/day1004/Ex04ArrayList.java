package day1004;
// 어레이리스트(ArrayList)
// 우리가 기존에는 배열의 동적할당을 위한 메소드를 직접 ArrayUtil 이라는 클래스에
// 만들어서, 사용을 하였지만 문제는 우리가 데이터타입을 새로 만들때마다
// 해당 데이터타입에 대한 동적할당 메소드를 처음부터 모두다 만들어주는 불편함이 있었다.
// 하지만, 이 배열의 동적할당이란 개념은 새로 등장한 개념이 아니라
// 이미 7, 80년대에 존재하던 오래된 개념이다.
// 당연히 3세대 언어 Java는 그 동적할당된 배열을 이미 클래스화 시켜놨고
// 우리는 그 클래스 객체를 만들어서 편하게 쓰면 된다.

// 동적할당이 구현된 배열을 우리가 List 라고 부르는데
// 이 List를 상속받는 여러개의 클래스가 있지만 우리는 그중에서
// 가장 사용이 간단한 ArrayList를 사용하게 될 것이다.

import java.util.ArrayList;

public class Ex04ArrayList {
    public static void main(String[] args) {
        // 어레이리스트 객체의 선언과 초기화
        // 어레이리스트 객체를 선언할 때에는 해당 객체가 어떤 데이터타입의 동적 할당 배열인지
        // 명시를 해주어야 하는데 이때에는
        // ArrayList<클래스> 라고 적어주면 된다.

        ArrayList<String> list = new ArrayList<>();
        // 1. 현재 ArrayList 객체의 "크기"를 알아낼때에는?
        // size()
        System.out.println("1. size()");
        System.out.println("list의 현재 크기: " + list.size());
        System.out.println("----------------------------\n");
        // 2. 현재 ArrayList 객체가 비어있는지 확인할때에는?
        // isEmpty()
        System.out.println("2. isEmpty()");
        System.out.println("list에 무언가 존재합니까? " + list.isEmpty());
        System.out.println("----------------------------\n");

        // 3. ArrayList 객체에 새로운 값을 추가할 때에는?
        // add()
        System.out.println("3. add()");
        System.out.println("add() 전 isEmpty(): " + list.isEmpty());
        // add()를 위한 String 객체 선언 및 초기화
        String str1 = "str1";
        String str2 = "str2";
        String str3 = "str3";
        String str4 = "str4";
        String str5 = "str5";
        String str6 = "str6";
        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str4);
        list.add(str5);
        list.add(str6);
        System.out.println("add() 후 isEmpty(): " + list.isEmpty());
        System.out.println("add() 후 size(): " + list.size());
        System.out.println("----------------------------\n");

        // 4. 특정 인덱스에 있는 객체를 호출할 때에는?
        //    get()
        System.out.println("4. get()");
        System.out.println("get(0): " + list.get(0));
        System.out.println("----------------------------\n");

        // 5. 특정 인덱스에 있는 객체를 삭제할 때에는?
        //    remove()
        System.out.println("5. remove()");
        System.out.println("remove() 전 size(): " + list.size());
        System.out.println("remove() 전 get(0): " + list.get(0));
        list.remove(0);
        System.out.println("remove() 후 size(): " + list.size());
        System.out.println("remove() 후 get(0): " + list.get(0));
        System.out.println("----------------------------\n");

        // 6. 특정 인덱스에 새로운 객체를 추가할 때에는?
        //    add(index, 객체)
        System.out.println("6. add(index, 객체)");
        System.out.println("add() 전 size(): " + list.size());
        System.out.println("add() 전 get(0): " + list.get(0));
        list.add(0, str1);
        System.out.println("add() 후 size(): " + list.size());
        System.out.println("add() 후 get(0): " + list.get(0));
        System.out.println("----------------------------\n");

        // 7. 특정 인덱스에 새로운 객체로 교환할때에는?
        //    set()
        System.out.println("7. set()");
        System.out.println("set() 전 get(5): " + list.get(5));
        String original = list.set(5, "교체당함");
        System.out.println("set() 후 get(5): " + list.get(5));
        System.out.println("원래 5번 인덱스에 있던 객체: " + original);
        System.out.println("----------------------------\n");

        // 여기서부터는 <> 안에 적어놓은 클래스가
        // equals()를 정확하게 오버라이드 해야 정상적으로 진행이 된다.
        String str1r = new String("str1");
        System.out.println("str1 == str1r: " + (str1 == str1r));
        System.out.println("str1.equals(str1r): " + str1.equals(str1r));

        // 8. 특정 객체가 ArrayList 객체 안에 있는지 확인할 때에는?
        //    contains()
        System.out.println("8. contains()");
        System.out.println("list.contains(\"교체당함\"): " + list.contains("교체당함"));
        System.out.println("list.contains(str2): " + list.contains(str2));
        System.out.println("list.contains(str6): " + list.contains(str6));
        System.out.println("list.contains(str1r): " + list.contains(str1r));
        System.out.println("----------------------------\n");

        // 9. 특정 객체가 ArrayList 객체 안에 가장 먼저 등장하는 인덱스를 알아낼때에는?
        //    indexOf()
        //    단, 해당 객체와 일치하는 객체가 어레이리스트 객체안에 없으면 -1이 리턴된다.
        System.out.println("9. indexOf()");
        System.out.println("list.indexOf(\"교체당함\"): " + list.indexOf("교체당함"));
        System.out.println("list.indexOf(str2): " + list.indexOf(str2));
        System.out.println("list.indexOf(str6): " + list.indexOf(str6));
        System.out.println("list.indexOf(str1r): " + list.indexOf(str1r));
        System.out.println("----------------------------\n");

        // 10. 특정 객체가 어레이리스트 객체 안에 가장 마지막에 등장하는 인덱스를 알아낼때에는?
        //     lastIndexOf()

        // 11. 특정 객체를 어레이리스트에서 삭제할때에는?
        //     remove()
        System.out.println("11. remove()");
        System.out.println("remove(str1) 전 size(): " + list.size());
        System.out.println("remove(str1) 전 indexOf(str1): " + list.indexOf(str1));
        list.remove(str1);
        System.out.println("remove(str1) 후 size(): " + list.size());
        System.out.println("remove(str1) 후 indexOf(str1): " + list.indexOf(str1));
        list.remove(str1);
        System.out.println("remove(str1) 두번 실행 후 size(): " + list.size());
        System.out.println("remove(str1) 두번 실행 후 후 indexOf(str1): " + list.indexOf(str1));
        System.out.println("----------------------------\n");
    }
}










