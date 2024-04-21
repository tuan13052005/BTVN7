package com.tn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category",uniqueConstraints = @UniqueConstraint(columnNames = "category"))
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String category;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
