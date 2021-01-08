package com.spring.mvc.psi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/psi")
public class PSIController {
    
    // 讀取商品資料
    @GetMapping(value = {"/product"})
    public String readProduct() {
        return "psi/product";
    }
    
}
