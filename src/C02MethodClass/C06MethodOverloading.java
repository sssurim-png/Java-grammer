package C02MethodClass;


import java.util.ArrayList;
import java.util.List;

/// 자바에서 같은 이름의 메서드명을 사용하되, 매개변수의 개수 또는 매개변수의 타입이 달라지는 메서드 오버로딩은 허용
public class C06MethodOverloading {
    public static void main(String[] args) {
/// 메서드 오버로딩 후 해당 메서드 호출
        System.out.println(sum(10, 20));
        System.out.println(sum(10.5, 20.5));
        System.out.println(sum(10, 20, 30));

//        또 다른 메서드 오버로딩 사례
        System.out.println("hello");
        System.out.println(10);
        System.out.println(10.5); //sout에는 무수히 많은 오버로딩을 해뒀을 것
        List<Integer> myList = new ArrayList<>();
        myList.add(10); //하나하면 값
        myList.add(0, 20);//두개하면 앞은 인덱스로 해줄게로 오버로딩해놯다

    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static double sum(double a, double b) {
        return a + b;
    }
//타입이 달라지거나 매개변수 개수가 달라지면 이름 같아도 에러 안난다
}