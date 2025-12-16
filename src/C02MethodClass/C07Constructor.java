package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

public class C07Constructor {
    public static void main(String[] args) {
//        캘린더 객체 생성
        Calenar c1 = new Calenar("2025","12","16");
        //원래 여기 //기본생성자 깡통+c1.setday("2025")//인걸 생성자로 함

//        캘린더 객체 출력
        System.out.println(c1);

//      java자료구조내에 직접 만든 객체를 담아 관리
        List<Calenar> myList =new ArrayList<>();
        myList.add(c1); //캘린더 객체 주소
        myList.add(new Calenar("2024","01","12"));

    }


    }
    class Calenar{
        private String year;
        private String month;
        private String day;

//        생성자: 객체가 만들어지는(new)시점에 호출되는 메서드
//        생성자특징: 1)클래스명과 메서드명이 동일 2)반환타입이 없음(void 쓰면 안된다) //숨어 있는것
//        생성자의 사용목적: 객체 생성시점에 객체변수값들을 초기화(세팅). 변수의 안정성을 위해 setter 사용을 지양하고, 생성자를 사용
        public Calenar(String year, String month,String day){ /// ////이거 의미가 뭐지
            this.year = year;
            this.month = month;
            this.day =day;

        }
///     직접 생성자를 1개라도 추가할 경우, 초기(기본)생성자는 무시가 되므로, 필요시 별도로 추가
        public  Calenar(){ //원래 기본 생성자가 내부적으로 숨어있는데 하나라도 호출하는 순간, 기본생성자 삭제
             //void도 사용불가

        }



        public String getYear() {
            return year;
        }

//        public void setYear(String year) {
//            this.year = year;
//        } 생성자 설정하면 set없애라(set은 값을 실수로라도 바꿀수 있어서 안정성을 떨군다ㅏ)

        public String getDay() {
            return day;
        }

//        public void setDay(String day) {
//            this.day = day;
//        }

        public String getMonth() {
            return month;
        }

//        public void setMonth(String month) {
//            this.month = month;
//        }


//        toString()메서드는 객체명으로 출력시 자동으로 메서드가 호출 (c1.toString으로 sout해야되는데 c1만해도 출력된다)
        @Override
        public String toString() { //매서드를 만든것 //아래와 같은 코드 sout
            return "Calenar{" +
                    "year='" + year + '\'' +
                    ", month='" + month + '\'' +
                    ", day='" + day + '\'' +
                    '}';
        }

//        public String calenderInfo(){
//            return "연도는 " + this.year + " 월은 " + this.month + " 일은 " + this.day;
//        }
    }



//클래스명: Calender, 변수: year,month, day 모두 String



//여러번!!!!!!!!!!!!!!!!!!!해보기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


//1)게시판