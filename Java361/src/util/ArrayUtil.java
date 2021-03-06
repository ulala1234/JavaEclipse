package util;
// 배열을 다룰 때 도움이 되는 메소드들과
// 동적할당을 사용할 때 필요로 하는 메소드들이 담겨있는
// ArrayUtil 클래스

import struct.Student;
import struct.Board;
public class ArrayUtil {
    // 1. int[] 기준
    // A. 현재 배열의 길이를 알려주는 size(int[])
    public static int size(int[] array) {
        return array.length;
    }
    
    // B. 현재 배열이 비어있는 배열인지 확인해주는 isEmpty(int[])
    public static boolean isEmpty(int[] array) {
        return size(array) == 0;
    }
    
    // C. 해당 배열의 특정 인덱스의 값을 리턴하는 get(int[], int)
    public static int get(int[] array, int index) {
        return array[index];
    }
    
    // D. 해당 배열에 특정 값이 존재하는지 확인해주는 contains(int[], int)
    public static boolean contains(int[] array, int element) {
        for(int i = 0; i < size(array); i++) {
            if(element == get(array, i)) {
                return true;
            }
        }
        
        return false;
    }
    
    // E. 해당 배열에 특정 값의 가장 먼저 등장하는 인덱스가 몇번인지 찾아주는 indexOf(int[], int)
    //    단, 해당 값이 존재하지 않으면 -1이 리턴된다.
    public static int indexOf(int[] array, int element) {
        for(int i = 0; i < size(array); i++) {
            if(element == get(array, i)) {
                return i;
            }
        }
        
        return -1;
    }
    
    // F. 해당 배열에 특정 값의 가장 나중에 등장하는 인덱스가 몇번인지 찾아주는
    //    lastIndexOf(int[], int)
    //    단, 해당 값이 존재하지 않으면 -1이 리턴된다.
    public static int lastIndexOf(int[] array, int element) {
        for(int i = size(array) -1; i >= 0; i--) {
            if(element == get(array, i)) {
                return i;
            }
        }
        
        return -1;
    }
    
    // G. 해당 배열의 크기를 1 늘리고 가장 마지막 칸에 새로운 요소를 추가하는
    //    add(int[], int)
    public static int[] add(int[] array, int element) {
        // 1. 파라미터 array보다 크기가 1 늘어난 배열을 선언과 초기화한다.
        int[] temp = new int[size(array) + 1];
        // 2. array의 전체 내용을 temp에 저장한다.
        for(int i = 0; i < size(array); i++) {
            temp[i] = get(array, i);
        }
        // 3. temp의 가장 마지막 인덱스에 element를 저장한다.
        temp[size(temp) -1] = element;
        // 4. temp를 리턴한다.
        return temp;
        
        
    }
    
    // H. 해당 배열의 특정 인덱스에 새로운 요소를 추가하는
    //    add(int[], int, int)
    public static int[] add(int[] array, int index, int element) {       
        
        // 1. 길이가 0인 int[] temp를 선언하고 초기화한다.
        int[] temp = new int[0];
        
        // 2. for문을 사용하여
        //    0번 인덱스부터 index 전까지를 temp에 추가한다.       
        for(int i = 0; i < index; i++) {
           temp = add(temp, get(array, i));
        }
        
        // 3. temp에 element를 추가한다.
        temp = add(temp, element);
        
        // 4. array배열의 index부터 끝까지를 temp에 추가한다.
        for(int i = index; i < size(array); i++) {
            temp = add(temp, get(array, i));
        }
               
        return temp;
        
    }
    
    // I. 해당 배열의 특정 인덱스에 새로운 값을 저장하고
    //    원래 있던 값은 리턴하는 set(int[], int, int)
    public static int set(int[] array, int index, int element) {
        // 1. index번에 저장된 값을 임시로 int temp에 저장한다.
        int temp = get(array, index);        
        // 2. index번에 element를 저장한다.
        array[index] = element;
        // 3. temp를 리턴한다.
        return temp;
    }
    
