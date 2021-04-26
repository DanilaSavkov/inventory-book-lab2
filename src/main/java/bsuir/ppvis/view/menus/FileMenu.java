package bsuir.ppvis.view.menus;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class FileMenu {
    private static final Menu MENU = new Menu("File");
    private static final MenuItem OPEN_ITEM = new MenuItem("Open");
    private static final MenuItem SAVE_ITEM = new MenuItem("Save");

    public static Menu getMenu() {
        MENU.getItems().addAll(OPEN_ITEM, SAVE_ITEM);
        return MENU;
    }

    public static MenuItem getOpenItem() {
        return OPEN_ITEM;
    }

    public static MenuItem getSaveItem() {
        return SAVE_ITEM;
    }
}
