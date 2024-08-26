@PostMapping("/register")
public ResponseEntity<Customer> registerCustomer(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String password) {
    Customer customer = new Customer(name, email, password);
    Customer savedCustomer = customerRepository.save(customer);
    return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
}
