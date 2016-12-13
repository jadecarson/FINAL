package rocketBase;

import org.apache.poi.ss.formula.functions.*;
import java.util.ArrayList;
import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore){
		ArrayList<RateDomainModel> rates = _RateDAL.getAllRates();
		double interestRate = -1.0;
		RateDomainModel rateDomainModel = null;
		
		for (RateDomainModel rate : rates) {
			if (rate.getiMinCreditScore() == GivenCreditScore) {
				interestRate = rate.getdInterestRate();
				rateDomainModel = rate;
			}
		}
		
		if ((rateDomainModel == null) || (interestRate == -1)) {
			throw new RateException(rateDomainModel);
		} else {
			return interestRate;
		}

		private RateBLL Income;
		private RateBLL Expenses;

		public RateBLL getIncome() {
			return Income;
		}

		public void setIncome(RateBLL income) {
			Income = income;
		}

		public RateBLL getExpenses() {
			return Expenses;
		}

		public void setExpenses(RateBLL expenses) {
			Expenses = expenses;
		}
		
		public static double getPayment(double r, double n, double p, double f, boolean t) {
			return FinanceLib.pmt(r / 12, n, p, f, t);
		}
}