package LooselyCoupled;

public class Main {
    public static void main(String[] args) {
        Desktop d = new Desktop();
        Laptop l = new Laptop();
        Computer obj = new Computer(d);
        obj.display();
    }
}
