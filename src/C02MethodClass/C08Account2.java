package C02MethodClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C08Account2 {
    public static void main(String[] args) {
//        계좌개설(객체생성)
//        List를 계좌객체를 담는 자료구조로 사용
//        List<Account> accountList = new ArrayList<>();
//        accountList.add(new Account("hong1", "12345", 1000000));
//        accountList.add(new Account("hong2", "54321", 0));
//
////        계좌1("12345")에서 계좌2("54321")로 송금(50000) : 잔고변경메서드필요
////        내 객체를 찾아서 50000원을 차감하고, 상대방 객체를 찾아서 50000원을 가산한다.
//        for (Account a : accountList){
//            if(a.getAccountNumber().equals("12345")){
////                계좌1의 잔고를 50000감소
//                a.setBalance(a.getBalance()-50000);
//            }
//            if(a.getAccountNumber().equals("54321")){
////                계좌2의 잔고를 50000증가
//                a.setBalance(a.getBalance()+50000);
//            }
//        }
//        원래 여기 sout

///       Map을 계좌객체를 담는자료구조로 사용
        Map<String,Account2>accountMap =new HashMap<>();

        accountMap.put("12345", new Account2("hong1","12345",100000));
        accountMap.put("54321", new Account2("hong2","54321",0));

        Account2 a = accountMap.get("12345");
        Account2 b = accountMap.get("54321");
        a.transfer(b,50000);
        b.transfer(b,50000);
//        static일경우...
        System.out.println(accountMap);
    }
}
//Account클래스 - 계좌주명(name), 계좌번호(accountNumber-String), 잔고(balance-long)
class Account2{
//  참조자료형은 초기값 null
    private Long id; //참조자료형은 초기값을 0이 아닌 null로 하기 위해 L로 wapper class쓴다
    private String name;
    private String accountNumber;
//    원시자료형은 각 자료형에 맞는 초기값
    private long balance;
    private static  long staticId;

    public Account2(String name, String accountNumber, long balance) {
        staticId++;
        this.id=staticId;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }
    //setBanlance 보다는 의도를 명확히 한 메서드며을사용하기를 권장
    public void setBalance(long balance) {
        this.balance = balance;
    }
/// //////메서드
    public void  transfer(Account2 targetAccount, long money){ //송금할 객체를빼버리자??? static매서드 안쓰려고- this쓸 수가 없어서
        if(this.balance<money){
            return;
        }

//        송금할 객체에서 돈을차감
        this.balance-=money;

//        송금방들 객체에 돈을 가산
        targetAccount.balance+=money;

    }


    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
