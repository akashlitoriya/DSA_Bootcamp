package oops.oops2.staticExample;

public class StaticBlock {
    static int a = 4;
    static int b;

    static{
        System.out.println("This is a static block");
        b = a * 5;
    }

    public static void main(String[] args) {
        System.out.println(StaticBlock.a + " " + StaticBlock.b); //Static thing are runs first when an class is loaded
        StaticBlock obj = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b); // 4 20

        StaticBlock.b += 3;

        System.out.println(StaticBlock.a + " " + StaticBlock.b); //4 23

        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b); // 4 23
    }
}
