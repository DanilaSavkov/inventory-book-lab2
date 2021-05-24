package bsuir.ppvis.view.dialogs.content;

import bsuir.ppvis.model.decomposition.RecordField;
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
        this.addRow(0, new Label(RecordField.PRODUCT_NAME.getName() + ": "), productNameField);
        this.addRow(1, new Label(RecordField.FABRICATOR_NAME.getName() + ": "), fabricatorNameField);
        this.addRow(2, new Label(RecordField.FABRICATOR_NUMBER.getName() + ": "), fabricatorPanField);
        this.addRow(3, new Label(RecordField.PRODUCT_COUNT.getName() + ": "), productCountField);
        this.addRow(4, new Label(RecordField.STORAGE_ADDRESS.getName() + ": "), storageAddressField);
//        setFieldValueToInteger(fabricatorPanField, 9);
//        setFieldValueToInteger(productCountField, 6);
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
