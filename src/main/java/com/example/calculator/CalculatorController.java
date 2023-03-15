package com.example.calculator;

//import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CalculatorController {
    private long firstEntry;
    private long secondEntry;
    private String operator;

    @FXML
    private Label output;

    @FXML
    private void processNumPad(ActionEvent event){
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);

    }
    @FXML
    private void processOperator(ActionEvent event){
        String value = ((Button) event.getSource()).getText();
        if(!value.equals("=")){
            if(!operator.isEmpty()){
                return;
            }operator = value;
            firstEntry = Long.parseLong(output.getText());
            output.setText("");

        }else{
            if(operator.isEmpty()) {
                return;
            }if(output.getText().isEmpty()){
                output.setText("Err");
                operator = "";

            }output.setText(calculation(firstEntry, Long.parseLong(output.getText()), operator));
            operator = "";

        }

    }


    private String calculation(long firstEntry, long secondEntry, String operator){
        switch(operator){
            case "+":
                return String.valueOf(firstEntry + secondEntry);
            case "-":
                return String.valueOf(firstEntry - secondEntry);
            case "x":
                return String.valueOf(firstEntry * secondEntry);
            case "/":
                if(secondEntry == 0){
                    return "Err";
                }return String.valueOf(firstEntry / secondEntry);
        }
        return "Err";
    }
}