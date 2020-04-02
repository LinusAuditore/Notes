package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("GUI Pizza Order System (Ver.114514, Build.1919810)");
        primaryStage.setScene(new Scene(root, 850, 403));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
