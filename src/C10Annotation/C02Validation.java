package C10Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C02Validation {
    public static void main(String[] args) throws IllegalAccessException {
        List<Member> memberList =new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("회원가입 서비스 입니다");
            System.out.println("이름을 입력해 주세요");
            String name = sc.nextLine();
            System.out.println("이메일을 입력해주세요");
            String email = sc.nextLine();
            Member member =new Member(name,email);
//            추후 스프링에서는 아래와 같은  "validate메서드 + 직접만든 어노테이션" 이 모두 합해져 있는 이미 만들어진 어노테이션을 사용
            validate(member); //만약에 입력안하면 오류내겠다 ->런타임 시점에 확인해야한다 [4]
            memberList.add(member);
        }

    }
//    특정 변수에 NotEmpty 어노테이션 설정이 있을 경우, 값이 비어있는지를 검사하는 메서드 //object
    static void  validate(Object object) throws IllegalAccessException { //[3]
//        리플렉션 기술을 통해 런타임시점에 private변수라 할지라도 객체 안의 필드값을 꺼내 확인할 수 있음
        Field[] fieldList = object.getClass().getDeclaredFields(); //선언되있는 필드를 가져가겠다. private인데 getter가 업ㅇㅅ으니 리플렉션으로 가져오겠다 //필드를 싹 다 꺼낸 것 name, email...
        for(Field f: fieldList){
            if(f.isAnnotationPresent(NotEmpty.class))
                f.setAccessible(true);
            String value = (String)f.get(object);
            if(value ==null || value.isEmpty()){
                NotEmpty nq =f.getAnnotation(NotEmpty.class); //빈 값이 있으면 에러를 던진다 ??
                throw new IllegalArgumentException("반드시 값을 입력해주세요");
            }
        }
    }
}
//이러한 어노테이션의 근간이 되는 기술 => 리플랙션 기술 사용






class Member{

    private String name;
    @NotEmpty //위에서 validate매서드를 만들어야 기능 사용(세트다) [2]
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

//어노테이션은 선언적 표시이고, 어떤기능도 수행하지 않음
//아래 NotEmpty어노테이션 클래스는 어떤 기능도 없지만, 특정 필드값이 비어있으면 안된다는 "선언적 표시"
//리플렉션은 기본적으로 런타임에 동작하므로, 어노테이션을 사용할 때에 기본적으로 런타임 동작 설정.
@Retention(RetentionPolicy.RUNTIME)
@interface NotEmpty{ //class선언하는 것이랑 같다 하면 @어노테이션 선언 가능 [1]
//    어노테이션 클래스의 속성은 일반적으로 메서드 형태로 정의
    String message() default  " this field cannot be empty!!"; // 이필드는 비어있을 수 없다 선언. but 어노테이션은 어디인지 모른다 =>변수 위에 올린다
}