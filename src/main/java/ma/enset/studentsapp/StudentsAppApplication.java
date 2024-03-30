package ma.enset.studentsapp;

import ma.enset.studentsapp.entities.Product;
import ma.enset.studentsapp.repository.PoductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StudentsAppApplication implements CommandLineRunner {
    @Autowired
    private PoductRepository poductRepository;
    public static void main(String[] args) {

        SpringApplication.run(StudentsAppApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
         poductRepository.save(new Product(null,"Computer",4300,3));
        poductRepository.save(new Product(null,"Printer",1200,4));
        poductRepository.save(new Product(null,"Smart Phone",3200,32));
        List<Product> products = poductRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product=poductRepository.findById(Long.valueOf(1)).get();
        System.out.println("************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("************");
        System.out.println("---------------");
        List<Product> productList =poductRepository.findByNameContains("C");
        productList.forEach(p->{
            System.out.println(p);
        });
        System.out.println("...............");
        List<Product> productList2 =poductRepository.search("%C%");
        productList.forEach(p->{
            System.out.println(p);
        });
        System.out.println("...............");
        List<Product> productList3 =poductRepository.searchByPrice(3000);
        productList.forEach(p->{
            System.out.println(p);
        });
    }

}
