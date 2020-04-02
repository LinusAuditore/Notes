package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

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
    @FXML
    private TextField UnitPrice;
    @FXML
    private Button DisplayUnitPrice;
    private LineItem theLine;
    private Pizza pizza;

    final String[] ham = new String[]{"Single", "None"};
    final String[] pepper = new String[]{"Single", "None"};
    final String[] pine = new String[]{"Single", "None"};
    final String[] cheese = new String[]{"Single", "Double", "Triple"};
    final String[] size = new String[]{"Small", "Medium", "Large"};
    final Boolean[] vegetarian = new Boolean[]{true, false};

    // Events Start here
    // Create a Pizza and display the unit price
    @FXML
    private void SinglePizza (ActionEvent event){
        String HamChoice = ham[Ham.getSelectionModel().getSelectedIndex()];
        String PepperChoice = pepper[Pepper.getSelectionModel().getSelectedIndex()];
        String PineChoice = pine[Pine.getSelectionModel().getSelectedIndex()];
        String CheeseChoice = cheese[Cheese.getSelectionModel().getSelectedIndex()];
        String SizeChoice = size[Size.getSelectionModel().getSelectedIndex()];
        Boolean VegetarianChoice = vegetarian[Vegetarian.getSelectionModel().getSelectedIndex()];
        try{
            this.pizza = new Pizza(SizeChoice, VegetarianChoice, CheeseChoice, PineChoice, PepperChoice, HamChoice);
        }catch (IllegalPizza illegalPizza) {
            JOptionPane.showMessageDialog(null, "Invalid Pizza Configuration!" ,"Oh, no!",  JOptionPane.PLAIN_MESSAGE);
        }
        double UPrice = pizza.getCost();
        UnitPrice.setText("CA$ " + UPrice);
    }

}
