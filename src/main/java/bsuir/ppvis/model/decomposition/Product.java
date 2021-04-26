package bsuir.ppvis.model.decomposition;

public class Product {
    private final String name;
    private final Fabricator fabricator;

    public Product(String name, Fabricator fabricator) {
        this.name = name;
        this.fabricator = fabricator;
    }

    public String getName() {
        return name;
    }

    public Fabricator getFabricator() {
        return fabricator;
    }
}
