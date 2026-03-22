package com.pedrorok.baozi.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 1, max = 100)
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Data de cadastro é obrigatória")
    @Column(name = "customer_since", nullable = false)
    private LocalDate customerSince;

    public Customer(String name, LocalDate customerSince) {
        this.name = name;
        this.customerSince = customerSince;
    }
}

