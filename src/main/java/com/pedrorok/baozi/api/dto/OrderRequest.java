package com.pedrorok.baozi.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(
        @NotNull(message = "ID do cliente é obrigatório")
        Long customerId,

        @NotNull(message = "ID do produto é obrigatório")
        Long productId,

        @NotNull(message = "Quantidade é obrigatória")
        @Min(value = 1, message = "Quantidade deve ser pelo menos 1")
        Integer quantity
) {}

