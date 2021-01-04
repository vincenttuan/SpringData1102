package com.spring.mvc.psi.repository;

import com.spring.mvc.psi.entities.Inventory;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
    
}
