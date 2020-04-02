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
    private TextField NumberInput;
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
    private TextField TotalPrice;
    @FXML
    private Button DisplayUnitPrice;
    private LineItem[] Lines = new LineItem[100000];
    private String LineStrInfo = "";
    private double LinePriceInfo = 0.0;
    private int i = -1;
    private Pizza pizza;


    final String[] ham = new String[]{"Single", "None"};
    final String[] pepper = new String[]{"Single", "None"};
    final String[] pine = new String[]{"Single", "None"};
    final String[] cheese = new String[]{"Single", "Double", "Triple"};
    final String[] size = new String[]{"Small", "Medium", "Large"};
    final Boolean[] vegetarian = new Boolean[]{true, false};

    public Controller() {
    }

    // Events Start here
    // Create a Pizza and display the unit price

    private void SinglePizza (){
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

    }
    @FXML
    private void ViewUnit(ActionEvent event){
        SinglePizza();
        double UPrice = pizza.getCost();
        UnitPrice.setText("CA$ " + UPrice);
    }
    @FXML
    private void LineItemGeneration(ActionEvent event) {

        int TotalNum = 1;
        try{
            TotalNum = Integer.parseInt(NumberInput.getText());
        }catch (NumberFormatException ignored){
            JOptionPane.showMessageDialog(null, "Invalid Number Choice!" ,"Oh, no!",  JOptionPane.PLAIN_MESSAGE);
            return;
        }
        SinglePizza();
        LineItem theLine = new LineItem(TotalNum, this.pizza);
        this.i += 1;
        this.Lines[this.i] = theLine;
        try {
            this.LineStrInfo += theLine.toString();
            this.LineStrInfo += "\n";
            this.LinePriceInfo += theLine.getCost();
        } catch (IllegalPizza illegalPizza) {
            JOptionPane.showMessageDialog(null, "Invalid Order Configuration!", "Oh, no!", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        LineItemInfo.setText(this.LineStrInfo);
        TotalPrice.setText("CA$ " + this.LinePriceInfo);

    }


}
