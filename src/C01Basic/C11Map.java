package C01Basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class C11Map {
    public static void main(String[] args) {

//        HashMap =무작위
//        map: key,value로 이루어진 자료구조, 인덱스 개념X
        Map<String,Integer> sports = new HashMap<>();
//        특징: 키는 중복이 없다, value는 중복이 가능. (덮어씌워짐)
        sports.put("농구",2);
        sports.put("축구",3);
        sports.put("배구",2); //put많이 쓰임, {농구=2, 배구=2, 축구=3}로 뜬다
        sports.put("농구",3); // 덮어쓰여진다.
//        특징: map의 key에는 순서가 없다 //해시테이블을 사용하기 때문

        System.out.println(sports);
//      특징: map에서 key값을 통한 검색 복잡도는 0(1). 매우 빠름. n이 아니다
        System.out.println(sports.get("배구"));//get 키를 통해 value값 빼옴

//        map의 전체 value데이터 출력
//        map의 key값 접근시에는 인덱스 사용 불가능(순서가 없어서) // ex. for(int i=0; i<sports.size...안됌
//        keySet():map의 전체 key목록을 반환하는 메서드
        //set도 인덱스 없다 =>향상된 for문만 가능
        //1번째 //복잡도 n
        for(String a: sports.keySet()){ //key값을 통해 value를 구하겠다
            System.out.println("key:"+a+"value : "+sports.get(a)); //순서는 모름 //get(a)가 값
        }//2번째 (1번째와 같다)
        Set<String> mySet =sports.keySet(); //set도 인덱스 없다 =>향상된 for문만 가능
        for(String a: mySet) { //key값을 통해 value를 구하겠다
            System.out.println("key:" + a + "value : " + sports.get(a)); //순서는 모름
        }


//      value(): map의 전체 value목록을 반환하는 메서드 (잘 안쓰임) //값만 덜렁 나오면 어따씀 어디 키랑 연결되있는지 모르는데
            for(int b :sports.values()){
                System.out.println(b);
            }

            Map<String, Integer>sports2 = new HashMap<>();
            sports2.put("축구",2);
            sports2.put("배구",3);
            sports2.put("농구",2);

//            remove: key를 통해 map요소 삭제
        sports2.remove("축구");
        System.out.println(sports2);

//        putIfAbsent: key값이 없는 경우에만 put     //비어있을 때만 put
        sports2.putIfAbsent("배구",10);
        System.out.println(sports2);

//        containsKey: 키가 있으면 true, 없으면 false  //키 있는지 없는지 확인
        System.out.println(sports2.containsKey("배구"));
        System.out.println(sports2.containsKey("탁구"));


//        map을 통한 개수 count
        String[]arr={"농구","축구","농구","야구","축구"}; //농구:2,야구:1,축구:2 -개수 한정하지 말고 넣어라
        Map<String,Integer> myMap = new HashMap<>();

//        담으려고 하는 key가 있으면 기존것+1
//        key가 없으면 (key,1)로 세팅
        for(String i: arr) { //i=key
            if (myMap.containsKey(i)) { //있는지 없는지 확인
                myMap.put(i, myMap.get(i) + 1); // 있으면 값에 +1
            } else {
                myMap.put(i, 1); //없으면 값 그대로 인데 1인 이유는 key가 없으면 넘어올 일이 없기 때문 //처음 아예 0일때 없으면 1로 설정을 해주는 것! 1.번째 방법
            }

            System.out.println(myMap);

//        getOrDefault(키값,초기값): key값이 있으면 있는 값 리턴, 없을 경우 초기값 리턴. (에러가 아니라)위에서는 값 확인 안해서 없느면 에러 터뜨렸다 2.번째 방법
            myMap.put(i, myMap.getOrDefault(i, 0) + 1);
        }
        System.out.println(myMap);



//      map의 value값 감소 로직
        String[]arr2 = {"농구","농구","농구","야구","축구"};
//        축구: 1만 남도록 key값 자체를 삭제해사(==0 XX)
        Map<String,Integer> myMap2 = new HashMap<>();

        for(String b: arr2){
            if(myMap2.containsKey(b)) {
                if (myMap2.get(b) == 1) {
                    myMap2.remove(b);
                } else {
                    myMap2.put(b, myMap2.get(b) - 1);
                }
            }
        }
        System.out.println(myMap2);



//      프로그래머스실습: 완주하지 못한 선수 //전형적인 문제 - 더 풀어보기
//      의상!!!!!!!!!!!!!!!!!!!!과제!!!!!!!!!!!!!!!!!!!!!!!!!
        String[][] clothes={{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        Map<String,Integer> myCloth= new HashMap<>(); //String,String언제 쓰는지 알기!!!!!!!!!!!!!!!!!!!물어보기!!!!!!!

        for(String[] a: clothes){
            String type = a[1]; //옷 종류 // 배열 a에 대한 1번 인덱스
            if(myCloth.containsKey(type)){
                myCloth.put(type,myCloth.get(type)+1);
            }else{
                myCloth.put(type,1);
            }
        }
        int result =1;
        for(int i : myCloth.values()){
            result=result*(i+1);
        }
        System.out.println(result-1);





//        가장 value가 큰 key값 찾기
        Map<String,Integer>myMap3 =new HashMap<>();
        myMap.put("축구",3);
        myMap.put("농구",2);
        myMap.put("야구",1);

        int max =Integer.MIN_VALUE;
        String maxKey ="";
        for(String a: myMap3.keySet()){ //value로는 key못찾는다
            int value =myMap3.get(a); //값
            if(max <value){
                max = value; //값 갱신
                maxKey =a; //key가 해당값일 때 조회된 key값으로 갱신
            }
        }
//        백준실습:베스트셀러
//        max value구한다(for문)
//        해당 max value를 갖는 key를 구한다. 모두 list에 더한다 (for문)
//        list를 정렬한다. 0번째 값 출력
//        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        String[]arr =new String[N];
//
//        for(int i=0; i<N; i++){
//            arr[i] = br.readLine();
//        }
//        Map<String,Integer> myMap =new HashMap<>();
//
//        for(String a: arr){
//            if(myMap.containsKey(a)){
//                myMap.put(a,myMap.get(a)+1);
//            }else{
//                myMap.put(a,1); //키 : 값 설정
//            }
//        }
//
//        int max2 = Integer.MIN_VALUE;
//        for(String b: myMap.keySet()){
//            int v = myMap.get(b);
//            if(v>max2){
//                max2=v; //값을 제일 큰걸 찾음 값만
//            }
//        }
//        List<String> list =new ArrayList<>(); //중복인게 몇개인지 모른다
//        for(String c : myMap.keySet()){
//            int value=myMap.get(c);
//            if(max2==value){ //제일 큰 값과 같은 myMap의 값의 키워드 있다면
//                list.add(c); // 키워드를 나열해라
//            } //value값으로 key값 찾아간거
//        }
//        list.sort(Comparator.naturalOrder());
//        System.out.println(list.get(0));//사전의 첫번째꺼

//        황건하님
//        import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//
//        public class Main {
//            public static void main(String[] args) throws IOException {
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//                int N = Integer.parseInt(br.readLine());
//                Map<String, Integer> books = new HashMap<>();
//
//                for(int i=0; i<N; i++){
//                    String str = br.readLine();
//                    books.put(str, books.getOrDefault(str, 0) +1);
//                }
//
//                int max = Integer.MIN_VALUE;
//                String bestSeller = "";
//                for(String book : books.keySet()){
//                    int count = books.get(book);
//                    if(count > max) {
//                        max = count;
//                        bestSeller = book;
//                    } else if(count == max){
//                        // book이 bestSeller보다 먼저오면
//                        if(bestSeller.compareTo(book)>0){
//                        bestSeller = book; /////////여기 좀더 물어보고 정렬 c로 시작하는거 3개 물어보기!!!!!!!!
//                    }
//                }
//                System.out.println(bestSeller);
//
//            }
//        }






////        TreeMap: key를 정렬(오름차순)하여 map을 저장
        Map<String, Integer> myMap4 = new TreeMap<>(); //오름차순
        Map<String, Integer> myMap5 = new TreeMap<>(Comparator.reverseOrder()); //key값 기준 내림차순     // a=<b
        myMap.put("hello",1);
        myMap.put("hello2",2);
        myMap.put("hello3",3);
        myMap.put("hello4",4);
        myMap.put("hello5",5);
        //집합과 맵, 해시를 사용한 집합과 맵 실버 후반대
        //트리맵: 백준 파일 정리


//더하고 빼는 것 다시 해보기////////////////////////!!!!!!!!!!!!!!!!!!!값 입력 및 remove


        //LinkedHashMap: 데이터의 삽입순서 보장(입력시간순 정렬)       /////LikedHashset = 같은데 key값만
        Map<String,Integer>myMap6= new LinkedHashMap<>();
        myMap6.put("hello",1);
        myMap6.put("hello2",2);
        myMap6.put("hello3",3);
        myMap6.put("hello4",4);
        myMap6.put("hello5",5);
        for(String a: myMap6.keySet()){
            System.out.println(a+" "+myMap6.get(a));
        }

        //iterator를 활용한 출력 //하나씩 값을 소모하면서 순서대로 출력 (while이나 for로 빼기)
        Map<String,Integer>myMap7 = new HashMap<>(); //여전히 Hash이기 때문에 순서X
        myMap7.put("야구",2);
        myMap7.put("축구",3);
        myMap7.put("농구",2);
        Iterator<String> iters = myMap7.keySet().iterator();
        //next메서드는 데이터를  하나씩 소모시키면서 값을 반환
        System.out.println(iters.next());
        //hasNext메서드느 iterator안에 그 다음값이 있는지 없는지 boolean리턴
        System.out.println(iters.hasNext());
        //System.out.println(iters); // 주소값//toString안되어 있다
        while(iters.hasNext()){
            System.out.println(iters.next()); //값이 있는 동안, 값을 소진하며 출력해라 // 있는 값을 다 꺼내는 것
        } //keySet을 만들어 소모한거지 myMap을 소모한 것이 아님 => myMap에는 그대로 값이 남아있다










}}

