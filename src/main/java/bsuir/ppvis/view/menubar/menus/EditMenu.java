package bsuir.ppvis.view.menubar.menus;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class EditMenu {
    private static final Menu MENU = new Menu("Изменить");
    private static final MenuItem ADD_ITEM = new MenuItem("Добавить");
    private static final MenuItem DELETE_ITEM = new MenuItem("Удалить");

    public static Menu getMenu() {
        MENU.getItems().addAll(ADD_ITEM, DELETE_ITEM);
        return MENU;
    }

    public static MenuItem getAddItem() {
        return ADD_ITEM;
    }

    public static MenuItem getDeleteItem() {
        return DELETE_ITEM;
    }
}
