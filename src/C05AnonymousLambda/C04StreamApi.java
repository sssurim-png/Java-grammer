package C05AnonymousLambda;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C04StreamApi {
    public static void main(String[] args) {
        int[]arr = {20,10,4,12};
//        전통적인 방식의 데이터 접근방법: 메모리 주소접근
        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]);//데이터와 객체 방식

        }
///        함수형 프로그래밍 방식: 데이터와 객체 중심이 아닌, 입력에 따른 출력(연산작업포함)만 존재하는 코딩 스타일 -트렌드
///        streamApi: java에서 함수형프로그래밍을 지원하는 라이브러리
///        foreach= 스트림의각 요소를 하나씨기 소모하면서 동작을 수행
//        (해당 사상을 가지고 만든 프로그래밍) //원본이 아닌 사본에서 프로그래밍 //원본에 직접적으로 접근하는 것은 위험하다는 생각

        Arrays.stream(arr).forEach(a-> System.out.println(a));
        //stream까지가 사본//arr을 straem(클래스)으로 감싸서 .하고 여러개 쓸 수 있다

///        스트림의 생성: .stream()
        List<String> myList = new ArrayList<>();
        myList.add("java");
        myList.add("python");
        myList.add("c++");
        Stream<String> stream1 = myList.stream();
        String[]myArr = {"java","python","c++"};
        Stream<String> stream2 =Arrays.stream(myArr); //사본작업을 할 수 있는 stream객체를 만드는중

//        원시자료형을 위한 stream객체가 별도로 존재 //보통 int stream인데 원시자료형은 그 형태에 맞게 다른게 있다
        int[]  intAr ={10,20,30,40,50};
        IntStream stream3 =Arrays.stream(intAr);


///        stream의 중개연산(변환): filter, map, sorted, distinct, mapToInt -읽을줄 알아라
///        fiter: 특정기준으로 대상을 필터링하여 새로운 스트림을 반환하는 중개연산
///        sum: 스트림의 요소를 하나씩 소모하여 총합을 구하는 메서드
        int[] intArr = {10,10,30,40,50};
        int total = Arrays.stream(intArr).filter(a->a>=30).sum(); //복잡도 n //복잡도는 같다 보기 편할 뿐//성능은 같거나 조금 떨어진다
        System.out.println(total+"!!!");
///        map: 기존의 스트림을 조작하여 새로운 스트림을 반환
        int total2 =Arrays.stream(intArr).map(a->a*a).sum();
        System.out.println(total2);
///        distinct: 중복제거
        int total3 =Arrays.stream(intArr).distinct().sum();
        System.out.println(total3);
///        sorted: 정렬 (배열로 리턴해야할 때 = toArray() 해줘야한다)
        int[]sortedArr =Arrays.stream(intArr).sorted(/*Comparator.reverseOrder()-integer이었으면 들어올 수 있었다*/).toArray();
        System.out.println(Arrays.toString(sortedArr));
///        mapToInt: intStream형태로 변환해주는 map
        String[]stArr = {"java","python","c++"};
        int totalLength = Arrays.stream(stArr).mapToInt(a->a.length()).sum(); //int 때 쓸 수 있는것 들을 내장하고 있다
//        Arrays.stream(stArr).mapToInt(a->a.length()) 이렇게까지가 intstream // String=>int




        int[] arr2 = {1,2,3,4,5,6};
//        실습1) arr에서 홀수만 담은 배열을 생성 후 배열 출력  //필터
        int[] result = Arrays.stream(arr2).filter(a->a%2==1).toArray();

//        실습2) arr에서 홀수만 걸러서 해당 홀수의 제곱값을 담은 배열을 출력 //필텉, 맵
        int[] result2 = Arrays.stream(arr2).filter(a->a%2==1).map(a->a*a).toArray();

//        실습3) arr에서 홀수만 걸러 제곱값을 구하고, 해당 숫자값을 오름차순한 순서로 배열을 출력
        int[] result3 = Arrays.stream(arr2).filter(a->a%2==1).map(a->a*a).sorted().toArray();

        //      중개연산만 . 으로 연결 가능하다




