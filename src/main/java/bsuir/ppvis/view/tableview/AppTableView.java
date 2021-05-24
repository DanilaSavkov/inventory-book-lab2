package bsuir.ppvis.view.tableview;

import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.decomposition.RecordField;
import bsuir.ppvis.view.style.Styles;
import bsuir.ppvis.view.style.Titles;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class AppTableView extends TableView<Record> implements Titles, Styles {
    private final TableColumn<Record, String> productName = new TableColumn<>(RecordField.PRODUCT_NAME.getName());
    private final TableColumn<Record, String> fabricatorName = new TableColumn<>(RecordField.FABRICATOR_NAME.getName());
    private final TableColumn<Record, Integer> fabricatorNumber = new TableColumn<>(RecordField.FABRICATOR_NUMBER.getName());
    private final TableColumn<Record, String> storageCount = new TableColumn<>(RecordField.PRODUCT_COUNT.getName());
    private final TableColumn<Record, String> storageAddress = new TableColumn<>(RecordField.STORAGE_ADDRESS.getName());

    public AppTableView() {
        super();
        configure();
    }

    private void configure() {
        getColumns().addAll(productName, fabricatorName, fabricatorNumber, storageCount, storageAddress);
        setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        setPlaceholder(new Label(EMPTY_TABLE_TITLE));
        setStyle(TABLE_VIEW_STYLE);
        configureColumns();
    }

    private void configureColumns() {
        productName.setCellValueFactory(new PropertyValueFactory<Record, String>("productName"));
        fabricatorName.setCellValueFactory(new PropertyValueFactory<Record, String>("fabricatorName"));
        fabricatorNumber.setCellValueFactory(new PropertyValueFactory<Record, Integer>("fabricatorPayerAccountNumber"));
        storageCount.setCellValueFactory(new PropertyValueFactory<Record, String>("productCountStringOnStorage"));
        storageAddress.setCellValueFactory(new PropertyValueFactory<Record, String>("storageAddress"));
    }
}