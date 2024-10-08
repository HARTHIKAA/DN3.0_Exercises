import java.util.HashMap;
class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: " + price;
    }
}

class Inventory {
    private HashMap<Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, String productName, Integer quantity, Double price) {
        Product product = products.get(productId);
        if (product != null) {
            if (productName != null) {
                product.setProductName(productName);
            }
            if (quantity != null) {
                product.setQuantity(quantity);
            }
            if (price != null) {
                product.setPrice(price);
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (products.remove(productId) == null) {
            System.out.println("Product not found.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products.values()) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Product product1 = new Product(1, "Laptop", 10, 999.99);
        Product product2 = new Product(2, "Smartphone", 20, 499.99);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        System.out.println("Initial Inventory:");
        System.out.println(inventory);

        inventory.updateProduct(1, null, 15, 950.00);
        System.out.println("\nInventory after updating product 1:");
        System.out.println(inventory);

        inventory.deleteProduct(2);
        System.out.println("\nInventory after deleting product 2:");
        System.out.println(inventory);
    }
}
