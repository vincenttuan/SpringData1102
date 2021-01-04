package psi;

import com.spring.mvc.psi.entities.Inventory;
import com.spring.mvc.psi.entities.Product;
import com.spring.mvc.psi.entities.Purchase;
import com.spring.mvc.psi.entities.Sales;
import com.spring.mvc.psi.repository.InventoryRepository;
import com.spring.mvc.psi.repository.ProductRepository;
import com.spring.mvc.psi.repository.PurchaseRepository;
import com.spring.mvc.psi.repository.SalesRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    @Test
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-jpa-config.xml");
        InventoryRepository ir = ctx.getBean(InventoryRepository.class);
        
        List<Inventory> inventories = ir.findAll();
        System.out.println(inventories);
                
        
        ctx.close();
    }
}
