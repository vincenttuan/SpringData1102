package com.spring.mvc.single_user.repository;

import com.spring.mvc.single_user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
只需定義 interface 的規格, 實作內容是由 SpringData 幫你做
<User, Long> -> User 指的是Entity的類別名, Long 指的是 @Id 的資料型別
方法命名規則：https://blog.csdn.net/sbin456/article/details/53304148
*/
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    // 根據 name 來取得 User
    User getByName(String name);
}
