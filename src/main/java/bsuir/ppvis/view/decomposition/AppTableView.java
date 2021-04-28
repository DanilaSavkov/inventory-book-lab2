package bsuir.ppvis.view.decomposition;

import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.view.styles.TableTitles;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AppTableView extends TableView<Record> implements TableTitles {
    private final TableColumn<Record, String> productName = new TableColumn<>(PRODUCT_NAME_TITLE);
    private final TableColumn<Record, String> fabricatorName = new TableColumn<>(FABRICATOR_NAME_TITLE);
    private final TableColumn<Record, Integer> fabricatorNumber = new TableColumn<>(FABRICATOR_NUMBER_TITLE);
    private final TableColumn<Record, Integer> storageCount = new TableColumn<>(STORAGE_COUNT_TITLE);
    private final TableColumn<Record, String> storageAddress = new TableColumn<>(STORAGE_ADDRESS_TITLE);

    public AppTableView() {
        super();
        this.getColumns().addAll(productName, fabricatorName, fabricatorNumber, storageCount, storageAddress);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
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