//package com.SecondLab;

//import com.SecondLab.Model.User;
//import com.SecondLab.View.MainWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Customer customer = new Customer(3);
        MainWindow pane = new MainWindow(customer);
        GridPane mainPane = pane.getMainGrid();
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }
}
