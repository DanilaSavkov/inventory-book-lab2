package bsuir.ppvis.model;

import bsuir.ppvis.model.decomposition.*;
import javafx.collections.FXCollections;

import java.util.List;

public class InventoryBookModel {
    private List<Record> records;
    private final FabricatorPool fabricatorPool;
    private final StoragePool storagePool; // плохо работает

    public InventoryBookModel() {
        this.records = FXCollections.observableArrayList();
        this.fabricatorPool = new FabricatorPool();
        this.storagePool = new StoragePool();
    }

    public InventoryBookModel(InventoryBookModel model) {
        this.records = FXCollections.observableArrayList();
        this.fabricatorPool = new FabricatorPool();
        this.storagePool = new StoragePool();
        for (Record record : model.records) {
            add(record);
        }
    }

    public List<Record> getRecords() {
        return records;
    }

    public FabricatorPool getFabricatorPool() {
        return fabricatorPool;
    }

    public StoragePool getStoragePool() {
        return storagePool;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public void add(Record record) {
        records.add(record);
        fabricatorPool.add(record.getProduct().getFabricator());
        storagePool.add(record.getStorage());
    }

    public void remove(Record record) {
        records.remove(record);
    }
}