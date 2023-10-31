package lab6.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductMultype {
    private List<Product> products;

    public ProductMultype() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProductMultype() {
        products.forEach(Product::displayInfo);
    }

    public List<Product> findDifference(ProductMultype productMultype) {
        List<Product> difference = new ArrayList<>(products);
        difference.removeAll(productMultype.products);
        return difference;
    }
    public void sortProductsByWarrantyPeriodDescending() {
        Collections.sort(products, (p1, p2) -> Integer.compare(p2.getWarrantyPeriod(), p1.getWarrantyPeriod()));
    }
}
