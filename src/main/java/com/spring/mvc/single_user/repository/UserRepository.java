package com.spring.mvc.single_user.repository;

import com.spring.mvc.single_user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
<User, Long> -> User 指的是Entity的類別名, Long 指的是 @Id 的資料型別
*/
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
