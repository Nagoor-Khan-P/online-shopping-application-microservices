package com.nagoorkhan.productservice.repository;

import com.nagoorkhan.productservice.model.business.ProductVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductVO, String> {
}
