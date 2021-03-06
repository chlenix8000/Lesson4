package ru.geekbrains.Lesson4.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.Lesson4.entities.Product;
import ru.geekbrains.Lesson4.repositiry.CartRepository;

import java.util.List;

@RequestMapping("/rest/cart")
@RestController
public class CartRestController {
    CartRepository cartRepository;


    public CartRestController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {return cartRepository.getCart();}

    @PostMapping
    public Product addProduct (@RequestBody Product product) {
        cartRepository.addToCart(product);
        return product;}

    @DeleteMapping()
    public int deleteProduct () {cartRepository.deleteFromCart(); return HttpStatus.OK.value();}

}
