package bsuir.ppvis.model.decomposition;

import bsuir.ppvis.model.exceptions.ProductNotFoundException;

public class Record {
    private String productName;
    private String fabricatorName;
    private int fabricatorPayerAccountNumber;
    private String productCountOnStorage;
    private String storageAddress;

    public Record(Product product, Storage storage) {
        this.productName = product.getName();
        this.fabricatorName = product.getFabricator().getName();
        this.fabricatorPayerAccountNumber = product.getFabricator().getPayerAccountNumber();
        try {
            int count = storage.getProductCount(product);
            this.productCountOnStorage = String.valueOf(count);
        } catch (ProductNotFoundException e) {
            this.productCountOnStorage = "нет на складе";
        }
        this.storageAddress = storage.getAddress();
    }

    @Override
    public String toString() {
        return "Record{" +
                "productName='" + productName + '\'' +
                ", fabricatorName='" + fabricatorName + '\'' +
                ", fabricatorPayerAccountNumber=" + fabricatorPayerAccountNumber +
                ", productCountOnStorage='" + productCountOnStorage + '\'' +
                ", storageAddress='" + storageAddress + '\'' +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public String getFabricatorName() {
        return fabricatorName;
    }

    public int getFabricatorPayerAccountNumber() {
        return fabricatorPayerAccountNumber;
    }

    public String getProductCountOnStorage() {
        return productCountOnStorage;
    }

    public String getStorageAddress() {
        return storageAddress;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setFabricatorName(String fabricatorName) {
        this.fabricatorName = fabricatorName;
    }

    public void setFabricatorPayerAccountNumber(int fabricatorPayerAccountNumber) {
        this.fabricatorPayerAccountNumber = fabricatorPayerAccountNumber;
    }

    public void setProductCountOnStorage(String productCountOnStorage) {
        this.productCountOnStorage = productCountOnStorage;
    }

    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }
}
