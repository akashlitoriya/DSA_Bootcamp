package oops.oops2.staticExample;


class Test{
    static String name;
    Test(String name){
        Test.name = name;
    }
}
public class InnerClasses {
    static class Test1{
        String name;
        Test1(String name){
            this.name = name;
        }
    }

    static class Test2{
        static String name;
        Test2(String name){
            Test2.name = name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Akash");
        Test b = new Test("Litoriya");
        System.out.println(a.name); //Litoriya
        System.out.println(b.name); //Litoriya
        /*
        This is the basic of static
         */


        Test1 c = new Test1("Aniket");
        Test1 d = new Test1("Litto");
        System.out.println(c.name); //Aniket
        System.out.println(d.name); //Litto
        /*
        Here Test1 is declared as static, which means Test1 is not dependent on object of InnerClasses, But it can
        have instances of its own. Which is why the name in Test1 depends on objects of Test1
        */

        Test2 e = new Test2("Anita");
        Test2 f = new Test2("Narendra");
        System.out.println(e.name);  //Narendra
        System.out.println(f.name);  //Narendra
        /*
        here Test2 is static, so it is independent of InnerClasses. The name property inside Test2 is also static
        so name is independent of objects of Test2, Hence we got the same output for both objects
         */
    }
}
