package bsuir.ppvis.view.pagecontrol;

import bsuir.ppvis.model.InventoryBookModel;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class StatusBar extends HBox {
    private static final Label TOTAL_RECORDS_COUNT = new Label("Всего записей:");
    private final Label recordsCount;

    public StatusBar() {
        super(10);
        recordsCount = new Label();
        getChildren().addAll(TOTAL_RECORDS_COUNT, recordsCount);
    }

    public Label getRecordsCount() {
        return recordsCount;
    }
}
