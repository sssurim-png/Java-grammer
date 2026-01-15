package C07ExceptionFileParsing.MemberException;

import java.util.List;
import java.util.NoSuchElementException;

//업무 규칙 처리, 트랜잭션 경계
//무엇을 할지 결정하는 곳
//다 매서드 뭐할지 정해두고 호출하면 그냥 이대로 돌아가는
public class MemberService {

    private MemberRepository memberRepository; //하려면 객체의 정보가 있어야한다

    public MemberService() {
        memberRepository = new MemberRepository();//생성자 호출
    }

    public void register(String name, String email, String password)throws NoSuchElementException {//throws~장식. 위임 //명시 정도(관례-보고 바로 어떤 에러 나는지 알 수 있다)
//        List(DB)에 이메일이 중복일경우 예외발생

        if (memberRepository.findByEmail(email).isPresent()) { //optional처리시 null값은 없다
            throw new IllegalArgumentException("이메일 중복이다");
        } //        객체 조립 후 repository를 통해 저장
            Member newMember = new Member(name, email, password);
            memberRepository.register(newMember); //insert 저장
//        memberRepository.register(new Member(name,email,password); <-조금 더 깔끔하다
/// optional처리 안했을 때는 if(member==null)이렇게 했다

    }

//    public Member findById(long id) { //아이디를찾아서 회원조회
//        Member member = memberRepository.findById(id);
//        if (member == null) {
//          throw new NoSuchElementException("없는 아이디입니다");
////            예외 발생
//        }
//        return member;
//    }

///  optional처리버전//
///
public Member findById(long id)  { //아이디를찾아서 회원조회
    return memberRepository.findById(id) //여긱까지가optional member
            .orElseThrow(()->new NoSuchElementException("없는 아이디입니다")); //orElseThrow

}



    public List<Member> findAll() {
        return memberRepository.findAll();
    }


//    public void login(String email, String password) {
//        Member member = memberRepository.findByEmail(email);
//        if (member == null) {
//            throw new NullPointerException("없는 이메일 입니다");
//        } else {
////        email이 있는지 확인 후 없으면 예외발생
//            boolean member1 = memberRepository.findByPassword(password, email);
//            if (!member1) {
//                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
//            }
////        객체에 대한 이메일과 password가 일치한지 확인 후 일치하지 않으면 예외 발생


//optional처리버전
public void login(String email, String password) { //여기도 optional처리
    Member member = memberRepository.findByEmail(email)
    .orElseThrow(() -> new IllegalArgumentException("없는 이메일 입니다"));

        boolean member1 = memberRepository.findByPassword(password, email);
        if (!member1) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }
//        객체에 대한 이메일과 password가 일치한지 확인 후 일치하지 않으면 예외 발생

    //깔끔한버전
//    if (!memberRepository.findByPassword(password, email)) {
//        throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
/// 굳이 DB까지 갈 필요 없으니 있는 eamil가지고 위처럼 바로 비교해주면 되겠다

    }

    }
