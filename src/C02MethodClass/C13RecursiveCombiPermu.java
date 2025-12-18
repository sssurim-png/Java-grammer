package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

///재귀함수 활용 대표적인 알고리즘 예시: 백트래킹, dfs 알고리즘에서 주로 사용.(또는 분할정복)
///대표적인 백트래킹 예시: 조합과 순열에서 경우의 수 찾기
public class C13RecursiveCombiPermu {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("hello wolrd");
            }
        }


//        위 for문의 반복횟수(개수)는 동적으로 결정되지 않고, 정적으로 코딩할수밖에 없는 한계가 존재
        recurFor(0, 3);
//        recurFor(0,4, 3);
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
///        숫자 1,2,3,4를 가지고 만들 수 있는 2개짜리 숫자조합물 출력. 이중리스트에 담아 출력
///        [[1,2] [1,3] [1,4] [2,4] [3,4]]  //특정 코드를 동적으로 받을 때 재귀가 필요하다
//        List<List<Integer>> doubleList =new ArrayList<>();
//
//        for(int i=0; i<myList.size();i++){
//            for(int j= i+1; j<myList.size();j++){
//                List<Integer>list1 =new ArrayList<>();
//                list1.add(myList.get(i));
//                list1.add(myList.get(j));
//                doubleList.add(list1);
//
//            }
//        }
//        System.out.println(doubleList);
//
//(대상이라서 그냥 보라고)        List<Integer> myList=new ArrayList<>();
// (대상이라서 그냥 보라고)       myList.add(1);
// (대상이라서 그냥 보라고)       myList.add(2);
// (대상이라서 그냥 보라고)       myList.add(3);
// (대상이라서 그냥 보라고)       myList.add(4);
///        재귀함수를 만들기 위한 for문 변형 (바깥, 안 for구조를 맞춰야한다)
///        [[1,2] [1,3] [1,4] [2,4] [3,4]]
//        List<List<Integer>> doubleList = new ArrayList<>();
//        List<Integer> list1 = new ArrayList<>();
//        for (int i = 0; i < myList.size(); i++) {
//            list1.add(myList.get(i));
//
//            for (int j = i + 1; j < myList.size(); j++) {
//                list1.add(myList.get(j));
//                List<Integer> newList = new ArrayList<>(list1); //담아야된다 계속 더해주는것을 끊어주려고
//                doubleList.add(newList);
//                list1.remove(list1.size() - 1); //j에서 합쳐지는거 출력 후 하나 빼주기 (헷갈리면 안떼보고 해보면 된다)
//
//            }
//            list1.remove(list1.size() - 1); //i번째에서도 끝자리 빼주기
////            현재 쌍방으로 add, remove한다
//
//        }
//        System.out.println(doubleList);
        /// //이제 이걸 재귀함수로 만들거다 (아래)


        List<List<Integer>>doubleList =new ArrayList<>();////////////////////////////////? combi진심 이해해보기 ㄹㅇ 재귀
        combi(new ArrayList<>(), myList,0, 2, doubleList); //원본, 2개짜리 조합, 조합을 담을

    }////////////////////////////////////////////////////////////////?
    public static void combi(List<Integer>temp,List<Integer>myList, int start, int n, List<List<Integer>>doubleList){
        if(temp.size()==n){
            doubleList.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < myList.size(); i++) { // i를 0으로 박으면 안된다
            temp.add(myList.get(i));
            combi(temp,myList,i+1, n,doubleList);
            }
            temp.remove(temp.size() - 1); //
//            현재 쌍방으로 add, remove한다

        }
/// //////수식????? boolean visitied 있는 코드 가져오기 순열!!!!!!!!!!!!!!!!!!!! 위에 조합
    public static void permu(List<Integer>temp,List<Integer>myList, int start, int n, List<List<Integer>>doubleList) {
        if (temp.size() == n) {
            doubleList.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < myList.size(); i++) { // i를 0으로 박으면 안된다
            temp.add(myList.get(i));
            permu(temp, myList, i + 1, n, doubleList);
        }
        temp.remove(temp.size() - 1); //

    }
    /// ///////////////
    ///
    /// 백준: 15649(N과 M), 6603(로또)

    public  static  void recurFor(int start, int end){
        if(start==end){
            System.out.println("hello");
            return;
        }
        for(int i=0;i<3;i++){
//            System.out.println("hello world"); //이렇게 실행하면 3^n형식이 아님. 개수 불일치
            recurFor(start+1,end);
        }




//    public  static  void recurFor(int start, int end, int a){

//        while(start<end){
//            for(int i=1; i<a;i++){
//                System.out.println("hello123123");
//            }
//            start++;
//            System.out.println("hello123123");
//
//            }
    }

}

