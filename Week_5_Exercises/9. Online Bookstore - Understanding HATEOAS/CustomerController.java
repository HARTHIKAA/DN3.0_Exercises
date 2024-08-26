package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.CustomerDTO;
import com.example.bookstoreapi.model.Customer;
import com.example.bookstoreapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Create a new customer
    @PostMapping
    public ResponseEntity<EntityModel<Customer>> createCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);

        EntityModel<Customer> resource = EntityModel.of(savedCustomer);
        resource.add(linkTo(methodOn(CustomerController.class).getCustomerById(savedCustomer.getId())).withSelfRel());
        resource.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("all-customers"));

        return ResponseEntity.ok(resource);
    }

    // Read all customers
    @GetMapping
    public List<EntityModel<Customer>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> EntityModel.of(customer)
                        .add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel())
                        .add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("all-customers")))
                .collect(Collectors.toList());
    }

    // Read a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Customer>> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (!customerOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Customer customer = customerOptional.get();
        EntityModel<Customer> resource = EntityModel.of(customer);
        resource.add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel());
        resource.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("all-customers"));

        return ResponseEntity.ok(resource);
    }

    // Update a customer
    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Customer>> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (!customerOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Customer customer = customerOptional.get();
        customer.updateFromDTO(customerDTO);
        Customer updatedCustomer = customerRepository.save(customer);

        EntityModel<Customer> resource = EntityModel.of(updatedCustomer);
        resource.add(linkTo(methodOn(CustomerController.class).getCustomerById(updatedCustomer.getId())).withSelfRel());
        resource.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("all-customers"));

        return ResponseEntity.ok(resource);
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        if (!customerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        customerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
