package bsuir.ppvis.controller;

import bsuir.ppvis.model.InventoryBookModel;

public class PageController {
    private final InventoryBookModel model;

    public PageController(InventoryBookModel model) {
        this.model = model;
    }

    public void updatePage() {
        model.updatePage();
    }

    public void updateRecordsPerPage(int newValue) {
        model.setRecordsPerPage(newValue);
    }

    public void updateCurrentPageIndex(int newValue) {
        model.setCurrentPageIndex(newValue);
    }

    public void updatePageCount() {
        model.updatePageCount();
    }
}
