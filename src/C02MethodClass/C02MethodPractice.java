package C02MethodClass;

import java.util.Scanner;

public class C02MethodPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input =Integer.parseInt(sc.nextLine());
        if(isPrime(input)){
            System.out.println("입력하신 숫자는 소수입니다");
        }else{
            System.out.println("입력하신 숫자는 소수가 아닙니다");
        }
    }

    public static boolean isPrime(int num){
        boolean isPrime = true;
        if(num<=1){
///            메서드에서 return을 만나면 메서드가 강제 종료
            return false;
        }


        for(int i =2; i*i<num; i++){
            if(num%i==0){
                return false;

            }
        }
return true;


    }
///    소수판별기(메서드(isPrime)생성
///    접근제어자(public), 클래스메서드, 반환타입은 boolean, 입력값은 int
    public static void voidMethod(){ //원래 반환 없다
        if(true){
///            void 메서드에서 return은 메서드 강제종료 목적으로 사용
            return; ///리턴이 아닌 강제종료
        }
        System.out.println("hello world"); //리턴이 아닌 출력
    }

}


