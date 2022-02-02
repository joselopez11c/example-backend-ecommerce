package com.coderhouse.repository;

import com.coderhouse.model.document.Category;
import com.coderhouse.model.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findByCode(String code);
}
