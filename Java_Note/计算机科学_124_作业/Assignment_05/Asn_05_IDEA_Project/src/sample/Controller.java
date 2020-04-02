package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private ScrollPane LayoutPane;
    @FXML
    private TextArea LineItemInfo;
    @FXML
    private Button LineItemGenerator;
    @FXML
    private TextField Number;
    @FXML
    private ChoiceBox Ham;
    @FXML
    private ChoiceBox Pepper;
    @FXML
    private ChoiceBox Pine;
    @FXML
    private ChoiceBox Cheese;
    @FXML
    private ChoiceBox Vegetarian;
    @FXML
    private ChoiceBox Size;
    private LineItem theLine;
    private Pizza pizza;

}
