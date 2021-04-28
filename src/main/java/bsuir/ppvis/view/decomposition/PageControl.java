package bsuir.ppvis.view.decomposition;

import bsuir.ppvis.controller.InventoryBookController;
import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.view.decomposition.pagecontrol.PageSwitcher;
import bsuir.ppvis.view.decomposition.pagecontrol.StatusBar;
import javafx.scene.layout.*;

public class PageControl extends BorderPane {
    private static final BorderPane PAGE_SWITCHER = PageSwitcher.getPageSwitcher();
    private final GridPane statusBar;

    public PageControl() {
        super();
        this.statusBar = new StatusBar();
        this.setLeft(statusBar);
        this.setRight(PAGE_SWITCHER);
    }
}
