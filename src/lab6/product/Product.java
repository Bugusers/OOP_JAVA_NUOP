package lab6.product;

import java.util.Objects;


public class Product {
    private String name;
    private String nameOfManufacturer;
    private int quantity;
    private double wholesalePrice;
    private double retailPrice;
    private int warrantyPeriod;

    public Product(String name, String nameOfManufacturer, int quantity,
                   double retailPrice, double wholesalePrice, int warrantyPeriod) {
        try {
            setName(name);
            setNameOfManufacturer(nameOfManufacturer);
            setQuantity(quantity);
            setRetailPrice(retailPrice);
            setWholesalePrice(wholesalePrice);
            setWarrantyPeriod(warrantyPeriod);
        } catch (IllegalArgumentException e) {
            System.err.println("Error by init product: " + e.getMessage());
        }
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name of the product.
     * @throws IllegalArgumentException if the name contains less than 3 characters.
     */
    public void setName(String name) throws IllegalArgumentException {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name contains less than 3 characters.");
        }
        this.name = name;
    }

    /**
     * Sets the name of the manufacturer.
     *
     * @param nameOfManufacturer The name of the manufacturer.
     * @throws IllegalArgumentException if the manufacturer's name contains less than 5 characters.
     */
    public void setNameOfManufacturer(String nameOfManufacturer) throws IllegalArgumentException {
        if (nameOfManufacturer.length() < 5) {
            throw new IllegalArgumentException("Manufacturer's name contains less than 5 characters.");
        }
        this.nameOfManufacturer = nameOfManufacturer;
    }

    /**
     * Sets the quantity of the product.
     *
     * @param quantity The quantity of the product.
     * @throws IllegalArgumentException if the quantity is negative.
     */
    public void setQuantity(int quantity) throws IllegalArgumentException {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    /**
     * Sets the wholesale price of the product.
     *
     * @param wholesalePrice The wholesale price of the product.
     * @throws IllegalArgumentException if the wholesale price is negative or greater than or equal to the retail price.
     */
    public void setWholesalePrice(double wholesalePrice) throws IllegalArgumentException {
        if (wholesalePrice < 0 || wholesalePrice >= retailPrice) {
            throw new IllegalArgumentException("Wholesale price cannot be negative or greater than or equal to the retail price.");
        }
        this.wholesalePrice = wholesalePrice;
    }

    /**
     * Sets the retail price of the product.
     *
     * @param retailPrice The retail price of the product.
     * @throws IllegalArgumentException if the retail price is not greater than zero.
     */
    public void setRetailPrice(double retailPrice) throws IllegalArgumentException {
        if (retailPrice <= 0) {
            throw new IllegalArgumentException("Retail price must be greater than zero.");
        }
        this.retailPrice = retailPrice;
    }

    /**
     * Sets the warranty period of the product.
     *
     * @param warrantyPeriod The warranty period of the product in months.
     * @throws IllegalArgumentException if the warranty period is less than 1 month.
     */
    public void setWarrantyPeriod(int warrantyPeriod) throws IllegalArgumentException {
        if (warrantyPeriod < 1) {
            throw new IllegalArgumentException("Warranty period must be at least 1 month.");
        }
        this.warrantyPeriod = warrantyPeriod;
    }

    /**
     * Displays information about the product.
     */
    public void displayInfo() {
        System.out.println("===============================");
        System.out.println(this);
        System.out.println("===============================");
    }


    @Override
    public String toString() {
        return "Product: " + '\n' +
                "Name of product: " + name + '\n' +
                "Name of manufacturer: " + nameOfManufacturer + '\n' +
                "Quantity: " + quantity + '\n' +
                "Wholesale price: " + wholesalePrice + '\n' +
                "Retail price: " + retailPrice + '\n' +
                "Warranty period: " + warrantyPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantity == product.quantity &&
                Double.compare(product.wholesalePrice, wholesalePrice) == 0 &&
                Double.compare(product.retailPrice, retailPrice) == 0 &&
                warrantyPeriod == product.warrantyPeriod &&
                Objects.equals(name, product.name) &&
                Objects.equals(nameOfManufacturer, product.nameOfManufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nameOfManufacturer, quantity, wholesalePrice, retailPrice, warrantyPeriod);
    }

    public String getName() {
        return name;
    }

    public String getNameOfManufacturer() {
        return nameOfManufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
}

