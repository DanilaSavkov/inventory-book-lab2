package bsuir.ppvis.model.decomposition;

import javafx.collections.FXCollections;

import java.util.List;

public class StoragePool {
    private final List<Storage> storages;

    public StoragePool() {
        this.storages = FXCollections.observableArrayList();
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public boolean add(Storage storage) {
        if (contains(storage)) {
            Storage current = find(storage);
            for (Product product : storage.getRegister().keySet()) {
                current.add(product, storage.getRegister().get(product));
            }
            return false;
        } else return storages.add(storage);
    }

    public boolean contains(Storage storage) {
        for (Storage s : storages) {
            if (s.equals(storage)) return true;
        }
        return false;
    }

    public Storage find(Storage storage) {
        for (Storage s : storages) {
            if (s.equals(storage)) return s;
        }
        return null;
    }
}
