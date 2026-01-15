package C06EtcClass;

public class C03EnumMain {
    public static void main(String[] args) {

///        classGrade를 일반문자열로 설계했을 경우 -> 데이터 종류에 대한 통제 불가
//        Student s1 =new Student("h1","FIRST_GRADE");
//        Student s2 =new Student("h2","first_grade");
//        Student s3 =new Student("h3","1학년");

///        static final 변수로 설계했을 경우 -final해도 여전히 통제 불가
//        Student s1 =new Student("h1",ClassGrade.c1);
//        Student s2 =new Student("h2",ClassGrade.c2);
//        Student s3 =new Student("h3","1학년");

        ///        classGrade를 Enum클래스로 설계했을 경우 -지정하지 않은 값 들어오지 못한다
        Student s1 = new Student("h1", ClassGrade2.FIRST_GRADE); //문자열 처럼 나오고 문자열처럼 취급되지만 "enum"
        Student s2 = new Student("h2", ClassGrade2.SECOND_GRADE);
        Student s3 = new Student("h3", ClassGrade2.THIRD_GRADE);
        System.out.println(s1);


    }
}




class ClassGrade{
    static final  String c1 = "FIRST_GRADE"; //재할당 안된다 -> 해결 안된다
    static final String c2 = "SECOND_GRADE";
    static final String c3 = "THIRD_GRADE";
}


///         enum클래스는 데이터의 종류를 하나의 enum명 아래 묶는 것
enum ClassGrade2{
    ///            enum의 변수값은 static final 변수처럼처럼 사용된다

    FIRST_GRADE,SECOND_GRADE,THIRD_GRADE
}



class Student{
    private String name;
    private ClassGrade2 classGrade2;
//    private String classGrade; //학년 : FIRST_GRADE, SECOND_GRADE, THIRD_GRADE만 있다고 가정.  /

    public Student(String name, ClassGrade2 classGrade2) {
        this.name = name;
        this.classGrade2 = classGrade2;
    }
    //    public Student(String name, String classGrade) {
//        this.name = name;
//        this.classGrade = classGrade;
//    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classGrade='" + classGrade2 + '\'' +
                '}';
    }
}