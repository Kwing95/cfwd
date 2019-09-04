package finalproject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class generator {

	public static final int DATE = 0;
	public static final int OPEN = 1;
	public static final int HIGH = 2;
	public static final int LOW = 3;
	public static final int CLOSE = 4;
	public static final int VOLUME = 5;
	public static final int ADJCLOSE = 6;
	private ArrayList<GregorianCalendar> dates;
	public static ArrayList<Double> open;
	private ArrayList<Double> high;
	private ArrayList<Double> low;
	public static ArrayList<Double> close;
	private ArrayList<Integer> volume;
	public static ArrayList<Double> adjclose;
	private static String instrument = "%5EGSPC&";

	public generator(GregorianCalendar start, GregorianCalendar end) { //takes in values for the start and end date to be plugged into the URL
																	   //in the generator method
		dates = new ArrayList<GregorianCalendar>();
		open = new ArrayList<Double>();
		high = new ArrayList<Double>();
		low = new ArrayList<Double>();
		close = new ArrayList<Double>();
		volume = new ArrayList<Integer>();
		adjclose = new ArrayList<Double>();

		// http://real-chart.finance.yahoo.com/table.csv?s=%5EGSPC&a=00&b=3&c=2001&d=03&e=26&f=2015&g=d&ignore=.csv
		
		//chop the url into components and add the start and end date we want
		
		String url = "http://real-chart.finance.yahoo.com/table.csv?s=" + instrument
				+ "&a=" + start.get(Calendar.MONTH) + "&b="
				+ start.get(Calendar.DAY_OF_MONTH) + "&c="
				+ start.get(Calendar.YEAR) + "&d=" + end.get(Calendar.MONTH)
				+ "&e=" + end.get(Calendar.DAY_OF_MONTH) + "&f="
				+ end.get(Calendar.YEAR) + "&g=d&ignore=.csv";
		try {
			URL prices = new URL(url);
			URLConnection data = prices.openConnection();
			Scanner input = new Scanner(data.getInputStream());
			if (input.hasNext()) // skip to the next line
				input.nextLine();

			while (input.hasNextLine()) {
				String line = input.nextLine();

				// System.out.println(line);
				String opens = line.substring(11, 18);
				if(opens.contains(",")){
					opens = opens.substring(0, opens.indexOf(","));
				}
				double opend = Double.parseDouble(opens);
				open.add(opend);
				// String highs = line.substring(22, 31);
				// double highd = Double.parseDouble(highs);
				// high.add(highd);
				// String lows = line.substring(33, 42);
				// double lowd = Double.parseDouble(lows);
				// low.add(lowd);
				// String adjcloses = line.substring(66,70);
				// double closes = Double.parseDouble(adjcloses);
				// close.add(closes);

				System.out.println(open);
				// System.out.println(" " + open.size() + " " + high.size() +
				// " " + low.size());
			}
		} catch (Exception e) {
			System.err.println(e);
		}

	}
	
	public ArrayList<Double> getOpen(){
		System.out.println(open.size());
		return open;
	}
	
	public static void setInstrument(String instrument){
		generator.instrument = instrument;
	}
	
}
