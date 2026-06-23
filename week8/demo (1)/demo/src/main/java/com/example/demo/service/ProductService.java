package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // 생성자 주입 방식을 사용해 Repository를 주입받습니다.
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // C: 상품 생성 (저장)
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // R: 전체 상품 조회
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // R: 특정 상품 단건 조회
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. ID: " + id));
    }

    // U: 상품 수정
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProductById(id);
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        return productRepository.save(product); //변경사항이 DB에 반영됩니다.
    }

    // D: 상품 삭제
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}