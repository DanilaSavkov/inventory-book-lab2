package bsuir.ppvis.model.decomposition;

import bsuir.ppvis.model.exceptions.ProductNotFoundException;

public class Record {
    private String productCountOnStorage;
    private final Product product;
    private final Storage storage;

    public Record(Product product, Storage storage) {
        this.product = product;
        this.storage = storage;
        try {
            int count = storage.getProductCount(product);
            this.productCountOnStorage = String.valueOf(count);
        } catch (ProductNotFoundException e) {
            this.productCountOnStorage = "нет на складе";
        }
    }

    public Product getProduct() {
        return product;
    }

    public Storage getStorage() {
        return storage;
    }

    public String getProductName() {
        return product.getName();
    }

    public String getFabricatorName() {
        return product.getFabricator().getName();
    }

    public int getFabricatorPayerAccountNumber() {
        return product.getFabricator().getPayerAccountNumber();
    }

    public String getProductCountOnStorage() {
        return productCountOnStorage;
    }

    public String getStorageAddress() {
        return storage.getAddress();
    }
}