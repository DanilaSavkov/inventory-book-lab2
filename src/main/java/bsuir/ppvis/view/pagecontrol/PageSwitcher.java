package bsuir.ppvis.view.pagecontrol;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PageSwitcher {
    private static final HBox PAGE_SWITCHER = new HBox();
    private static final Button TO_FIRST = new Button("TO FIRST");
    private static final Button TO_PREVIOUS = new Button("TO PREVIOUS");
    private static final Button TO_NEXT = new Button("TO NEXT");
    private static final Button TO_LAST = new Button("TO LAST");
    private static final Label CURRENT_PAGE_NUMBER = new Label("1");
    private static final Label SEPARATOR = new Label("/");
    private static final Label TOTAL_PAGES_COUNT = new Label("7");

    public static HBox getPageSwitcher() {
        PAGE_SWITCHER.getChildren().addAll(TO_FIRST, TO_PREVIOUS, CURRENT_PAGE_NUMBER, SEPARATOR, TOTAL_PAGES_COUNT, TO_NEXT, TO_LAST);
        return PAGE_SWITCHER;
    }
}
