package bsuir.ppvis.controller;

import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;

import java.util.List;

public class RemoveController {
    private final InventoryBookModel model;

    public RemoveController(InventoryBookModel model) {
        this.model = model;
    }

    public void remove(List<Record> records) {
        model.getRecords().removeIf(records::contains);
    }
}