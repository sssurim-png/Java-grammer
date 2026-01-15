package C03Inheritance.C05ProtectedPakage;

import C03Inheritance.C04Protected;

public class C05ProtetedTest extends  C04Protected{
    public static void main(String[] args) {
        C05ProtetedTest c1 =new C05ProtetedTest();
        System.out.println(c1.st1); //public
///        System.out.println(c1.st2); //private <--접근불가
///        System.out.println(c1.st3); //default <--접근불가
        System.out.println(c1.st4); //protect
    }


}
