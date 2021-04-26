package bsuir.ppvis.view.dialogs;

import bsuir.ppvis.model.decomposition.Fabricator;
import bsuir.ppvis.model.decomposition.Product;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.decomposition.Storage;
import javafx.scene.control.*;
import javafx.util.Callback;

public class AddingDialog extends Dialog<Record> {
    private final AddingDialogContent CONTENT;
    private static final ButtonType OK_BUTTON = new ButtonType("Ок", ButtonBar.ButtonData.APPLY);
    private static final ButtonType CANCEL_BUTTON = new ButtonType("Отмена", ButtonBar.ButtonData.CANCEL_CLOSE);

    public AddingDialog() {
        super();
        this.CONTENT = new AddingDialogContent();
        this.setTitle("Добавить запись");
        this.getDialogPane().setContent(CONTENT);
        this.getDialogPane().getButtonTypes().addAll(OK_BUTTON, CANCEL_BUTTON);
        this.setResultConverter(new Callback<ButtonType, Record>() {
            @Override
            public Record call(ButtonType param) {
                if (param.equals(CANCEL_BUTTON)) return null;
                else return getRecordByDialog();
            }
        });
        Button button = new Button();
    }

    private Record getRecordByDialog() {
        Record record = null;
        try {
            Fabricator fabricator = new Fabricator(CONTENT.getFabricatorName(), Integer.parseInt(CONTENT.getFabricatorPan()));
            Product product = new Product(CONTENT.getProductName(), fabricator);
            Storage storage = new Storage(CONTENT.getStorageAddress());
            storage.add(product, Integer.parseInt(CONTENT.getProductCount()));
            record = new Record(product, storage);
        } catch (Exception ignored) {}
        return record;
    }
}