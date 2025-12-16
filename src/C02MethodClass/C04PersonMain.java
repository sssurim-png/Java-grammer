package C02MethodClass;

public class C04PersonMain {
    public static void main(String[] args) {
///       setter와 getter는 외부 접근이 가능하도록 일반적으로 public하게 설정
///        회원가입 예시 //원시적인 코드
//        String name1 = "hong1";
//        String email1 = "hong1@naver.com";
//        int age1 = 30;
//        printMember(name1, email1, age1);
//        String name2 = "hong1";
//        String email2 = "hong1@naver.com";
//        int age2 = 30;
//        printMember(name2, email2, age2);
///       위 코드는 요소(속성)들이 그룹화 되어있지 않다보니, 중복과 코드의 가독성이 저하
///
///       클래스에 속성을 정의하여, 사람 객체로 생성
//        C04Person p1 = new C04Person();
//        p1.name = "hong1";
//        p1.email = "hong1@naver.com";
//        p1.age = 14;
//
//        C04Person p2 = new C04Person();
//        p2.name = "hong2";
//        p2.email = "hong2@naver.com";
//        p2.age = 40;
//
//        printMember(p1);
//        printMember(p2); //위에 다 에러 private라

//        위 코드의 문제점
//       1. person객체의 변수에 외부 클래스에서 접근가능
//       2. person에 대한 출력 코드가 외부 클래스마다 중복되어 들어갈 여지
        C04Person p3 =new C04Person();
        p3.setName("heon3");
        p3.setEmail("hong3@naver.com");
        p3. setAge(30);
        System.out.println(p3.retunPersonInfo());
//        System.out.println(p3); //객체라 주소 출력



    }
//    public static void printMember(String name, String email, int age){
//        System.out.println("이름은"+name+" 이메일은" +email+" 나이는"+ age);
//    } // 원시적인 코드 프린트

    public static void printMember(C04Person person){  ///객체의 주소값이 매개변수로 전달
//        System.out.println("이름은"+person.name()+"+ 이메일은" +person.email()+" 나이는"+ person.age());
        System.out.println("이름은"+person.getName()+"+ 이메일은" +person.getEmail()+" 나이는"+ person.getAge());
    }
///    사용자정보 출력메서드(printMenber)
///    예시)이름은 xx, 이메일은 yy, 나이는zz입니다.
}

/// //////////////////// call by?????????????????
