package com.spring.mvc.psi.controller;

import com.spring.mvc.psi.entities.Product;
import com.spring.mvc.psi.repository.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/psi")
public class PSIController {
    
    @Autowired
    private ProductRepository pr;
    
    // 讀取商品資料
    @GetMapping(value = {"/product", "/product/{id}", "/product/{delete}/{id}"})
    public String readProduct(Model model,
            @RequestParam Optional<Boolean> deleteError,
            @PathVariable Optional<Integer> id,
            @PathVariable Optional<String> delete) {
        Product product = new Product();
        String _method = "POST";
        if(id.isPresent()) {
            product = pr.findOne(id.get());
            if(delete.isPresent() && delete.get().equals("delete")) {
                _method = "DELETE";
            } else {
                _method = "PUT";
            }
        }
        model.addAttribute("_method", _method);
        model.addAttribute("product", product);
        model.addAttribute("products", pr.findAll());
        model.addAttribute("deleteError", deleteError.isPresent()?"刪除失敗":"");
        return "psi/product";
    }
    
    // 新增商品
    @PostMapping(value = {"/product"})
    public String createProduct(@ModelAttribute("product") Product product) {
        pr.saveAndFlush(product);
        return "redirect: ../psi/product";
    }
    
    // 修改商品
    @PutMapping(value = {"/product"})
    public String updateProduct(@ModelAttribute("product") Product product) {
        pr.saveAndFlush(product);
        return "redirect: ../psi/product";
    }
    
    // 刪除商品
    @DeleteMapping(value = {"/product"})
    public String deleteProduct(@ModelAttribute("product") Product product) {
        try {
            pr.delete(product.getId());
        } catch (Exception e) {
            return "redirect: ../psi/product?deleteError=true";
        }
        return "redirect: ../psi/product";
    }
    
}
