package C08Thread;

public class Library {
    private static int bookCount =100;
//    syncronized: 메서드내에서 1개의 스레드만을 실행되도록 보장
//    public synchronized static void borrow(){
    public static void borrow(){
        if(bookCount>0){
            try {
                Thread.sleep((100));
            }catch (InterruptedException e){
                throw  new RuntimeException(e); //실제와 비스한 환경 주려고 객체 만들어지는 시간 벌려고 딜레이 넣는 것// 동시성
            }
            bookCount-=1;
            System.out.println("대출완료");
        }else{
            System.out.println("대출 불가");
        }
    }
    public static  int getBookCount(){
        return bookCount;
    }

}

