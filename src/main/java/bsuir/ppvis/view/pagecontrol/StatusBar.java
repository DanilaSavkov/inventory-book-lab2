package bsuir.ppvis.view.pagecontrol;

import bsuir.ppvis.view.style.Styles;
import bsuir.ppvis.view.style.Titles;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class StatusBar extends HBox implements Titles, Styles {
    private final Label TOTAL_RECORDS_COUNT = new Label(RECORDS_TOTAL_TITLE);
    private final Label recordsCount;

    public StatusBar() {
        super();
        recordsCount = new Label();
        configure();
    }

    private void configure() {
        setSpacing(10);
        getChildren().addAll(TOTAL_RECORDS_COUNT, recordsCount);
        TOTAL_RECORDS_COUNT.setStyle(STATUS_BAR_STYLE);
        recordsCount.setStyle(STATUS_BAR_STYLE);
    }

    public Label getRecordsCount() {
        return recordsCount;
    }
}