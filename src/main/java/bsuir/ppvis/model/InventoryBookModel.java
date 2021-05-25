package bsuir.ppvis.model;

import bsuir.ppvis.model.decomposition.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class InventoryBookModel {
    private final ListProperty<Record> records = new SimpleListProperty<>();
    private final ListProperty<Record> page = new SimpleListProperty<>();
    private final IntegerProperty recordsPerPage = new SimpleIntegerProperty(Integer.MAX_VALUE);
    private final IntegerProperty pageCount = new SimpleIntegerProperty(1);
    private final IntegerProperty currentPageIndex = new SimpleIntegerProperty(0);

    public InventoryBookModel() {
        records.setValue(FXCollections.observableArrayList());
    }

    public InventoryBookModel(InventoryBookModel model) {
        records.setValue(FXCollections.observableArrayList(model.records));
    }

    public InventoryBookModel(List<Record> records) {
        this.records.setValue((ObservableList<Record>) records);
    }

    public void add(Record newRecord) {
        records.add(newRecord);
    }

    public void updatePage() {
        int startIndex = getStartIndex();
        int endIndex = getEndIndex(startIndex);
        ObservableList<Record> result = FXCollections.observableArrayList();
        for (int i = startIndex; i < endIndex; i++) {
            result.add(records.get().get(i));
        }
        page.setValue(result);
    }

    public void updatePageCount() {
        pageCount.set((int) Math.ceil(records.sizeProperty().doubleValue() / recordsPerPage.doubleValue()));
    }

    public ListProperty<Record> recordsProperty() {
        return records;
    }

    public ListProperty<Record> pageProperty() {
        return page;
    }

    public IntegerProperty pageCountProperty() {
        return pageCount;
    }

    public ObservableList<Record> getRecords() {
        return records.get();
    }

    public ObservableList<Record> getPage() {
        return page.get();
    }

    public void setRecords(ObservableList<Record> records) {
        this.records.set(records);
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage.set(recordsPerPage);
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex.set(currentPageIndex);
    }

    private int getStartIndex() {
        return currentPageIndex.get() * recordsPerPage.get();
    }

    private int getEndIndex(int startIndex) {
        return Math.min(startIndex + recordsPerPage.get(), records.get().size());
    }

    public void setPage(ObservableList<Record> page) {
        this.page.set(page);
    }
}