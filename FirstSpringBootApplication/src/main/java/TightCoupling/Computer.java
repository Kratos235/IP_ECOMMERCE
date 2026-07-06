package TightCoupling;

public class Computer {
    Laptop l;
    Computer(){
        l=new Laptop();
    }
    public void display(){
        System.out.println("My Computer is:- ");
        l.display();
    }
}
