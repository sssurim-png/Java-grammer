package C01Basic;

import java.io.*;
import java.util.*;

public class C09Array {
    public static void main(String[] args) throws IOException {
//        배열표현식1. 배열 선언 후 값 할당 방식
////        java의 배열은 반드시 사전에 길이가 결정되어야 함
////       int[]arr1 =new int[]; <--이런거 허용안됌
//        int[] arr1 = new int [5];
//        arr1[0]=10;
//        arr1[1]=20;
////      int배열의 경우 선언 시 기본적으로 0으로 초기화. boolean은 false초기화. 참조자료형은 null로 초기화.
//        arr1[3]=40;
//        arr1[4]=50;
//        //arr1[5]=60; 에러 //index out of bounds예외 발생
////        배열표현식2. 리터럴방식
//        int[]arr2 ={10,20,30,40,50};
//
////        배열표현식3. 명시적 배열 생성 방식
//        int[]arr3 = new int[]{10,20,30,40,50};
//
////        배열표현식 3. 활용예시: 배열을 다른 매서드의 매개변수로 사용할 경우.
//       // List<자료형>
//        List<int[]> myList = new ArrayList<>();
//        myList.add(new int[3]);
//        myList.add(new int[]{10,20,30,40,50});
////        myList.add({10,20,30,40,50}); //사용 불가: 배열인지 구분 불가

//        85,65,90으로 구성된 int 배열을 선언하고, 총합과 평균을 구하시오
//        int[] a =new int[] {85,65,90};
//        int sum = 0;
//        double avg =0;
//        for(int i=0; i<a.length;i++){
//            sum+=a[i];
//        }
//        avg =(double) sum/a.length;
//        System.out.println(sum);
//        System.out.println(avg);

//        배열의 최대값, 최소값
//        int[]arr = {10,20,30,12,8,17};
////        최대값을 구할 때는 가장 작은 값을 설정
//        int max=Integer.MIN_VALUE;
////        최소값을 구할때는 가장 큰 값을 설정
//        int min = Integer.MAX_VALUE;
//
////        최대값
//        for(int i=0; i<arr.length; i++){
//            if(arr[i]>max){
//                max=arr[i];
////        최소값
//            if(arr[i]<min){
//                min=arr[i];
//            }
//        }

//            배열의 자리 바꾸기
//            int [] arr ={20,10,30};
//            int temp =arr[0]; //0이 잃어버리는 값을 저장
//            arr[0] = arr[1];
//            arr[1] =  temp;

////            배열 뒤집기
//        int[] arr ={10,20,30,40,50};
//        int[] newArr = new int[arr.length];
//        int index = 0;
//        for(int i=arr.length-1; i>=0;i--){ // 이렇게도 가능
//            newArr[index] = arr[i];
//            index++;
//
//            for(int i=0; i<arr.length;i++){ //정석
//                newArr[arr.length-i-1] = arr[i]; //좀 더 보기!!!!!!!!!!!!!
//        }




////        배열의 정렬
          String test = "hello";

        String[] stArr = {"abc","aaa","acb","abb"};
        Arrays.sort(stArr); //기본: 오름차순 정렬 , 클래스 뭐..?
        System.out.println(Arrays.toString(stArr)); //출력
        Arrays.sort(stArr, Comparator.reverseOrder()); //내림찻ㄴ 정렬
        System.out.println(Arrays.toString(stArr));
        int[]arr = {17,12,20,10,15};
        Arrays.sort(arr); //오름차순 정렬
//        Arrays.sort(arr), Comparator.reverseOrder()); // "원시자료형"은 Comparator사용불가능 (char, boolean 다 불가능) //클래스라서


        //// [선택정렬 알고리즘 구현]실습 int[]arr = {17,12,20,10,15}; 을 Arrays.sort없이 정렬시켜봐라
        //// 선택정렬: min 찾는 알고리즘으로 index 0자리부터 기록하도록, 제일 작은 숫자가 있는 곳을 저장해서 index 0과 교체
        //// 구현로직: 1)2중 for문을 사용하여 index마다 최소값 찾기 2. 현재위치와 자리 change
        int[]arr1 ={17,12,20,10,15};

        for(int i=0; i<arr1.length;i++){
            int min=  arr1[i]; //Integer.MAX_VALUE; 로 할 시 본인 포함 안시키고 비교하기때문에 그러면 j에서 i+1로 하면 안된다
            int minindex =i; //왜 0은 안되고 -1이 된다고?
            for(int j =i+1; j<arr1.length;j++){
                if(arr1[j]<min){
                    min =arr1[j];
                    minindex=j;
                }
            }
            int temp = arr1[i]; //잃어버릴값 먼저 저장
            arr1[i] =arr1[minindex];
            arr1[minindex] =temp;

//            자리바꾸기: i와 index 자리 change
        }
        System.out.println(Arrays.toString(arr1));

        ////////// 2번째 방법//////////
        int[]arr2 ={17,12,20,10,15};

        for(int i=0; i<arr2.length;i++){
            for(int j =i; j<arr2.length;j++){
                if(arr2[i]>arr2[j]){
                    int temp = arr2[i]; //잃어버리는 i값
                    arr2[i] = arr2[j]; //오른쪽에서 왼쪽으로 값 change
                    arr2[j] =temp; //temp=기존의 i값으로 arr2[j] change
                }
            }


//            자리바꾸기: i와 index 자리 change
        }
        System.out.println(Arrays.toString(arr2));

//가는 길목마다 작은게 있으면 바꾼다

 //////////////// 선택정렬의 복잡도: O(n^2). java 기본 내장 정렬함수의 복잡도 : "O(n*log(n))"

////실습 조합 문제: 모두 각기 다른 숫자의 배열이 있을 때. 만들어질 수 있는 두 숫자의 조합을 출력
//        ex) (10,20),(10,30),  ... 중복 제거
        int[] arr3= {10,20,30,40,50};

        int n = 1;
        for(int i= 1; i<=arr3.length;i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + "," + arr[j]);
            }
        }


