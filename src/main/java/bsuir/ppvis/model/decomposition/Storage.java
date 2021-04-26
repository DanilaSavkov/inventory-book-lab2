package bsuir.ppvis.model.decomposition;

import bsuir.ppvis.model.exceptions.IllegalProductAmountException;
import bsuir.ppvis.model.exceptions.ProductNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final String address;
    private final Map<Product, Integer> register = new HashMap<>();

    public Storage(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Map<Product, Integer> getRegister() {
        return register;
    }

    public void add(Product product, int count) {
        if (register.containsKey(product)) {
            int currentCount = register.get(product);
            register.put(product, currentCount + count);
        } else this.register.put(product, count);
    }

    public void remove(Product product, int count) throws IllegalProductAmountException, ProductNotFoundException {
        if (register.containsKey(product)) {
            int currentCount = register.get(product);
            if (count > currentCount) throw new IllegalProductAmountException();
            else if (count == currentCount) remove(product);
            else register.put(product, currentCount - count);
        } else throw new ProductNotFoundException();
    }

    public void remove(Product product) throws ProductNotFoundException {
        if (register.containsKey(product)) register.remove(product);
        else throw new ProductNotFoundException();
    }

    public int getProductCount(Product product) throws ProductNotFoundException {
        if (register.containsKey(product)) {
            return register.get(product);
        } else throw new ProductNotFoundException();
    }
}