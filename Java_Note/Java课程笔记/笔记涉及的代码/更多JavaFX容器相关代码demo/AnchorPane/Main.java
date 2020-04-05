package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = new AnchorPane();
			Button leftTopButton = new Button("Left Top");
			leftTopButton.setFont(new Font("Consolas", 20));
			Button rightBottomButton = new Button("Right Bottom");
			rightBottomButton.setFont(new Font("System", 18));
			Label leftBottomLabel = new Label("Left Bottom");
			leftBottomLabel.setFont(new Font("Times New Roman", 22));
			
			AnchorPane.setLeftAnchor(leftTopButton, 10.0);
			AnchorPane.setTopAnchor(leftTopButton, 10.0);
			AnchorPane.setRightAnchor(rightBottomButton, 10.0);
			AnchorPane.setTopAnchor(rightBottomButton, 10.0);
			AnchorPane.setBottomAnchor(rightBottomButton, 10.0);
			AnchorPane.setLeftAnchor(leftBottomLabel, 80.0);
			AnchorPane.setBottomAnchor(leftBottomLabel, 80.0);
			
			root.getChildren().addAll(leftTopButton, leftBottomLabel, rightBottomButton);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Project AnchorPane");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