    // J. 특정 인덱스의 값을 배열에서 삭제하는
    //    remove(int[], int).
    //    단, 우리 배열이 int[]이기 때문에 K에 나올 메소드와 구분하기 위하여
    //    이번 한번만은 removeByIndex(int[], int) 라고 한다.
    //    또한, 잘못된 index가 파라미터로 넘어올 경우,
    //    변경되지 않은 int[]이 리턴된다.
    public static int[] removeByIndex(int[] array, int index) {
        // 1. 크기가 0인 int[] temp 선언 및 초기화
        int[] temp = new int[0];
        // 2. array의 길이 만큼 반복되는 for문 시작
        for(int i = 0; i < size(array); i++) {
            // 3. for문을 반복하면서 i가 index와 다르면
            //    array의 i번째 값을 temp에 추가
            if(i != index) {
                temp = add(temp, get(array, i));
            }
        }
        // 4. temp를 리턴한다.
        return temp;
    }
    
    // K. 해당 배열에서 특정 요소를 제거하는
    //    removeByElement(int[], int)
    //    단, 해당 배열에 해당 요소가 없을 경우에는 
    //    아무것도 제거하지 않는다.
    //    또한 해당 배열에서 똑같은 요소가 여러개일 경우에는
    //    가장 먼저 등장하는 요소를 제거한다.
    public static int[] removeByElement(int[] array, int element) {
        // 1. array에서 해당 element의 인덱스를 찾아서 삭제한 결과를 리턴한다.
        return removeByIndex(array, indexOf(array, element));
    }
    
    // 2. String[] 기준
    // A. size(String[])
    public static int size1(String[] array) {
        return array.length;
    }
    
    // B. isEmpty(String[])
    public static boolean isEmpty1(String[] array) {
        return size1(array) == 0;
    }
    
    // C. get(String[], int)
    public static String get1(String[] array, int index) {
        return array[index];
    }
    
    // D. contains(String[], String)
    public static boolean contains1(String[] array, String e) {
        for(int i = 0; i < size1(array); i++) {
            if(e.equals(get1(array, i))) {
                return true;
            }
        }
        return false;
    }
    
    // E. indexOf(String[], String)
    public static int indexOf1(String[] array, String e) {
        for(int i = 0; i < size1(array); i++) {
            if(e.equals(get1(array, i))) {
                return i;
            }
        }
        return -1;
    }
    
    // F. lastIndexOf(String[], String)
    public static int lastIndexOf1(String[] array, String e) {
        for(int i = size1(array) -1; i >= 0; i--) {
            if(e.equals(get1(array, i))) {
                return i;
            }
        }
        return -1;
    }
    
    // G. add(String[], String)
    public static String[] add1(String[] array, String e) {
        String[] temp = new String[size1(array) + 1];
        
        for(int i = 0; i < size1(array); i++) {
            temp[i] = get1(array, i);
        }
        temp[size1(temp) -1] = e;
        
        return temp;
    }
    
    // H. add(String[], String)
    public static String[] add1(String[] array, int index, String e) {
        String[] temp = new String[0];
        
        for(int i = 0; i < index; i++) {
            temp = add1(temp, get1(array, i));
        }
        
        temp = add1(temp, e);
        
        for(int i = index; i < size1(array); i++) {
            temp = add1(temp, get1(array, i));
        }
        
        return temp;
    }
    
    // I. set(String[], int, String)
    
    public static String set1(String[] array, int index, String e) {
        String temp = get1(array, index);
        
        array[index] = e;
        
        return temp;
    }
    // J. remove(String[], int)
    
    public static String[] remove1(String[] array, int index) {
        String[] temp = new String[0];
        
        for(int i = 0; i < size1(array); i++) {
            if(i != index) {
                temp = add1(temp, get1(array, i));
            }
        }
        
        return temp;
    }
    // K. remove(String[], String[])
    
    public static String[] remove1(String[] array, String e) {
        return remove1(array, indexOf1(array, e));
    }
    
    
    // 3. Student[]
    // A. equals(Student, Student)
    public static boolean equals(Student s1, Student s2) {
        
        return s1.id == s2.id;
    }
    
    // B. size(Student[])
    public static int size(Student[] array) {
        return array.length;
    }
    
    // C. isEmpty(Student[])
    public static boolean isEmpty(Student[] array) {
        return size(array) == 0;
    }
    
