package bsuir.ppvis.controller;

import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;


public class InventoryBookController {
    private final InventoryBookModel model;

    public InventoryBookController(InventoryBookModel model) {
        this.model = model;
    }

    public void add(Record record) {
        model.add(record);
    }

    public void setModel(InventoryBookModel model) {
        this.model.setRecords(model.getRecords());
    }

    public void remove(Record record) {
        model.remove(record);
    }
}
