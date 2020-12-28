package single_user;

import com.spring.mvc.single_user.entities.User;
import com.spring.mvc.single_user.repository.UserRepository;
import java.util.Date;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserRepository ur = ctx.getBean(UserRepository.class);
        
        User user = new User();
        user.setName("Vincent");
        user.setEmail("vin@gmail.com");
        user.setBirth(new Date());
        
        //ur.saveAndFlush(user); // 及時儲存
        ur.save(user); // 方法結束(commit)後才儲存
        
    }
}
