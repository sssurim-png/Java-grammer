package C01Basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C07ReferenceType {
    public static void main(String[] args) throws IOException {


// 기본(원시)자료형: int, char, boolean 등
// 특징: 리터럴 형식(값 그대로)으로 값 세팅
//        int a = 10;
//        //참조자료형: 기본자료형을 제외한 '클래스 기반'의 객체
//        //특징: new 키워드를 통해 값 세팅
//        String st1 = new String("hello world");
//        //String은 예외적으로 리터럴값 세팅 허용
//        String st2 ="hello world";
//        //참조자료형을 출력하면 힙메모리의 주소값이 출력되어야 하나, String 내부에 toString매서드가 구현 및 자동호출 되도록 설계
//        System.out.println(st1);
//
//        int[]arr1=new int[4]; //원론적
//        //배열도 객체이므로 new 키워드를 써야하나, 예외적으로 리터럴 값 세팅 허용
//        int[]arr2= {1,3,5,7}; //리터럴 값
//        System.out.println(arr2); //toString 매서드가 구현 안되어있다
//        //배열은 toString매서드가 별도로 구현되어 있기 때문에, 별도로 호출해줘야함.
//        System.out.println(Arrays.toString(arr2));

//        원시자료형은 스택메모리에 값이 저장되므로, ==로 비교시 "값자체"를 비교
//        참조자료형은 스택메모리에 힘메모리의 주소값이 저장되므로, ==로 비교시 "메모리 값"을 비교
//        int a =10;
//        int b = 10;
//        System.out.println(a==b);
//
////        참조자료형은 스택메모리에 힙메모리의 주소값이 저장되므로, ==로 비교시 메모리 주소값을 비교
//        String st1 = new String("hello");
//        String st2 = new String("hello");
//        System.out.println(st1==st2); //스택의 주소값 출력
//        System.out.println(st1.equals(st2));
////        별도의 매서드를 통해 힙메모리의 값을 비교

//        WrapperClass: 기본형 타입을 Wrapping한 클래스(참조자료형)
//        int i1=10;
//        Integer i2 =10;
//        //Integer i4 = new Integer((10)); 원래 이렇게 써야되는데 위를 허용+권장// 박싱과 언박싱이 자유로움
//        //Wrapper클래스의 주요 메서드 사용 예시
//        String st1 = Integer.toString(i1);
//        int i3 =Integer.parseInt(st1);
//
////        추후 배우게 될 list, map, set 등 참조자료형에는 원시 자료형을 쓸 수 없음 //참조자료형만 넣을 수 있다
//        List<Integer>list1 = new ArrayList<>();
//        list1.add(10);
//        list1.add(20);
//        list1.add(30);
//
////        다만, 예외적으로 배역(참조자료형)에는 원시자료형 세팅 가능
//        int[]arr1 = {10,20,30}; //Integer인데 int도 허용해주고 있다

        int i1 =10;
//        Integer ig1 =new Integer(10); //원시 자료형과 너무 호환이 좋아서 알아서 해준다
//        오토박싱: 원시자료형 -> Wrapper클래스 자동 형변환
        Integer ig1 = i1;
//        오토언박싱: Wrapper클래스 -> 원시 자료형 자동 형변환 //int a =list1.get(0); //원랜 int아니고 Integer
        int i2 =ig1;










    }
}
