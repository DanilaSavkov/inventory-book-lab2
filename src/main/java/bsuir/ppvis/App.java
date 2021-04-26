package bsuir.ppvis;

import bsuir.ppvis.controller.InventoryBookController;
import bsuir.ppvis.model.InventoryBookModel;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;
import bsuir.ppvis.view.AppView;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        InventoryBookModel model = new InventoryBookModel();
        InventoryBookController controller = new InventoryBookController(model);
        AppView appView = new AppView(model, controller);
        Scene scene = new Scene(appView.asParent(), 640, 480);
        stage.setScene(scene);
        stage.setTitle("2 lab");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}