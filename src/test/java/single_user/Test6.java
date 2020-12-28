package single_user;

import com.spring.mvc.single_user.entities.User;
import com.spring.mvc.single_user.entities.UserView;
import com.spring.mvc.single_user.repository.UserRepository;
import com.spring.mvc.single_user.repository.UserViewRepository;
import java.util.Date;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

public class Test6 {

    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserViewRepository uvr = ctx.getBean(UserViewRepository.class);
        // 分頁
        int pageNo = 0;
        int pageSize = 10;
        // 排序
        Order order1 = new Order(Sort.Direction.ASC, "name");
        Order order2 = new Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order1, order2);
        // 分頁請求
        PageRequest pageRequest = new PageRequest(pageNo, pageSize, sort);
        Page<UserView> page = uvr.findAll(pageRequest);
        System.out.println(page.getContent()); // 得到分頁內容
        System.out.println((pageNo+1) + "/" + page.getTotalPages()); // 得到分頁內容
                
        
    }
}