////    배열의 중복제거: set자료구조(자료X,순서X)활용
//      ex) 10,20,30,40만 남도록 "set"
        int[] arr4 = {10,30,20,30,10,40};
        Set<Integer> mySet = new HashSet<>();
        for(int a: arr4){
            mySet.add(a);
        }
        int[] answer =new int [mySet.size()]; //set은 인덱스 개념이 없다 //향상된 for문 필수//index는 따로 끌고가야한다
        int index =0;
        for(int a: mySet){
             answer[index] =a;
             index++;
        }
        Arrays.sort(answer);
        System.out.println(Arrays.toString(answer));


/// /////////프로그래머스 실습: 두 개 뽑아서 더하기 !!!!!!!!!????????????다시 풀기!!!!!!!!!!!!
        int[] numbers = {2, 1, 3, 4, 1};

        int a = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                a++;
            }
        }

        int[] num = new int[a];
        int index2 = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                num[index2] = numbers[i] + numbers[j];
                index2++;
            }
        }

        Set<Integer> mySet2 = new HashSet<>();


        for(int b: num){
            mySet2.add(b);
        }

        int[] an =new int[mySet2.size()];
        int index3=0;

        for(int b: mySet2){
            an[index3]= b;
            index3++;
        }
        Arrays.sort(an);
        System.out.println(Arrays.toString(an));






////        배열의 검색: 복잡도 O(n) ---> O(log(n))=이분탐색(이진탐색)
        int[]arr6 = {1,3,6,8,8,9,11,15};
        int target=11;
