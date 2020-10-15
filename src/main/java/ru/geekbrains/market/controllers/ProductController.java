package ru.geekbrains.market.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.market.entities.Product;
import ru.geekbrains.market.services.ProductService;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public String productList(Model model, @RequestParam(defaultValue = "0", name = "min") int minPrice, @RequestParam(defaultValue = "0", name = "max") int maxPrice  ){
        if (maxPrice == 0) {
            maxPrice = productService.getMaxPrice();
        }
        model.addAttribute( "products", productService.findAllByPriceBetween(minPrice, maxPrice) );
        return "products";
    }
}
