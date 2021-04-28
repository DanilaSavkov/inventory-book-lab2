package bsuir.ppvis.view.dialogs;

import bsuir.ppvis.model.decomposition.Fabricator;
import bsuir.ppvis.model.decomposition.Product;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.decomposition.Storage;
import bsuir.ppvis.view.dialogs.content.AddingDialogContent;
import javafx.scene.control.*;
import javafx.util.Callback;

public class AddingDialog extends Dialog<Record> {
    private final AddingDialogContent content;
    private static final ButtonType OK_BUTTON = new ButtonType("Ок", ButtonBar.ButtonData.APPLY);
    private static final ButtonType CANCEL_BUTTON = new ButtonType("Отмена", ButtonBar.ButtonData.CANCEL_CLOSE);

    public AddingDialog() {
        super();
        content = new AddingDialogContent();
        setTitle("Добавить запись");
        getDialogPane().setContent(content);
        getDialogPane().getButtonTypes().addAll(OK_BUTTON, CANCEL_BUTTON);
        setResultConverter(dialogCallback());
    }

    private Callback<ButtonType, Record> dialogCallback() {
        return new Callback<ButtonType, Record>() {
            @Override
            public Record call(ButtonType param) {
                if (param.equals(CANCEL_BUTTON)) return null;
                else return getRecordByDialog();
            }
        };
    }

    private Record getRecordByDialog() {
        Record record = null;
        try {
            Fabricator fabricator = new Fabricator(content.getFabricatorName(), Integer.parseInt(content.getFabricatorPan()));
            Product product = new Product(content.getProductName(), fabricator);
            Storage storage = new Storage(content.getStorageAddress());
            storage.add(product, Integer.parseInt(content.getProductCount()));
            record = new Record(product, storage);
        } catch (Exception ignored) {}
        return record;
    }
}