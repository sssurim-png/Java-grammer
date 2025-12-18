package C02MethodClass;
//변수의 유효범위: 클래스 변수와 객체변수는 클래스 전역에서 사용 가능
public class C05Scope {
//        클래스변수
        static int v1 =10;
//        객체변수: 객체메서드에서만 접근 가능 //static에서 접근불가
        int v2 =20;

    public static void main(String[] args) {
//        지역변수: 지역변수는 해당 메서드내에서만 사용
        int v3=10;
        scope1(v3);
        System.out.println(v3); //10
        C04Person p1 = new C04Person();
        p1.setName(("Kim"));
        p1.setName(("Kimfd@naver.com"));
        p1.setAge((30));
        scope2(p1);
        System.out.println(p1.retunPersonInfo());
    }

    public static  void  scope1(int v3){ //(원시자료형) call by value: 값을 통한 호출. 값만을 전달
        v3=30; //원본 여기서 변경x //값을 변경 -변경시 원본에 상관x
        System.out.println(v3); //30
    }
    public static  void  scope2(C04Person person){ //클래스(객체) //call by reference: 참조의 의한 호출. 힘매모리 주소값 전달
        person.setName("lee"); //주소를 넘기면서 변수가 바뀌어 있다 // 변경 시 원본도 바뀐다
        System.out.println(person.retunPersonInfo()); //name: lee
    }//객체 메모리  자체로 설명?
}
