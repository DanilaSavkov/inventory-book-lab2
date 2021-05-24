package bsuir.ppvis.controller;

import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;
import javafx.collections.FXCollections;

import java.util.List;

public class SearchController {
    private final InventoryBookModel model;

    public SearchController(InventoryBookModel model) {
        this.model = model;
    }

    public List<Record> find(ChoiceBoxConstants recordField, String... values) {
        List<Record> records = FXCollections.observableArrayList();
        switch (recordField) {
            case ALL:
                records = model.getRecords();
                break;
            case PRODUCT:
                findByProductName(records, values[0]);
                findByProductCount(records, values[1]);
                break;
            case FABRICATOR:
                findByFabricatorName(records, values[0]);
                findByFabricatorNumber(records, values[1]);
                break;
            case STORAGE:
                findByStorageAddress(records, values[0]);
                break;
        }
        return records;
    }

    private void findByProductName(List<Record> records, String name) {
        for (Record record : model.getRecords()) {
            if (record.getProductName().contains(name) && !records.contains(record)) {
                records.add(record);
            }
        }
    }

    private void findByFabricatorName(List<Record> records, String name) {
        for (Record record : model.getRecords()) {
            if (record.getFabricatorName().contains(name) && !records.contains(record)) {
                records.add(record);
            }
        }
    }

    private void findByFabricatorNumber(List<Record> records, String number) {
        for (Record record : model.getRecords()) {
            if (String.valueOf(record.getFabricatorPayerAccountNumber()).equals(number) && !records.contains(record)) {
                records.add(record);
            }
        }
    }

    private void findByProductCount(List<Record> records, String count) {
        for (Record record : model.getRecords()) {
            if ((String.valueOf(record.getProductCountStringOnStorage()).equals(count)
                    || (count.equals("0") && record.getProductCountOnStorage() == 0))
                    && !records.contains(record)) {
                records.add(record);
            }
        }
    }

    private void findByStorageAddress(List<Record> records, String address) {
        for (Record record : model.getRecords()) {
            if (record.getStorageAddress().contains(address) && !records.contains(record)) {
                records.add(record);
            }
        }
    }
}