package C03Inheritance;

public class C05ProtetedTest {
    public static void main(String[] args) {
        C04Protected c1 =new C04Protected();
        System.out.println(c1.st1); //public
//        System.out.println(c1.st2); //private <--접근불가
        System.out.println(c1.st3); //default
        System.out.println(c1.st4); //protect
    }


}
