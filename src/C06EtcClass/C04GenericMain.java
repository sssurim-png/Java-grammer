package C06EtcClass;

import java.util.*;
import java.util.stream.Stream;

public class C04GenericMain {
    public static void main(String[] args) {
        String[] stArr = {"java","python","c++"};
        stChange(stArr,0,1);
        System.out.println(Arrays.toString(stArr));

        Integer[] intArr = {10,20,30};
        intChage(intArr,0,1);
        System.out.println(Arrays.toString(intArr));

        allChage(stArr,1,2); //제네릭
        System.out.println(Arrays.toString(stArr));
        allChage(intArr,0,2);
        System.out.println(Arrays.toString(intArr));


///        제네릭을 사용한 객체 생성
        GenericPerson <String> p1 = new GenericPerson("hong"); //자료형 뭐쓸건지 넣어줘야한다
        GenericPerson <Integer> p2 = new GenericPerson(20);
        System.out.println(p1.getValue());
        System.out.println(p2.getValue());

///        제네릭의 사용 예시 -실제로 많이 쓴 것
        List<String>myList =new ArrayList<>();
        Map<String,Integer> map = new HashMap<>(); //애초에 T(제네릭)으로 설계되어있어서 이것저것 다 넣을 수 있는 것
        Stream<String>myStream;  //안에 student도 넣고 그런다
        Optional<Student>myStudent; //"참조자료형"이기만 하면된다

    }


    static void stChange(String[] stArr, int a, int b){

        String temp=stArr[a];
        stArr[a]=stArr[b];
        stArr[b]=temp;


    }

    static  void intChage(Integer[]intArr, int a, int b){
        // 자료형 바뀔때마다하나하나 만들어야된다 -> 제네릭으로 범용적으로 사용하겠다

        Integer temp=intArr[a];
        intArr[a]=intArr[b];
        intArr[b]=temp;

    }

///  제네릭메서드는 반환타입 왼쪽에 <T>라고 선언 - <>에 들어가는 것이다: 이제까지 <>에 원시자료형 못넣은 이유
/// 이때 T는 참조형변수인 객체타입만을 허용 //원시자료형 (ex.int)안된다
    static <T> void allChage(T[]arr, int a, int b){

        T temp =arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}



//제네릭으로 만들어보자
class GenericPerson<T>{
    private T  value;


    public  GenericPerson(T value){ //클래스 차원의 <>가 있으면 매서드에서 안써도 된다
        this.value =value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

