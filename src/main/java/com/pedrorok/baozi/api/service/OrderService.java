package com.pedrorok.baozi.api.service;

import com.pedrorok.baozi.api.model.Customer;
import com.pedrorok.baozi.api.model.Order;
import com.pedrorok.baozi.api.model.Product;
import com.pedrorok.baozi.api.repo.CustomerRepository;
import com.pedrorok.baozi.api.repo.OrderRepository;
import com.pedrorok.baozi.api.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order save(Long customerId, Long productId, Integer quantity) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);

        if (customer == null || product == null) {
            return null;
        }

        Order order = new Order(customer, product, quantity);
        return orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return orderRepository.existsById(id);
    }

    public Order update(Long id, Long customerId, Long productId, Integer quantity) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return null;
        }

        Customer customer = customerRepository.findById(customerId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);

        if (customer == null || product == null) {
            return null;
        }

        order.setCustomer(customer);
        order.setProduct(product);
        order.setQuantity(quantity);
        return orderRepository.save(order);
    }
}

