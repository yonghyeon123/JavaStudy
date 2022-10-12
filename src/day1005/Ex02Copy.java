package day1005;

import model.StudentDTO;

// 얕은 복사와 깊은 복사
// 우리가 객체의 값을 복사할 때 2가지 방법이 가능하다.
// 1. 얕은 복사(Shallow Copy)
//    얕은 복사는 객체 안의 필드 값을 복제하는 것이 아니라
//    원본 객체의 주소값을 복사할 객체에 저장하게 된다.
//    즉 두 개의 객체가 만들어지지만, 실제론 하나의 공간과 연결이 되어
//    원본 혹은 복사본의 필드에 저장된 값을 변경하면 반대편에도 똑같이 반영이 된다.

// 2. 깊은 복사(deep copy)
//    깊은 복사는 객체를 복사할 때 단순히 주소값을 복사하는 것이 아니라
//    별개의 공간을 만들어서, 원본에서 각각 필드에 저장된 값을
//    다시 별개의 공간에 저장하는 방법이다.
//    그러므로, 하나의 값이 바뀌더라도 반대편은 반영이 되지 않는다.

public class Ex02Copy {
    public static void main(String[] args) {
        // 1. 얕은 복사
        StudentDTO origin = new StudentDTO();
        origin.setName("조재영");
        StudentDTO copied = origin;

        copied.setName("김철수");

        System.out.println(origin.getName());
        System.out.println(copied.getName());

        // 2. deep copy
        origin = new StudentDTO();
        origin.setName("조재영");

        copied = new StudentDTO();
        copied.setName(origin.getName());

        copied.setName("김철수");

        System.out.println(origin.getName());
        System.out.println(copied.getName());

    }
}










