package oops.oops3.inheritance;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(4);
        System.out.println(box1.l + " " + box1.h + " " + box1.w);
        Box box2 = new Box(1,2,3);
        System.out.println(box2.l + " " + box2.h + " " + box2.w);
        Box box3 = new Box(box1);
        System.out.println(box3.l + " " + box3.h + " " + box3.w);


        BoxWeight boxw1 = new BoxWeight();
        System.out.println(boxw1.l + " " + boxw1.weight);

        Box box = new BoxWeight(1,2,3,4);
        System.out.println(box.l + " " + box.h + " " + box.w); //box.weight can't be accessed as
        // Type of reference variable will determine what all values will be accessed. Here type of reference variable
        // is Box, so it will only access values that are in the Box

//        BoxWeight boxw = new Box(1,2,3);



        BoxPrice obj = new BoxPrice(1,2,3,4,6);
        System.out.printf("Length : %f Height : %f width : %f weight : %f price : %f", obj.l, obj.h, obj.w, obj.weight,obj.price);


        Box objStat = new BoxWeight();
        objStat.greeting();  //Box class greeting will be called

        BoxWeight objStat1 = new BoxWeight();
        objStat1.greeting();   //BoxWeight class greeting will be called

    }
}
