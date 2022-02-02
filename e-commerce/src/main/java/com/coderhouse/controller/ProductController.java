package com.coderhouse.controller;

import com.coderhouse.model.exceptions.ApiRestException;
import com.coderhouse.model.request.ProductRequest;
import com.coderhouse.model.response.ProductResponse;
import com.coderhouse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coder-house")
public class ProductController {

    private final ProductService service;

    @PostMapping("/product")
    public ProductResponse create(
            @Validated @RequestBody ProductRequest product) throws ApiRestException {
        return service.create(product);
    }

    @PutMapping("/product/{id}")
    public ProductResponse update(@PathVariable String id,
                                         @Validated @RequestBody ProductRequest product) {
        return service.update(id, product);
    }

    @GetMapping("/product/all")
    public List<ProductResponse> search() {
        return service.searchAll();
    }

}
