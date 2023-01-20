package com.example.demo.product;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String sku;
    private String name;
    private String category;
    private String description;
    private Double opinion;
    private boolean visible;

    public Product() {
    }

    public Product(String sku, String name, String category, String description, Double opinion, boolean visible) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.description = description;
        this.opinion = opinion;
        this.visible = visible;
    }

    public Product(Long id, String sku, String name, String category, String description, Double opinion, boolean visible) {
        this(sku, name, category, description, opinion,visible);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getOpinion() {
        return opinion;
    }

    public void setOpinion(Double opinion) {
        this.opinion = opinion;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", opinion=" + opinion +
                ", visible=" + visible +
                '}';
    }
}
