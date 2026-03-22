package com.pedrorok.baozi.api.service;

import com.pedrorok.baozi.api.model.Customer;
import com.pedrorok.baozi.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return customerRepository.existsById(id);
    }
}

