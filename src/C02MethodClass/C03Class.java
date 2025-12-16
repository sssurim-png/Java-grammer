package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

public class C03Class {
    ///    클래스메서드의 기본 호출 방식
    public static void main(String[] args) {
        int result = Calculator.sum(10, 20);
        System.out.println(result);

///       객체가 아닌 클래스의 메서드의 문제점  //feat 왜 객체를 써야하는가
///        고유의변수, 고유의 메서드 사용 불가
//        A부서의 매출
//        20원 매출 발생
        Calculator.sumAcc(20);
        System.out.println(Calculator.total);
//        30원 매출 발생
        Calculator.sumAcc(30);
        System.out.println(Calculator.total);
//        40원 매출 발생
//        Calculator.sumAcc(40);
//        System.out.println(Calculator.total);
//        누적매출: 90원
//        System.out.println(Calculator.total);
        System.out.println(Calculator.sumAcc(40));

//        B부서의  매출 //B부서의 고유변수가 없어서 고유의 값을 구할 수 없다
//        10원 매출: 누적10원
        System.out.println(Calculator.sumAcc(10)); //100 ->10이 되어야함
//        20원 매출: 누적30원
        System.out.println(Calculator.sumAcc(20)); //120 ->30이 되어야함
        //B를위해 클래스 변수는 하나 더 만들게 되면 '매서드'도 하나 더 만들어야된다
        //부서가 생길때 마다 변수 및 메서드추가

///     객체를 활용한 부서별 매출계산 (문제 해결)
///     객체 생성 방법: 클래스명 객체명 = new 클래스명(); //static없는 것으로 객체 생성
        CalculatorForInstance calA = new CalculatorForInstance();
        calA.sumAcc(20);
        calA.sumAcc(30);
        calA.sumAcc(40);
        System.out.println(calA.total);
        CalculatorForInstance calB = new CalculatorForInstance();
        calB.sumAcc(10);
        calB.sumAcc(20);
        System.out.println(calB.total);


///    클래스메서드 사용 예시
        System.out.println(Math.min(10, 20));
///    객체사용 예시
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
    }


}

class Calculator{ //1.클래스 문제
///     static이 붙어있으면 클래스 변수, 붙어있지 않으면 객체 변수
    static int total = 0; //클래스 변수

   public static int sum(int a, int b){
       return a+b;

    }
    public static int sumAcc(int a){
       total +=a;
       return total;

    }
}



class CalculatorForInstance{ // 2. 문제 해결
    //static이 붙어있지 않으니 객체 변수
    int total = 0; //클래스 변수
///    메서드에 static 있는 경우는 클래스 메서드
///    클래스 메서드: 일반적으로 객체의 상태와 상관없는 독립적인 로직 수행시에 사용(ex. 아래 계산 로직)
///    클래스메서드 호출 시: 클래스 명.메서드명()
    public  int sum(int a, int b){
        return a+b; //그냥 연산해서 뱉어내는 경우// 굳이 메모리에 저장안해도 되니까 객체 안해도 된다

    }
///    메서드에 static이 없는 경우는 객체 메서드
///     객체메서드 호출 시: 객체명.메서드명();
    public  int sumAcc(int a){
///     this=객체를 지칭. 일반적으로, 매개변수와 객체변수 이름을 구분짓기 위해서 사용
//      매개변수명과 같을 수 있어서 헷갈릴 수 있다
        this.total +=a;  //위의 누적된 객체 total이다
        return total;

    }
}








