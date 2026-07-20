package Ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EcommerceApplication {
    public static void main(String[] args) {
        ApplicationContext contex = SpringApplication.run(EcommerceApplication.class,args);
    }
}
