package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.runtime.ObjectMethods;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class C04Json {
    public static void main(String[] args) throws IOException {
///        외부의 json파일을 java의 클래스(객체)변환: json파싱(역직렬화)
        Path filePath = Paths.get("src/C07ExceptionFileParsing/myjson1.json");
//       1. readString: 문자열 전체를 통째로 read
        String st1 = Files.readString(filePath); //abstract로 잘라야되는거
        System.out.println(st1);

//        ObjectMapper 라이브러리(spring에는 기본적을 탑재.java에서는 별도로 추가)를 통한 객체로 파싱xxx??
//        JackSon라이브러리(spring에는 기본적으로 탑재. java에서는 별도로 추가)의 ObjectMapper클래스를 통한 객체로의 파싱
        ObjectMapper o1 =new ObjectMapper();
///       2. Map으로 -지양 -객체 만드는법1
        Map<String,String> myMap =o1.readValue(st1, Map.class);
        System.out.println(myMap);
        System.out.println(myMap.get("name"));

//        {//textㅍ jason파일
//            "id": 1,
//                "name" : "hong1",
//                "classNumber" : "1",
//                "city" : "seoul"
//        }//자열이다


///      3.  내가 직접만든 객체로 파싱 -객체만드는법2 json1
        Student myStudent =o1.readValue(st1,Student.class);
        System.out.println(myStudent+"123333333333");
        System.out.println(myStudent.getId());
        System.out.println(myStudent.getName());

/////      4.  List형식으로 주어지는 json파싱: 트리구조의 JsonNode로 변환 json2
//        Path filePath1 = Paths.get("");
//        String st2 =Files.readString(filePath);
//        ObjectMapper o2 =new ObjectMapper();
//        JsonNode JsonNode1 =o2.readTree(st1);
//
//        List<Student> studentList = new ArrayList<>();
//        for(JsonNode j: JsonNode1){
//            Student s1 =o1.readValue(j.toString(), Student.class);
//            studentList.add(s1);
//        }
//        System.out.println(studentList);
//
/// //////////////////??????????



///  json직렬화: 객체 -> json
        Student s1 = new Student(1L,"h1","1","seoul");
        String result = o1.writeValueAsString(s1);
        System.out.println(s1+"123");
        System.out.println(result+"1321");
    }
}












///실제 값의 setting은 private 변수이므로 직접접근 불가
///java의 reflection 기술을 통해 런타임 시점에 private 변수도 직접 접근 가능 -private인데도 접근할 수 있게
///다만, 필드값을 유추할 수 있도록 (getter 메서드+기본생성자)를 생성해야함
class  Student{
    private  Long id;
    private String name;
    private String  classNumber;
    private String city;

    public Student(Long id, String name, String classNumber, String city) {
        this.id = id;
        this.name = name;
        this.classNumber = classNumber;
        this.city = city;
    }
    public Student(){

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", city='" + city + '\'' +
                '}';
    }


}
