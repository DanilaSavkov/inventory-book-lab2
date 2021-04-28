package bsuir.ppvis.controller;

import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.RecordField;
import bsuir.ppvis.model.decomposition.Record;
import javafx.collections.FXCollections;

import java.util.List;

public class InventoryBookSearchController {
    private final InventoryBookModel model;

    public InventoryBookSearchController(InventoryBookModel model) {
        this.model = model;
    }

    public List<Record> find(RecordField recordField, String value) {
        List<Record> records = FXCollections.observableArrayList();
        switch (recordField) {
            case ALL:
                records = model.getRecords();
                break;
            case PRODUCT_NAME:
                records = findByProductName(value);
                break;
            case FABRICATOR_NAME:
                records = findByFabricatorName(value);
                break;
            case FABRICATOR_NUMBER:
                records = findByFabricatorNumber(value);
                break;
            case PRODUCT_COUNT:
                records = findByProductCount(value);
                break;
            case STORAGE_ADDRESS:
                records = findByStorageAddress(value);
                break;
        }
        return records;
    }

    private List<Record> findByProductName(String name) {
        List<Record> result = FXCollections.observableArrayList();
        for (Record record : model.getRecords()) {
            if (record.getProductName().equals(name)) {
                result.add(record);
            }
        }
        return result;
    }

    private List<Record> findByFabricatorName(String name) {
        List<Record> result = FXCollections.observableArrayList();
        for (Record record : model.getRecords()) {
            if (record.getFabricatorName().equals(name)) {
                result.add(record);
            }
        }
        return result;
    }

    private List<Record> findByFabricatorNumber(String number) {
        List<Record> result = FXCollections.observableArrayList();
        for (Record record : model.getRecords()) {
            if (String.valueOf(record.getFabricatorPayerAccountNumber()).equals(number)) {
                result.add(record);
            }
        }
        return result;
    }

    private List<Record> findByProductCount(String count) {
        List<Record> result = FXCollections.observableArrayList();
        for (Record record : model.getRecords()) {
            if (String.valueOf(record.getProductCountOnStorage()).equals(count)) {
                result.add(record);
            }
        }
        return result;
    }

    private List<Record> findByStorageAddress(String address) {
        List<Record> result = FXCollections.observableArrayList();
        for (Record record : model.getRecords()) {
            if (record.getStorageAddress().equals(address)) {
                result.add(record);
            }
        }
        return result;
    }
}