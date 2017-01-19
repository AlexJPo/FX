package javaFxCalc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
	@FXML
	private Button btn0;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btn7;
	@FXML
	private Button btn8;
	@FXML
	private Button btn9;
	
	@FXML
	private Button btnReset;
	@FXML
	private Button btnPlus;
	@FXML
	private Button btnMinus;
	@FXML
	private Button btnMulty;
	@FXML
	private Button btnDivide;
	@FXML
	private Button btnSum;
		
	@FXML
	private TextField resultText;
	
	private int firstValue, secondValue;
	private String operation;
	/**
	 * Add numbers(0, 1, 2, 3, 4, 5, 6, 7, 8, 9) 
	 */
	public void addNumber(ActionEvent event) {
		Button currentButton = (Button) event.getSource();
		resultText.setText(resultText.getText() + currentButton.getText());
	}
	/**
	 * Add operation(+, -, *, /) 
	 */
	public void addOperation(ActionEvent event) {
		Button currentButton = (Button) event.getSource();
		
		firstValue = Integer.valueOf(resultText.getText());
		operation = currentButton.getText();
		resultText.clear();		
	}
	/**
	 * Clear TextField and write first number to 'firstValue'
	 */
	public void resetTextField(ActionEvent event) {
		resultText.clear();
	}
	/**
	 * Calculate result values
	 */
	public void summValues(ActionEvent event) {
		secondValue = Integer.valueOf(resultText.getText());
		
		switch (operation) {
			case "+":
				resultText.setText(String.valueOf(firstValue + secondValue));
				break;
			case "-":
				resultText.setText(String.valueOf(firstValue - secondValue));
				break;
			case "*":
				resultText.setText(String.valueOf(firstValue * secondValue));
				break;
			case "/":
				resultText.setText(String.valueOf(firstValue / secondValue));
				break;
		}
	}
}