/////        stream의 소모: foreach(출력), sum(합계),count, max, min, reduce(누적연산), findFirst(스트림의 첫번째값 리턴)
        int[] intArr2 = {10,20,30,40};
        Arrays.stream(intArr2).forEach(a-> System.out.println(a));//.찍고 갈 수 없다// steam까지만 되는건데 이미 다 꺼내서 소모한거라 이제 stream이 아니다
        int total4 =Arrays.stream(intArr2).sum();
        long count =Arrays.stream(intArr2).count(); //기본으로 count =long으로 받게 설계되어있다
        System.out.println(count+"qwer");

///        optional객체: 값이 있을수도 있고, 없을수도 있음을 명시한 객체
        int max = Arrays.stream(intArr2).max().getAsInt();//orElse ... //getAsInt =값이 확실히 있어 걍 내놔 - 약간 위험할수도
        int mini = Arrays.stream(intArr2).min().getAsInt();

///        reduce: 누적연산 -> reduce(초기값, 연산식) //실전에서 종종
        int[] intArr3 ={10,20,30,40};
        int accSum =Arrays.stream(intArr3).reduce(0,(a,b)->a+b); //이전까지는 매개가 1개만 나왔는데 이번에 2
        System.out.println(accSum);
        int accMultiply =Arrays.stream(intArr3).reduce(1,(a,b)->a*b); //이전까지는 매개가 1개만 나왔는데 이번에 2
        System.out.println(accMultiply);
        String[] stArr2 = {"java","python", "c++"};
        String result4 =Arrays.stream(stArr2).reduce("",(a,b)-> a+b); //스트링 빌더가 더 빠르다
        System.out.println(result4);

///        findFirst: 첫번째요소 반환
        String firstValue = Arrays.stream(stArr2).filter(a->a.length()>5).findFirst().get(); //5글자 이상
        System.out.println(firstValue);
        Map<String,Integer> myMap =new TreeMap<>();
        myMap.put("hello",10);
        myMap.put("java",10);
        String firstKeyValue = myMap.keySet().stream().findFirst().get(); //int가 아니니까 getis??안ㅇ한다
        System.out.println(firstKeyValue);


///        배열로 변환시 주의사항: 제네릭의 타입소거-> 자바의 런타임 시점에 <String> 과 같은 제네릭의 타입이 제거되는 현상 //모든 객체가 다 그렇다 원시자료형 빼고 (배열때랑 다르게 반대로 문제가 된다)
///        제네릭의 타입소거로 인해, toArray를 통해 새로운 String배열을 곧바로 만들어내는 것은 불가 // -그당 안중요
        String[] stArr3 ={"hello","java","world"};
        String[]answer = Arrays.stream(stArr3).filter(a->a.length()>=5).toArray(a->new String[a]); //a안에는 배열의 길이가 담김 //중간에 타입 사라짐 1.버전???
//        int[] intArr5 ={10,20};
//        int[] answer2 =Arrays.stream(intArr5).filter(a->a>=10).toArray(); //얘는 되는데 왜 위는 안되냐

///        메소드 참조:형식-하나의 메소드만을 호출하는 경우에 매개변수를 제거한 형식
///        형식-"클래스명::메서드명", 조건-하나의 메서드(실행문)만을 호출하는 경우
        Arrays.stream(stArr3).forEach(a-> System.out.println(a));
        Arrays.stream(stArr3).forEach(System.out::println); //System.out.// <-클래스 //println(); 굳이
        String[]answer2 = Arrays.stream(stArr3).filter(a->a.length()>=5).toArray(String[]::new); //new= 메서드, String =클래스 2.버전


        List<Student> myList2 = new ArrayList<>();
        myList2.add( new Student("kim",20));
        myList2.add( new Student("choi",30));
        myList2.add( new Student("lee",25));
        myList2.add( new Student("park",23));
//        1)모든 객체의 평균나이(average함수)
        double aver= myList2.stream().mapToInt(Student::getAge).average().getAsDouble();

//        2)정렬을 통한 가장 나이 어린 사람 찾기(sorted +findFirst)
        Student s1 = myList2.stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        }).findFirst().get(); //있을 수도 있고 없을 수도 있는데 get()있다

//        3)30대인 사람들만의 이름만 모아서 새로운 String 배열에 담기(map활용)
        String[]arr3= myList2.stream().filter(a->a.getAge()>=30).map(a->a.getName()).toArray(a-> new String[a]); ///뭐가 사라져????????????//다시 해보기!!!!!!!!



