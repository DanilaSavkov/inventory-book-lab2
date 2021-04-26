package bsuir.ppvis.model.file;

public interface InventoryBookXMLConstants {
    String INVENTORY_BOOK = "inventory_book";
    String RECORD = "record";
    String PRODUCT = "product";
    String FABRICATOR = "fabricator";
    String STORAGE_ADDRESS = "storage_address";
    String COUNT_ON_STORAGE = "count";
    String NAME = "name";
    String PAYER_ACCOUNT_NUMBER = "pan";
}

/*  XML STRUCTURE
    <inventory_book>
        <record>
            <product name="">
                <fabricator name="" pan=""/>
            </product>
            <count> </count>
            <storage_address> </storage_address>
        </record>
    </inventory_book>
*/