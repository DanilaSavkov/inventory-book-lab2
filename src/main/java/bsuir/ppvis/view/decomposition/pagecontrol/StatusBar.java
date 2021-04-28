package bsuir.ppvis.view.decomposition.pagecontrol;

import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class StatusBar extends GridPane {
    private static final Label TOTAL_RECORDS_CAPTION = new Label("Всего записей:\t");
    private static final Label RECORDS_PER_PAGE_CAPTION = new Label("Записей на странице:\t");
    private static final Label TOTAL_RECORDS_RESULT = new Label();
    private static final ChoiceBox<Integer> RECORDS_PER_PAGE_RESULT = new ChoiceBox<>(FXCollections.observableArrayList(5, 10, 15, 20));

    public StatusBar() {
        super();
        this.add(TOTAL_RECORDS_CAPTION, 0, 0);
        this.add(RECORDS_PER_PAGE_CAPTION, 0, 1);
        this.add(TOTAL_RECORDS_RESULT, 1, 0);
        this.add(RECORDS_PER_PAGE_RESULT, 1, 1);
        RECORDS_PER_PAGE_RESULT.setValue(10);
    }
}
