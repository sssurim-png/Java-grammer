package C03Inheritance;

import java.util.ArrayList;
import java.util.List;

public class C06AbstractMain {
    public static void main(String[] args) {
////        추상클래스는 구현체가 없는 메서드가 있으므로, 기본적으로 객체 생성 불가능
//        AbstractAnimal a1 =new AbstractAnimal();//오른쪽이 찐또 //현재 깡통이라 불가

        AbstractDog d1 = new AbstractDog();
        d1.makeSound1();
        d1.makeSound2();

//        인터페이스는 모든 메서드가 abstract인 클래스 (List는 인터페이스=구현체가 없다)
//        인터페이스는 구현체가 없으믈, 별도의 객체 생성 불가
        List<Integer> myList =new ArrayList<>();//오늘쪽에 List넣으면 구현체가 없는 것
    }
}
///클래스에 추상메서드가 하나라도 있으면 이 클래스는 추상클래스가 되고, 클래스 앞에 abstract가 붙음.
abstract  class AbstractAnimal{ //abstract는 객체를 만들 수 없다 ->자식클래스에서 상속받아 만들어라+여기서@Override로 익명 클래스 abstact 객체는 아니다
    void  makeSound1(){
        System.out.println("동물은 소리를 냅니다");

    }
///    abstract(추상) 메서드는 메서드를  선언만하고 구현이 없는 메서드
///    해당 클래스를  상속받는 클래스에서 abstract메서드 구현
    abstract void makeSound2(); //아직 생성/구현은 안했는데 앞으로 앞는로 할거야

}
class AbstractDog extends AbstractAnimal {

    //구현되지 않은 makeSound2를 구현.
    @Override
    void makeSound2() {
        System.out.println("멍멍멍");
    } //아직 생성/구현은 안했는데 앞으로 앞는로 할거야
    }


//    final키워드를 통해 "상속 불가"한 클래스로 변경 //재정의도 등 불가
    final class FinalParents{

}