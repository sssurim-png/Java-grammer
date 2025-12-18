package C02MethodClass;
 /*
        <계좌개설 및 입출금 서비스>
        1.계좌객체 : id(auto_increment Long), name(String), accountNumber(String), balance(long)
        2.자료구조 :  계좌객체를 담아둘 자료구조는 Map
        3.서비스 기능: 사용하실 서비스 번호를 입력해주세요
            3-1)계좌개설 : "이름"과 사용하실 "계좌번호"와 현재 "가지고있는돈"을 입력하세요. -> 자동으로 id값 증가되어 객체 생성 !
            3-2)계좌조회 : 계좌조회서비스입니다. 조회하실 계좌의 계좌번호를 입력해주세요. -> 계좌주명, 계좌번호번호, 잔고를 보기좋게 출력 ! 오버라이드?
            3-3)입금 : 계좌입금서비스입니다. 입금하실 계좌번호와 입금금액을 입력해주세요. -> 입금전 잔액, 입금후 잔액 출력
            3-4)출금 : 계좌출금서비스입니다. 출금하실 계좌번호와 출금금액을 입력해주세요. -> 잔액검증 -> "출금 후 남은 금액은 얼마입니다" 또는 "잔액이 부족합니다" 출력
            3-5)송금 : 송금서비스입니다. 본인의 계좌번호, 상대방의 계좌번호, 송금금액을 입력해 주세요. -> 잔액검증 -> "송금 후 남은 금액은 얼마입니다" 또는 "잔액이 부족합니다" 출력.
        4.주의사항
            4-1)프로그램은 상시적 실행될수 있도록 전체코드를 while(true)처리
            4-2)main메서드에서 입출력 처리를 하고, 입금(deposit), 출금(withdraw), 송금(transfer)기능에 대한 핵심 메서드는 BankAccount클래스에 생성.
         */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C09BankService { //사용자와 의사소통하는 코드 출력등
    public static void main(String[] args) {
//        while(true){
//        Scanner sc = new Scanner(System.in);
//        int number = Integer.parseInt(sc.nextLine());
//    }

        Map<String,BankAccount> account3Map =new HashMap<>();

        account3Map.put("12345", new BankAccount("홍길동","12345",100000));
        account3Map.put("54321", new BankAccount("홍길동2","54321",500000));
        BankAccount a= account3Map.get("12345");
        BankAccount b= account3Map.get("54321");


        long before =a.getBalance();
        boolean result=a.transfer(b,50000);
        if(result){
            System.out.println("송금 전 잔액:"+before);
            System.out.println("송금 후 잔액:"+a.getBalance());
        }else{
            System.out.println("잔액이 부족");
        }


}
}

class BankAccount{ //핵심기능
    private Long id;
    private String name;
    private  String accountNumber;
    private long balance; //초기값이 0이어도 되서
    private static long staticId;

    public BankAccount(String name,String accountNumber, long balance){//생성자
        staticId++;
        this.id=staticId;
        this.name= name;
        this. accountNumber =accountNumber;
        this.balance = balance;
    }
    public String getName(){
        return name;
    }


    public String getAccountNumber(){
        return accountNumber;
    }

    public long getBalance(){
        return balance;
    }

    /// ///메서드
public boolean transfer(BankAccount targetAccount, long money){

    if(this.balance<money){
        return false;
    }
    this.balance-=money; //a의 계좌

    targetAccount.balance+=money; //b의 계좌

//    계좌입금서비스입니다. 입금하실 계좌번호와 입금금액을 입력해주세요. -> 입금전 잔액, 입금후 잔액 출력
//    3-4)출금 : 계좌출금서비스입니다. 출금하실 계좌번호와 출금금액을 입력해주세요. -> 잔액검증 -> "출금 후 남은 금액은 얼마입니다" 또는 "잔액이 부족합니다" 출력
return true;
}

/// ////

    @Override
    public String toString() {
        return "Account3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

}
