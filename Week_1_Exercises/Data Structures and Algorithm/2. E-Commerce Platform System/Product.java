import java.util.Arrays;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "ProductID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

class LinearSearch {
    public static Product search(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
}

class BinarySearch {
    public static Product search(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == productId) {
                return products[mid];
            }
            if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

public class ECommercePlatformSearch {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Table", "Furniture"),
            new Product(4, "Chair", "Furniture"),
            new Product(5, "Headphones", "Electronics")
        };

        // For binary search, we need a sorted array
        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        int searchId = 3;

        // Linear Search
        Product result = LinearSearch.search(products, searchId);
        System.out.println("Linear Search Result: " + (result != null ? result : "Product not found"));

        // Binary Search
        result = BinarySearch.search(products, searchId);
        System.out.println("Binary Search Result: " + (result != null ? result : "Product not found"));
    }
}
