package bsuir.ppvis.model.decomposition;

public enum RecordField {
    ALL("Все записи"),
    PRODUCT_NAME("Название продукта"),
    FABRICATOR_NAME("Название производителя"),
    FABRICATOR_NUMBER("УНП производителя"),
    PRODUCT_COUNT("Количество на складе"),
    STORAGE_ADDRESS("Адрес склада");

    private final String name;

    RecordField(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
