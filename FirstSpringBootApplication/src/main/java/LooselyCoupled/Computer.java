package LooselyCoupled;

public class Computer {
    Machine m;
    Computer(Machine m){
        this.m=m;
    }
    public void display(){
        System.out.println("Mu computer is:- ");
        m.display();
    }
}
