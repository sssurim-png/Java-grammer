package C01Basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C13QueueStackDeque {
    public static void main(String[] args) {
////        Queue인터페이스를 Linkedlist를 구현한 아래와 같은 방식으로 가장 많이 사용//
        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(10);
        myQue.add(20);
        myQue.add(30);

        //poll=Queue에서 가장 앞의 데이터를 삭제하면서, 동시에 return하는 메서드 (get+remove)
        int value = myQue.poll(); ///중요!!!!!!!!!!
        System.out.println(value); //10 //값을 하나꺼낸것
        System.out.println(myQue); //20,30
////        peek=Queue에서 데이터를 삭제하지 않고, 가장 앞의 데이터를 return하는 메서드
//         -poll과 다르게 꺼내기만 하고 삭제는 하지 않는다
        int value2 = myQue.peek(); ///중요!!!!!!!!!
        System.out.println(value2); //20
        System.out.println(myQue); //20,30


////      while문을 통한 queue출력 방식
        Queue<String> printerQueue = new LinkedList<>();
        printerQueue.add("문서1");
        printerQueue.add("문서2");
        printerQueue.add("문서3");
        printerQueue.add("문서4");
////        Qeueu는 일반적으로 while문을 통해 요소를 소모
        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
//        for(int i=0; i< printerQueue.size(),i++){
//            System.out.println(printerQueue.poll());} //직관적이지 않다 for이 들어갈때마다 size가 바뀐다

////        LinkedList와 ArrayList성능차이 비교
////        ArrayList 장점: 조회성능빠름, 단점: 중간 삽입/삭제 성능 저하
// //       LinkedList 장점 : 중간 삽입/삭제 성능 빠름,단점: 조회성능 저하
        LinkedList<Integer> myLinkedList = new LinkedList<>(); //왼쪽 Queue라고 써도 된다 왼쪽이 찐또 1.시간 성능 비교
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            myLinkedList.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("linkedlist에 중간에 값 add시에 소요시간: " + (endTime - startTime));
        //결과: linkedlist에 중간에 값 add시에 소요시간: 125 //1000000일때

        ArrayList<Integer> myArrayList = new ArrayList<>(); //if 앞에다가 100000번 넣으면 복잡도 n제곱 2. 시간 성능 비교
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            myArrayList.add(0, i);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("Arraylist에 중간에 값 add시에 소요시간: " + (endTime2 - startTime2));
        //결과: Arraylist에 중간에 값 add시에 소요시간: 65080  <-수 커질수록 확연히 차이 //1000000일때

////        관련문제: 카드2, 요세푸스 문제 //숙제!!  -자료구조도 list를 쓸건지 Queue를 쓸건지 구별해봐라 //번호가 밀리면 Queue가 유리(앞에꺼 빼네? 성능떨어지네?)
//         Queue를 구현하는 구현체: Linkedlist, offer (길이제한 Queue),heap자료구조...?


///         길이제한 Queue
        Queue<String> blockingQueue = new ArrayBlockingQueue<>(3); //3개로 제한
//        blockingQueue.add("문서1");
//        blockingQueue.add("문서2");
//        blockingQueue.add("문서3");
//        blockingQueue.add("문서4"); //길이 초과시 에러 발생
        blockingQueue.offer("문서1");
        blockingQueue.offer("문서2");
        blockingQueue.offer("문서3");
        blockingQueue.offer("문서4"); //제한된 길이까지만 add. 에러발생X
        System.out.println(blockingQueue);

///     poll,peak,offer

///     우선순위 큐: 데이터를 poll할때 정렬된 데이터 결과값(최소값/최대값) 보장
///     지속적으로 데이터가 추가/제거 되면서 전체데이터가 "실시간으로 변경"되는 상황에 사용
//             그냥 정렬할거면 list 담고 sort하면 된다, but 실시간 사용 시 복잡도 확올라감
        Queue<Integer> pq = new PriorityQueue<>();//()에 기준 값 없으면 최소값부터
        pq.add(30);
        pq.add(20);
        pq.add(10);
        pq.add(40);
        pq.add(50);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());                //순서대로 정렬
//            poll할때마다 최소값을 추출하게 되고, 복잡도 log(n). peek =최소값을 확인만하고 추출은X 복잡도(log n)
//            전체 데이터를 모두 poll하면 복잡도 n*log(n)
        }                                                //list=그냥 있는 그대로


///      백준: 최소 힙 (문제!!)
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        int[] n = new int[N];
//
//        Queue<Integer> pq = new PriorityQueue<>();
//
//        for (int i = 0; i < N; i++) {
//            n[i] = Integer.parseInt(br.readLine());
//            if (n[i]== 0) {
//                if (pq.isEmpty()) {
//                    bw.write("0");
//                    bw.newLine();
//                } else {
//                    bw.write(String.valueOf(pq.poll()));
//                    bw.newLine();
//                }
//            }else {
//                pq.offer(n[i]);
//            }
//
//
//        }
//        bw.flush();
//    }
//
//}

///     프로그래머스: 더 맵게
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        Queue<Integer> pq1 = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq1.offer(scoville[i]);
        }
        int count = 0;
        while (pq1.peek() < K && pq1.size() >= 2) {
            int a = pq1.poll(); //중간중간 add가 들어갈때 poll쓰는게 낫다 // 한번에 poll당길바에는 list쓰는게 낫다 복잡도 log(n)
            int b = pq1.poll();
            int sum = a + b * 2;
            pq1.offer(sum);
            count++;
        }

        if (pq1.peek() < K) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
//       백준:최대힙
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
//
//        int N = Integer.parseInt(br.readLine());
//        int[] n = new int[N];
//
//        Queue<Integer> qp = new PriorityQueue<>(Comparator.reverseOrder());
//
//        for (int i = 0; i < N; i++) {
//            n[i] = Integer.parseInt(br.readLine());
//            if (n[i] == 0) {
//                if (qp.isEmpty()) {
//                    bw.write("0");
//                    bw.newLine();
//                } else {
//                    bw.write(String.valueOf(qp.poll()));
//                    bw.newLine();
//                }
//
//            } else {
//                qp.offer(n[i]);
//
//            }//poll//peek//offer
//
//        }
//        bw.flush();


    //0이면 최대값순으로 출력
    //0일때 출력할게 없으면 0출력
    //0이 아니면 offer




//        백준: 카드 정렬하기

///  최대힙: poll할때마다 "최대값"을 추출
        Queue<Integer>pq2 =new PriorityQueue<>(Comparator.reverseOrder());

//   stack: 후입선출의 자료구조
        Stack<Integer>myStack = new Stack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println(myStack.pop()); //마지막에 입력한 값을 꺼내는 것
        System.out.println(myStack.peek()); //마지막에 입력한 값을 확인만
        System.out.println(myStack.size());
        System.out.println(myStack.isEmpty());

//      프로그래머스:올바른 괄호
//      프로그래머스: 같은 숫자는 싫어


//        deque: addFirst, addLast, pollFirst,pollLast,peekFirst, pekLast
        Deque<Integer>myDeque = new ArrayDeque<>();
        myDeque.addLast(10);
        myDeque.addLast(20);
        myDeque.addFirst(30); //30 10 20
        System.out.println(myDeque.pollLast()); //20
        System.out.println(myDeque.pollFirst()); //30
        System.out.println(myDeque.pollFirst()); //40



    }
}
