package bsuir.ppvis.view.decomposition;

import bsuir.ppvis.model.decomposition.Fabricator;
import bsuir.ppvis.model.decomposition.Product;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.decomposition.Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AppTableView {
    private static final TableView<Record> TABLE_VIEW = new TableView<>();
    private static final TableColumn<Record, String> PRODUCT_NAME = new TableColumn<>("Название товара");
    private static final TableColumn<Record, String> FABRICATOR_NAME = new TableColumn<>("Название производителя");
    private static final TableColumn<Record, Integer> FABRICATOR_NUMBER = new TableColumn<>("УНП производителя");
    private static final TableColumn<Record, String> STORAGE_COUNT = new TableColumn<>("Количество на складе");
    private static final TableColumn<Record, String> STORAGE_ADDRESS = new TableColumn<>("Адрес склада");

    public static TableView<Record> getTableView() {
        configureTableView();
        TABLE_VIEW.setItems(getTestRecords());
        return TABLE_VIEW;
    }

    private static void configureTableView() {
        PRODUCT_NAME.setCellValueFactory(new PropertyValueFactory<Record, String>("productName"));
        FABRICATOR_NAME.setCellValueFactory(new PropertyValueFactory<Record, String>("fabricatorName"));
        FABRICATOR_NUMBER.setCellValueFactory(new PropertyValueFactory<Record, Integer>("fabricatorPayerAccountNumber"));
        STORAGE_COUNT.setCellValueFactory(new PropertyValueFactory<Record, String>("productCountOnStorage"));
        STORAGE_ADDRESS.setCellValueFactory(new PropertyValueFactory<Record, String>("storageAddress"));

        TABLE_VIEW.getColumns().addAll(PRODUCT_NAME, FABRICATOR_NAME, FABRICATOR_NUMBER, STORAGE_COUNT, STORAGE_ADDRESS);
        TABLE_VIEW.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private static ObservableList<Record> getTestRecords() {
        ObservableList<Record> records = FXCollections.observableArrayList();

        Fabricator zara = new Fabricator("Zara Беларусь", 123456789);
        Fabricator savushkin = new Fabricator("Савушкин продукт", 123456789);
        Fabricator mark = new Fabricator("Mark Formelle", 123456789);

        Product underpants = new Product("Труханы", zara);
        Product tvorog = new Product("Подзалупный творожок", savushkin);
        Product underpants2 = new Product("Другие труханы", zara);
        Product underpants3 = new Product("Труханы бичевские", mark);
        Storage bsuir = new Storage("бгуир рюкзак глеба");
        Storage obshaga = new Storage("леонида беды 4к1");

        Record record1 = new Record(underpants, bsuir);
        Record record2 = new Record(tvorog, bsuir);
        Record record3 = new Record(underpants2, bsuir);
        Record record4 = new Record(underpants3, bsuir);
        Record record5 = new Record(underpants, obshaga);

        records.addAll(record1, record2, record3, record4, record5);
        return records;
    }
}