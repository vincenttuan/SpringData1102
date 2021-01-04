package psi;

import com.spring.mvc.psi.entities.Product;
import com.spring.mvc.psi.entities.Purchase;
import com.spring.mvc.psi.entities.Sales;
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
        // 新增商品
//        Product p1 = new Product();
//        p1.setName("Apple");
//        Product p2 = new Product();
//        p2.setName("Orange");
//        Product p3 = new Product();
//        p3.setName("Mango");
//        pr.save(Arrays.asList(p1, p2, p3));
        
        // 買進商品
        Product p1 = pr.findOne(1);
        Product p2 = pr.findOne(2);
        Product p3 = pr.findOne(3);
//        Purchase u1 = new Purchase(10, 20, p1); // price, quantity, product
//        Purchase u2 = new Purchase(15, 25, p2);
//        Purchase u3 = new Purchase(20, 30, p3);
//        Purchase u4 = new Purchase(15, 30, p1);
//        Purchase u5 = new Purchase(20, 10, p2);
//        ur.save(Arrays.asList(u1, u2, u3, u4, u5));
        // 賣出商品
        Sales s1 = new Sales(50, 20, p1);
        Sales s2 = new Sales(70, 10, p2);
        Sales s3 = new Sales(100, 20, p3);
        Sales s4 = new Sales(120, 10, p3);
        Sales s5 = new Sales(50, 10, p1);
        sr.save(Arrays.asList(s1, s2, s3, s4, s5));
        System.out.println("OK");
        
    }
}
