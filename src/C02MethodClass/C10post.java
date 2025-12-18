/*
       <게시판서비스>
       1.계좌객체 : Author, Post
       2.자료구조 : List(authorList, postList)
       3.서비스 기능 : 사용하실 서비스 번호를 입력해주세요
           3-1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
           3-2.회원 전체 목록 조회 : id, email
           3-3.회원 상세 조회(id로 조회) : id, email, name, password, 작성글수  (postList에서 조회하거나, author객체에서 postList목록을 변수로 갖는것도 가능)
           3-4.게시글 작성 : id, title, contents, 작성자Email  (직접 Author 객체를 변수로 갖는것도 가능)
           3-5.게시물 목록 조회 : id(post), title
           3-6.게시물 상세 조회(게시글 id로 조회) : id, title, contents, 작성자이름
    */


package C02MethodClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C10post {
    public static void main(String[] args) {
        List<Author> authorList =new ArrayList<>();
        List<Post> postList =new ArrayList<>();
        while(true){
            Scanner sc =new Scanner(System.in);
            int number =Integer.parseInt(sc.nextLine());
            if(number==1){  //3-1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
                System.out.println("회원가입서비스입니다.");
                System.out.print("이름을 입력해주세요");
                String name = sc.nextLine();
                System.out.print("이메일을 입력해주세요");
                String email = sc.nextLine();
                System.out.print("비밀번호을 입력해주세요");
                String password = sc.nextLine();

                Author author =new Author(name, email, password); //계속 author로 불러서 쓰려고
                if(authorList.contains(email)){
                    System.out.println("이메일 중복");
                }else {
                    authorList.add(author); //생성자 만들기
                }



            }else if(number==2){  //3-2.회원 전체 목록 조회 : id, email
                System.out.println("회원목록 조회 서비스입니다");

                    if(authorList.isEmpty()){
                        System.out.println("회원목록이 없습니다");
                    }else{
                        for(Author a: authorList){
                            System.out.println("id는"+ a.getId() + "email은"+ a.getEmail());
                        } //그냥 a하면 주소값 출력될거 같은데 다 출력하는 거 어떻게 하는거지
                }

            }else if(number==3){
                System.out.println("회원상세 조회 서비스 입니다(id)");
//                3-3.회원 상세 조회(id로 조회) : id, email, name, password, 작성글수  (postList에서 조회하거나, author객체에서 postList목록을 변수로 갖는것도 가능)
                System.out.println("회원ID를 입력해주세요");
                long id = Long.parseLong(sc.nextLine());
                Author author =null;
                for(Author a: authorList){
                    if(a.getId()==id){
                        author =a;
                        break;
                    }
                }
                long post=0;
                for(Post a: postList){
                    if(a.getAuthorEmail().equals(author.getEmail())){
                        post++;// 객체 아니고 email 추가 버전
                    }

                }


            }else if(number==4){ //  3-4.게시글 작성 : id, title, contents, 작성자Email  (직접 Author 객체를 변수로 갖는것도 가능)
                System.out.println("게시글작성서비스입니다.");
                System.out.print("제목을 입력해주세요");
                String title = sc.nextLine();
                System.out.print("내용을 입력해주세요");
                String contents = sc.nextLine();
                System.out.print("회원EMAIL을 입력해주세요");
                String email = sc.nextLine();

                Author author =null;
                for(Author a: authorList){
                    if(a.getEmail().equals(email)){
                        author=a;
                        break;
                    }
                }
                Post post = new Post(title, contents, email); //authorEmail란
                postList.add(post);



//


            }else if(number==5){ //3-5.게시물 목록 조회 : id(post), title
                System.out.println("게시글 목록조회 서비스 입니다");
                System.out.print("게시글ID를 입력해주세요");
                long id =Long.parseLong(sc.nextLine());
                Post post = null;
                for(Post p: postList){
                    System.out.println(p); //오버라이딩 해놓으면 주소값 아니고 이쁘게 출력된다 //아니면 하나하나 다ㅏ 적어야된다

                }


            }else if(number==6){ //3-6.게시물 상세 조회(게시글 id로 조회) : id, title, contents, 작성자이름
                System.out.println("게시글 상세조회 서비스 입니다(게시글 id)");
                System.out.print("게시글ID를 입력해주세요");
                long id =Long.parseLong(sc.nextLine());
                Post post =null;
                for(Post p: postList){
                    if(p.getId() == id){
                        post =p;
                        break;
                    }
                }

//

            }




        }
    }



}
class Author{
    private Long id;
    private String name;
    private String email;
    private String password;
    private  static  long staticId; //<-이거 알기!!!!!!!!

    public Author(String name, String email, String password){
        staticId++;
        this.id=staticId;
        this.name=name;
        this.email=email;
        this.password=password;
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
    public static long getStaticId() {
        return staticId;
    }

/// /////////매서드
//    public void



/// /////////매서드

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}








class Post{
    private Long id; //얘는 초기화때 0이어도 되니까? null이어야되나? 없어도 되는 객체니까?
    private String title;
    private String contents;
    private static long staticId;
    private String authorEmail;

    public Post(String title, String contents,String authorEmail) {
        staticId++;
        this.id = staticId;
        this.title = title;
        this.contents = contents;
        this.authorEmail =authorEmail;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public long getId() {
        return id;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }
///


    ///

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}

// <게시판서비스>
//       1.계좌객체 : Author, Post
//       2.자료구조 : List(authorList, postList)
//       3.서비스 기능 : 사용하실 서비스 번호를 입력해주세요
//           3-1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
//           3-2.회원 전체 목록 조회 : id, email
//           3-3.회원 상세 조회(id로 조회) : id, email, name, password, 작성글수  (postList에서 조회하거나, author객체에서 postList목록을 변수로 갖는것도 가능)
//           3-4.게시글 작성 : id, title, contents, 작성자Email  (직접 Author 객체를 변수로 갖는것도 가능)
//           3-5.게시물 목록 조회 : id(post), title
//           3-6.게시물 상세 조회(게시글 id로 조회) : id, title, contents, 작성자이름