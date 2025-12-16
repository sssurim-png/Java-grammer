package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class C06LoopStatementAdvance {
    public static void main(String[] args) throws IOException {

//// 1~20까지 수 중에 짝수의 총합 출력
//        int total =0;
//        for(int i =1; i<21; i++){
//            if(i%2==0){
//                total+=i;
//            }
//        }
//        System.out.println(total);

//최대공약수 구하기(내공식)
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int a =Integer.parseInt(br.readLine());
//        int b =Integer.parseInt(br.readLine());
//
//        for(int i= 1; i<Math.min(a,b);i++){
//            if (a % i == 0 && b % i == 0){
//                System.out.println(i);
//            }
//공약수 (강사님 공식)
//        int a =24;
//        int b = 36;
//        int min = a>b?b:a; //Math.min(a,b);
//        int answer = 0;
//        for(int i=1; i<min+1; i++){
//            if (a % i == 0 && b % i == 0){
//                answer=i;
//            }

//        }????????????????????????????????????????????????????????????????????
//        for(int i = min; i>=0; i--){
//        if (a % i == 0 && b % i == 0) {
//            answer = i;
//            break;
//        }
//    }
//            System.out.println(answer);
//        }

//        소수인지 여부 판별. 소수란 1과 자신을 제외한 숫자로 나누어지지 않는 1보다 큰 수. 잘못된거
//        int num =11;
//        for(int i=2; i<num; i++){????????????????????????????잘못적음
//            if(num%i==0){
//                System.out.println();
// ///커져서 에러날 수 있다. log? 루트 씌워서 10까지만 돌리자/????????????????????여기 잘못 적음

//        int[] arr = {1, 3, 5, 7};
//        //일반 for문을 통한 배열 접근 방식
////        for(int i=0; i<arr.length;i++){
////            System.out.println(arr[i]);
////        }
//        //향상된(enhanced for문,for each문)을 통한 배열 접근 방식
//        for(int a:arr){ //인덱스가 아니라 값을 꺼낸다
//            System.out.println(a);
//        }
//
//        //일반 for문을 통한 arr의 저장된 값 변경
//        for(int i=0; i<arr.length;i++){ //주소값에 직접 접근
//            arr[i] +=10;
//        }
//        //참조형 변소(객체타입)은 기본적으로 변수를 통한 출력시에 메모리값이 출력
//        //그래서, 내장된 메서드를 통해 힘메모리안의 객체값을 보기좋게 출력할 수 있음
//        System.out.println(Arrays.toString((arr)));
//        //향상된 for문을 통한 arr의 저장된 값 변경 -> 원본의 값 변경 불가
//        for(int a:arr){ //그냥 실제로 꺼내온 것 //실제 원본 주소에 접근하는 것이 아닌,사본으로 값만 가져오는것
//             a+=10;

        //스택, 힙 중요!!!!!!!!!!!!!

        //자바 변수의 유효범위: {}
//        int num1 =10;
//        if(true){
//            num1 =20;
//            int num2 =30;
//        }
//        //하위 영역의 블록(중괄호)에서 정의된 변수는 상위블록에서는 접근불가
//        num2 =40; //불가


        //for문은 사용했던 변수명을 for문이 끝난 이후에 또 다른 for문에서 재선언이 가능
//        for(int i =0; i<10;i++){
//            System.out.println(i);
//        }
//
//
//        for(int i =0; i<10;i++){
//        System.out.println(i);
//    }
//}
//}

    //다중 fot문
    //2~9단까지 모든 구구단 한꺼번에 출력
    //2단입니다. 를 먼저 출력후에 2X1=2 2X2=4 2X3=6...
    //3단입니다. 를 먼저 출력후에 3X1=3 3X2=6 3X3=9...

        for(int i=2;i<10;i++){
            System.out.println("\n"+i+"단입니다");
            for(int j=1; j<10;j++){
                System.out.println(i+"*"+j+"="+i*j);
            }
        }

        //라벨문: 반복문에 이름을 붇이는 것
        loop1:
        for(int i=0; i<10; i++){
            for(int j=0;j<10;j++){
                if(true){
                    //원하는 for문을 라벨링을 통해 break 또는 continue시킬 수 있다
                    break loop1; //break는 본래 가까이에 있는거 먼저 종료 시킨다//라벨 다니까 loop 즉 바깥꺼 종료 (return도 있긴하다)

                }
            }
        }
    }
}
