package finalproject;

import java.util.ArrayList;

import javax.swing.Timer;

import java.util.Collections;

public class Stochastic {

	private static ArrayList<String> close = new ArrayList<String>();
	private static double closeValue;
	private static ArrayList<String> HHigh = new ArrayList<String>();
	private static ArrayList<String> LLow = new ArrayList<String>();
	public static ArrayList<String> prices = new ArrayList<String>();
	private static int index = 0;
	private static int i = 0;
	public static String lowestLow;
	public static String highestHigh;
	public static ArrayList<String> H1 = new ArrayList<String>();
	public static double h1value;
	public static ArrayList<String> H2 = new ArrayList<String>();
	public static double h2value;
	public static ArrayList<String> value = new ArrayList<String>();
	public static ArrayList<String> preK = new ArrayList<String>();
	public static ArrayList<String> pred = new ArrayList<String>();
	public static double precentk;
	public static int maxValue = 100;
	public static String signalerS;
	public static int buytradesS = 0;
	public static int selltradesS = 0;
	public static String Strenght;
	public static int wintradesS = 0;
	public static int losetradesS = 0;
	public static int buytradesF = 0;
	public static int selltradesF = 0;
	public static int wintradesF = 0;
	public static int losetradesF = 0;
	public static String signalerF;
	public static ArrayList<String> signaler = new ArrayList<>();
	public static ArrayList<Integer> buy = new ArrayList<>();
	public static ArrayList<Integer> sell = new ArrayList<>();
	public static int run = 0;
	public static boolean winF;
	public static boolean winS;
	public static ArrayList<Double> profit = new ArrayList<>();
	public static ArrayList<Double> loss = new ArrayList<>();
	public static ArrayList<String> fibonacci = new ArrayList<>();
	public static int fibonacciPeriod = 10;
	public static int stochasticPeriod = 15;
	public static double temp = 0;
	public static double val1;// %k
	public static double val2;// %d
	public static String val1b;// initial
	public static String val2b;// final
	public static double difference;
	public static double netProfit;
	public static double winbuytrades;
	public static double winselltrades;

	// static Interpreter signal = new Interpreter();

	public Stochastic() {

		// Stochastic1.generator();
		// Stochastic1.setClose();
		// Stochastic1.polarity();
		// Stochastic1.precentK();

	}

