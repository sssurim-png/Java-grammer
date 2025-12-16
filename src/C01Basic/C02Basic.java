package C01Basic;

import java.math.BigDecimal;
import java.util.StringTokenizer;

public class C02Basic {
    public static void main(String[] args) {
//        //변수의 명명규칙
//        //변수명에 의미의 분저러이 일어나는 경우에는 camelcase 또는 _ 사용
//        String myFirstName = "hongildong";
//        String my_first_name = "hongildong";
//
//        //정수: byte(1바이트),int(4바이트),long(8바이트)
//        byte a =127;
//        byte b =-128;
//
//       // 자료형이 표현할 수 있는 범위를 넘어선 경우 오버플로우/언더플로우 발생
//        //오버플로우
//        a++; //역으로 돌아가게 된다
//        System.out.println(a);
//         //언더플로우
//        b--; //역으로 돌아가게 된다
//        System.out.println(b);
//
//        long l1 =10;
//         //long은 명식적으로 L을 붙여서 해당 값이 long타입임을 명시
//        long l2 =20L;
//        System.out.println(l1+" " +l2);
//
//        //실수: double, float 부동소수점 활용 ->오차 발생한다
//        //실수: float, double
//        float f1 = 1.123f; //불합리한 문법 f붙여줘야한다
//        double d1 = 1.123;
//
//        //실수연산은 기본적으로 오차 발생: 소수점을 2진법으로 표현하는 부동 소수점을 사용하기 때문
//        double d2 = 0.1;
//        System.out.println(d2);
//        //미세한 오차는 소수점 절사를 통하여 당장에는 드러나지 않음
//
//        //부동소수점 오차 테스트
//        double total =0;
//        for(int i =0; i<1000; i++){
//            total +=0.1;
//        }
//        System.out.println(total);
//
//        //소수점 연산 오차 해결방법1 : 소수를  정수로 변환 후 추후 다시 소수로 변환 --비추
//        double total2=0;
//        for(int i =0; i<1000; i++){
//            total2 +=(0.1*10);
//    }
//        System.out.println(total/10); //쓰지는 마라

        //소수점 연산 오차 해결방법2 : BigDecimal 클래스 사용
//        double d1 = 1.03;
//        double d2 = 0.42;
//        System.out.println(d1 - d2);
//        //값을 입력받아 저장할 때부터 문자로 입력을 받아 오차문제를 해결
//        BigDecimal b1 = new BigDecimal("1.03"); //<--참조자료형 (String도 참조자료형이지만 너무 많이 써서 생략해준것)
//        BigDecimal b2 = new BigDecimal("0.42"); // <-- 돈 다뤄야되는 민감한 서비스에서만 활용. 알고리즘X
//        double result = b1.subtract(b2).doubleValue();
//        System.out.println(result);

//        String st2; // 기본적으로 null이 할당한다 =>그냥 쓰면 에러나긴한다
//        char c2; //기본적으로 null 할당
//        System.out.println(st2); // --에러
//    }

        //문자형: char-1글자(String- 1글자 이상)
//        char c1 = '가';
//        String st1 = "가";
//        //String 또는 char 배열 최초 선언 시 초기값이 null해당
//        String[] stArr = new String[10]; //0~10까지 아직 다 null// 값 안채웠다 아직
//        System.out.println(stArr[0]); //---이제 null출력

        //null은 값이 없다는 의미로서 하나의 타입 !!!!!!!!!!!!!!!!!!!!!!!"헷갈리기 쉽다"!!!!!!!!!
//        String st1 = ""; //빈문자열이 할당
//        String st2 = null; // null이 할당 st2는 더이상 String이 아님
//        System.out.println(st1.isEmpty());//true
//        System.out.println(st2.isEmpty());//에러
////
//        String[] stArr = new String[5];  //문법에는 문제 없다 //런타임 에러
//        stArr[1] = "helloworld1";
//        stArr[3] = "helloworld3";
//        for(int i=0; i<stArr.length; i++){
//            System.out.println(stArr[i].length());
//        }
//        //boolean형 : true or false
//        boolean b1 =false;
//if(b1){
//    System.out.println("참입니다");
//}else{
//    System.out.println("거짓입니다");
//}
////int 초기값0
////boolean초기값은 false
//// char, String 초기값은 null
//// =>배열 만들때 문제가 된다


        //문자비교를 위한 묵시적 형변환

        //문제)알파벳 소문자 개수 세기
        System.out.println((int)'a');

        String st1 = "01abcd123한글AB123";
        int count = 0;
        for (int i = 0; i < st1.length(); i++) {
            char ch = st1.charAt(i);
            if (ch >= 'a' && ch <= 'z'|| ch >= 'A' && ch <= 'Z') {
                count++;
            }
        }
        System.out.println(count);


        //변수와 상수
        //변수: 재할당 가능, 재선언은 불가능
        int a1 =10;
        a1 =20;
      //  int a1 =30; -->허용불가

        //상수: 값의 재할당 불가능. 정해진 값(고전된 값)을 사용시 상수 활용
        final double PI =3.14;
        //PI = 3.14 <-- 재할당 불가능


    }
}