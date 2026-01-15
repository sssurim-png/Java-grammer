package C05AnonymousLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C03_2Student {
    public static void main(String[] args) {

        List<Student> list =new ArrayList<>();
        list.add(new Student("홍길동", 17));
        list.add(new Student("홍길동2", 13));
        list.add(new Student("홍길동3", 11));
        list.add(new Student("홍길동4", 27)); //얘네는 그냥 정렬해줘 X => 자바가 예측한 것이 아니니까

///        방법1. Comparator를 구현한 익명객체 방식
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName()); //여기서 람다 // 나이로 할 땐 -, String= -안된다 compareTo로 해야됌
            }
        });

///        방법2. Comparable을 구현한 방식 //but유연하게 사용하기 어렵다 바꿀때 마다 아래 다시 정의 (객체 다시 선언???? 그건 못들었다)
///        Student 객체 안에 Comparable을 implements하는 방식
///        sort실행 시 자동으로 Student안의 compareTo메서드 호출
        Collections.sort(list); //기준을 밑에서 구현해놨다 //호출한 것


    }
}
class Student implements Comparable<Student> { //Comparable은 impements로 활용
    //class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    ///Comparable의 compareTo에서는 this와 매개변수로 주어지는 객체와 비교
//    this가 앞에 있으면 오름차순, 매개변수객체가 앞에 있으면 내림차순
    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}

//    @Override //무조건 구현하라고 빨간불 든다 //위에꺼랑 같은데 그냥 설명 추가
//    public int compareTo(Student o) { //Comparator  =매개변수 2개, Comparable =매개변수 1개 -this와 매개변수와 비교
//        return this.getName().compareTo(o); //여기 compareTo랑 위 compareTo와 다르다
//    }
//}
