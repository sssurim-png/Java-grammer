package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

//재귀함수 긱본 호출 원리와 과정

public class C11RecursiveBasicFlow {
    public static void main(String[] args) {
        recur0(0, 3);
        recur1(0, 3);
        recur2(new ArrayList<>
                (),0, 3);
    }

    //기본자료형 변수의 재귀함수내 변화과정(매개변수로 넘기는 시점에 값 변경)
    public static void recur0(int count, int target) { //매개변수로 횟수 조작
        if (count == target) {
            return;
        }
        System.out.println("재귀 호출 전 count: " + count); ///0(첫번째)->1(두번째) ->2(세번째)
        recur0(count + 1, target); //함수라기 보다는 형식을 말함 //본인 함수 불러옴//반복문이 아니라서 break X ->return
        System.out.println("재귀 호출 후 count:" + count); ///2(네번째) -> 1(다섯번째) ->0(여섯번째)

    }


    //기본자료형 변수의 재귀함수내 변화과정(함수내에서 변경)
    public static void recur1(int count, int target) { //매개변수로 횟수 조작
        if (count == target) {
            return;
        }
        System.out.println("재귀 호출 전 count: " + count); //0(첫번째)->1(두번째) ->2(세번째)
        count += 1;
        recur1(count, target);

//        System.out.println("재귀 호출 후 count:" + count); //3(네번째) -> 2(다섯번째) ->1(여섯번째)


    }

//  객체를 매개변수로 활용한 재귀함수내 변화과정: 객체는 힙메모리를 통해 원본객체가 변경되므로, 재귀함수간에도 값의 변화를 공유.
    public static void recur2(List<Integer> myList, int count, int target) {
        if (myList.size()== target) { //size에 원하는 개수만큼 차면 (count와 비슷)
            return;
        }

        myList.add(count);
        recur2(myList, count + 1, target); ////f3에서 [0,1,2]출력 2.f2에서 [0,1,2]출력 3. f1에서 [0,1,2]
        System.out.println(myList); //실시간으로 객체..//그냥 값에 추가되는거랑 다르다
        myList.remove(myList.size()-1);

    }
}
//끝나는 로직이 꼭있어야 한다- 보통 맨 앞