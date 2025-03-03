package com.example.faveFood.faveFood;

import jakarta.persistence.*;

@Entity
@Table
public class Food {
    @Id
    @SequenceGenerator(
            name = "food_sequence",
            sequenceName = "food_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "food_sequence"
    )
    private Long id;
    private String name;
    private String origin;
    private String type;
    private Integer price;

    public Food() {
    }

    public Food(Long id, String name, String origin, String type, Integer price) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.type = type;
        this.price = price;
    }

    public Food(String name, String origin, String type, Integer price) {
        this.name = name;
        this.origin = origin;
        this.type = type;
        this.price = price;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