	public static void Analysis() {

		run++;

		if (pred.size() > 3) {

			System.out.println("THIS IS THE CLOSING PRICE: "
			+ prices.get(prices.size() - 1));
			System.out.println("highestHigh: " + highestHigh);
			System.out.println("lowestLow: " + lowestLow);
			System.out.println("Close price: " + prices.get(prices.size() - 1));

			// System.out.println("this is the H1 value: " + H1);

			// System.out.println("this is the H1 value: " + h1value);

			// System.out.println("size of the H1 value: " + H1.size());

			// System.out.println("this is the H2 value: " + H2);

			// System.out.println("this is the H2 value: " + h2value);

			// System.out.println("size of the H2 value: " + H2.size());

			// System.out.println("Stochastic %k: " + preK);

			// System.out.println("Size of %k: " + preK.size());

			// System.out.println("Stochastic %D: " + pred);

			// System.out.println("Size of %D: " + pred.size());

			String Value1 = pred.get(Stochastic.pred.size() - 1);

			String Value2 = preK.get(Stochastic.preK.size() - 1);

			System.out.println("the last three closing prices: "

			+ prices.get(prices.size() - 4) + " "

			+ prices.get(prices.size() - 3) + " "

			+ prices.get(prices.size() - 2) + " "

			+ prices.get(prices.size() - 1));

			System.out.println("the last three %k values: "

			+ preK.get(pred.size() - 4) + " "

			+ preK.get(pred.size() - 3) + " "

			+ preK.get(pred.size() - 2) + " "

			+ preK.get(pred.size() - 1));

			System.out.println("the last three %d values: "

			+ pred.get(pred.size() - 4) + " "

			+ pred.get(pred.size() - 3) + " "

			+ pred.get(pred.size() - 2) + " "

			+ pred.get(pred.size() - 1));

			System.out.println("number of prices: " + prices.size());

			// while (prices.size() > 20 && run < prices.size() -1) {

			String Value1b = prices.get(prices.size() - 2);

			// System.out.println(Value1b);//check

			String Value2b = prices.get(prices.size() - 1);

			// System.out.println(Value2b);//check

			String Value1a = preK.get(preK.size() - 5);

			// System.out.println(Value1a);//check

			// System.out.println(preK.get(pred.size() - 2));//check

			String Value2a = pred.get(pred.size() - 2);

			// System.out.println(Value2a);//check

			double value1 = Double.parseDouble(Value1b);

			double value2 = Double.parseDouble(Value2b);

			difference = value1 - value2;

			for (int q = 0; q < profit.size(); q++) {

				netProfit += profit.get(q);

				System.out.println(profit.get(q));

			}

			System.out.println("The net profit: " + netProfit);

			System.out.println("Total number of trades: "
					+ (buytradesS + selltradesS));

			System.out.println("difference of prices: " + difference);

			System.out.println("The number of buy trades: " + buytradesS);

			System.out.println("The number of sell trades: " + selltradesS);

			System.out.println("Total number of winning trades: " + wintradesS);

			System.out.println("percentage of win buy trades: "
					+ ((winbuytrades / buytradesS) * 100));

			System.out.println("percentage of win sell trades: "
					+ ((winselltrades / selltradesS) * 100));

			System.out
					.println("percentage of winning trades: "
							+ (((winbuytrades + winselltrades) / (buytradesS + selltradesS)) * 100));

			System.out.println("difference of prices: " + difference);
			
			

			// signalerS = "buy";

			// buytradesS++;

			// if (val1b < val2b) {

			// wintradesS++;

			// winS = true;

			//

			// } else {

			// losetradesS++;

			// winS = false;

			// }

			// if (winS) {

			// profit.add(difference);

			// System.out.println("The profit on the trade is: "

			// + difference * 10);

			// } else {

			// loss.add(difference);

			// System.out.println("The loss on the trade is: "

			// + difference * 10);

			// }

			// }

			// if (val2 <= val1) {

			// signalerS = "sell";

			// selltradesS++;

			// if (val1b > val2b) {

			// wintradesS++;

			// winS = true;

			//

			// } else {

			// losetradesS++;

			// winS = false;

			// }

			// if (winS) {

			// profit.add(difference);

			// System.out.println("The profit on the trade is: "

			// + difference * 10);

			// } else {

			// loss.add(difference);

			// System.out.println("The loss on the trade is: "

			// + difference * 10);

			// }

			// }

			// // if (preK.get(preK.size() - 2) ==0){

			// //

			// // }

			//

			// }

			// }

			//

			// if (val1 >= val2) {

			// signaler = "buy";

			// buytrades++;

			// double difference = val2 - val1;

			// if (difference == 10) {

			// Strenght = "mild";

			// } else if (difference > 10) {

			// Strenght = "strong";

			// } else if (difference < 10) {

			// Strenght = "weak";

			// }

			// if (val1b <= val2b) {

			// wintrades++;

			// } else if (val1b >= val2b) {

			// losetrades++;

			// }

			// }

			// if (val1 <= val2) {

			// signaler = "sell";

			// selltrades++;

			// double difference = val2 - val1;

			// if (difference == 10) {

			// Strenght = "mild";

			// } else if (difference > 10) {

			// Strenght = "strong";

			// } else if (difference < 10) {

			// Strenght = "weak";

			// }

			//

			// if (val1b >= val2b) {

			// wintrades++;

			// } else if (val1b <= val2b) {

			// losetrades++;

			// }

			// }

			// System.out.println("number of winning trades: " + wintrades);

			// // double precentagewin = (wintrades / (buytrades + selltrades))
			// *

			// 100;

			//

			// System.out.println("algo recommends: " + signaler + " "

			// + "strenght of recommendation: " + Strenght);

			// // System.out.println("the precentage of winning trades: "

			// // + precentagewin);

			System.out.println();

			System.out.println();

			System.out.println();

			//

			//

		}

	}

	// }

