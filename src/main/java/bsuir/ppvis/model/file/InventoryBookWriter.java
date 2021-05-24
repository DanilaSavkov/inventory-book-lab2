package bsuir.ppvis.model.file;

import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.model.decomposition.Record;
import bsuir.ppvis.model.exceptions.XMLWritingException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InventoryBookWriter implements InventoryBookXMLConstants {
    private final InventoryBookModel model;
    private Document document;

    public InventoryBookWriter(InventoryBookModel model) {
        this.model = model;
    }

    public void writeXMLTo(File file) throws XMLWritingException {
        try (FileWriter writer = new FileWriter(file)) {
            document = buildDocument();
            configureDocument();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(writer);
            transformer.transform(source, streamResult);
        } catch (IOException | ParserConfigurationException | TransformerException exception) {
            throw new XMLWritingException("XML Document can't be generated", exception);
        } catch (NullPointerException ignored) {

        }
    }

    private static Document buildDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    private void configureDocument() {
        Element root = getDocumentRoot();
        root.appendChild(getRecordsElement());
        document.appendChild(root);
    }

    private Element getRecordsElement() {
        Element records = document.createElement(RECORDS);
        for (Record record : model.getRecords()) {
            records.appendChild(getRecordElement(record));
        }
        return records;
    }

    private Element getRecordElement(Record record) {
        Element element = document.createElement(RECORD);
        element.setAttribute(PRODUCT_NAME, record.getProductName());
        element.setAttribute(FABRICATOR_NAME, record.getFabricatorName());
        element.setAttribute(FABRICATOR_PAYER_ACCOUNT_NUMBER, String.valueOf(record.getFabricatorPayerAccountNumber()));
        element.setAttribute(PRODUCT_COUNT_ON_STORAGE,  record.getProductCountStringOnStorage());
        element.setAttribute(STORAGE_ADDRESS, record.getStorageAddress());
        return element;
    }

    private Element getDocumentRoot() {
        return document.createElement(INVENTORY_BOOK);
    }
}
