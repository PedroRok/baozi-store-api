package com.pedrorok.baozi.api.controller;

import com.pedrorok.baozi.api.dto.OrderRequest;
import com.pedrorok.baozi.api.model.Order;
import com.pedrorok.baozi.api.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/orders", "/pedidos"})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody OrderRequest request) {
        Order saved = orderService.save(request.customerId(), request.productId(), request.quantity());
        if (saved != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        }
        return ResponseEntity.badRequest()
                .body("Cliente ou produto não encontrado. Verifique os IDs informados.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!orderService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody OrderRequest request) {
        Order order = orderService.update(id, request.customerId(), request.productId(), request.quantity());
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.badRequest()
                .body("Pedido, cliente ou produto não encontrado. Verifique os IDs informados.");
    }
}

