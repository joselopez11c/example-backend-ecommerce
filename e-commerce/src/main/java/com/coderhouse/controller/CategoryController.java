package com.coderhouse.controller;

import com.coderhouse.model.exceptions.ApiRestException;
import com.coderhouse.model.request.CategoryRequest;
import com.coderhouse.model.response.CategoryResponse;
import com.coderhouse.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coder-house")
public class CategoryController {

    private final CategoryService service;

    @PostMapping("/category")
    public CategoryResponse create(
            @Validated @RequestBody CategoryRequest request) throws ApiRestException {
        return service.create(request);
    }
}
