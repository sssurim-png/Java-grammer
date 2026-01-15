package C10Annotation;

import java.lang.reflect.Field;

public class C01Reflextion {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
///        리플렉션: 자바에서 런타임시점에 클래스, 변수,메서드에 접근할 수 있다 -코드가 실행되는 와중에 private에 접근할 수 있다 <-이것만 알아도된다  //흐름만 이해해라
//        클래스 정보를 런타임 시점에 얻을 수 있다, 호출, 필드 접근 수정, 객체 생성 가능
        Person p1 =new Person();
///        아래와 같은 방식을 통해 private변수인 name변수에 직접 접근
      Field nameFile = Person.class.getDeclaredField("name") ; //개발자가 아는것처럼 String으로 설정하면 안된다
      nameFile.setAccessible(true); //private이라 할지라도 접근가능하도록 세팅변경 가능
        nameFile.set(p1,"hongildong");
        System.out.println(p1);
    }
}
class  Person{
    private  String name;
    private  int age;

    @Override //@으로 시작하는 것이 어노테이션 =런타임시점에 동작
    public String toString () {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}