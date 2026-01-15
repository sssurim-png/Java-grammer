

//1. Animal이름의 클래스 생성
//   -void sound()메서드: "동물이 소리를  냅니다" 출력
//2. Dog이름의 클래스 생성
//   -Animal클래스를 상속
//   -sound2()메서드: "멍멍멍멍" 출력
//3. Cat이름의 클래스 생성
//   -Animal 상속, sound2(): "야옹야옹"출력
//4. Animal Main
//  -Dog객체 생성 후 sound2 메서드호출
//  -Cat객체 생성 후 sound2 메서드호출

package C03Inheritance;

public class C03AnimalMain {
    public static void main(String[] args) {
        Dog d1 =new Dog();
        d1. sound2();
        Cat c1 =new Cat();
        c1.sound();
        Animal d2 =new Dog(); // ==Dog d2 =new Dog();
        d2.sound();
//        부모클래스의 타입으로 지정시, 부모클래스에서 정의된 메서드만 객체에서 사용가능
//        d2.sound2(); <--Animal시 안됌 에러
//        상속관계일때는 부모클래스의 타입을 자식클래스의 객체 타입으로 지정가능
    }
}

class Animal{


    public void sound(){
        System.out.println("동물이 소리를 냅니다");
    }

}

class Dog extends Animal{

    @Override
    public void sound(){
        System.out.println("멍멍멍");
    }

    public void sound2(){
        System.out.println("멍멍");

    }

}

class Cat extends Animal{
    public void sound2(){
        System.out.println("야옹");

    }

}
