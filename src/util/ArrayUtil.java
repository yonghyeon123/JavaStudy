package util;

import Struct.StudentStruct;

// 배열을 사용할 때 도움이 될 다양한 메소드들.
public class ArrayUtil {
    // 1. int[]
    // A. 해당 배열의 길이가 얼마인지 확인해주는 size()
    public static int size(int[] arr) {
        return arr.length;
    }

    // B. 해당 배열이 비어있는지를 확인해주는 isEmpty()
    public static boolean isEmpty(int[] arr) {
        return size(arr) == 0;
    }

    // C. 해당 배열의 특정 인덱스에 저장된 값을 리턴하는 get()
    public static int get(int[] array, int index) {
        return array[index];
    }

    // D. 해당 배열에 특정 값이 존재하는지 확인해주는 contains()
    public static boolean contains(int[] array, int element) {
        for (int i = 0; i < size(array); i++) {
            if (get(array, i) == element) {
                return true;
            }
        }
        return false;
    }

    // E. 해당 배열에 특정 값의 가장 먼저 등장하는 인덱스를 리턴하는 indexOf()
    //    단, 해당 배열에 그 값이 없을 경우에는 -1이 리턴된다.
    public static int indexOf(int[] array, int element) {
        for (int i = 0; i < size(array); i++) {
            if (get(array, i) == element) {
                return i;
            }
        }

        return -1;
    }

    // F. 해당 배열에 특정 값의 가장 나중에 등장하는 인덱스를 리턴하는 lastIndexOf()
    //    단, 해당 배열에 그 값이 없을 경우에는 -1이 리턴된다.
    public static int lastIndexOf(int[] array, int element) {
        for (int i = size(array) - 1; i >= 0; i--) {
            if (get(array, i) == element) {
                return i;
            }
        }

        return -1;
    }

    // G. 배열의 현재 내용을 다 날리고 비어있는 배열을 리턴하는 clear()
    public static int[] clear() {
        return new int[0];
    }

    // H. 현재 배열에 새로운 값을 가장 마지막에 추가하는 add()
    public static int[] add(int[] array, int element) {
        // array보다 길이가 1 늘어난 배열을 하나 새로 만든다.
        int[] temp = new int[size(array) + 1];
        // array의 기존 내용을 차례대로 temp에 저장한다.
        for (int i = 0; i < size(array); i++) {
            temp[i] = get(array, i);
        }
        // temp의 가장 마지막 인덱스번칸에 element를 저장한다.
        temp[size(temp) - 1] = element;

        // 새로운 배열 temp를 리턴한다.
        return temp;
    }

    // I. 특정 인덱스에 새로운 값을 추가하는 add()
    public static int[] add(int[] array, int index, int element) {
        int[] temp = new int[0];
        for (int i = 0; i < size(array); i++) {
            if (i == index) {
                temp = add(temp, element);
            }
            temp = add(temp, get(array, i));
        }

        return temp;
    }

    // J. 특정 인덱스의 값을 다른 element로 교체하는 set()
    //    단, 원래 해당 인덱스의 있는 값은 다른데서 사용할 수도 있으니 해당 값을 리턴해준다.
    public static int set(int[] array, int index, int element) {
        int temp = get(array, index);
        array[index] = element;
        return temp;
    }

    // K. 해당 배열의 특정 인덱스번 칸을 삭제하는 removeByIndex()
    //    단, 해당 인덱스가 존재하지 않을 경우, 원래 배열을 그대로 리턴한다.
    public static int[] removeByIndex(int[] array, int index) {
        if (index < 0 || index >= size(array)) {
            return array;
        }

        int[] temp = new int[0];

        for (int i = 0; i < size(array); i++) {
            if (i != index) {
                temp = add(temp, get(array, i));
            }
        }

        return temp;
    }

    // L. 해당 배열에서 특정 엘리먼트를 삭제하는 removeByElement()
    //    단, 해당 엘리먼트가 여러번 등장하면 가장 먼저 등장하는 엘리먼트를 삭제한다.
    public static int[] removeByElement(int[] array, int element) {
        return removeByIndex(array, indexOf(array, element));
    }

    // 2. String[]
    // A. size()
    public static int size(String[] arr) {
        return arr.length;
    }

    // B. isEmpty()
    public static boolean isEmpty(String[] arr) {
        return size(arr) == 0;
    }

    // C. get()
    public static String get(String[] arr, int index) {
        return arr[index];
    }

