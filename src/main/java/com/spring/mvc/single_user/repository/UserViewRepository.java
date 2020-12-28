package com.spring.mvc.single_user.repository;

import com.spring.mvc.single_user.entities.UserView;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserViewRepository extends JpaRepository<UserView, Long>{
    
}
