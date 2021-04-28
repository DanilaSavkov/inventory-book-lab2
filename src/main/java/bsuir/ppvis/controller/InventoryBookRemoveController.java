package bsuir.ppvis.controller;

import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;

import java.util.List;

public class InventoryBookRemoveController {
    private final InventoryBookModel model;

    public InventoryBookRemoveController(InventoryBookModel model) {
        this.model = model;
    }

    public void remove(Record record) {
        model.remove(record);
    }

    public void removeAll(List<Record> records) {
        model.getRecords().removeIf(records::contains);
    }
}
