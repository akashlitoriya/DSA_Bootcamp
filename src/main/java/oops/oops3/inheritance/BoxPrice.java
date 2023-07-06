package oops.oops3.inheritance;

public class BoxPrice extends BoxWeight{
    double price;

    BoxPrice(double l, double h, double w, double weight, double price){
        super(l, h, w, weight);
        this.price = price;
        this.l = 0; //if class doesn't have the variable 'l' then it will find it in the parent
        //so here 'this' will refer to Box
    }
}
