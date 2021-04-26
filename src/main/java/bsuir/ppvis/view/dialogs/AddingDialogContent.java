package bsuir.ppvis.view.dialogs;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;

public class AddingDialogContent extends GridPane {
    private final TextField productNameField = new TextField();
    private final TextField fabricatorNameField = new TextField();
    private final TextField fabricatorPanField = new TextField();
    private final TextField productCountField = new TextField();
    private final TextField storageAddressField = new TextField();

    public AddingDialogContent() {
        super();
        this.addRow(0, new Label("Название продукта:"), productNameField);
        this.addRow(1, new Label("Название производителя:"), fabricatorNameField);
        this.addRow(2, new Label("УНП производителя:"), fabricatorPanField);
        this.addRow(3, new Label("Количество на складе:"), productCountField);
        this.addRow(4, new Label("Адрес склада:"), storageAddressField);
        setFieldValueToInteger(fabricatorPanField, 9);
        setFieldValueToInteger(productCountField, 6);
    }

    public String getProductName() {
        return productNameField.getText();
    }

    public String getFabricatorName() {
        return fabricatorNameField.getText();
    }

    public String getFabricatorPan() {
        return fabricatorPanField.getText();
    }

    public String getProductCount() {
        return productCountField.getText();
    }

    public String getStorageAddress() {
        return storageAddressField.getText();
    }

    private void setFieldValueToInteger(TextField field, int maxSymbolsCount) {
        field.setTextFormatter(new TextFormatter<Integer>((TextFormatter.Change change) -> {
            if (change.getControlNewText().matches("^[1-9]+\\d*") && change.getControlNewText().length() <= maxSymbolsCount) {
                return change;
            }
            return null;
        }));
    }
}
