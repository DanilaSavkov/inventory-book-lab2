package bsuir.ppvis.view.decomposition.pagecontrol;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class PageSwitcher  {
    private static final BorderPane PAGE_SWITCHER = new BorderPane();
    private static final Button TO_FIRST = new Button("<<");
    private static final Button TO_PREVIOUS = new Button("<");
    private static final Button TO_NEXT = new Button(">");
    private static final Button TO_LAST = new Button(">>");
    private static final Label CURRENT_PAGE_NUMBER = new Label();
    private static final Label SEPARATOR = new Label("/");
    private static final Label TOTAL_PAGES_COUNT = new Label();

    public static BorderPane getPageSwitcher() {
        PAGE_SWITCHER.getChildren().addAll(TO_FIRST, TO_PREVIOUS, CURRENT_PAGE_NUMBER, SEPARATOR, TOTAL_PAGES_COUNT, TO_NEXT, TO_LAST);
        PAGE_SWITCHER.setCenter(new HBox(CURRENT_PAGE_NUMBER, SEPARATOR, TOTAL_PAGES_COUNT));
        PAGE_SWITCHER.setLeft(new HBox(TO_FIRST, TO_PREVIOUS));
        PAGE_SWITCHER.setRight(new HBox(TO_NEXT, TO_LAST));
        return PAGE_SWITCHER;
    }
}
