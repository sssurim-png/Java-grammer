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


package C00Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class post01 {
    public static void main(String[] args) {
        List<Author> authorList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();


        while (true) {
            System.out.println("서비스 번호를 입려하시오");
            Scanner sc = new Scanner(System.in);
            int number = Integer.parseInt(sc.nextLine());
            if (number == 1) { //3-1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
                System.out.println("회원가입서비스입니다.");
                System.out.print("이름을 입력해주세요");
                String name = sc.nextLine();
                System.out.print("이메일을 입력해주세요");
                String email = sc.nextLine();
                System.out.print("비밀번호을 입력해주세요");
                String password = sc.nextLine();
                Author author = new Author(name, email, password); //객체생성
                authorList.add(author);


            }else if(number==2){ //회원 전체 목록 조회 : id, email
                System.out.println("회원 전체 조회 서비스 입니다");
                System.out.println("이메일을 입력하세요");
                String email =sc.nextLine();

                for(Author a: authorList){
                    System.out.println(a.getName());
                }

            }else if(number==3){ //회원 상세 조회(id로 조회) : id, email, name, password, 작성글수  (postList에서 조회하거나, author객체에서 postList목록을 변수로 갖는것도 가능)
                System.out.println("회원 상세조회 서비스 입니다");
                System.out.print("회원ID를 입력해주세요");
                long id =Long.parseLong(sc.nextLine());
                Author author = null;

                for(Author a: authorList){
                    if(a.getId()==id){
                        author =a;
                    }
                }
                int count=0;
                for(Post p : postList){
                    if(p.getAuthorEmail().equals(id)){
                        count++;
                    }
                }


            }else if(number==4){  //게시글 작성 : id, title, contents, 작성자Email  (직접 Author 객체를 변수로 갖는것도 가능)
                System.out.println("게시글작성서비스입니다.");
                System.out.print("제목을 입력해주세요");
                String title = sc.nextLine();
                System.out.print("내용을 입력해주세요");
                String contents = sc.nextLine();
                System.out.print("회원EMAIL을 입력해주세요");
                String email = sc.nextLine();

                Post post =new Post(title,contents,email); //이게 post의 authorEmail
                postList.add(post);

            }


        }
    }

}

    class Author {
        private Long id;  // 객체 고유 id
        private String name;
        private String email;
        private String password;
        private static long staticId; // 클래스 공용 카운터

        public Author(String name, String email, String password) {
            staticId++; /////////??????알기
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

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }


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
        private Long id; //객체 고유의 것
        private String title;
        private String contents;
        private static long staticId;
        private String authorEmail;

        public Post(String title, String contents, String authorEmail){ //외부에서 받아오는 값
            staticId++;
            this.id=staticId;  //실제로 들어가는건 여기서
            this.title=title;
            this.contents=contents;
            this.authorEmail=authorEmail;
        }

        public Long getId() {
            return id;
        }
        public String getTitle() {
            return title;
        }
        public String getContents() {
            return contents;
        }
        public String getAuthorEmail() {
            return authorEmail;
        }

        @Override
        public String toString() {
            return "Post{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", contents='" + contents + '\'' +
                    '}';
        }
    }

