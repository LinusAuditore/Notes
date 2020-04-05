package application;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			root.setHgap(20);
			root.setVgap(20);
			root.setGridLinesVisible(false);
			
			ColumnConstraints column0 = new ColumnConstraints();
			column0.setHalignment(HPos.CENTER);
			root.getColumnConstraints().add(column0);
			ColumnConstraints column1 = new ColumnConstraints();
			column1.setHalignment(HPos.RIGHT);
			root.getColumnConstraints().add(column1);
			ColumnConstraints column2 = new ColumnConstraints();
			column2.setHalignment(HPos.CENTER);
			root.getColumnConstraints().add(column2);
			
			Font myFont = new Font("Consolas", 24);
			Font bigFont = new Font("Consolas", 32);
			Label label1 = new Label("Label");
			Label label2 = new Label("Wide Label");
			Label topLabel = new Label("Top Label!");
			Button button1 = new Button("Button");
			Button button2 = new Button("Wide Button");
			
			label1.setFont(myFont);
			label2.setFont(myFont);
			topLabel.setFont(bigFont);
			button1.setFont(myFont);
			button2.setFont(myFont);
			
			//				column, row, colspan, rowspan
			root.add(topLabel, 0, 0, 3, 1);	// Try changing column span.
			root.add(label1,   1, 1);
			root.add(label2,   1, 2);
			root.add(button1,  2, 1);
			root.add(button2,  2, 2);
			
			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Project GridPane");	// Change window title
			primaryStage.show();
			
			// How to get the buttons to be the same size?
			button1.setPrefWidth(button2.getWidth());

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
