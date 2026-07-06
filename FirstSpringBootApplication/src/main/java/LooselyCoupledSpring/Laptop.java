package LooselyCoupledSpring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Laptop implements MachineInterface{
    @Override
    public void display(){
        System.out.println("Laptop");
    }
}
