package C05AnonymousLambda;


///익명내부클래스
public class C02AnonymousClass {
    public static void main(String[] args) {
///        AbstractAnimal을 상속한 클래스가 별도로 존재하지 않고,
///       내부에서 익명클래스가 만들어짐과 동시에 익명 객체가 생성
///       추상클래스는 반드시 상속을 전제로 설계된 클래스임.
///       즉, 직접 객체로 만들 목적이 아닌 “공통된 기본 틀”을 제공하기 위한 클래스인 것.
        AbstractAnimal aa = new AbstractAnimal() {
            @Override
            void makeSound() {
                System.out.println("멍멍");
            }
        };
        aa.makeSound();
        aa.eat();


///        구현체가 없는 추상클래스 또는 인터페이스는 익명객체로 생성
        Animal1 a1 = new Animal1() { //익명 클래스를 만들어주며 익명 객체를 만듦// a1은 Animal꺼가 아니라 new Animal1의 구현체  //???// 익명클래스내부
            @Override
            public void makeSound() {

            }

            @Override
            public void eat() { //"상속"받으면 무조건 안에 있느 것들은 다 구현하게 제한


            }

        }; //객체로 처리되서



///        인터페이스의 익명객체에 구현해야할 메서드가 1개밖에 없을때에는 람다표현식(화살표함수)사용가능
        Animal2 a2 = () -> {
            System.out.println("hello world1");
            System.out.println("hello world2");
        };
        a2.makeSound();

///        실행문이 1줄밖에 없을때에는 {} 생략가능
        Animal2 a2_2 = () -> System.out.println("hello world1");
        a2_2.makeSound();

//      매개변수가 있는 익명객체의 람다함수 생성
        Animal3 a3_1 = (a, b, c) -> a + "," + b + "," + c;  //리턴 생략
        System.out.println(a3_1.makeSound("java", "python", "dfs"));

        //Overriding으로 깔아놓고 자동으로람다로 바꿔도 좋다 //실습
        Animal4 a4 = (a, b, c) -> {
            if (c >= 10) {
                return a + b;
            } else {
                return a;
            }
        };
        System.out.println(a4.makeSound("abc", "bcd,", 20));
    }
}

    abstract class AbstractAnimal { //객체로 못만든다 - 구현체가 없다 ->자식이 상속해서 구현 or 위에서 오버라이드
        abstract void makeSound();

        void eat() {
            System.out.println("동물이 먹이를   먹습니다");
        }
    }

    interface Animal1 { //원래 객체 못만듦

        void makeSound();

        void eat();

    }

    interface Animal2 {
        void makeSound();
    }

    interface Animal3 {
        String makeSound(String a, String b, String c);
    }

//Animal4 인터페이스 생성 및 makeSound메서드 선언: 매개변수는 String, String, int 리턴타입은 String
//익명객체 생성 시 매서드의 기능: 매개변수의 숫자값이 10이상이면 a+b를 리턴. 10미만이면 a만 리턴


    interface Animal4 {
        String makeSound(String a, String b, int c);
    }














