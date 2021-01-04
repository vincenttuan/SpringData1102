package psi;

import com.spring.mvc.psi.entities.Product;
import com.spring.mvc.psi.repository.ProductRepository;
import com.spring.mvc.psi.repository.PurchaseRepository;
import com.spring.mvc.psi.repository.SalesRepository;
import java.util.Arrays;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-jpa-config.xml");
        ProductRepository pr = ctx.getBean(ProductRepository.class);
        PurchaseRepository ur = ctx.getBean(PurchaseRepository.class);
        SalesRepository sr = ctx.getBean(SalesRepository.class);
        Product p1 = new Product();
        p1.setName("Apple");
        Product p2 = new Product();
        p2.setName("Orange");
        Product p3 = new Product();
        p3.setName("Mango");
        pr.save(Arrays.asList(p1, p2, p3));
        
        System.out.println("OK");
        
    }
}
