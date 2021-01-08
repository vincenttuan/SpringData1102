package com.spring.mvc.psi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "INVENTORY2")
public class Inventory2 {
    @Id
    private Integer id;
    
    @Column
    private String name;
    
    @Column(name = "image", columnDefinition="clob")
    @Lob
    private String image;
    
    @Column(name = "QTY")
    private Integer qty;
    
    @Column(name = "PU_COST")
    private Integer puCost;
    
    @Column(name = "SA_COST")
    private Integer saCost;
    
    @Column(name = "PRICE1")
    private Integer price1;
    
    @Column(name = "PRICE2")
    private Integer price2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPuCost() {
        return puCost;
    }

    public void setPuCost(Integer puCost) {
        this.puCost = puCost;
    }

    public Integer getSaCost() {
        return saCost;
    }

    public void setSaCost(Integer saCost) {
        this.saCost = saCost;
    }

    public Integer getPrice1() {
        return price1;
    }

    public void setPrice1(Integer price1) {
        this.price1 = price1;
    }

    public Integer getPrice2() {
        return price2;
    }

    public void setPrice2(Integer price2) {
        this.price2 = price2;
    }

    
}