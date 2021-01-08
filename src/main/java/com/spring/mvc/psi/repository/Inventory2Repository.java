package com.spring.mvc.psi.repository;

import com.spring.mvc.psi.entities.Inventory2;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Inventory2Repository extends JpaRepository<Inventory2, Integer>{
    
}
