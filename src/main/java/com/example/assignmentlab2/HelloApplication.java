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
        Label ir = new Label("Annual Interest Rate");
        ir.setLayoutY(50); ir.setLayoutX(10);
        TextField intRate = new TextField();
        intRate.setLayoutX(130);
        intRate.setLayoutY(50);
        Label ny = new Label("Number of Years");
        ny.setLayoutY(100); ny.setLayoutX(10);
        TextField numYears = new TextField();
        numYears.setLayoutY(100);
        numYears.setLayoutX(130);
        Label la = new Label("Loan Amount");
        la.setLayoutY(150);la.setLayoutX(10);
        TextField amt = new TextField();
        amt.setLayoutX(130);
        amt.setLayoutY(150);
        Label mp = new Label("Monthly Payment");
        mp.setLayoutY(200);mp.setLayoutX(10);
        TextField pay = new TextField();
        pay.setLayoutX(130);
        pay.setLayoutY(200);
        Label tp = new Label("Total Payment");
        tp.setLayoutY(250); tp.setLayoutX(10);
        TextField total = new TextField();
        total.setLayoutX(130);
        total.setLayoutY(250);
        Button calc = new Button("Calculate");
        calc.setLayoutX(160);
        calc.setLayoutY(290);
        Group group = new Group(intRate, numYears, amt, pay, calc, tp, la, ny, ir, mp, total);
        Scene scene = new Scene(group, 320, 340);
        stage.setTitle("Loan Calculator");
        stage.setScene(scene);
        stage.show();
        calc.setOnAction(e -> {
            double rate = Double.parseDouble(intRate.getText()) / 100 + 1;
            double years = Double.parseDouble(numYears.getText());
            double amount = Double.parseDouble(amt.getText());
            //I wasn't sure how to get the values that were given in the picture so I hope this is fine
            double totalAmount = rate * years * amount;
            double monthlyPay = totalAmount / (years * 12);
            total.setText(String.valueOf(Math.round(totalAmount*100.0)/100.0));
            pay.setText(String.valueOf(Math.round(monthlyPay*100.0)/100.0));

        });
    }


        public static void main(String[] args) {
        launch();
    }
}