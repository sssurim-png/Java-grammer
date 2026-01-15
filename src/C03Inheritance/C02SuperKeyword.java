package C03Inheritance;

//부모클래스를 상속받을때, 자식객체의 생성자에서는 부모객체를 자동으로 생성
//이때, 부모클래스에 기본생성자가 없으면 자식클래스에서 에러발생
public class C02SuperKeyword extends SuperParents{
    int a=20;
    public C02SuperKeyword(){ //기본 생성자 호출해야되는데 없어서 맞게 커스텀해서 부름
//        super(): 부모클래스의 생성자를 호출하는 메서드 (괄호 있다)
    super(10);
    this.a=20;
    }

    public static void main(String[] args) {
        C02SuperKeyword c1 =new C02SuperKeyword();
        c1.display();

    }
    public void display(){
        System.out.println("자식의 변수: " + this.a);
//        부모의 변수나 메서드에 접근할 때에는 super 키워드 사용
        System.out.println("부모의 변수: " + super.a); //자식이 변수를 덮어씌우면 자식이 먼저다
                                                     //but 그때 부모에 접근하고 싶을때
    }
}

class SuperParents{ //부모생성자 -만들면서 기본 생성자 사라짐
    int a; //이게 맞나? 클래스 만든거? 게시판 확인하기
    public SuperParents(int a){
        this.a =a;
    }
}

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