	public static void Tradable() {

		if (pred.size() > 3) {

			// System.out.println("number of prices: " + prices.size());

			// while (prices.size() > 20 && run < prices.size() -1) {

			String Value1b = prices.get(prices.size() - 2);

			// System.out.println(Value1b);//check

			String Value2b = prices.get(prices.size() - 1);

			// System.out.println(Value2b);//check

			String Value1a = preK.get(preK.size() - 4);

			// System.out.println(Value1a);//check

			// System.out.println(preK.get(pred.size() - 2));//check

			String Value2a = pred.get(pred.size() - 2);

			double value1 = Double.parseDouble(Value1a);

			double value2 = Double.parseDouble(Value2a);

			double difference = value1 - value2;

			if (difference > stochasticPeriod
					|| difference < -1 * stochasticPeriod) {

				// System.out.println("number of prices: " + prices.size());

				// while (prices.size() > 20 && run < prices.size() -1) {

				String Value1b1 = prices.get(prices.size() - 2);

				// System.out.println(Value1b);//check

				String Value2b1 = prices.get(prices.size() - 1);

				// System.out.println(Value2b);//check

				String Value1a1 = preK.get(preK.size() - 5);

				// System.out.println(Value1a);//check

				// System.out.println(preK.get(pred.size() - 2));//check

				String Value2a1 = pred.get(pred.size() - 2);

				double value11 = Double.parseDouble(Value1a1);

				double value21 = Double.parseDouble(Value2a1);

				if (value11 >= value21) {

					Transaction(1);
				}

				else if (value11 <= value21) {

					Transaction(0);
				}

			}

		}

		Analysis();

	}

	public static ArrayList<String> getPrices() {

		return prices;

	}

	public static void setPrices(ArrayList<Double> prices) {

		for (int i = 0; i < prices.size(); i++) {

			double value = prices.get(i);

			String values = "" + value;

			Stochastic.prices.add(values);

			generator();

		}

	}

	public static void generator() {

		// // database.makeSet(14000, 20);

		// double num1;

		//

		// while (prices.size() < maxValue) {

		//

		// num1= Math.random() * 2000; // Generate random numbers to

		// // simulate price fluctuations

		//

		// if (num1 > 1500) {

		//

		// index++;

		// String number = new Double(num1).toString();

		// prices.add(number); // add these prices to the list 'price'

		// close.add(number); // add these prices to the list 'close'

		// System.out.println("Current Price: " + number);

		// System.out.println("" + index);

		// if (index >= 14) {

		setClose();

		polarity();

		Tradable();
		
		Fibonacci(fibonacciPeriod);

		// Fibonacci(fibonacciPeriod);

		// }

		// }

		// }

		// else if (prices.size()>56){

		// polarity();

		// polarityfinal();

		// }

		// HHigh.add(number);

		// LLow.add(number);

	}

	// public static void generator(){

	// double[] dataSet = makeSet(700, 2000);

	// // for(int i = 0; i < dataSet.length; i++){

	// // System.out.print(dataSet[i] + ", ");

	// // }

	// double[] points = getPointIntervals(dataSet, 600, 140);

	// for(int i = 0; i < points.length; i++){

	// for(int j = 0; j < points[i]; j++){

	// System.out.print(" ");

	// }

	// for (int i1 = 0; i1 < points.length; i1++){

	// System.out.println("|" + points[i1]);

	// }

	//

	// }

	// }

	//

	// public static double newPoint(double lastPoint, double spasticity){

	// //return Math.round( (lastPoint + (Math.random() * spasticity) -

	// (spasticity / 2.0)) * 100) / 100.0;

	// return Math.round( (lastPoint + (Math.random() * spasticity) -

	// (spasticity / 2.0)) * 100) / 100.0;

	// }

	// public static double[] getPointIntervals(double[] data, int span, int

	// numOfValues){

	// double[] retVal = new double[numOfValues];

	// for(int i = 0; i < retVal.length; i++){

	// // System.out.println(i + "th Index taken: " + (int)(data.length - span +

	// Math.round(i * (double)span / numOfValues)));

	// // Math.round(data.length - (span / numOfValues))

	// // start at data.length - span

