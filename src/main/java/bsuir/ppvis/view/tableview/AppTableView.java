package bsuir.ppvis.view.tableview;

import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.decomposition.RecordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AppTableView extends TableView<Record> {
    private final TableColumn<Record, String> productName = new TableColumn<>(RecordField.PRODUCT_NAME.getName());
    private final TableColumn<Record, String> fabricatorName = new TableColumn<>(RecordField.FABRICATOR_NAME.getName());
    private final TableColumn<Record, Integer> fabricatorNumber = new TableColumn<>(RecordField.FABRICATOR_NUMBER.getName());
    private final TableColumn<Record, Integer> storageCount = new TableColumn<>(RecordField.PRODUCT_COUNT.getName());
    private final TableColumn<Record, String> storageAddress = new TableColumn<>(RecordField.STORAGE_ADDRESS.getName());

    public AppTableView() {
        super();
        getColumns().addAll(productName, fabricatorName, fabricatorNumber, storageCount, storageAddress);
        setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        configureColumns();
    }

    private void configureColumns() {
        productName.setCellValueFactory(new PropertyValueFactory<Record, String>("productName"));
        fabricatorName.setCellValueFactory(new PropertyValueFactory<Record, String>("fabricatorName"));
        fabricatorNumber.setCellValueFactory(new PropertyValueFactory<Record, Integer>("fabricatorPayerAccountNumber"));
        storageCount.setCellValueFactory(new PropertyValueFactory<Record, Integer>("productCountOnStorage"));
        storageAddress.setCellValueFactory(new PropertyValueFactory<Record, String>("storageAddress"));
    }
}