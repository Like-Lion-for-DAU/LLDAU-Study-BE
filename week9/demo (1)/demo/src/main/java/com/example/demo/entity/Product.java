package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 이 클래스가 데이터베이스 테이블과 매핑되는 엔티티임을 선언합니다.
public class Product {

    @Id // 테이블의 기본키(Primary Key)를 지정합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL의 auto_increment를 사용해 id를 자동 생성합니다.
    private Long id;

    private String name;
    private int price;

    // JPA를 위해 반드시 필요한 기본 생성자
    public Product() {}

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Getter 및 Setter (또는 Lombok의 @Getter, @Setter 사용 가능)
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
