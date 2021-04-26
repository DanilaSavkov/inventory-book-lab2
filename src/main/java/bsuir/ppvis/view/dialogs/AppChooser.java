package bsuir.ppvis.view.dialogs;

import javafx.stage.FileChooser;

import java.io.File;

public class AppChooser {
    private static final FileChooser FILE_CHOOSER = new FileChooser();

    public AppChooser() {
    }

    private static void configureDirectoryChooser() {
        FILE_CHOOSER.setInitialDirectory(new File(System.getProperty("user.home")));
        FILE_CHOOSER.setInitialFileName("Безымянный");
    }

    public static FileChooser getFileChooser() {
        configureDirectoryChooser();
        return FILE_CHOOSER;
    }
}
