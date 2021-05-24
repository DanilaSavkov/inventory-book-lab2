package bsuir.ppvis;

import bsuir.ppvis.model.InventoryBookModel;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;
import bsuir.ppvis.view.AppView;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        InventoryBookModel model = new InventoryBookModel();
        AppView appView = new AppView(model);
        Scene scene = new Scene(appView, 900, 600);
        stage.setScene(scene);
        stage.setTitle("Таблица");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}