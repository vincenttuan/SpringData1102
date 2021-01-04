package com.spring.mvc.psi.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    
    @Column(name = "image", columnDefinition = "clob") // clob 大字串, blob 大二進位
    @Lob
    private String image; // base64 String for image
    
    @OneToMany(mappedBy = "product")
    private List<Purchase> purchases = new ArrayList<>();
    
    @OneToMany(mappedBy = "product")
    private List<Sales> saleses = new ArrayList<>();
    
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

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public List<Sales> getSaleses() {
        return saleses;
    }

    public void setSaleses(List<Sales> saleses) {
        this.saleses = saleses;
    }
    
    
}
