package bsuir.ppvis.view.menubar.menus;

import bsuir.ppvis.view.style.Styles;
import bsuir.ppvis.view.style.Titles;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class EditMenu extends Menu implements Titles, Styles {
    private static final MenuItem ADD_ITEM = new MenuItem(ADD_TITLE);
    private static final MenuItem DELETE_ITEM = new MenuItem(REMOVE_TITLE);

    public EditMenu() {
        super(EDIT_MENU_TITLE, null, ADD_ITEM, DELETE_ITEM);
        configure();
    }

    private void configure() {
        setStyle(MENU_STYLE);
    }

    public static MenuItem getAddItem() {
        return ADD_ITEM;
    }

    public static MenuItem getDeleteItem() {
        return DELETE_ITEM;
    }
}
