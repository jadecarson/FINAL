package rocket.app.view;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;
import eNums.eAction;

import exceptions.RateException;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import rocket.app.MainApp;

import rocketBase.RateBLL;

import rocketCode.Action;

import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	@FXML
	private TextField txtIncome;

	@FXML
	private TextField txtExpenses;

	@FXML
	private TextField txtCreditScore;

	@FXML
	private TextField txtHouseCost;

	@FXML
	private TextField txtDownPayment;

	@FXML
	private ComboBox<String> cmbTerm;

	@FXML
	private Label term;

	@FXML
	ObservableList<String> cmbList = FXCollections.observableArrayList("15 years", "16 years");

	@FXML
	public void initialize() {
		cmbTerm.setItems(cmbList);
	}

	@FXML
	private Label lblMortgagePayment;

	@FXML
	private Button btnCalculatePayment;

	@FXML
	private Label creditScore;

	@FXML
	private Label houseCost;

	@FXML
	private Label downPayment;

	@FXML
	private Label thrownException;

	@FXML
	private Label income;

	@FXML
	private Label expenses;

	@FXML
	private TextField txtRate;

	@FXML
	private TextField txtMonthlyPayment;
	
	@FXML
	private Label paymentException;

	@FXML
	private Button exit;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		lq.setiDownPayment(Integer.parseInt(txtDownPayment.getText()));
		lq.setIncome(Double.parseDouble(txtIncome.getText()));
		lq.setExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		try {
			lq.setdRate(RateBLL.getRate(lq.getiCreditScore()));
		} catch (RateException e) {
			lq.setdRate(-1);
		}
		if (cmbTerm.getValue() == "15 years") {
			lq.setiTerm(15);
		} else {
			lq.setiTerm(30);
		}
		
		a.setLoanRequest(lq);
		mainApp.messageSend(lq);
	}
	
	private static NumberFormat cf = NumberFormat.getCurrencyInstance();
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		double onePayment = lRequest.getIncome() * .28;
		double twoPayment = (lRequest.getIncome() * .36 - lRequest.getExpenses());
		double finalPayment;

		if (onePayment < twoPayment) {
			finalPayment = onePayment;
		} else {
			finalPayment = twoPayment;
		}

		double payment = lRequest.getdPayment();

		if (payment > finalPayment) {
			paymentException.setText(payment + finalPayment + "Payment too high");

		} else {
			lblMortgagePayment.setText("Monthly Mortgage Payment: " + cf.format(lRequest.getdPayment()));

		}
	}
	@FXML

	public void Exit(ActionEvent event) {

		System.exit(0);

	}
}