//        target이 몇번째 index에 있는지 출력
        int index1 =-1;
        for(int i=0; i<arr.length;i++) {
            if (arr6[i] == target) {
                index1 = i;
                break;
            }
        }

        System.out.println(index);

        ////이분탐색(이진검색) - binary search, 복잡도 log(n) //정렬과 다르게 직접 구현할 줄 알아야한다
        //사전에 데이터가 오름차순 정렬돼 있는 경우만, 이분탐색 가능
        int[]arr7 = {1,3,6,8,8,9,11,15}; //같은 값이 있을 경우 어떤게 먼저 나올지 모른다
        int target1=11;
        //찾고자 하는 값이 있으면 해당 index 리턴
        //찾고자 하는 값이 없으면 음수값 리턴
        int index4 = Arrays.binarySearch(arr7, target1);//복잡도의 의미가중요
        int index5 = Arrays.binarySearch(arr7, 13);//13은 없다 없으면 음수
        System.out.println(index4);
        System.out.println(index5);

        /// //실습: 백준 - 수 찾기 1920 //정렬 때 n log(n) //집합 맵이 낫긴한데 이분탑색
        //1. 그냥 풀어서 시간초과
        //2. 이분탐색 통과
        //1. 시간초과
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[]arr8 =new int[N];
        for (int i = 0; i < N; i++) {
            arr8[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr8);

        int M =Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        int[]arr9 =new int[M];
        for (int i = 0; i < M; i++) {
            arr9[i] = Integer.parseInt(input2[i]);}


        for(int i=0; i<arr9.length;i++) {
            int temp = 0;
            for (int j = 0; j < arr8.length; j++) {
                if (arr9[i] == arr8[j]) {
                    temp = 1;
                    break;
                } else {
                    temp = 0;
                }

            }
            System.out.println(temp);
        }

            //2. 이분탐색 통과


            int N1 = Integer.parseInt(br.readLine());

            String[] input3 = br.readLine().split(" ");
            int[] arr10 = new int[N];
            for (int i = 0; i < N; i++) {
                arr8[i] = Integer.parseInt(input3[i]);
            }
            Arrays.sort(arr10);

            int M1 = Integer.parseInt(br.readLine());

            String[] input4 = br.readLine().split(" ");
            int[] arr11 = new int[M];
            for (int i = 0; i < M; i++) {
                arr9[i] = Integer.parseInt(input4[i]);
            }


            for (int i = 0; i < M; i++) {
                int target2 = arr9[i];
                int index7 = Arrays.binarySearch(arr8, target2);
                if(index7>=0){ //해당 값의 인덱스를 반환하는 것이기 때문// 인덱스 반환하면 있다는 뜻이지
                    bw.write(String.valueOf("1"));
                    bw.newLine();
                }else{
                    bw.write(String.valueOf("0"));
                    bw.newLine();
                }

            }
            bw.flush();


/// ////!!!!!!!!!!!!!!!!!!!!풀기!!!!!!!!!!!


//        배열값 비교
            int[] arr12 = {10, 20, 30};
            int[] arr13 = {10, 20, 30};
            System.out.println(arr12 == arr13); //false //주소값 비교
            System.out.println(Arrays.equals(arr12, arr13)); //true

//        배열복사
//        Arrays.copyOf(배열명, length) Arrays.copyOfRange(배열명, strat, end)
            int[] arr14 = {1, 4, 6, 7, 8, 1, 2, 4, 6};
            int[] arr15 = Arrays.copyOf(arr14, 4);
            System.out.println(Arrays.toString(arr15));
            int[] arr16 = Arrays.copyOfRange(arr14, 3, 6);
            System.out.println(Arrays.toString(arr14));

////     Arrays.fill: 배열에 모든값을 변경(채우기)
//            String[] arr15 = new String[5];
//            for (int i = 0; i < arr15.length; i++) {
//                arr15[i] = "";
//            }
//            Arrays.fill(arr15, "");
//
//            //일반탐색 :O(n) ....      ///복잡도 잘 따지고 들어가야한다 접근도가 달라진다
//            //이분탐색: 정렬mlog(n)+ ...
//

//        2차원배열의 선언과 값할당
//        {{1,2},{1,2}, [1,2}}
//        방법1. 선언 후 할당 방식
            int[][] arr17 = new int[3][2];
            arr17[0][0] = 1;
            arr17[0][1] = 2;
            arr17[0][2] = 1;
            arr17[1][0] = 2;
            arr17[2][1] = 1;
            arr17[2][2] = 2;

//        방법2. 리터럴방식
            int[][] arr18 = {{1, 2}, {1, 2}, {1, 2}};

//        [3][4]사이즈의 2차원 배열을 선언하고, 1~12까지 숫자값을 각 배열에 순차적으로 할당
//        {{1,2,3,4},{5,6,7,8},{9,10,11,12}}
//            int[][] arr18 = new int[3][4];
//            int num = 1;
//            for (int i = 0; i < arr18.length; i++) {
//                for (int j = 0; j < arr18[i].length; j++) {
//                    arr18[i][j] = num;
//                    num++;
//
//                }
//
//            }
//            System.out.println(Arrays.deepToString(arr18)); //각각의 힙메모리가 들어있다
////2차원배열의 출력
//            System.out.println(arr18); //2차원 배열의 heap주소값
//            System.out.println(Arrays.toString(arr18)); //각  1차원 배열의 heap주소값
//            System.out.println(Arrays.deepToString(arr18)); //각 1차원 배열의 값을 출력 //2차원?




//        프로그래머스=행렬의 덧셈 (문제풀이)
        int[][]arr19= {{1,2},{2,3}};
        int[][]arr20= {{3,4},{5,6}};

        int[][]result= new int[arr19.length][arr19[0].length];
        for(int i =0; i< arr19.length;i++) {
            for (int j = 0; j < arr19[i].length; j++) {
                result[i][j] = arr19[i][j] +arr20[i][j];
            }
            System.out.println(Arrays.toString(result[i]));
        }
        System.out.println(Arrays.deepToString(result));
       // return result;

        /// ////k번째수 프로그래머스


        int[]array= {1,5,2,6,3,7,4};
        int[][]commands= {{2,5,3},{4,4,1},{1,7,3}};//첫자리, 끝자리, 번째수
        int[][] temp = new int[commands.length][];
        for(int i=0; i<commands.length;i++) {
//            잘라서 새로운 배열을 만든다
//            만들어진 배열을 정렬한다
//            원하는 값을 구해서 answer에 담는다 /////////////////////////////////다시


            int[] arr21 = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);//사람기준의 2번째(인덱스 기준3번째)니까 1빼주기 // end에서는 어차피 미만이다
            Arrays.sort(arr21);
            temp[i] = arr21; //i에 짤린 array 3개 들어가있음
            int k = arr21[commands[i][2] - 1];
        }
                int[] a1= new int[temp.length];
                for(int i=0; i< temp.length;i++){
                    int k1= commands[i][2]-1; // index

                    a1[i]=temp[i][k1];

                }
                System.out.println(Arrays.toString(a1));






////        가변배열: 2차원 배열에서 각 1차원의 배열의 길이가 서로 다른 배열의 구조
        int [][]arr22 ={{1,2},{1,2,3},{1,2,3,4}};

//        배열 전체길이는 반드시 사전할당되어야 하지만, 1차원 배열의 길이는 추후 할당가능
        int[][]arr23 =new int[3][];
        arr22[0] = new int[2]; //여기부터는 배열길이 설정해줘야한다
        arr22[1] = new int[3]; //이렇게 하는게 더 잘 쓰인다
        arr22[2] = new int[4];





        }







    }









//        프로그래머스=k번째수






























