package bsuir.ppvis.view.pagecontrol;

import bsuir.ppvis.controller.PageController;
import bsuir.ppvis.model.InventoryBookModel;
import bsuir.ppvis.view.style.Styles;
import bsuir.ppvis.view.style.Titles;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Pagination;
import javafx.scene.layout.*;
import javafx.util.StringConverter;

public class PageControl extends BorderPane implements Titles, Styles {
    private InventoryBookModel model;
    private PageController controller;

    private final Pagination pagination;
    private final StatusBar statusBar;
    private final ChoiceBox<Integer> choiceBox;

    public PageControl(InventoryBookModel model) {
        super();
        this.model = model;
        controller = new PageController(model);
        pagination = new Pagination();
        statusBar = new StatusBar();
        choiceBox = new ChoiceBox<>();
        configure();
    }

    public void setModel(InventoryBookModel model) {
        this.model = model;
        controller = new PageController(model);
        configure();
    }

    private void configure() {
        setStyle(PAGE_CONTROL_STYLE);
        setCenter(pagination);
        setLeft(statusBar);
        setRight(choiceBox);
        configurePagination();
        configureStatusBar();
        configureChoiceBox();
    }

    private void configurePagination() {
        pagination.setStyle(PAGINATION_STYLE);
        pagination.pageCountProperty().bind(model.pageCountProperty());
        pagination.currentPageIndexProperty().addListener(paginationChangeListener());
    }

    private void configureStatusBar() {
        statusBar.getRecordsCount().textProperty().bind(model.recordsProperty().sizeProperty().asString());
        statusBar.getRecordsCount().textProperty().addListener(statusBarListener());
    }

    private void configureChoiceBox() {
        choiceBox.setStyle(CHOICE_BOX_STYLE);
        choiceBox.getItems().removeIf(integer -> choiceBox.getItems().contains(integer));
        choiceBox.getItems().addAll(Integer.MAX_VALUE, 5, 10, 15, 20, 25);
        choiceBox.setValue(Integer.MAX_VALUE);
        choiceBox.setConverter(choiceBoxStringConverter());
        choiceBox.valueProperty().addListener(choiceBoxChangeListener());
    }

    private InvalidationListener statusBarListener() {
        return new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                controller.updatePageCount();
                controller.updatePage();
            }
        };
    }

    private ChangeListener<Integer> choiceBoxChangeListener() {
        return new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                controller.updateRecordsPerPage(newValue);
                controller.updatePageCount();
                controller.updatePage();
            }
        };
    }

    private ChangeListener<Number> paginationChangeListener() {
        return new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                controller.updateCurrentPageIndex((Integer) newValue);
                controller.updatePage();
            }
        };
    }

    private StringConverter<Integer> choiceBoxStringConverter() {
        return new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                if (object.equals(Integer.MAX_VALUE)) return ALL_RECORDS_TITLE;
                else return object.toString();
            }

            @Override
            public Integer fromString(String string) {
                if (string.equals(ALL_RECORDS_TITLE)) return Integer.MAX_VALUE;
                else return Integer.parseInt(string);
            }
        };
    }

    public ChoiceBox<Integer> getChoiceBox() {
        return choiceBox;
    }
}