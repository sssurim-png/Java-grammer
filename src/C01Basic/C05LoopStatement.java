package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class C05LoopStatement {
    public static void main(String[] args) throws IOException {

        //while문의 조건식에 변화를 주지 않으면 whhile문은 기본적으로 무한루프
        // int a =0;
        //아래 while문은 10번 반복되는 반복문
//        while(a<10){
//            System.out.println("hello world");
//            a=a+1;
//        }
//        //while문 활용하여 2~10까지 출력
//        int b = 2;
//        while(b<11){
//            b++;
//        }
//        int c =2;
//        while(true){
//            System.out.println(c);
//            c++;
//            if(c>10){
//               //break키워드를 통해 가장 가까이에 있는 반복을 즉시종료
//                break;
//            }
//        }
        //반복되는 도어락키 예제
        //만약 비밀번호를 밪추면 즉시 종료 -> 문이 열렸습니다 출력->비밀번호 5회 초과 출력


        //이볅한 숫자의 구구단 단수 출력
//        while (true){
//            Scanner sc = new Scanner(System.in);
//            int input = Integer.parseInt((sc.nextLine()));
//            int count =1;
//            while(count<10){
//                System.out.println(input+ "X"+count+ "=" +input*count);
//                count++;
        //      }
        // }
// do while문: 무조건 1번은 실행되는 while문
//        int a = 100;
////        do {
////            System.out.println("hello world");
////        }
////        while (a < 10);
////        //for문: 초기식, 조건식, 증감식이 모두 포함돼 있는 반복문
////        for (int i = 0; i < 10; i++) {
////            System.out.println("hello world");
////        }

        //1~10중에 홀수만 출력하기
//        for (int i = 1; i < 11; i++) {
//            if (i % 2 != 0) {
//                System.out.println(i);
//            }
//        }

//continue: 반복문의 증감, 조건식으로 이동하는 명령어. 즉, continue하위의 코드를 더이상 실행하지 않음.
        for (int i = 1; i < 11; i++) {
            if (i % 2 == 0) {
                //continue는 코드의 직관성과 가독성을 위해 사용 //꼭 써야하는 상황은 없을 거다
                continue; //짝수면 for문으로 올라가겠다 출력안하고
            }
            System.out.println(i);
        }



    }
}

