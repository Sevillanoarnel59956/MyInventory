package MyModel;

import javax.swing.ImageIcon;





import javax.swing.ImageIcon; // Correctly formatted import

public class Product {
    private String name;
    private String price;
    private String quantity;
    private ImageIcon image;

    // Constructor with parameters to initialize the Product object
    public Product(String name, String price, String quantity, ImageIcon image) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    // Default constructor
    public Product() {
        // You can initialize fields with default values if needed
        this.name = "";
        this.price = "";
        this.quantity = "";
        this.image = null;
    }

    // Getter methods to access private fields
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public ImageIcon getImage() {
        return image;
    }
}
