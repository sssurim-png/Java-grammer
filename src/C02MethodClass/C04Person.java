package C02MethodClass;

public class C04Person {
//    객체변수는일반적을 변수의 안정성을 위해 private(클래스내에서만 접근 가능한 접근제어자)로 설정
    private String name;
    private String email;
    private int age;

    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAge(int age) {
        this.age = age;
    }



    public String getName() { //제너럴..자동..
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }

    public String retunPersonInfo() {
        return "이름은" + this.name + "+ 이메일은" + this.email + " 나이는" + this.age;

    }
///    객체 메서드들간의 호출은 문제없이 호출 가능
///     객체 메서드는 static 메서드 접근 가능. static은 다 접근 가능
    public void testMethod1(){
        String temp = this.retunPersonInfo()  ;

    }
//    클래스 메서드는 기본적으로 객체생성을 가정하지 않으므로, 클래스메서드내에서 객ㅊ메서드를 호출하는 것은 불가능(논리적 모순)
///    public  static  void testMethod2(){
///        String temp =this.retunPersonInfo(); //클래스메서드에서 객세 메서드x
///    }

}
