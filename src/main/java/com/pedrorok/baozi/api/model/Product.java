package com.pedrorok.baozi.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("nome")
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 1, max = 100)
    @Column(nullable = false)
    private String name;

    @JsonProperty("preco")
    @NotNull(message = "Preço é obrigatório")
    @DecimalMin(value = "0.01", message = "Preço deve ser maior que zero")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @JsonProperty("estoque")
    @NotNull(message = "Estoque é obrigatório")
    @Column(nullable = false)
    private Boolean inStock;

    public Product(String name, BigDecimal price, Boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }
}

