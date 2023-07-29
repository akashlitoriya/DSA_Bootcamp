package oops.oops5.interfaces.nested;

public class A {
    //nested interface
    public interface NestedInterface{
        boolean isOdd(int num);
    }
}
class B implements A.NestedInterface{
    public boolean isOdd(int num){
        return (num & 1) == 1;
    }
}
