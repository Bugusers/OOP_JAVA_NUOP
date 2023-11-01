package lab6.product;

import lab6.exceptions.DuplicateProductException;

import java.util.*;

public class ProductMultype implements List<Product> {
    private List<Product> products;

    public ProductMultype() {
        products = new ArrayList<>();
    }

    /**
     * Adds a product to the collection if a similar product doesn't already exist.
     *
     * @param product The product to be added.
     * @throws DuplicateProductException if a product with the same name and manufacturer already exists with a different warranty period.
     */
    public void addProduct(Product product) throws DuplicateProductException {
        for (Product p1 : products) {
            if (p1.getName().equals(product.getName()) &&
                    p1.getNameOfManufacturer().equals(product.getNameOfManufacturer())) {
                if (p1.getWarrantyPeriod() != product.getWarrantyPeriod()) {
                    throw new DuplicateProductException("An item with this name and manufacturer already exists");
                }
            }
        }
        products.add(product);
    }

    /**
     * Displays information about all the products in the collection.
     */
    public void displayProductMultype() {
        products.forEach(Product::displayInfo);
    }

    /**
     * Finds and returns the differences between this ProductMultype and another ProductMultype.
     *
     * @param productMultype The other ProductMultype to compare with.
     * @return A list of products representing the differences between the two ProductMultypes.
     */
    public List<Product> findDifferences(ProductMultype productMultype) {
        List<Product> differences = new ArrayList<>(products);
        differences.removeAll(productMultype.products);

        List<Product> combinedList = new ArrayList<>(productMultype.products);
        combinedList.removeAll(products);

        differences.addAll(combinedList);
        return differences;
    }

    /**
     * Sorts the products in the collection by warranty period in descending order.
     */
    public void sortProductsByWarrantyPeriodDescending() {
        Collections.sort(products, (p1, p2) -> Integer.compare(p2.getWarrantyPeriod(), p1.getWarrantyPeriod()));
    }

    @Override
    public int size() {
        return products.size();
    }

    @Override
    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return products.contains(o);
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    @Override
    public Object[] toArray() {
        return products.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return products.toArray(a);
    }
    @Override
    public boolean add(Product product) {
        // Add your implementation to add a product to the list
        return products.add(product);
    }

    @Override
    public boolean remove(Object o) {
        return products.remove(o);
    }

    @Override
    public Product get(int index) {
        return products.get(index);
    }

    @Override
    public Product set(int index, Product element) {
        return products.set(index, element);
    }

    @Override
    public void add(int index, Product element) {
        products.add(index, element);
    }

    @Override
    public Product remove(int index) {
        return products.remove(index);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return products.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Product> c) {
        return products.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Product> c) {
        return products.addAll(index, c);
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        return products.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return products.retainAll(c);
    }

    @Override
    public void clear() {
        removeAll(this);
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public List<Product> subList(int fromIndex, int toIndex) {
        return products.subList(fromIndex, toIndex);
    }

    @Override
    public ListIterator<Product> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Product> listIterator(int index) {
        return null;
    }
}
