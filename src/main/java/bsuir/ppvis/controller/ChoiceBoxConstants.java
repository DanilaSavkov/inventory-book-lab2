package bsuir.ppvis.controller;

public enum ChoiceBoxConstants {
    ALL("Все записи"),
    PRODUCT("Название продукта или количество на складе"),
    FABRICATOR("Название производителя или УНП"),
    STORAGE("Адрес склада");

    private final String string;

    ChoiceBoxConstants(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
