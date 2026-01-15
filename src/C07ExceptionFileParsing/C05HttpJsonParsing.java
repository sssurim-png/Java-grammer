package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class C05HttpJsonParsing {
    public static void main(String[] args) throws IOException, InterruptedException {
//        외부에서 데이터를 받아 java의 객체로 변환
//        외부api요청을 하기 위한 라이브러리
//        HttpClient = java내장클래스
//        RestTemplate,RestClient은 스프링에서 가장 많이 사용하는 클래스
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .GET().build();

        HttpResponse<String>response = client.send(request, HttpResponse.BodyHandlers.ofString());//외부 요청 시 보통 checked exception뜬다
        String data =response.body();
        ObjectMapper o1 = new ObjectMapper();
//        String data = ;
        System.out.println(data);
//객체로 파싱
//       Post p1 = o1.readValue(data,Post.class);
//        System.out.println(p1); !!!!!!!다시!!!!!!!


//리스트형식의 객체로 파싱
//        ObjectMapper o2= new ObjectMapper();
//        HttpClient client2 = HttpClient.newHttpClient();
//        HttpRequest request1 =HttpRequest.newBuilder()
//                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
//                .GET().build();
//        HttpResponse<String> response1= client2.send(request1,HttpResponse.B)
/// ////////////////////////다시!!!!!!!!!!!




    }
}

//class Post{
//    private long id;
//    private long userId;
//    private  String
//} 다시!!!!!!!!
