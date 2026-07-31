package Ecommerce.service;

import Ecommerce.dto.ProductDTO;
import Ecommerce.entity.ProductEntity;
import Ecommerce.repository.productrepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    //Dummy database
    private List<ProductEntity> productList = new ArrayList<>();
    //Modelmapper injection
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private productrepo repo;

    //CREATE
    public ProductDTO addProduct(ProductDTO dto){
        ProductEntity entity = modelMapper.map(dto,ProductEntity.class);
        ProductEntity outputEntity=repo.save(entity);
        return modelMapper.map(outputEntity,ProductDTO.class);
    }

    //Read All
    public List<ProductDTO>getAllProduct(){
        List<ProductDTO>dtoList= new ArrayList<>();
        for(ProductEntity entity:productList){
            ProductDTO pdto=modelMapper.map(entity,ProductDTO.class);

//            pdto.setId(entity.getId());
//            pdto.setName(entity.getName());
//            pdto.setQuantity(entity.getQuantity());
//            pdto.setPrice(entity.getPrice());

            dtoList.add(pdto);
        }
        return dtoList;
    }

    //READ By ID
    public ProductDTO getProductById(int id){
        for(ProductEntity entity: productList){
            if(entity.getId()==id){
                ProductDTO pdto=modelMapper.map(entity,ProductDTO.class);

//                pdto.setId(entity.getId());
//                pdto.setName(entity.getName());
//                pdto.setQuantity(entity.getQuantity());
//                pdto.setPrice(entity.getPrice());

                return pdto;
            }
        }
        return null;
    }

    //UPDATE
    public ProductDTO updateProduct(int id,ProductDTO dto){
        for(ProductEntity entity:productList){
            if(entity.getId()==id){
                entity.setName(dto.getName());
                entity.setPrice(dto.getPrice());
                entity.setQuantity(dto.getQuantity());

                return modelMapper.map(entity,ProductDTO.class);
            }
        }
        return null;
    }

    //DELETE
    public String deleteProduct(int id){
        for(ProductEntity entity :productList){
            if(entity.getId()==id){
                productList.remove(entity);
                return "Product Deleted";
            }
        }
        return "Product Not Found";
    }
}
