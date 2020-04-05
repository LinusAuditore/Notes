package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class Main extends Application {

	private void getWidths(Button aButton) {
		double width = aButton.getWidth();
		double layoutWidth = aButton.getLayoutBounds().getWidth();
		System.out.println("For " + aButton.getText() + ":");
		System.out.print("Width = " + width + ", Layout Width = " + layoutWidth);
		double textWidth = width - aButton.getPadding().getLeft() - aButton.getPadding().getRight();
		System.out.println(", Text Width = " + textWidth);		
	} // end getWidths
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FlowPane root = new FlowPane();
			//FlowPane root = new FlowPane(Orientation.VERTICAL);
			//FlowPane root = new FlowPane(Orientation.HORIZONTAL);	// Default
			root.setHgap(10);
			root.setVgap(5);
			ArrayList<Button> buttons = new ArrayList<>();
			Button toAdd;
			Font myFont = new Font("Consolas", 20);
			for (int i = 0; i < 15; i++) {
				toAdd = new Button("Button " + i);
				toAdd.setFont(myFont);
				//toAdd.setPrefSize(140, 30);
				toAdd.setPadding(new Insets(20, 20, 20, 20));
				buttons.add(toAdd);
			}
			root.getChildren().addAll(buttons);
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Project FlowPane");
			primaryStage.show();
			
			// Can only get sizes after window is showing:
			getWidths(buttons.get(1));
			getWidths(buttons.get(10));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
