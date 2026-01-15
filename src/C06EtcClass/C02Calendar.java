package C06EtcClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

public class C02Calendar {
    public static void main(String[] args) {

///        java.util패키지의  Calendar클래스 -잘 안쓰임

///        Calendar myCalendar =Calendar.getInstance();
///        System.out.println(myCalendar.getTime()); //문자열 타입으로 뽑아주기
///        System.out.println(myCalendar.get(Calendar.YEAR)); //get=>어떻게 꺼낼거냐
///        System.out.println(myCalendar.get(Calendar.MONTH)+1); //0부터 센다
///        System.out.println(myCalendar.get(Calendar.DAY_OF_WEEK)); //요일 (일, 월, 화...이렇게 나온다-숫자로 EX. 화=3)
///        System.out.println(myCalendar.get(Calendar.DAY_OF_MONTH)); //0부터 시작안해ㅐ서 그냥 출력
///        System.out.println(myCalendar.get(Calendar.HOUR));
///        System.out.println(myCalendar.get(Calendar.MINUTE));
///        System.out.println(myCalendar.get(Calendar.SECOND));



///        java.time패키지의 LocalDateTime, LocalDate, LocalTime 클래스 <--압도적으로 많이 쓴다
        LocalDate myLocalDate = LocalDate.now();
        System.out.println(myLocalDate);
        System.out.println(myLocalDate.getYear());
        System.out.println(myLocalDate.getMonth());
        System.out.println(myLocalDate.getMonthValue());
        System.out.println(myLocalDate.getDayOfMonth());
        System.out.println(myLocalDate.getDayOfWeek());


        LocalTime  myLocalTime = LocalTime.now();
        System.out.println(myLocalTime.getHour());
        System.out.println(myLocalTime.getMinute());
        System.out.println(myLocalTime.getSecond());



        LocalDateTime myLocalDateTime = LocalDateTime.now();
        System.out.println(myLocalDateTime.getYear());
        System.out.println(myLocalDateTime.getHour());
//        ChronoField매개변수로 다양한 형식의 날짜/시간정보 조회 -다양한 옵션이 있다
        System.out.println(myLocalDateTime.get(ChronoField.YEAR)); //옵션이 많아서 쓴다
        System.out.println(myLocalDateTime.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(myLocalDateTime.get(ChronoField.AMPM_OF_DAY)); //0:오전, 1:오후
        System.out.println(myLocalDateTime.get(ChronoField.CLOCK_HOUR_OF_DAY)); //24시 체계

//        .of: 임의로 특정시간정보객체를 만들어내고 싶을 때 사용 (원하는 시간)
        LocalDate birthDay =LocalDate.of(2000,11,12);
        System.out.println(birthDay);

        LocalDateTime birthDaytime =LocalDateTime.of(2000,11,12,15,14,10);








    }
}
