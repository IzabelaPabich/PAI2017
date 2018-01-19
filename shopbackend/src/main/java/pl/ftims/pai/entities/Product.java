package pl.ftims.pai.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;

    private String description;

    private String color;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductType productType;

    public Product() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
