package bsuir.ppvis.model.file;

import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Fabricator;
import bsuir.ppvis.model.decomposition.Product;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.decomposition.Storage;
import bsuir.ppvis.model.exceptions.XMLReadingException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class InventoryBookReader implements InventoryBookXMLConstants {
    private static InventoryBookModel inventoryBook;

    private static class XMLInventoryBookReader extends DefaultHandler {
        private String productName;
        private String fabricatorName;
        private int fabricatorPayerAccountNumber;
        private String productCountOnStorage;
        private String storageAddress;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals(RECORD)) {
                productName = attributes.getValue(PRODUCT_NAME);
                fabricatorName = attributes.getValue(FABRICATOR_NAME);
                fabricatorPayerAccountNumber = Integer.parseInt(attributes.getValue(FABRICATOR_PAYER_ACCOUNT_NUMBER));
                productCountOnStorage = attributes.getValue(PRODUCT_COUNT_ON_STORAGE);
                storageAddress = attributes.getValue(STORAGE_ADDRESS);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals(RECORD)) {
                Fabricator fabricator = new Fabricator(fabricatorName, fabricatorPayerAccountNumber);
                Product product = new Product(productName, fabricator);
                Storage storage = new Storage(storageAddress);
                int count = 0;
                try {
                    count = Integer.parseInt(productCountOnStorage);
                } catch (NumberFormatException ignored) {}
                storage.add(product, count);
                Record record = new Record(product, storage);
                inventoryBook.add(record);
            }
        }
    }

    public InventoryBookReader() {
        inventoryBook = new InventoryBookModel();
    }

    public InventoryBookModel read(File file) throws XMLReadingException {
        parseFile(file);
        return inventoryBook;
    }

    private static void parseFile(File file) throws XMLReadingException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLInventoryBookReader handler = new XMLInventoryBookReader();
            parser.parse(file, handler);
        } catch (ParserConfigurationException | IOException | SAXException exception) {
            throw new XMLReadingException("File can't be read...", exception);
        }
    }
}
