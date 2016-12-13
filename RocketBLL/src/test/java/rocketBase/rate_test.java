package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;
import exceptions.RateException;

public class rate_test {
	@Test
	public void knownRateTest() throws RateException {
		assertEquals(RateBLL.getRate(800), 3.5, .01);
	}
	
	@Test(expected = RateException.class)
	public void unknownRateTest() throws RateException {
		RateBLL.getRate(725);
	}
	
	@Test
	public void getPaymentTest() {
		assertTrue(RateBLL.getPayment(0.04, 360, 300000, 0, false) == 1432.25);
	}

}
