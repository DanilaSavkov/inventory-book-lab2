package bsuir.ppvis;

import bsuir.ppvis.controller.AddingController;
import bsuir.ppvis.model.InventoryBookModel;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;
import bsuir.ppvis.view.AppView;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        InventoryBookModel model = new InventoryBookModel();
        AddingController controller = new AddingController(model);
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