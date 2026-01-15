package C07ExceptionFileParsing.MemberException;

public class  Member{
    private static Long staticId =0L;
    private Long id;
    private String name;
    private String email;
    private String password;

    public Member(String name, String email, String password) {
        staticId++;
        this.id = staticId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
// 회원이란 무엇인가(데이터 구조)
// 회원의 상태(state)표현
// DB테이블과 1:1대응되는 경우가 많다