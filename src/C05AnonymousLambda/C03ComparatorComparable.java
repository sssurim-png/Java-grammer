package C05AnonymousLambda;

import java.util.*;

public class C03ComparatorComparable {
    public static void main(String[] args) {
//        java에서는 비교를 위한 인터페이스 대표적으로 2개 제공
//        1. Comparator 인터페이스: 인터페이스 내 compareTo 메서드만 존재
//        2. Comparable인터페이스: 인터페이스 내 compare메서드만 존재

        List<Integer> myList = new ArrayList<>();
        myList.add(20);
        myList.add(10);
        myList.add(30);
//        java의 대부분의 정렬함수는 매개변수로 Comparator객체 요구
        myList.sort(Comparator.naturalOrder()); //정해진 정렬
//        o1과 o2의 숫자값을 마이너스 형식으로 코딩을 하되, o1이 먼저 있으면 오름차순. o2가 먼저 있으면 내림차순
//        o1이 먼저 있으면 오름차순, o2가 먼저 있으면 내림차순
        myList.sort(new Comparator<Integer>() { //직접 커스텀 //두 개의 매개변수만 존재-수백개를 해도 두개씩 비교
            @Override
            public int compare(Integer o1, Integer o2) { //정렬은 두개 있으면 충분
                return o1 - o2;
            }
        });

        List<String> myList2 = new ArrayList<>();
        myList2.add("java");
        myList2.add("python");
        myList2.add("c++");

//         기본적이 문자열 정렬일 때에슨 Comparator 커스텀을 하지 않고,
//        복잡한 자신만의 정렬기준을 가지고 정렬해야 할때 Comparator익명객체 생성 (new 붙이고 자료형 넣어서)
//            ex)문자열의  길이로 정렬하되, 문자열의 길이가 같은 경우에는 알파벳순으로 정렬
        Collections.sort(myList2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }


            }
        });
        System.out.println(myList2);

//        백준: 단어정렬 숙제

//        배열, 리스트 정렬외에 java의 그외 정렬자료구조
//        Queue<String>pa =new PriorityQueue<>((o1,o2)->o1.length()-(o2).length());

        Set<String> treeSet = new TreeSet<>((o1, o2) -> o1.length() - (o2).length());


//comparator로 최대값 힙 풀어봐라 잘풀린다
//최대값 힙 아니고 절대값 힘이다
//백준: 선긋기

//리스트 안의 배열 정렬 //실습
//[{4,5},{1,2},{5,0},{3,1}]

//리스트안의 배열에 1번째 index를 기준으로 오름차순 정렬
//1.List선언 후 배열 넣기;
//2.Comparator

        int[][] asd= {{4,5},{1,2},{5,0},{3,1}};

        List<int[]> list = new ArrayList<>();

        list.add(new int[] {4,5});
        list.add(new int[] {1,2});
        list.add(new int[] {5,0});
        list.add(new int[] {3,1});

//        리스트 안의 배열에 1번째 index를 기준으로 오름차순 정렬
        list.sort(new Comparator<int[]>() { //아싸리 그냥 Comparator는 못쓴다
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
                for(int[]a: list){
                    System.out.println(Arrays.toString(a));


            }


        }}

//      직접 만든 객체 정렬
//      1.Student 정의 name, age 변수 //생성자 //getter// toString
//      2.Srudent 객체 List에 4개쯤 담기




    /////////// 문제 풀이에 있다
//    import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//    public class StudentPractice {
//        public static void main(String[] args) {
//
//            List<Student>list =new ArrayList<>();
//            list.add(new Student("홍길동", 17));
//            list.add(new Student("홍길동2", 13));
//            list.add(new Student("홍길동3", 11));
//            list.add(new Student("홍길동4", 27)); //얘네는 그냥 정렬해줘 X => 자바가 예측한 것이 아니니까
//
/////        방법1. Comparator를 구현한 익명객체 방식
//            list.sort(new Comparator<Student>() {
//                @Override
//                public int compare(Student o1, Student o2) {
//                    return o1.getName().compareTo(o2.getName()); //여기서 람다 // 나이로 할 땐 -, String= -안된다 compareTo로 해야됌
//                }
//            });
//
/////        방법2. Comparable을 구현한 방식 //but유연하게 사용하기 어렵다 바꿀때 마다 아래 다시 정의 (객체 다시 선언???? 그건 못들었다)
/////        Student 객체 안에 Comparable을 implements하는 방식
/////        sort실행 시 자동으로 Student안의 compareTo메서드 호출
//            Collections.sort(list); //기준을 밑에서 구현해놨다 //호출한 것
//
//
//        }
//    }
//    class Student implements Comparable<Student> { //Comparable은 impements로 활용
//        //class Student{
//        private String name;
//        private int age;
//
//        public Student(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        @Override
//        public String toString() {
//            return "Student{" +
//                    "name='" + name + '\'' +
//                    ", age=" + age +
//                    '}';
//        }
//
//        ///Comparable의 compareTo에서는 this와 매개변수로 주어지는 객체와 비교
////    this가 앞에 있으면 오름차순, 매개변수객체가 앞에 있으면 내림차순
//        @Override
//        public int compareTo(Student o) {
//            return this.getName().compareTo(o.getName());
//        }
//    }
//
////    @Override //무조건 구현하라고 빨간불 든다 //위에꺼랑 같은데 그냥 설명 추가
////    public int compareTo(Student o) { //Comparator  =매개변수 2개, Comparable =매개변수 1개 -this와 매개변수와 비교
////        return this.getName().compareTo(o); //여기 compareTo랑 위 compareTo와 다르다
////    }
////}
//
//
//
//
//
//
//
//}











