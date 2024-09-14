package com.example.assignmentlab2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Created a label for annual rate and set its position
        Label ir = new Label("Annual Interest Rate");
        ir.setLayoutY(50); ir.setLayoutX(10);
        //Created a text field for the user to input the annual rate and set its position
        TextField intRate = new TextField();
        intRate.setLayoutX(130);
        intRate.setLayoutY(50);
        //Created a label for number of years and set its position
        Label ny = new Label("Number of Years");
        ny.setLayoutY(100); ny.setLayoutX(10);
        //Created a text field for the user to input the number of years and set its position
        TextField numYears = new TextField();
        numYears.setLayoutY(100);
        numYears.setLayoutX(130);
        //Created a label for the loan amount and set its position
        Label la = new Label("Loan Amount");
        la.setLayoutY(150);la.setLayoutX(10);
        //Created a text field for the user to input the loan amount and set its position
        TextField amt = new TextField();
        amt.setLayoutX(130);
        amt.setLayoutY(150);
        //Created a label for monthly payment and set its position
        Label mp = new Label("Monthly Payment");
        mp.setLayoutY(200);mp.setLayoutX(10);
        //Created a text field for the monthly pay to be shown
        TextField pay = new TextField();
        pay.setLayoutX(130);
        pay.setLayoutY(200);
        //Created a label for total payment and set its position
        Label tp = new Label("Total Payment");
        tp.setLayoutY(250); tp.setLayoutX(10);
        //Creates a text field for the total amount to be shown
        TextField total = new TextField();
        total.setLayoutX(130);
        total.setLayoutY(250);
        //Created a button to calculate
        Button calc = new Button("Calculate");
        calc.setLayoutX(160);
        calc.setLayoutY(290);
        Group group = new Group(intRate, numYears, amt, pay, calc, tp, la, ny, ir, mp, total);
        Scene scene = new Scene(group, 320, 340);
        stage.setTitle("Loan Calculator");
        stage.setScene(scene);
        stage.show();
        //The code needed to allow the calculate button to properly function
        calc.setOnAction(e -> {
            //Calculates the interest rate and assigns it to rate
            double rate = Double.parseDouble(intRate.getText()) / 100 + 1;
            //Assigns the numYears text field to the double years
            double years = Double.parseDouble(numYears.getText());
            //Assigns the amt text field to the double amount
            double amount = Double.parseDouble(amt.getText());
            //Calculates the total amount that needs to be paid
            double totalAmount = rate * years * amount; //I wasn't sure how to get the values that were given in the picture so I hope this is fine
            //Calculates the monthly amount by dividing by the total number of months
            double monthlyPay = totalAmount / (years * 12);
            //Rounds the two values and puts them into the proper text fields
            total.setText(String.valueOf(Math.round(totalAmount*100.0)/100.0));
            pay.setText(String.valueOf(Math.round(monthlyPay*100.0)/100.0));

        });
    }


        public static void main(String[] args) {
        launch();
    }
}