    // D. get(Student[], int)
    public static Student get(Student[] array, int index) {
        return array[index];
    }
    
    // E. contains(Student[], Student)
    public static boolean contains(Student[] array, Student s) {
        for(int i = 0; i < size(array); i++) {
            if(equals(s, get(array, i))) {
                return true;
            }
        }
        
        return false;
    }
    
    // F. indexOf(Student[], Student)
    public static int indexOf(Student[] array, Student s) {
        for(int i = 0; i < size(array); i++) {
            if(equals(s, get(array, i))) {
                return i;
            }
        }
        
        return -1;
    }
    
    // G. add(Student[], Student)
    public static Student[] add(Student[] array, Student s) {
        Student[] temp = new Student[size(array) + 1];
        for(int i = 0; i < size(array); i++) {
            temp[i] = get(array, i);
        }
        temp[size(temp) - 1] = s;
        return temp;
    }
    
    // H. add(Student[], int, Student)
    public static Student[] add(Student[] array, int index, Student s) {
        Student[] temp = new Student[0];
        for(int i = 0; i < index; i++) {
            temp = add(temp, get(array, i));
        }
        temp = add(temp, s);
        for(int i = index; i < size(array); i++) {
            temp = add(temp, get(array, i));
        }
        return temp;
        
    }
    
    // I. set(Student[], int, Student)
    public static Student set(Student[] array, int index, Student s) {
        Student temp = get(array, index);
        array[index] = s;
        return temp;
    }
    
    // J. remove(Student[], int)
    public static Student[] remove(Student[] array, int index) {
        Student[] temp = new Student[0];
        for(int i = 0; i < size(array); i++) {
            if(i != index) {
                temp = add(temp, get(array, i));
            }
        }
        return temp;
    }
    
    // K. remove(Student[], Student)
    public static Student[] remove(Student[] array, Student s) {
        return remove(array, indexOf(array, s));
    }
    
    
    // 4. Board[]
    // A. equals(Board, Board)
    public static boolean equals(Board b1, Board b2) {
        
        return b1.id == b2.id;
    }
    
    // B. size(Board[])
    public static int size(Board[] array) {
        return array.length;
    }
    
    // C. isEmpty(Board[])
    public static boolean isEmpty(Board[] array) {
        return size(array) == 0;
    }
    
    // D. get(Board[], int)
    public static Board get(Board[] array, int index) {
        return array[index];
    }
    
    // E. contains(Board[], Board)
    public static boolean contains(Board[] array, Board b) {
        for(int i = 0; i < size(array); i++) {
            if(equals(b, get(array, i))) {
                return true;
            }
        }
        
        return false;
    }
    
    // F. indexOf(Board[], Board)
    public static int indexOf(Board[] array, Board b) {
        for(int i = 0; i < size(array); i++) {
            if(equals(b, get(array, i))) {
                return i;
            }
        }
        
        return -1;
    }
    
    // G. add(Board[], Board)
    public static Board[] add(Board[] array, Board b) {
        Board[] temp = new Board[size(array) + 1];
        for(int i = 0; i < size(array); i++) {
            temp[i] = get(array, i);
        }
        temp[size(temp) - 1] = b;
        return temp;
    }
    
    // H. add(Board[], int, Board)
    public static Board[] add(Board[] array, int index, Board b) {
        Board[] temp = new Board[0];
        for(int i = 0; i < index; i++) {
            temp = add(temp, get(array, i));
        }
        temp = add(temp, b);
        for(int i = index; i < size(array); i++) {
            temp = add(temp, get(array, i));
        }
        return temp;
        
    }
    
    // I. set(Board[], int, Board)
    public static Board set(Board[] array, int index, Board b) {
        Board temp = get(array, index);
        array[index] = b;
        return temp;
    }
    
    // J. remove(Board[], int)
    public static Board[] remove(Board[] array, int index) {
        Board[] temp = new Board[0];
        for(int i = 0; i < size(array); i++) {
            if(i != index) {
                temp = add(temp, get(array, i));
            }
        }
        return temp;
    }
    
    // K. remove(Board[], Board)
    public static Board[] remove(Board[] array, Board b) {
        return remove(array, indexOf(array, b));
    }


}
