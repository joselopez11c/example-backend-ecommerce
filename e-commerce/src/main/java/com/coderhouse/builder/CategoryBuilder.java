package com.coderhouse.builder;

import com.coderhouse.model.document.Category;
import com.coderhouse.model.request.CategoryRequest;
import com.coderhouse.model.response.CategoryResponse;

import java.time.LocalDateTime;

public class CategoryBuilder {
    public static Category requestToDocument(CategoryRequest category) {
        return Category.builder()
                .code(category.getCode())
                .description(category.getDescription())
                .creationDate(LocalDateTime.now())
                .status(Boolean.TRUE)
                .build();
    }

    public static CategoryResponse documentToResponse(Category category) {
        return CategoryResponse.builder()
                .code(category.getCode())
                .description(category.getDescription())
                .status(category.isStatus())
                .creationDate(category.getCreationDate())
                .modificationDate(category.getModificationDate())
                .build();
    }
}
