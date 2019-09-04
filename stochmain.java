package finalproject;

import java.util.GregorianCalendar;

public class stochmain {

	public static void main(String[] args){
		GregorianCalendar start = new GregorianCalendar(2015, 0, 01);
		GregorianCalendar end = new GregorianCalendar(2015, 3, 27);
		generator prices = new generator(start, end);
		Stochastic.setPrices(generator.open);;
//		graphPanel panel = new graphPanel(Stochastic1.getPrices());
	 
//		Stochastic1.setClose();
//		Stochastic1.polarity();
//		Stochastic1.precentK();
//		Stochastic1.precentD();
//	}
		
		
}}
