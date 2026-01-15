package C07ExceptionFileParsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class C02ExtceptionAdvance {
    public static void main(String[] args) throws IOException {

///        의도된 예외 강제 발생: 특정 시점에 프로그램을 강제 중지시키기 위한 목적
///        Scanner sc =new Scanner(System.in);
///        System.out.println("email을 입력해주세요");
///        String email =sc. nextLine();
///        System.out.println("password를 입력해주세요");
///        String password =sc.nextLine();
///        register(email,password);
///        System.out.println("DB에 저장되는 코드");
 /// //////uncheked를 아는게 더 중요

///        checked excpetion의 처리방법
///        방법1. thouws를 통해 checked예외처리를 위임받고, main에서도 throws(시스템에 위임- 예외처리  안하는것)
        String text =fileRead("src/C07ExceptionFileParsing/test.txt"); //파일 리턴받아서 출력
        System.out.println(text);

///        방법2.throws를 통해 checked예외처리를 위임받고, 호출하는 쪽에서 예외처리
        try{
            String text3= fileRead("src/C07ExceptionFileParsing/test.txt"); //파일 리턴받아서 출력
            System.out.println(text3);
        }catch(RuntimeException e){
//            사용자에게 메시지 전달(가정)
            System.out.println("파일 처리 과정에서 에러가 발생했스빈다");
            e.printStackTrace();
        }

//     방법3. checked예외를 try/catch 하여 unchecked예외 강제 발생(DB 롤백 목적
     try{
            String text2= fileRead("src/C07ExceptionFileParsing/test.txt"); //파일 리턴받아서 출력
            System.out.println(text2);
        }catch (RuntimeException e){ //DB롤백이..?
//            사용자에게 메시지 전달(가정)
            System.out.println("파일 처리 과정에서 에러가 발생했스빈다");
            e.printStackTrace();
        }

    }
    ///    static String fileRead(String path) throws IOException {//파일 읽은 것을 리턴
    static String fileRead(String path){
        Path filePath = Paths.get(path);
        String text = null;
        try {
            text = Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }




    static  boolean register(String email, String password) {
        boolean check= false;
        if (password.length() >= 10) {
            check= true;
        } else {
///            예외를 강제 발생시키으로서 이 시점에서 해당 메서드 강제 종료
///            예외는 기본적으로 메서드를 호출한 쪽으로 전파
            throw new IllegalArgumentException("비밀번호가 너무 짧습니다");//
        }
        System.out.println("DB에 저장되는 코드");
        return  check;

    }
}

//사용자에게 입출력 받는다 -> 회원가입 =>DB

//////////////////////////////////////////////////회원가입 뭐 없는거 같은데 여기????