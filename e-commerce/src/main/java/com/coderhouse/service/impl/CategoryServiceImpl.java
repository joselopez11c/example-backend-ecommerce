package com.coderhouse.service.impl;

import com.coderhouse.builder.CategoryBuilder;
import com.coderhouse.model.exceptions.ApiRestException;
import com.coderhouse.model.request.CategoryRequest;
import com.coderhouse.model.response.CategoryResponse;
import com.coderhouse.repository.CategoryRepository;
import com.coderhouse.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public CategoryResponse create(CategoryRequest request) throws ApiRestException {
        validateRequestCreate(request);
        var document = repository.save(CategoryBuilder.requestToDocument(request));
        return CategoryBuilder.documentToResponse(document);
    }

    @Override
    public CategoryResponse update(String id, CategoryRequest category) {
        return null;
    }

    @Override
    public List<CategoryResponse> searchAll() {
        return null;
    }

    private void validateRequestCreate(CategoryRequest request) throws ApiRestException {
        var category = repository.findByCode(request.getCode());
        if (!Objects.isNull(category)) {
            throw new ApiRestException("La categoria ya existe");
        }
    }
}