    // D. contains()
    public static boolean contains(String[] arr, String element) {
        for (int i = 0; i < size(arr); i++) {
            if (get(arr, i).equals(element)) {
                return true;
            }
        }
        return false;
    }

    // E. indexOf()
    public static int indexOf(String[] arr, String element) {
        for (int i = 0; i < size(arr); i++) {
            if (get(arr, i).equals(element)) {
                return i;
            }
        }
        return -1;
    }

    // F. lastIndexOf()
    public static int lastIndexOf(String[] arr, String element) {
        for (int i = size(arr) - 1; i >= 0; i--) {
            if (get(arr, i).equals(element)) {
                return i;
            }
        }
        return -1;
    }

    // G. add()
    public static String[] add(String[] arr, String element) {
        String[] temp = new String[size(arr) + 1];
        for (int i = 0; i < size(arr); i++) {
            temp[i] = get(arr, i);
        }
        temp[size(temp) - 1] = element;
        return temp;
    }

    // H. add()
    public static String[] add(String[] arr, int index, String element) {
        String[] temp = new String[0];
        for (int i = 0; i < size(arr); i++) {
            if (i == index) {
                temp = add(temp, element);
            }
            temp = add(temp, get(arr, i));
        }

        return temp;
    }

    // J. set()
    public static String set(String[] arr, int index, String e) {
        String temp = get(arr, index);
        arr[index] = e;

        return temp;
    }

    // K. remove()
    public static String[] remove(String[] arr, int index) {
        if (index < 0 || index >= size(arr)) {
            return arr;
        }

        String[] temp = new String[0];
        for (int i = 0; i < size(arr); i++) {
            if (i != index) {
                temp = add(temp, get(arr, i));
            }
        }

        return temp;
    }

    // L. remove()
    public static String[] remove(String[] arr, String e) {
        return remove(arr, indexOf(arr, e));
    }

    // 3. StudentStruct[]
    // A. equals()
    public static boolean equals(StudentStruct s1, StudentStruct s2) {
        return s1.id == s2.id;
    }

    // B. size()
    public static int size(StudentStruct[] array) {
        return array.length;
    }

    // C. isEmpty()
    public static boolean isEmpty(StudentStruct[] array) {
        return size(array) == 0;
    }

    // D. get()
    public static StudentStruct get(StudentStruct[] array, int index) {
        return array[index];
    }

    // E. contains()
    public static boolean contains(StudentStruct[] array, StudentStruct s) {
        for (int i = 0; i < size(array); i++) {
            if (equals(get(array, i), s)) {
                return true;
            }
        }
        return false;
    }

    // F. indexOf()
    public static int indexOf(StudentStruct[] array, StudentStruct s) {
        for (int i = 0; i < size(array); i++) {
            if (equals(get(array, i), s)) {
                return i;
            }
        }
        return -1;
    }

    // G. lastIndexOf()
    public static int lastIndexOf(StudentStruct[] array, StudentStruct s) {
        for (int i = size(array) - 1; i >= 0; i--) {
            if (equals(get(array, i), s)) {
                return i;
            }
        }
        return -1;
    }

    // H. add()
    public static StudentStruct[] add(StudentStruct[] array, StudentStruct s) {
        StudentStruct[] temp = new StudentStruct[size(array) + 1];
        for (int i = 0; i < size(array); i++) {
            temp[i] = get(array, i);
        }
        temp[size(temp) - 1] = s;

        return temp;
    }

    // I. add()
    public static StudentStruct[] add(StudentStruct[] array, int index, StudentStruct s) {
        StudentStruct[] temp = new StudentStruct[0];
        for (int i = 0; i < size(array); i++) {
            if (i == index) {
                temp = add(temp, s);
            }
            temp = add(temp, get(array, i));
        }
        return temp;
    }

    // J. set()
    public static StudentStruct set(StudentStruct[] array, int index, StudentStruct s) {
        StudentStruct temp = get(array, index);
        array[index] = s;
        return temp;
    }

    // K. remove()
    public static StudentStruct[] remove(StudentStruct[] array, int index) {
        if (index < 0 || index >= size(array)) {
            return array;
        }
        StudentStruct[] temp = new StudentStruct[0];
        for (int i = 0; i < size(array); i++) {
            if (i != index) {
                temp = add(temp, get(array, i));
            }
        }
        return temp;
    }

    // L. remove()
    public static StudentStruct[] remove(StudentStruct[] array, StudentStruct s) {
        return remove(array, indexOf(array, s));
    }
}












