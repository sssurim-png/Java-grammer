package C01Basic;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class C08String {
    public static void main(String[] args) throws IOException {
//        String 선언방법 2가지
////        객체선언방식
//        String st1 = new String("hello world");
//        String st2 = new String("hello world");
////        리터럴방식: String pool을 사용하는 방식(java에서 추천) //최적화에 도움
//        String st3 ="hello world";
//        String st4 ="hello world";
//        System.out.println(st1==st2); //false
//        System.out.println(st3==st4); //true //String pool 개념이 녹아있다
//        System.out.println(st1==st3); //false //별개의 힙메모리
//
////        참조자료형의 비교는 ==을 지양
//        System.out.println(st1.equals(st3)); //true //힙메모리가서 값을 가져와서 값끼리 비교

//        /* ************ String 주요 매서드 ************ */
//        //📍 .equals() : 힙 메모리의 문자열을 가져와서 equal 관계 비교
//        String st_1 = "hello1";
//        String st_2 = "Hello1";
//        System.out.println(st_1.equals(st_2)); // false
//        System.out.println(st_1.equalsIgnoreCase(st_2)); // true
//
//        //📍 .length() : 문자열의 길이 출력
//        String st__1 = "hello1 world1 java1";
//        System.out.println(st__1.length()); // 19
//
//        //📍 .charAt(n) : 특정 index의 문자(char)값을 리턴
//        char ch1 = st__1.charAt(7);
//        System.out.println(ch1); // w
//
//        //📍 .toCharArray() : String 문자열을 char배열로 변환(향상된for문 활용 용이)
//        char[] charArr = st__1.toCharArray();
//        System.out.println(charArr);
//
//        //📍 .indexOf(문자열) : 특정 문자열의 위치(index) 반환. 가장 먼저 나오는 문자열의 위치 반환.
//        String st___1 = "hello java java";
//        System.out.println(st___1.indexOf("java")); // 6
//
//        //📍 .lastIndexOf(문자열) : 특정 문자열의 위치(index) 반환. 가장 나중에 나오는 문자열의 위치 반환.
//        System.out.println(st___1.lastIndexOf("java")); // 11
//
//        //📍 .contains(문자열) : 특정 문자열이 포함되어 있는지 확인
//        System.out.println(st___1.contains("java")); // true
//        System.out.println(st___1.contains("javascript")); // false
//
//        // 위 매서드들은 복잡도가 o(n)의 검색 속도를 가짐, 성능이 그다지 좋지는 않음
//
//        //📍 += : 문자열 더하기. 성능 측면에서는 추후 배울 StringBuffer, StringBuilder 사용
//        String st____1 = "hello";
//        st____1 += " world";
//        st____1 += '1'; // String에 char를 더하면 String으로 자동 변환
//        st____1 += 0; // String에 int를 더하면 String으로 자동 변환
//        System.out.println(st____1);
//
//        // 여러 번 println()을 호출하는 것보다 문자열을 합쳐 한 번에 출력하는 방식이 더 효율적이다.
//        // 이때 단순히 String을 +=로 이어붙이는 것보다 StringBuilder나 StringBuffer를 사용하는 편이 훨씬 빠르다.
//        //
//        // 이유:
//        // println()은 콘솔이라는 I/O(입출력 장치)와의 통신을 거쳐야 하므로 상대적으로 느리다.
//        // 반면, StringBuilder나 StringBuffer는 메모리 상에서 문자열을 임시로 모아둔 뒤
//        // 한 번에 출력(=버퍼링)하기 때문에 불필요한 I/O 호출이 줄어든다.
//        //
//        // 참고:
//        // 1. println() 여러 번 호출 → I/O 연산이 반복되어 느림
//        // 2. String += 결합 → 객체가 매번 새로 생성되어 비효율적
//        // 3. StringBuilder / StringBuffer / BufferedWriter 등 사용 → 메모리 내에서 처리 후 한 번에 출력 → 가장 효율적
//        //
//        // 참고로 StringBuilder가 일반적으로 가장 빠르지만, 상황과 코드 스타일에 따라 선택하면 된다.
//
//
//        //📍 .substring(a,b) : a 이상 b 미만의 index의 문자를 잘라 문자열로 반환
//        String st_____1 = "hello world";
//        System.out.println(st_____1.substring(0, 5)); // hello
//        System.out.println(st_____1.substring(6, st_____1.length())); // world
//
//        //📍 .trim(), .strip() : 문자열 양쪽 끝의 공백 제거
//        String st______1 = " hello world   ";
//        String st__2 = st______1.trim();
//        String st__3 = st______1.strip();
//        System.out.println(st__2); // hello world(양끝 공백 X)
//        System.out.println(st__3); // hello world(양끝 공백 X)
//
//        //📍 .toUpperCase(), .toLowerCase(): 모든 문자열을 대문자/소문자로 변환 (원본값을 변경하는건 아님, 불변객체 <-> 스택, 큐는 원본값을 변동, 가변객체)
//        String st_______1 = "Hello";
//        System.out.println(st_______1.toUpperCase()); // HELLO
//        System.out.println(st_______1.toLowerCase()); // hello
//
//        //📍 .replace
//        //
//        // (a,b) : a문자열을 b문자열로 대체
//        String st________1 = "hello world world";
//        String st___2 = st________1.replace("world", "java");
//        System.out.println(st___2);
//
//        //📍 .replaceAll(a,b) : replace와 사용법 동일, 정규표현식을 사용할 수 있는 점이 다름
//        // 정규표현식에 사용되는 메타문자 (^는 시작, $는 끝을 알림)
//        // 1. 한글 : "[가-힣]"
//        // 2. 소문자 영어 : "[a-z]"
//        // 3. 대문자 영어 : "[A-Z]"
//        // 4. 알파벳 : "[A-Za-z]"
//        // 5. 공백 : "\\s+"
//        String st_________1 = "01abC123  한글123";
//        String st____2 = st_________1.replaceAll("[가-힣]", "");
//        System.out.println("한글 제거 : "+st____2); // 01abC123  123
//        String st____3 = st_________1.replaceAll("[a-z]", "");
//        System.out.println("소문자 알파벳 제거 : "+st____3); // 01C123  한글123
//        String st____4 = st_________1.replaceAll("[A-Z]", "");
//        System.out.println("대문자 알파벳 제거 : "+st____4); // 01ab123  한글123
//        String st____5 = st_________1.replaceAll("[A-Za-z]", "");
//        System.out.println("알파벳 제거 : "+st____5); // 01123  한글123
//        String st____6 = st_________1.replaceAll("\\s+", "");
//        System.out.println("공백 제거 : "+st____6); // 01abC123한글123
//
////        split: 특정문자를 기준으로 잘라서 문자배열로 만드는 것.
//        String a= "a:b:c:d";
//        String[]arr =a.split(":");
//
//        String b = "a b c  d";
//        String[]arr2 =b.split(" ");
//        String[]arr3 =b.split("\\s+"); //정규표현식
//        System.out.println(arr2.length);
//        System.out.println(arr3.length);

//        null과 공백의 차이
//        String st1 =null; //null은 문자열 아님
//        String st2 = ""; //빈문자열은 문자열
//        String st3 = " "; //공백
//        System.out.println(st1==st2); //false
//        //System.out.println(st1.isEmpty());//nullpointer exception
//        System.out.println(st2.isEmpty()); //true
//        System.out.println(st3.isEmpty()); //false (공백인거다)
//        System.out.println(st3.isBlank()); //true
//
////        공백의 개수 세기
//        String abc = "hello    world   java";
//        for(int i=0; i<abc.length();i++){
//            if(abc.substring(i, i+1).isBlank()){ //미만 ///////!!!!!!!!다시 보기!!!!!!!
//                total++;
//        }
//    }
//        System.out.println(total);  //=>사용자 입력 검증할 때 쓰인다

//        문자열 조립: StringBuffer, StringBuilder
//        String[]arr = {"java","python","javascript"};
//        String result = "";
//        StringBuffer sb = new StringBuffer();
//        for(int i=0; i<arr.length; i++){
//            sb.append(arr[i]);
//            sb.append("\n"); // \n은 줄바꿈을 의미
//        }/////////////////??????????여기부터 필기 문제
//        sb.insert(0, "C++"-1); //문자열 중간에 insert하는 것은 성능저하를 발생
//        sb, deletcharAt(sb.length())
//        sb.deleteCharAt(0); //마지막 index를 삭제하는 것 오에는 성능저하 발생
//        result = sb.toString();
//        System.out.println(result);
//
//
//        //StringBuildr는 성증이 뛰어나지마, 동시성 문제 있음
//        StrinBuilder sb2 =new StringBuffer();
//
////        StringBilder은 성능이 뛰어나지만, 동시성 문제가 있음(Tnread=Safe하지 않음)
//        예를 들어)쓰레스A가ㅏ append("hello"쓰레드B가 append("world")
//                이  두작업이 중간에 섞여 "heworlllo"이런식으로 잘못된 값을 만들 수 있음
//                StringBuilder sb2 = new StringBuilder();


//        StringBuilder sb2 =new StringBuilder();
////문자열 뒤집기
//String st1 = "hello";
//String st2 ="";
//for(int i= st1.length()-1; i>=0; i--){
//    sb2.append(st1.charAt(i)); ///////////!!!!!!!!!!!!!append알기!!!!!!!!!!
//
//}
//        StringBuilder sb3 = new StringBuilder(st1);
//sb3.reverse();
//        System.out.println(sb3);

        String A = "werw"; ///////////////////ㅈ 돼따 문자열 밀기
        String B = "wwer";
//            String s = "";
//            StringBuilder sb = new StringBuilder(A);
//            for(int i=0; i<A.length();i++){
//                sb.insert(0,끝자리값 구해서 넣기);
//                sb.deleteCharAt(sb.length()-1);
//                count++;
//                if(sb의 B같으면) /// ////성능 떨어짐
//            }

//        A+A => hellohello =>성능은 빠른데 잘 못쓴다
//        A를 StringBuilder로 변환
        //A에 마지막 값을 앞으로 insert,마지막 값 제거
        //A와 B를 비교



        //문자열비교
        String st1 = "hello";
        String st2 = "dello";
        String st3 = "hello";
        String st4 = "hfllo";

        System.out.println(st1. compareTo((st2))); //양
        System.out.println(st2. compareTo((st1))); //음
        System.out.println(st1. compareTo((st3))); //0
        System.out.println(st4. compareTo((st3))); //양
/// //////////////////////////////////////??????????

}}











