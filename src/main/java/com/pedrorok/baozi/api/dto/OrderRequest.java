package com.pedrorok.baozi.api.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(
        @JsonProperty("clienteId")
        @JsonAlias("customerId")
        @NotNull(message = "ID do cliente é obrigatório")
        Long customerId,

        @JsonProperty("produtoId")
        @JsonAlias("productId")
        @NotNull(message = "ID do produto é obrigatório")
        Long productId,

        @JsonProperty("quantidade")
        @JsonAlias("quantity")
        @NotNull(message = "Quantidade é obrigatória")
        @Min(value = 1, message = "Quantidade deve ser pelo menos 1")
        Integer quantity
) {}
