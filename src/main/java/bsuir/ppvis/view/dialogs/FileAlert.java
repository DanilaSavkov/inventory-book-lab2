package bsuir.ppvis.view.dialogs;

import javafx.scene.control.Alert;

public class FileAlert extends Alert {
    public FileAlert(Exception exception) {
        super(AlertType.ERROR);
        setTitle("Error");
        setHeaderText(exception.getMessage());
        setContentText(exception.getCause().getMessage());
    }
}
