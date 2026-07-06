package LooselyCoupledSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    MachineInterface m;

    @Autowired
    Computer(@Qualifier("desktop") MachineInterface m){
        this.m=m;
    }
    public void display(){
        System.out.println("My computer is ");
        m.display();
    }
}
