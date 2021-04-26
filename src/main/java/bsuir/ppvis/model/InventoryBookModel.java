package bsuir.ppvis.model;

import bsuir.ppvis.model.decomposition.Record;

import java.util.ArrayList;
import java.util.List;

public class InventoryBookModel {
    private final List<Record> records;

    public InventoryBookModel() {
        this.records = new ArrayList<>();
    }

    public InventoryBookModel(List<Record> records) {
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void add(Record record) {
        records.add(record);
    }

    public void remove(Record record) {
        records.remove(record);
    }

    public List<Record> search(String productName) {
        List<Record> result = new ArrayList<>();
        for (Record record : records) {
            if (record.getProductName().equals(productName)) {
                result.add(record);
            }
        }
        return result;
    }
}