package C09NetWorking;

import java.sql.*;

public class C03DbConnect {
//    java->db연결
    public static void main(String[] args) throws SQLException {
//        mysql드라이버 별도 다운로드 및 추가
        String url = "jdbc:mysql://localhost:3306/board?useSSL=false"; //SSL 보안
        String userName ="root";
        String password = "test1234";
        Connection myConnection = DriverManager.getConnection(url,userName,password);
        System.out.println(myConnection);

//        Statement객쳉 쿼리를담아 db에 전송
        Statement st = myConnection.createStatement(); //객체 import됐는데 원래 이렇게 쓴느건가 그래고 왜sql이지
        ResultSet result = st.executeQuery("select*from  post");
//        next()를 통해 데이터를1행씩 read
        while(result.next()){
//            db랑 이름 같아야된다
            System.out.println(result.getInt("id"));
            System.out.println(result.getString("title"));
            System.out.println(result.getString("contents"));

        }
    }
}
