package C07ExceptionFileParsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03File {
    public C03File() throws IOException {
    }

    public static void main(String[] args) throws IOException {
////        콘솔창에 키보드를 통한 입출력
//        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//        String input =  br.readLine();
//        System.out.println(input);

////      파일에서 읽기: IO패키지
//        BufferedReader br2 =new BufferedReader(new FileReader("src/C07ExceptionFileParsing/test.txt"));
//        String line  = br2.readLine();
//        while(line !=null){ //여러줄 읽을때
//            System.out.println(line);
//            line= br2.readLine();

        }

////        파일에서 읽기: NIO패키지  //NIO>IO 성능// NIO(동시에 작업해서)<IO 안정성
//        Path filePath = Paths.get("src/C07ExceptionFileParsing/test.txt");
////        readString: 문자열 전체를 통째로 read
//        String st1 = Files.readString(filePath);
//        System.out.println(st1);
////        readAllLines: 문자열을 라인별로 split하여 list형태로 저장
//        List<String> st2 = Files.readAllLines(filePath);
//        System.out.println(st2);

//        파일에 문자열 쓰기
//        Path filePath2 = Paths.get("src/C07ExceptionFileParsing/test.txt");
//        Files.write(filePath2,"홍길동0".getBytes(), StandardOpenOption.CREATE_NEW); //새로 만들기
//        Files.write(filePath2,"홍길동0".getBytes(), StandardOpenOption.APPEND); //추가모드
//        Files.write(filePath2,"홍길동1".getBytes(), StandardOpenOption.WRITE); //덮어쓰기
    /// ///////////하나도 안됐다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

 // 싹 다 ㄷ다시!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

///  JSON
/// json→객체: 파싱(역직렬화), 객체 → json: 직렬화    !!!!!!중요!!!!!!!! 꼭 외우기!!