package ma.enset.studentsapp.web;

import ma.enset.studentsapp.entities.Product;
import ma.enset.studentsapp.repository.PoductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class ProductRestService {
    @Autowired
    private PoductRepository poductRepository;
    @GetMapping("/products")
   public List<Product>products(){
       return poductRepository.findAll();
   }
    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable Long id){
        Product product = poductRepository.findById(id).orElse(null);
        return product;
    }

}