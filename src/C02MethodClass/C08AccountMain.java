package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

public class C08AccountMain {
    public static void main(String[] args) {
        Account acc = new Account("보내는 사람", "1234", 10000);

//        계좌개설(객체생성)
//        List를 계좌객체를 담는 자료구조로 사용 2,3개
        List<Account> myList =new ArrayList<>();
        myList.add(acc);
        myList.add(new Account("받는 사람", "54321", 10000));
        myList.add(new Account(" 사람", "53423", 10000));
        myList.add(new Account(" 사람2", "23532", 10000));
        Account.Mehod(myList);

//        계좌1("1234')에서 계좌2("54321"로 송금(50000): 잔고변경메서드필요 set balance
//        내 객체를찾아서 50000원을차감하고, 상대방 객체를 찾아서 50000원을가산한다.

//        for(Account a: myList){
//
//        }
    }

    }


//        객체 정의
        class Account {
    private String name;
    private String accountNumber;
    private long balance; //캡슐화


    public Account(String name, String accountNumber, long balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance; //선언값 넣을거다
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

    /// ////잔액 차감
    private boolean withdraw(long amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    /// ////잔액증가
    private void deposit(long amount) {
        balance += amount;
    }


    @Override
    public String toString() {
        return "이름" + name + "계좌번호" + accountNumber + "잔고" + balance;
    }

    public static void Mehod(List<Account> myList) { //자료형 맞춰줘야한다

        String from = "1234";
        String to = "54321";
        long amount = 5000;

        Account sender = null;
        Account receiver = null;

        for (Account a : myList) {
            if (a.getAccountNumber().equals(from)) {
                sender = a;
            }
            if (a.getAccountNumber().equals(to)) {
                receiver = a;
            }
        }
            if (sender == null || receiver == null) {
                System.out.println("ERROR");

            }

            if (sender.withdraw(amount)) {
                receiver.deposit(amount);
                System.out.println(" 입금자: " + sender.name + ", 잔고: " + sender.getBalance() +
                        "\n 받은사람: " + receiver.name + ", 잔고: " + receiver.getBalance());
            } else {
                System.out.println("ERROR");
            }

        }

    }






//Account클래스 - name 계좌주명 (name), 계좌번호(accountNumber-String), 잔고(balance-long)