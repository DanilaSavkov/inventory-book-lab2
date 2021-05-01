package bsuir.ppvis.view.menubar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import bsuir.ppvis.view.menubar.menus.EditMenu;
import bsuir.ppvis.view.menubar.menus.FileMenu;

public class AppMenuBar {
    private static final MenuBar MENU_BAR = new MenuBar();
    private static final Menu FILE_MENU = FileMenu.getMenu();
    private static final Menu EDIT_MENU = EditMenu.getMenu();

    public static MenuBar getMenuBar() {
        MENU_BAR.getMenus().addAll(FILE_MENU, EDIT_MENU);
        return MENU_BAR;
    }

    public static Menu getFileMenu() {
        return FILE_MENU;
    }

    public static Menu getEditMenu() {
        return EDIT_MENU;
    }
}