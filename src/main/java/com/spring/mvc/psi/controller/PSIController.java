package com.spring.mvc.psi.controller;
import com.spring.mvc.psi.entities.Product;
import com.spring.mvc.psi.entities.Purchase;
import com.spring.mvc.psi.repository.Inventory2Repository;
import com.spring.mvc.psi.repository.InventoryRepository;
import com.spring.mvc.psi.repository.ProductRepository;
import com.spring.mvc.psi.repository.PurchaseRepository;
import com.spring.mvc.psi.repository.SalesRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/psi")
public class PSIController {
    
    @Autowired
    private ProductRepository pr;
    
    @Autowired
    private InventoryRepository ir;
    
    @Autowired
    private Inventory2Repository ir2;
    
    @Autowired
    private PurchaseRepository ur;
    
    @Autowired
    private SalesRepository sr;
    
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
    
    // 讀取庫存
    @GetMapping(value = {"/inventory"})
    public String readInventory(Model model) {
        model.addAttribute("inventories", ir.findAll());
        model.addAttribute("inventories2", ir2.findAll());
        return "psi/inventory";
    }
    
    // 讀取進貨
    @GetMapping(value = {"/purchase"})
    public String readPurchase(Model model) {
        model.addAttribute("purchases", ur.findAll());
        model.addAttribute("inventories2", ir2.findAll());
        return "psi/purchase";
    }
    
    @PostMapping(value = {"/purchase"},
                 consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createPurchase(@RequestBody MultiValueMap<String, String> map) {
        Integer pid = Integer.parseInt(map.getFirst("pid"));
        Integer quantity = Integer.parseInt(map.getFirst("quantity"));
        Integer price = Integer.parseInt(map.getFirst("price"));
        Purchase purchase = new Purchase();
        purchase.setProduct(pr.findOne(pid));
        purchase.setPrice(price);
        purchase.setQuantity(quantity);
        ur.saveAndFlush(purchase);
        return "redirect: ../psi/purchase";
    }
    
    // 讀取銷貨
    @GetMapping(value = {"/sales"})
    public String readSales(Model model) {
        model.addAttribute("sales", sr.findAll());
        model.addAttribute("inventories2", ir2.findAll());
        return "psi/sales";
    }
    
}
