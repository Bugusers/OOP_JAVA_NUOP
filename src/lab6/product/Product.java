package lab6.product;

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
            System.err.println("An exception occurred during product initialization: " + e.getMessage());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameOfManufacturer(String nameOfManufacturer) {
        this.nameOfManufacturer = nameOfManufacturer;
    }


    public void setQuantity(int quantity) {
        try {
            if (quantity < 0) {
                throw new IllegalArgumentException("Quantity cannot be negative.");
            }
            this.quantity = quantity;
        } catch (IllegalArgumentException e) {
            System.err.println("An exception occurred while setting quantity: " + e.getMessage());
        }
    }

    public void setWholesalePrice(double wholesalePrice) {
        try {
            if (wholesalePrice < 0 || wholesalePrice >= retailPrice) {
                throw new IllegalArgumentException("Wholesale price cannot be negative.");
            }
            this.wholesalePrice = wholesalePrice;
        } catch (IllegalArgumentException e) {
            System.err.println("An exception occurred while setting wholesale price: " + e.getMessage());
        }
    }

    public void setRetailPrice(double retailPrice) {
        try {
            if (retailPrice <= 0) {
                throw new IllegalArgumentException("Retail price must be greater than zero.");
            }
            this.retailPrice = retailPrice;
        } catch (IllegalArgumentException e) {
            System.err.println("An exception occurred while setting retail price: " + e.getMessage());
        }
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        try {
            if (warrantyPeriod < 1) {
                throw new IllegalArgumentException("Warranty period must be at least 1 month.");
            }
            this.warrantyPeriod = warrantyPeriod;
        } catch (IllegalArgumentException e) {
            System.err.println("An exception occurred while setting warranty period: " + e.getMessage());
        }
    }

    public void displayInfo() {
        System.out.println("===============================");
        System.out.println(this);
        System.out.println("===============================");
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

    @Override
    public String toString() {
        return "Product: " + '\n' +
                "Name of product: " + name + '\n' +
                "Name of manufacturer: " + nameOfManufacturer + '\n' +
                "Quantity: " + quantity + '\n' +
                "Wholesale price: " + wholesalePrice + '\n' +
                "Retail price: " + retailPrice + '\n' +
                "Warranty period=" + warrantyPeriod;
    }
}

