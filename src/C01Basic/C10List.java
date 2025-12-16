package C01Basic;

import java.util.*;

public class C10List {
    public static void main(String[] args) {
//        List선언방법1 (객체선언방법
//        클래스명 변수명 = new 클래스명();
//        List -인터페이스
//        1)ArrayList:클래스
//        1)LinkList:클래스

//        List선언방법1
        ArrayList<String> myList1 = new ArrayList<String>(); //String자료타입들을 추가할거다
        ArrayList<String> myList2 = new ArrayList<>(); //String 뒤에는 안써도 된다

//        List선언방법2: 가장 일반적인 방법
        List<String> myList3 = new ArrayList<>(); //ArrayList,LinkedList(카테고리)는 List에 포함되는 내용 //인터페이스는 실체 없는 껍데기(카테고리)// List는 선언만 된 껍데기다
        myList3.add("hello"); //객체는 본인만의 고유한 메모리를 가지고 있다

//        초기값 세팅방법. 개별 data add //배열처럼 길이 선언안하고, 쭉 그냥 집어 넣을 수 있다
        myList3.add("java");
        myList3.add("sdf");
        myList3.add("asf");

//        초기값 세팅방법2 배열을 리스트로 변환
        String[] arr = {"java", "python", "C++"};
        List<String> myList4 = new ArrayList<>(Arrays.asList(arr));
        System.out.println(myList4);

//        List의 출력
//        List등의 컬렉션프레임워크 안에는 toString메서드가 구현되어있고, 자동호출
        System.out.println(myList4);


//        List의 안의 자료타입으로는 기본형타입은 쓸 수 없음
        int[] intArr = {10, 20, 30};
        List<Integer> myList5 = new ArrayList<>();//Arrays.asList(arr) int에 못쓴다
        for (int i : intArr) { //이건 오토박싱 되는것
            myList5.add(i);
        }

//        add: 리스트에 값을하나씩 추가하는 매서드
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(0, 30); //List는 중간위치에 데이터를 삽입/삭제하는 작업은 비효율적
        //잘 쓰지마라 인덱스 전체 밀린다
        System.out.println(myList); //출력이 아니라 toString으로 보기 좋게 나열한 것


//        get(index): 특정 index의 요소 반환
        System.out.println(myList.get(2));

//        size():리스트의 개수(길이)를 반환

//        리스트의 값 출력 방법1. 일반 for문
        for (int i = 0; i < myList.size(); i++) {  //length X
            System.out.println(myList.get(i));
        }

//        리스트의 값 출력방법2. 일반 for문
        for (int a : myList) {
            System.out.println(a);
        }


//        remove: 값 삭제
        List<Integer> myList6 = new ArrayList<>();
        myList6.add(10);
        myList6.add(20);
        myList6.add(30);
        myList6.remove(0); //앞에꺼 빼면 복잡도 놓아진다 다 땡겨야된다
        myList6.remove(myList6.size() - 1); //끝에꺼 지우기
//      값에 의한 삭제: 중복제거 못한다, 성능 떨어짐 복잡도 높아진다


//        indexOf: 특정값을 찾아 index return (가장 먼저 나오는 값
        List<Integer> myList7 = new ArrayList<>();
        myList6.add(10);
        myList6.add(20);
        myList6.add(30);
        myList6.add(30);
        System.out.println(myList.indexOf(30)); //보통 2가 나온다 //for 돌려도 상관없다

//        contains: 값이 있는지 없는지 여부를 리턴 //복잡도n
        System.out.println(myList7.contains(20));

//        n의 배수 고르기
        int n = 3;
        int[] numlist = new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12};

        for (int i = 1; i < numlist.length; i++) {
            if (numlist[i] % n == 0) {
                System.out.print(numlist[i]+" ");//그냥 보여줌 //list없이 배열 담으려면 수 세는 for, 값 찾는 for둘 다 사용
            }
        }
//        프로그래머스: n의 배수 고르기 //list 버전
        List<Integer> list = new ArrayList<>(); //
        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] % n == 0) {
                list.add(numlist[i]); //값을 list에 하나씩 저장
            }
        }
//        System.out.println(list); //여기서 바로 출력해도 됌

        int[] answer = new int[list.size()];//

                for(int i=0; i<list.size();i++) { //배열에 담아서 보여줌
                    answer[i] = list.get(i);
                }

        System.out.println(Arrays.toString(answer));




