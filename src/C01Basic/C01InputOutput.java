package C01Basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C01InputOutput {
    public static void main(String[] args) {
//        //출력: System.out을 통해 콘솔(터미널창)출력
//        System.out.println(20); //println은 줄바꿈있는 출력 2)입출력은 모두 문자열로 진행
//        System.out.print("helllo world2"); // 줄바꿈이 없는 출력
//        System.out.print("helllo world3");

    //입력1: Scanner클래스 - 입력을위한 클래스로서 바이트단위 입력처리. System.in-키보드 입력
//    Scanner 객체변수명 = new Scanner(System.in);
//    Scanner myScanner = new Scanner();
//    String input =myScanner.nextLine(); //입력받은 데이터를 한줄로 읽어서, String으로 리턴
//System.out.println("사용자 입력 사항 :" +input)
//    //바이트 단위로 쪼개서 보낸다 //ex키보드에서 컴퓨터

//    //입력2 BufferedReader : 성능 빠른 이유 1) 버퍼를 활용하여 더 좋은 성능 2)InputStreamReader는 바이ㅣ트 대신 문자단위로 입력
//    BufferedReader br = new BufferedReader(new InputStreamReader//*문자단위로 쪼개서 보낸다*/(System.in));
//    String input2 =br.readLine(); // 입력받은 데이터를 한줄씩 read
//    System.out.println("사용자 입력 사항 :" +input2);

//아래와 같이 입력값이 주어졌을 때 처리 방법
        /*
        abc
        bcd
        2
        3
         */
//Scanner myScanner=  new Scanner(System.in);
//String input1 = myScanner.nextLine();
//String input2 = myScanner.nextLine();
//int input3 = Integer.parseInt(myScanner.nextLine()); //-추천. 입력받은 문자열을 직접 형변환(추천하는 방식)
//int input4 = myScanner.nextInt();
//        System.out.println("입력사항1: "+ input1);
//        System.out.println("입력사항2: "+ input2);
//        System.out.println("입력사항3: "+ input3);
//        System.out.println("입력사항4: "+ input4);



///입력값 abc bcd efg
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input2 =br.readLine();
//        String[]arr=input2.split(" ");
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);
//       // close()는 메모리 회수
        //        br.close();ㄴ,ㄴ 메모리 회수, 외부입출려 치와 연계디ㅗㄴ 코드이므로, GC(가비지컬렉터)dml 대ㅏㅇ이 아님


//기본적으로 물리적인 기기들이 다를 때는 무조건 성능이 떨어진다(ex. 키보드->컴퓨터)
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String input = br.readLine();;
        //StringTokenize를 통해 공백을 기준으로 무나열을 하나씩 잘라서 내부에 토큰왕
      //  StringTokenizer st = new StringTokenizer(int input7);
}
}