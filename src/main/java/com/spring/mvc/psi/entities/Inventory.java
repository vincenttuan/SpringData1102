package com.spring.mvc.psi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "INVENTORY")
public class Inventory {
    @Id
    private Integer id;
    
    @Column
    private String name;
    
    @Column(name = "image", columnDefinition = "clob")
    @Lob
    private String image;
    
    @Column(name = "PU_QTY")
    private Integer puQty;
    
    @Column(name = "PU_TOTAL")
    private Integer puTotal;
    
    @Column(name = "SA_QTY")
    private Integer saQty;
    
    @Column(name = "SA_TOTAL")
    private Integer saTotal;

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

    public Integer getPuQty() {
        return puQty;
    }

    public void setPuQty(Integer puQty) {
        this.puQty = puQty;
    }

    public Integer getPuTotal() {
        return puTotal;
    }

    public void setPuTotal(Integer puTotal) {
        this.puTotal = puTotal;
    }

    public Integer getSaQty() {
        return saQty;
    }

    public void setSaQty(Integer saQty) {
        this.saQty = saQty;
    }

    public Integer getSaTotal() {
        return saTotal;
    }

    public void setSaTotal(Integer saTotal) {
        this.saTotal = saTotal;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
    
}
