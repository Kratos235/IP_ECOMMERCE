package ecommerce.service;

import ecommerce.DTO.ProductDTO;
import ecommerce.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    //Dummy
    private List<ProductEntity> productList = new ArrayList<>();

    public ProductDTO addProduct(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        productList.add(entity);
        return dto;
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> dtoList = new ArrayList<>();
        for(ProductEntity entity : productList) {
            ProductDTO dto = new ProductDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setQuantity(entity.getQuantity());
            dtoList.add(dto);
        }

        return dtoList;
    }
    // Read by ID
    public ProductDTO getProductById(int id) {
        for(ProductEntity entity:productList) {
            if(entity.getId() == id) {
                ProductDTO dto = new ProductDTO();
                dto.setId(entity.getId());
                dto.setName(entity.getName());
                dto.setPrice(entity.getPrice());
                dto.setQuantity(entity.getQuantity());
                return dto;
            }
        }
        return null;
    }

    //Update
    public ProductDTO updateProduct(int id, ProductDTO dto) {
        for(ProductEntity entity:productList) {
            if(entity.getId() == id) {
                entity.setId(dto.getId());
                entity.setName(dto.getName());
                entity.setPrice(dto.getPrice());
                entity.setQuantity(dto.getQuantity());
                return dto;
            }
        }
        return null;
    }
    //DELETE
    public String deleteProduct(int id) {
        for(ProductEntity entity:productList) {
            if(entity.getId() == id) {
                productList.remove(entity);
                return "Product deleted";
            }
        }
        return "Product not found";
    }
}
