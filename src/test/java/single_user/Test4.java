package single_user;

import com.spring.mvc.single_user.entities.User;
import com.spring.mvc.single_user.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {

    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserRepository ur = ctx.getBean(UserRepository.class);
        
        User user = ur.getByName("Anita");
        System.out.println(user);
        
        List<User> users = ur.getByNameStartingWithAndIdLessThan("S", 100L);
        System.out.println(users);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            users = ur.getByIdInOrBirthLessThanEqual(Arrays.asList(2L, 4L, 8L, 16L), 
                                                     sdf.parse("2000-12-31"));
            System.out.println(users);
        } catch (Exception e) {
            System.out.println("Date Error !");
        }
        
        users = ur.getByAgeLessThan(20);
        System.out.println(users);
        
        Long totalCount = ur.getTotalCount();
        System.out.println(totalCount);
    }
}
