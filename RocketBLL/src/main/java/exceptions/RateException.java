package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {


	private RateDomainModel Rdm;
	public RateException(RateDomainModel rdm){
		super();
		Rdm=rdm;
	}
	public RateDomainModel getRte(){
		return Rdm;
	}
}
