/** Things to save...
 * Stock information for each one of the corporations being tracked
 * Last recorded value for global temperature
 * Effectiveness score tally of each indicator
 * Timestamp for the last time the program interfaced with database
 * 
 * Auto-transactions will occur every second for a stock. When a meter
 * is successful, it will gain points for accuracy, which will give it
 * a stronger bearing on the overall algorithm that gives a binary
 * buy/sell signal. */

package finalproject;
import java.util.ArrayList;

public class DatabaseAL {
	
	private final static int priceMin = 1500;//1500
	private final static int priceMax = 2000;//2000

	public static void main(String[] args){
		
		ArrayList<Double> dataSet = makeSet(14400, 4);//14 days = 1,209,600 seconds, spasticity 20
		
//		for(int i = 0; i < dataSet.length; i++){
//			System.out.print(dataSet[i] + ", ");
//		}
		
		// The first parameter is for the array you're getting points from.
		// The second parameter is the span of time you're looking at. Past minute (60) five minutes (300) or hour (3600) etc.
		// The third parameter is how many points you're gathering. For stocastics, these may be 14 or 28.
		ArrayList<Double> points = getPointIntervals(dataSet, 300, 140);
		
		for(int i = 0; i < points.size(); i++){
			for(int j = 0; j < points.get(i); j++){
				System.out.print(" ");
			}
			System.out.println("| " + points.get(i));
		}
		
	}
	
	/* Hypothetically, each item in the array tracks the price over the past second. With 14400 data points,
	 * this will cover data over the past four hours. */
	
	public static double getLow(ArrayList<Double> set){
		double retVal = set.get(0);
		for(int i = 0; i < set.size(); i++){
			retVal = Math.min(retVal, set.get(i));
		}
		return retVal;
	}
	
	public static double getHigh(ArrayList<Double> set){
		double retVal = set.get(0);
		for(int i = 0; i < set.size(); i++){
			retVal = Math.max(retVal, set.get(i));
		}
		return retVal;
	}
	
	public static double newPoint(double lastPoint, double spasticity){
		//Keep in mind newPoint will only generate a percentage of a maximum
		double retVal = Math.round( (lastPoint + (Math.random() * spasticity) - (spasticity / 2.0))  * 100) / 100.0;
		if(retVal > priceMax){
			retVal = priceMax;
		}else if(retVal < priceMin){
			retVal = priceMin;
		}
		return retVal;
	}

	public static ArrayList<Double> getPointIntervals(ArrayList<Double> data, int span, int numOfValues){
		
		ArrayList<Double> retVal = new ArrayList<>();
		
		for(int i = 0; i < numOfValues; i++){
//			System.out.println(i + "th Index taken: " + (int)(data.length - span + Math.round(i * (double)span / numOfValues)));
			// Math.round(data.length - (span / numOfValues))
			// start at data.length - span
			// each successive loop, increase the index by span / numOfValues, rounded
			retVal.add(i, data.get((int)(data.size() - span + Math.round(i * (double)span / numOfValues))));
		}
		
		return retVal;
		
	}
	
	public static ArrayList<Double> makeSet(int numOfValues, double spasticity){
		
		ArrayList<Double> dataSet = new ArrayList<>();
		
		dataSet.add(Math.round(Math.random() * 10000) / 100.0);
		
		for(int i = 1; i < numOfValues; i++){
			dataSet.add(i, newPoint(dataSet.get(i - 1), spasticity));
		}
		
		return dataSet;
		
	}
	
}
