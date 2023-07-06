package oops.oops3.inheritance;

public class BoxWeight extends Box {
    public double weight;
    BoxWeight(){
        this.weight = -1;
    }
    BoxWeight(double l, double h, double w, double weight){
        super(l,h,w); //super() class the constructor of parent class, like in this example Box(p1,p2,p3) constructor will
        //be called. It initializes the value present in parent class;
        this.weight = weight;
    }

    static void greeting(){
        System.out.println("This is greeting() in the BoxWeight");
    }
}
