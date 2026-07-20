package Ecommerce.entity;


import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductEntity {
    private int id;
    private String name;
    private double price;
    private int quantity;
}
