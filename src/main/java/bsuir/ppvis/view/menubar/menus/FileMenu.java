package bsuir.ppvis.view.menubar.menus;

import bsuir.ppvis.view.style.Styles;
import bsuir.ppvis.view.style.Titles;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class FileMenu extends Menu implements Titles, Styles {
    private static final MenuItem OPEN_ITEM = new MenuItem(OPEN_FILE_TITLE);
    private static final MenuItem SAVE_ITEM = new MenuItem(SAVE_FILE_TITLE);

    public FileMenu() {
        super(FILE_MENU_TITLE, null, OPEN_ITEM, SAVE_ITEM);
        configure();
    }

    private void configure() {
        setStyle(MENU_STYLE);
    }

    public static MenuItem getOpenItem() {
        return OPEN_ITEM;
    }

    public static MenuItem getSaveItem() {
        return SAVE_ITEM;
    }
}