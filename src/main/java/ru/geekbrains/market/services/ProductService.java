package ru.geekbrains.market.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.market.entities.Product;
import ru.geekbrains.market.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> findAllByPriceBetween(int minPrice, int maxPrice){
        return productRepository.findAllByPriceBetween( minPrice, maxPrice);
    }

    public Integer getMaxPrice(){
        List<Product> products = productRepository.findAllByPriceGreaterThanOrderByPriceDesc(0);
        return products.get(0).getPrice();
    }

}
