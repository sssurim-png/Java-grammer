package C01Basic;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class C12set {
    public static void main(String[] args) { //단일 자료형
//        set의 특성: 중복X,순서보장X, 성능 O(1) //복잡도
//        데이터가 너무 많으면 메모리 터질수는 있긴하다 //거의 안터지긴 함
        Set<String>mySet = new HashSet<>();  //value 없이 contain만 있다
        mySet.add("야구");
        mySet.add("농구");
        mySet.add("야구");
        mySet.add("축구");
        System.out.println(mySet);
        System.out.println(mySet.contains("야구")); //O(1)의 복잡도

//        수찾기 (1920) -> 다시 풀어보기 set은 복잡도 n으로 끝낼거가 // list= n^2 // 이분 n log(n)
//

//        TreeSet: 데이터를 오름차순 정렬
        Set<String>mySet2 = new TreeSet<>();  //value 없이 contain만 있다
        mySet2.add("야구");
        mySet2.add("농구");
        mySet2.add("야구");
        mySet2.add("축구");
        System.out.println(mySet2);


//        백준: 숫자카드(10815),
//        프로그래머스: 폰켓몬(종류 구하는 문제/ 중복제거)
        int[] nums = {3,3,3,2,2,4};

        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        int half =nums.length/2;

        if(half<=set.size()){
            System.out.println(half);
        }else{
            System.out.println(set.size());
        }



//        집합관련함수: 교집합(retailAll), 합집합(addAll), 차집합(removeAll)
        Set<String> s1 =new HashSet<>();
        s1.add("java");
        s1.add("python");
        s1.add("c++");
        Set<String> s2 =  new HashSet<>();
        s2.add("java");
        s2.add("html");
        s2.add("css");
        s1.retainAll(s2); //s1에는 교집합인 java만 남음
        System.out.println(s1);
        s1.addAll(s2); //s1에는 합집합인 java, python,c++,html,css가 남음 ////???????????
        System.out.println(s1);
        s1.removeAll(s2); //s1에는 차집합인 python, c++이 남은/////?????????
        System.out.println(s1);
    }
}