//        정렬: 방법 2가지(Collections클래스의 sort메서드 사용, 객체의 sort메서드 사용)
            List<Integer> myList8 = new ArrayList<>();
            myList8.add(5);
            myList8.add(3);
            myList8.add(2);
            myList8.add(1);
            myList8.add(4);

//      1번째:클래스명.매서드
            Collections.sort(myList8); //오름차순 //클래스명.매서드
            Collections.sort(myList8, Comparator.reverseOrder()); //내림차순

//      2번째:변수명.매서드
            myList8.sort(Comparator.naturalOrder()); //오름차순  //둘 다 복잡도 n log(n)
            myList8.sort(Comparator.reverseOrder()); //내림차순 //해당 변수명.메서드=최근 매서드

        //        Comparable = 기본 규칙----------tocompare,,?,,,뭐,,,???
        //        Comparator = 바꿔 쓰는 규칙------ 세개 무슨 차이?
        //        Collections.sort = 정렬 버튼----




//        이중리스트: 리스트안의 리스트
//        [[1,2,3],[4,5,6]]
            List<List<Integer>> myList9 = new ArrayList<>(); //숫자 Integer를 가져온다는게 아니라 list를 가져온다는 것
            List<Integer> m1 = new ArrayList<>(); //메모리 주소만 있는 것//myList9에 0번째에 m1이 있는 것     //1.아예 선언하고 m1을 add하거나

            myList9.add(m1);  //   [[]]   값이 아닌 메모리 주소값을 넣기 때문에 값을 먼저 넣던 나중에 넣던 상관없다
            myList9.add(new ArrayList<>()); //[[][]]m2인것                                              //2.add자체를 list로 하거나
            m1.add(1);//myList9.get(0).add(1);
            m1.add(2); //myList9.get(0).add(2);
            m1.add(3); //myList9.get(0).add(3); // [[1,2,3][]]
            myList9.get(1).add(4);
            myList9.get(1).add(5);
            myList9.get(1).add(6);
            System.out.println(myList9);


//      이중 리스트 실습 [[1,2,3],[4,5,6],[7,8,9],...,[58,59,60]] 해당형태의 이중리스트 생성

            List<List<Integer>> myList10 = new ArrayList<>(); //빈 리스트 채우기
            for (int i = 0; i < 20; i++) {
                myList10.add(new ArrayList<>()); //위의 m1이랑 다르게 배열 선언
            }
            int num = 1;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 3; j++) {
                    myList10.get(i).add(num);
                    num++;
                }
            }
            System.out.println(myList10);


//        int num1=1;  ///2번째 방법 채우면서 간다
//        for(int i =0; i<20;i++){
//            myList10.add(new ArrayList<>())
//            for(int j =0; j<3;j++){
//                myList10.get(i).add(num1);
//                num1++;
//            }
//        }
//        System.out.println(myList10);

//       int num2=1;  ///3번째 방법 m3에 직접할당?
//        for(int i =0; i<20;i++){
//            List<Integer> m3= new ArrayList<>();
//             myList.add(m3);
//            for(int j =0; j<3;j++){
//                m3.add(num);
//                num1++;
//            }
//        }
//        System.out.println(myList10);

////        리스트 안의 배열
//        [{10,22},{1,2,3},{4,3,2,1}]
            List<int[]> myList11 = new ArrayList<>(); //배열도 객체다
            int[] arr2 = new int[2];
            arr2[0] = 10;
            arr2[1] = 20;
            myList11.add(arr2); //위의 값을 나중에 설정해도 된다 //값 할당하기 전에 먼저 선언해도 된다는 소리

            myList11.add(new int[3]);
            myList11.get(1)[0] = 1; //아싸리 찾아가서 할당
            myList11.get(1)[1] = 2;
            myList11.get(1)[2] = 3;

            myList11.add(new int[]{4, 3, 2, 1}); //더해주면서 리??형 배열 선언?으로 더해주기?

//      System.out.println(myList11); //배열 주소값이 출력 [x1배열주소, x2배열주소,x3배열의주소] 배열은 toString이 자동 호출이 안된다 //밖의 List는 toString되어있는 것
            for (int i = 0; i < myList11.size(); i++) {
                System.out.print(Arrays.toString(myList11.get(i)));
            }

        }
        }
