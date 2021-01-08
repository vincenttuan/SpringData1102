package com.spring.mvc.psi.controller;

import com.spring.mvc.psi.entities.Product;
import com.spring.mvc.psi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/psi")
public class PSIController {
    
    @Autowired
    private ProductRepository pr;
    
    // 讀取商品資料
    @GetMapping(value = {"/product"})
    public String readProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "psi/product";
    }
    
    // 新增商品
    @PostMapping(value = {"/product"})
    public String createProduct(@ModelAttribute("product") Product product) {
        pr.saveAndFlush(product);
        return "redirect: ../psi/product";
    }
    
}
