package com.coderhouse.service.impl;

import com.coderhouse.builder.ProductBuilder;
import com.coderhouse.model.exceptions.ApiRestException;
import com.coderhouse.model.request.ProductRequest;
import com.coderhouse.model.response.ProductResponse;
import com.coderhouse.repository.CategoryRepository;
import com.coderhouse.repository.ProductRepository;
import com.coderhouse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponse create(ProductRequest request) throws ApiRestException {
        validateRequestCreate(request);
        var document = productRepository.save(ProductBuilder.requestToDocumentCreate(request));
        return ProductBuilder.documentToResponseCreate(document);
    }

    @Override
    public ProductResponse update(String id, ProductRequest request) {
        return null;
    }

    @Override
    public List<ProductResponse> searchAll() {
        return null;
    }

    private void validateRequestCreate(ProductRequest request) throws ApiRestException {
        var category = categoryRepository.findByCode(request.getCategory().getCode());
        var product = productRepository.findByCode(request.getCode());

        if (Objects.isNull(category)) {
            throw new ApiRestException("La categoria no existe");
        }
        if (!Objects.isNull(product)) {
            throw new ApiRestException("El producto ya existe");
        }
    }

}
