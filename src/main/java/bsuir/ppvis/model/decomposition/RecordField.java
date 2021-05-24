package bsuir.ppvis.model.decomposition;

import bsuir.ppvis.view.style.Titles;

public enum RecordField implements Titles {
    ALL(ALL_RECORDS_TITLE),
    PRODUCT_NAME(PRODUCT_NAME_TITLE),
    FABRICATOR_NAME(FABRICATOR_NAME_TITLE),
    FABRICATOR_NUMBER(FABRICATOR_NUMBER_TITLE),
    PRODUCT_COUNT(COUNT_ON_STORAGE_TITLE),
    STORAGE_ADDRESS(STORAGE_ADDRESS_TITLE);

    private final String name;

    RecordField(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}