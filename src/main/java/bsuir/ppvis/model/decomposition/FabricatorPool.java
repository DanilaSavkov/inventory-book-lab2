package bsuir.ppvis.model.decomposition;

import javafx.collections.FXCollections;

import java.util.List;

public class FabricatorPool {
    private final List<Fabricator> fabricators;


    public FabricatorPool() {
        fabricators = FXCollections.observableArrayList();
    }

    public List<Fabricator> getFabricators() {
        return fabricators;
    }

    public boolean add(Fabricator fabricator) {
        if (contains(fabricator)) {
            return false;
        } else return fabricators.add(fabricator);
    }

    public boolean contains(Fabricator fabricator) {
        for (Fabricator fab : fabricators) {
            if (fab.equals(fabricator)) return true;
        }
        return false;
    }
}
