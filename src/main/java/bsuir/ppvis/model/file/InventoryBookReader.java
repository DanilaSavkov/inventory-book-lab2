package bsuir.ppvis.model.file;

import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Fabricator;
import bsuir.ppvis.model.decomposition.Product;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.decomposition.Storage;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryBookReader implements InventoryBookXMLConstants {
    private static InventoryBookModel inventoryBook;

    private static class XMLInventoryBookReader extends DefaultHandler {
        private List<Fabricator> fabricators = new ArrayList<>();
        private List<Storage> storages = new ArrayList<>();
        private Product product;
        private Storage storage;
        private Record record;
        private String productName;
        private String fabricatorName;
        private int fabricatorPayerAccountNumber;
        private int countOnStorage;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            switch (qName) {
                case INVENTORY_BOOK:
                    break;
                case RECORD:
                    break;
                case PRODUCT:
                    break;
                case FABRICATOR:
                    break;
                case COUNT_ON_STORAGE:
                    break;
                case STORAGE_ADDRESS:
                    break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {

        }
    }

    public static InventoryBookModel read(File file) throws XMLReadingException {
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
