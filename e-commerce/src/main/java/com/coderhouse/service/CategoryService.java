package com.coderhouse.service;

import com.coderhouse.model.exceptions.ApiRestException;
import com.coderhouse.model.request.CategoryRequest;
import com.coderhouse.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse create(CategoryRequest category) throws ApiRestException;

    CategoryResponse update(String id, CategoryRequest category);

    List<CategoryResponse> searchAll();
}
