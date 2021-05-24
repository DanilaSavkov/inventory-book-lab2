package bsuir.ppvis.view.menubar;

import bsuir.ppvis.view.style.Styles;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import bsuir.ppvis.view.menubar.menus.EditMenu;
import bsuir.ppvis.view.menubar.menus.FileMenu;

public class AppMenuBar extends MenuBar implements Styles {
    private static final Menu FILE_MENU = new FileMenu();
    private static final Menu EDIT_MENU = new EditMenu();

    public AppMenuBar() {
        super(FILE_MENU, EDIT_MENU);
        configure();
    }

    private void configure() {
        setStyle(MENU_BAR_STYLE);
    }
}