///        Optional객체: 특정객체에 값이 없을지도(null) 모른다는 것을 명시적으로 표현한 객체 -중요
//        스프링에서, 실제 사용자가 있을 때 많이 필요
        String st1 = null;
        if(st1==null){
            System.out.println("값이 없습니다");
        }else{
            System.out.println(st1.length());
        } //분기 처리하는 이유 -> 사용자가 있을 때는 뭐가 올지 모른다
        Optional<String> opt1=Optional.ofNullable(null); //String을 Optional이라고 하는 ㄴ함수로 감싼것. 값이 없을 수 있으니
        if(opt1.isPresent()){
            System.out.println(opt1.get().length());
        }else{
            System.out.println("값이 없습니다");
        } //"알고리즘"x, "spring" OOOOO



//        Optional객체 생성 방법 3가지.
        Optional<Stream> opt2 =Optional.empty(); //비어있는 optional객체 생성 (없을 때 get하면 error)
        Optional<String> opt3_1 = Optional.ofNullable(null); //비어있는 Optional객체 생성 (없을 때 get하면 error)
        Optional<String> opt3_2 = Optional.ofNullable("hello"); //값이 있는 optional 객체 생성 (있을 때 get하면 ok)
        Optional<String> opt4 = Optional.of("hello"); //값이 있는optional 객체 생성


///     Optional 객체 처리방법 4가지 -Optional =중요
///        방법1. isPresent()로 확인후에 get()
        if(opt4.isPresent()){
            System.out.println(opt4.get());
        }else{
            System.out.println(opt1.get()); //에러 -stop
            System.out.println("값이 없습니다");

        }

///        방법2. orElse(): 값이 있으면 있는 값 return, 없으면 지정한 값 return
        System.out.println(opt3_1.orElse("값이 없습니다"));
        System.out.println(opt3_2.orElse("값이 없습니다"));

///        방법3. orElseGet(): 값이 있으면 있는 값 return, 없으면 람다함수 실행
        System.out.println(opt3_1.orElseGet(()->new String("값이 없습니다")));

///        방법4.
//        - 가장많이 사용, 값이 있으면 있는 값 return, 없으면 지정한 예외(에러) 강제발생
//        왜 에러를 터뜨려야되나: 웹개발에서 값을 입력하는 사용자에게 적절한 메시지 전달 목적과 의도된 코드 중단을 목표로 강제로 예외(에러)를 방생시키는 경우는 매우 일반적
///        System.out.println(opt3_1.orElseThrow(()->new RuntimeException(" 값이 없습니다."))); // 값이 없을 때 이와 같이 에러를 터뜨림 //에러를 적극적으로 활용 //에러나서 주석처리
///        System.out.println(opt3_1.get()); //에러발생,의도치 않는 에러발생. (지양해야 할 에러)

///        optional객체 처리 실습1)
        List<Student> list =new ArrayList<>();
        list.add(new Student("홍길동", 17));
        list.add(new Student("홍길동2", 13));
        list.add(new Student("홍길동3", 11));
        list.add(new Student("홍길동4", 27));
///        optional객체 처리방법1.
        OptionalDouble optionalAvg = list.stream().mapToInt(a->a.getAge()).average();
        double value1 =0;
        if(optionalAvg.isPresent()){
            value1=optionalAvg.getAsDouble();
            System.out.println(value1);
        }else{
            System.out.println("값이 없습니다");
        }
///        optional객체 처리방법2 -더 많이 쓰는 방법
        double value2 = list.stream().mapToInt(a->a.getAge()).average().orElseThrow(()->new NoSuchElementException());
        System.out.println(value2);


//        optional객체 처리 실습2) //중요 DB에 붙인댄다
        List<Student> list2 =new ArrayList<>();
        list2.add(new Student("홍길동", 17));
        list2.add(new Student("홍길동2", 13));
        list2.add(new Student("홍길동3", 11));
        list2.add(new Student("홍길동4", 27));
        System.out.println("조회하고자 하는 student의 index번호를 입력해주세요");
        Scanner sc = new Scanner(System.in);
        int number=Integer.parseInt(sc.nextLine());
        Optional<Student>s2; //감싸기
        if(list2.size()<=number||number<0){
            s2=Optional.empty();

        }else{
            s2 =Optional.of(list2.get(number));
        }
        System.out.println(s2.orElseThrow(()->new NoSuchElementException("없는 회원입니다")));




    }
}
