package bsuir.ppvis;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;
import bsuir.ppvis.view.AppView;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        AppView appView = new AppView();
        Scene scene = new Scene(appView.asParent(), 640, 480);
//        Scene scene = new Scene(appView.asParent());
        stage.setScene(scene);
        stage.setTitle("2 lab");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}