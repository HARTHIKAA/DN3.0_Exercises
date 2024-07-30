public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository repository = new CustomerRepositoryImpl();
        
        // Inject the repository into the service
        CustomerService service = new CustomerService(repository);
        
        // Use the service to find and display a customer
        service.displayCustomer("12345");
    }
}
