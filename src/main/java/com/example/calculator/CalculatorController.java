package com.example.calculator;

import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CalculatorController {
    private long firstEntry;
    private long secondEntry;
    private String operator = "";
    private Boolean start = true;

    @FXML
    private Label output;

    @FXML
    private void processNumPad(ActionEvent event){

        if(start){
            output.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);

    }
    @FXML
    private void processOperator(ActionEvent event){
        if(output.getText().equals("Error")){
            return;
        }
        String value = ((Button)event.getSource()).getText();
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
                output.setText("Error");
                operator = "";
                start = true;
                return;

            }output.setText(calculation(firstEntry, Long.parseLong(output.getText()), operator));
            operator = "";
            start = true;

        }

    }

@FXML
private void clearOutput(ActionEvent event){
        output.setText("0");
        start = true;
        operator = "";
}

@FXML
private void decimalPoint(ActionEvent event){ // TODO: 3/27/23 Fix decimal point issue 
//        if(output.getText().equals(".")){
            output.setText(output.getText()+".");
            start = true;
            operator = "";
        }





    private String calculation(long firstEntry, long secondEntry, String operator){
        switch(operator){
            case "%":
                return String.valueOf(firstEntry % secondEntry);
            case "+":
                return String.valueOf(firstEntry + secondEntry);
            case "-":
                return String.valueOf(firstEntry - secondEntry);
            case "x":
                return String.valueOf(firstEntry * secondEntry);
            case "/":
                if(secondEntry == 0){
                    return "Error";
                }return String.valueOf(firstEntry / secondEntry);

        }
        return "Error";
    }
}