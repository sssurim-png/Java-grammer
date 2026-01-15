package C07ExceptionFileParsing.MemberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//저장소역할을 하는 계층-애매
//DB에 CRUD를 수행하는 계층 - 저장, 조회, 수정, 삭제
//데이터를 꺼내고 넣는 기술 담당
// select와 insert, delete에 해당
public class MemberRepository { //list릉 repository안에서만 접근할거기 때문에 getter가 필요없다.
    private List<Member> memberList; // 회원 객체들을 여러개 보관할 내부 저장공간, 실제 db테이블  ///////member에 변수저장 느낌

    public MemberRepository(){//객체 생성 시 자동으로 실행되는 위의 생성자 //////생성자
        this.memberList = new ArrayList<>(); //회원데이터를 담을 빈 리스트 생성
    }

    public void register(Member member){ //insert -회원객체저장
        this.memberList.add(member);
    }

    public Optional<Member> findByEmail(String email){ //이메일을 기준으로 회원을 조회하는 메서드 //여기부터 optional하자

        for ( Member member1 : memberList){
        if(member1.getEmail().equals(email)){
         return Optional.of(member1);
    }
        }
        return Optional.empty(); //optional처리
    }

    public Optional<Member> findById(long id){ //id를 기준으로 회원을 조회하는 메서드//단일 회원 조회용

        for (Member member1 : memberList){
            if(member1.getId()==id){
                return Optional.of(member1);
            }
        }
        return Optional.empty();
    }

    public boolean findByPassword(String email, String password){ //이메일을 기준으로 회원의 비밀번호 일치여부를 조회하는 메서드//단일 회원 조회용
        for (Member member1 : memberList){
            if(member1.getPassword().equals(password) && member1.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }





    public List<Member> findAll(){ //저장된 모든 회원을 조회하는 메서드
        return this.memberList;
    }
}
