package bsuir.ppvis.controller;

import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;
import javafx.collections.ObservableList;


public class AddingController {
    private final InventoryBookModel model;

    public AddingController(InventoryBookModel model) {
        this.model = model;
    }

    public void add(Record record) {
        model.add(record);
    }

    public void setModel(InventoryBookModel model) {
        this.model.setRecords((ObservableList<Record>) model.getRecords());
    }
}