package oops.oops6.exceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try{
            int c = a / b;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Finally will always runs");
        }

        b = 1;
        try{
            int c = a/b;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Here Exception not thrown but finally will run");
        }

        try{
            System.out.println(divide(100,20));
            System.out.println(divide(50,0));
            System.out.println(divide(10,10)); // This will not get Executed as Exception is thrown in line 29. So
                                                        //pointer will move to catch();
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }

        try{
            divide2(10,0);
        }catch(Exception exp){
            System.out.println(exp.getMessage());
        }

        //Throwing multiple Exceptions
        int arr[] = new int[2];
        try{

            int i = arr[2];
            divide(10, 0);
        }catch(ArithmeticException e1) {
            System.out.println(e1.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e2){
            System.out.println(e2);
        }
        catch(Exception e3){
            System.out.println(e3);
        }
    }

    static int divide(int a, int b){
        if(b == 0){
            throw new ArithmeticException("Not allowed to divide by zero");
        }
        return a / b;
    }

    static int divide2(int a, int b) throws ArithmeticException{
        return a / b;
    }
}
