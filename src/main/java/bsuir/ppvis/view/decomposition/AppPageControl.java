package bsuir.ppvis.view.decomposition;

import bsuir.ppvis.view.decomposition.pagecontrol.PageSwitcher;
import bsuir.ppvis.view.decomposition.pagecontrol.RecordsState;
import javafx.scene.layout.*;

public class AppPageControl {
    private static final BorderPane PAGE_CONTROL = new BorderPane();
    private static final HBox PAGE_SWITCHER = PageSwitcher.getPageSwitcher();
    private static final GridPane RECORDS_STATE = RecordsState.getRecordsState();

    public static BorderPane getPageControl() {
        PAGE_CONTROL.setLeft(RECORDS_STATE);
        PAGE_CONTROL.setRight(PAGE_SWITCHER);
        return PAGE_CONTROL;
    }
}
