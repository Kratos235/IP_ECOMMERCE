package LooselyCoupledSpring;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements MachineInterface {
    @Override
    public void display(){
        System.out.println("Desktop");
    }
}
