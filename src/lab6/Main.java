package lab6;


import lab6.exceptions.DuplicateProductException;
import lab6.product.Product;
import lab6.product.ProductMultype;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductMultype products = new ProductMultype();

        try {
            products.addProduct(new Product("Product 1", "Manufacturer 1", 10, 19.99, 14.99, 12));
            products.addProduct(new Product("Product 2", "Manufacturer 2", 15, 29.99, 22.99, 18));
            products.addProduct(new Product("Product 3", "Manufacturer 3", 8, 9.99, 7.99, 6));
            products.addProduct(new Product("Product 4", "Manufacturer 4", 20, 39.99, 32.99, 24));
        } catch (DuplicateProductException e) {
            System.err.println("An exception error: " + e.getMessage());
        }

        products.displayProductMultype();

        System.out.println("Sorting by decreasing warranty period.....");
        products.sortProductsByWarrantyPeriodDescending();

        products.displayProductMultype();

        ProductMultype products1 = new ProductMultype();
        try {
            products1.addProduct(new Product("Product 1", "Manufacturer 1", 10, 19.99, 14.99, 12));
            products1.addProduct(new Product("Product 2", "Manufacturer 2", 15, 29.99, 22.99, 18));
            products1.addProduct(new Product("Product 6", "Manufacturer 6", 12, 14.99, 11.99, 9));
            products1.addProduct(new Product("Product 7", "Manufacturer 7", 7, 24.99, 19.99, 15));
        } catch (DuplicateProductException e) {
            System.err.println("An exception error: " + e.getMessage());
        }

        List<Product> difference = products.findDifferences(products1);

        System.out.println("Difference:");
        for (Product product : difference) {
            System.out.println(product.getName() + " - " + product.getNameOfManufacturer());
        }
    }

}
