package C07ExceptionFileParsing.MemberException;

import java.util.*;

//사용자에게 입출력 요청받기 , 서비스 호출
public class MemberController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberService memberService = new MemberService();
        while (true){
            System.out.println("1번 : 회원가입, 2번 : 회원상세조회, 3번 : 회원목록조회, 4번 : 로그인");
            String input = sc.nextLine();
            if(input.equals("1")){
                System.out.println("회원가입서비스입니다.");
                System.out.println("이름을 입력해주세요");
                String name = sc.nextLine();
                System.out.println("email을 입력해주세요");
                String email = sc.nextLine();
                System.out.println("비밀번호를 입력해주세요");
                String password = sc.nextLine();
//                사용자의 입력값 단순 검증
                if(password.length()<10){
                    System.out.println("입력값이 너무 짧습니다");
                    return; //코드 중지를 위해 //왜 Ser은 그냥 return안하고 예외를 던지냐?
                }
//
                try{ //회원가입시 발생하는 예외를 적절히 try/catch
                    memberService.register(name, email,password);
                    System.out.println("회원가입 성공");
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            }else if (input.equals("2")){
                System.out.println("회원상세조회 서비스입니다.");
                System.out.println("회원 ID값을 입력해주세요");
                long id = Long.parseLong(sc.nextLine());
//                회원상세조회시 발생하는 예외를 적절히 try/catch
                try{
                    Member member = memberService.findById(id);
                    System.out.println(member);
                }catch (NoSuchElementException e){
                    System.out.println(e.getMessage()); //서비스에 에러메시지 넣어놨으면 거기서 꺼내는 것이 맞다
                }


            }else if (input.equals("3")){
                System.out.println("회원목록조회 서비스입니다.");
                List<Member> memberList = memberService.findAll();
                System.out.println(memberList);

            }else if (input.equals("4")){
                System.out.println("로그인 서비스입니다.");
                System.out.println("email을 입력해주세요");
                String email = sc.nextLine();
                System.out.println("비밀번호를 입력해주세요");
                String password = sc.nextLine();
//                예외처리 : 예외발생시, 예외의 원인 출력.
                try{
                    memberService.login(email, password);
                    System.out.println("로그인 성공");
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();// 뭐더라
                }catch (NoSuchElementException e){
                    System.out.println(e.getMessage());
                    e.printStackTrace(); //두개 이상도 된다
                }



            }
        }
    }
}
