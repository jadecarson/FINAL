package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	
	//TODO - RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketDAL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void test() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assertEquals(rates.size(), 5);
		
		assertEquals(rates.get(4).getdInterestRate(), 5.00,  0.01);

		assertEquals(rates.get(3).getdInterestRate(), 4.50, 0.01); 

		assertEquals(rates.get(2).getdInterestRate(), 4.00,  0.01); 

		assertEquals(rates.get(1).getdInterestRate(), 3.50,  0.01); 

		assertEquals(rates.get(0).getdInterestRate(), 3.75,  0.01); 
	}

}
