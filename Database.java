/** HOW TO USE:
 * 
 * makeSet();
 * 
 * 
 * 
 * Things to save...
 * Stock information for each one of the corporations being tracked
 * Last recorded value for global temperature
 * Effectiveness score tally of each indicator
 * Timestamp for the last time the program interfaced with database
 * 
 * Auto-transactions will occur every second for a stock. When a meter
 * is successful, it will gain points for accuracy, which will give it
 * a stronger bearing on the overall algorithm that gives a binary
 * buy/sell signal.
 * 
 */

package finalproject;

public class Database {

	public static void main(String[] args){
		
		double[] dataSet = makeSet(14400, 4);
		
//		for(int i = 0; i < dataSet.length; i++){
//			System.out.print(dataSet[i] + ", ");
//		}
		
		// The first parameter is for the array you're getting points from.
		// The second parameter is the span of time you're looking at. Past minute (60) five minutes (300) or hour (3600) etc.
		// The third parameter is how many points you're gathering. For stocastics, these may be 14 or 28.
		double[] points = getPointIntervals(dataSet, 300, 140);
		
		for(int i = 0; i < points.length; i++){
			for(int j = 0; j < points[i]; j++){
				System.out.print(" ");
			}
			System.out.println("|");
		}
		
	}
	
	/* Hypothetically, each item in the array tracks the price over the past second. With 14400 data points,
	 * this will cover data over the past four hours. */
	
	public static double newPoint(double lastPoint, double spasticity){
		return Math.round( (lastPoint + (Math.random() * spasticity) - (spasticity / 2.0)) * 100) / 100.0;
	}

	public static double[] getPointIntervals(double[] data, int span, int numOfValues){
		
		double[] retVal = new double[numOfValues];
		
		for(int i = 0; i < retVal.length; i++){
//			System.out.println(i + "th Index taken: " + (int)(data.length - span + Math.round(i * (double)span / numOfValues)));
			// Math.round(data.length - (span / numOfValues))
			// start at data.length - span
			// each successive loop, increase the index by span / numOfValues, rounded
			retVal[i] = data[(int)(data.length - span + Math.round(i * (double)span / numOfValues))];
		}
		
		return retVal;
		
	}
	
	public static double[] makeSet(int numOfValues, double spasticity){
		
		double[] dataSet = new double[numOfValues];
		
		dataSet[0] = Math.round(Math.random() * 10000) / 100.0;
		double newValue = 0;
		
		for(int i = 1; i < numOfValues; i++){
			
			newValue = newPoint(dataSet[i - 1], spasticity);
			
			if(newValue > 100){
				newValue = 100;
			}else if(newValue < 0){
				newValue = 0;
			}
			
			dataSet[i] = newValue;
			
		}
		
		return dataSet;
		
	}
	
}