	// // each successive loop, increase the index by span / numOfValues,

	// rounded

	// retVal[i] = data[(int)(data.length - span + Math.round(i * (double)span /

	// numOfValues))];

	// }

	// return retVal;

	// }

	// public static double[] makeSet(int numOfValues, double spasticity){

	// double[] dataSet = new double[numOfValues];

	// //dataSet[0] = Math.round(Math.random() * 2000) / 100.0;

	// dataSet[0] = Math.round(Math.random() * 2000) / 100.0;

	// double newValue = 0;

	// for(int i = 1; i < numOfValues; i++){

	// newValue = newPoint(dataSet[i - 1], spasticity);

	// if(newValue > 100){

	// newValue = 100;

	// }else if(newValue < 0){

	// newValue = 0;

	// }

	// dataSet[i] = newValue;

	// }

	// return dataSet;

	// }

	// public static void load(double[] p){

	// dataset

	// for (int i =0; i<p.length; i++){

	// String price = "" + p[i];

	// close.add(price);

	// HHigh.add(price);

	// LLow.add(price);

	// // prices.add(price);

	// }

	// }

	public static void setClose() {

		String closeprice = prices.get(prices.size() - 1);

		closeValue = Double.parseDouble(closeprice);

	}

	public static void polarity() {

		// if (prices.size() % 14 == 0) {

		if (prices.size() >= stochasticPeriod) {

			// ever 14th price move the algorithim is triggered

			for (int q = prices.size() - stochasticPeriod; q < prices.size(); q++) {

				LLow.add(prices.get(q));

				HHigh.add(prices.get(q));

			}

			Collections.sort(LLow);

			Collections.sort(HHigh);

			lowestLow = LLow.get(0);

			setH2(lowestLow);

			highestHigh = HHigh.get(HHigh.size() - 1);

			setH1(highestHigh, lowestLow);

		}

		precentK();

		precentD();

	}

	public static void polarityfinal() {

		if (prices.size() == maxValue || prices.size() > 55) {

			Stochastic.i = prices.size() - 55;

			for (int q = Stochastic.i; q < prices.size(); q++) {

				LLow.add(prices.get(q));

				HHigh.add(prices.get(q));

			}

			Collections.sort(LLow);

			Collections.sort(HHigh);

			lowestLow = LLow.get(0);

			setH2(lowestLow);

			highestHigh = HHigh.get(HHigh.size() - 1);

			setH1(highestHigh, lowestLow);

		}

		// for (int r = Stochastic1.i; r < prices.size(); r++){

		// HHigh.add(prices.get(r));

		// Collections.sort(HHigh);

		// int pus = HHigh.size();

		//

		// }

	}

	public static double getH1() {

		return h1value;

	}

	public static void setH1(String high, String low) {

		double Hvalue = Double.parseDouble(high);

		double Lvalue = Double.parseDouble(low);

		double value = Hvalue - Lvalue;

		String pvalue = "" + value;

		H1.add(pvalue);

		h1value = value;

	}

	public static double getH2() {

		return h2value;

	}

	public static void setH2(String low) {

		int i;

		int q;

		// for (i = 0; i < close.size(); i++) {

		// for (q = 0; q < LLow.size(); q++) {

		// String value1 = close.get(close.size() - 1);

		// String value2 = LLow.get(i);

		double value1 = closeValue;

		String value2 = low;

		double v2 = Double.parseDouble(value2);

		double h1 = value1 - v2;

		String value = "" + h1;

		H2.add(value);

		h2value = h1;

	}

	// }

	//

	public static void precentK() {

		if (prices.size() > stochasticPeriod) {

			// for (int i = 0; i < H1.size(); i++) {

			// for (int q = 0; q < H2.size(); q++) {

			String value1 = H2.get(H2.size() - 1);

			String value2 = H1.get(H1.size() - 1);

			double v1 = Double.parseDouble(value1);

			double v2 = Double.parseDouble(value2);

			if (v2 == 0) {

				String noValue = "no value";

				preK.add(noValue);

			} else {

				double value = (v1 / v2) * 100;

				String total = "" + value;

				preK.add(total);

				precentk = value;

				// }System.out.println("" + preK);

			}

		}

	}

