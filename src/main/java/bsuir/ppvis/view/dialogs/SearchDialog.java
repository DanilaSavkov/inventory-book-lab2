package bsuir.ppvis.view.dialogs;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class SearchDialog extends Dialog {
    private final TableDialogContentView CONTENT;
    private static final ButtonType OK_BUTTON = new ButtonType("Ок", ButtonBar.ButtonData.APPLY);
    private static final ButtonType CANCEL_BUTTON = new ButtonType("Отмена", ButtonBar.ButtonData.CANCEL_CLOSE);

    public SearchDialog() {
        super();
        setResizable(true);
        this.CONTENT = new TableDialogContentView("Найти записи");
        this.setTitle("Найти записи");
        this.getDialogPane().setContent(CONTENT);
        this.getDialogPane().getButtonTypes().addAll(OK_BUTTON, CANCEL_BUTTON);
    }
}