	public static void precentD() {

		if (prices.size() == maxValue || prices.size() > stochasticPeriod + 3) {

			String valueh1 = H1.get(H1.size() - 3);

			String valueh1a = H1.get(H1.size() - 2);

			String valueh1b = H1.get(H1.size() - 1);

			double Averageh1 = (Double.parseDouble(valueh1)

			+ Double.parseDouble(valueh1a) + Double

			.parseDouble(valueh1b)) / 3;

			String valueh2 = H2.get(H2.size() - 3);

			String valueh2a = H2.get(H2.size() - 2);

			String valueh2b = H2.get(H2.size() - 1);

			double Averageh2 = (Double.parseDouble(valueh2)

			+ Double.parseDouble(valueh2a) + Double

			.parseDouble(valueh2b)) / 3;

			double precentD = (Averageh2 / Averageh1) * 100;

			String precent = "" + precentD;

			pred.add(precent);

		}

	}

	public static void Transaction(int flag) {

		if (flag == 1) {

			buy.add(1);

			buytradesS++;

			System.out.println("recommendation BUY");

			val1b = prices.get(prices.size() - 2);

			double value1 = Double.parseDouble(val1b);

			val2b = prices.get(prices.size() - 1);

			double value2 = Double.parseDouble(val2b);

			if (value1 <= value2) {

				difference = value1 - value2;

				wintradesS++;

				winbuytrades++;

				profit.add(difference * 10);

			}

			else {

				losetradesS++;

				profit.add(-1 * difference * 10);

			}

			System.out.println("Info for transaction#: "
					+ (buytradesS + selltradesS) + " - " + prices.size()
					+ generator.DATE);

			System.out.println("Trade P&L: " + profit.get(profit.size() - 1));

			System.out.println("TOTAL P&L: " + profit);

			System.out.println(" ");

			System.out.println(" ");

		}

		if (flag == 0) {

			sell.add(1);

			selltradesS++;

			System.out.println("recommendation SELL");

			val1b = prices.get(prices.size() - 2);

			double value1 = Double.parseDouble(val1b);

			val2b = prices.get(prices.size() - 1);

			double value2 = Double.parseDouble(val2b);

			if (value1 >= value2) {

				difference = value2 - value1;

				wintradesS++;

				winselltrades++;

				profit.add(difference * 10);

			}

			else {
				losetradesS++;

				profit.add(difference * 10 * -1);

			}

			System.out.println("Info for transaction#: "
					+ (buytradesS + selltradesS) + " - " + prices.size()
					+ generator.DATE);

			System.out.println("Trade P&L: " + profit.get(profit.size() - 1));

			System.out.println("TOTAL P&L: " + profit);

			System.out.println(" ");

			System.out.println(" ");

		}

	}

	public static void Fibonacci(int period) {

//		while (prices.size() > period + 2
//				&& prices.size() > stochasticPeriod + 3) {
		
		if (prices.size() > period*3) {

			for (int i = prices.size() - period*2; i < prices.size(); i++) {

				fibonacci.add(prices.get(i));

			}

			Collections.sort(fibonacci);

			String low = fibonacci.get(0);
			
			System.out.println("This is the low price: " + low);

			String high = fibonacci.get(fibonacci.size() - 1);
			
			System.out.println("This is the high price: " + high);

			double lowprice = Double.parseDouble(low);
			
			
			System.out.println(lowprice);

			double highprice = Double.parseDouble(high);
			
			System.out.println(highprice);

			double difference = highprice - lowprice;

			double Price = Double.parseDouble(prices.get(prices.size() - 1));

			double fiftyline = difference / 2;
			
			System.out.println(fiftyline);

			double fitlydifference = ((Price-difference) / difference) * 100;

			System.out.println(fitlydifference);
			
			System.out.println(" ");

			String fifty = "" + fiftyline;

			fibonacci.add(fifty);

			if (Price > fiftyline) {

				if (fitlydifference <= 75) {

					signalerF = "sell";

				}

			}
			else {
				System.out.println("There is not enough price data to generate this indicator.");
			}

		}

	}

}