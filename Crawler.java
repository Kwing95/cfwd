/** HOW TO USE:
 * 
 * getMood(urls, yay, nay): double
 *    urls is an array of Strings. The method will check all of the URLs in them.
 *    yay and nay are arrays of Strings. The method will look for instances of them.
 *    
 * getSiteMood(url, yay, nay): double
 *    Same as above, but only checks one website. This method will search for search for words
 *    in yay and nay that appear inside of hyperlinks, and will then use getPageMood(); to crawl
 *    those pages. Keep in mind this method only branches once - a homepage may direct the method
 *    to check 10 pages, but it will not look for links within those 10 pages, it will only get
 *    the word count from them.
 *    
 * getPageMood(url, yay, nay): double
 *    Returns the temperature of just one webpage.
 *
 * Note: There should be an inherentMod value for each website which states the temperature of a website's UI and
 * compensates appropriately so that it does not interfere with the temperature reading. This is of course dependent
 * upon which sites are being read from. */

package finalproject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Crawler {

		public static void main(String args[]) throws IOException {
			
		    String[] yay = {"buy", "bull", "positive", "award", "hire", "well", "good",
		        "positive", "ethical", "profit", "grow", "earn", "cut", "cheap", "bonus", "higher",
		        "success", "record", "propel", "improve", "recover", "surge", "gain", "dividends", "interest", 
		        "new", "hit", "up", "above", "benefit", "spike", "best", "rise", "better", "profit",          };
		    String[] nay = { "sell", "bear", "incompetence", "strike", "fire", "poor",
		        "bad", "negative", "suffer", "downsiz", "debt", "lose", "ukraine", "isis", "attack", 
		         "hike", "bankrupt", "yellen", "janet", "mario", "draghi", "default", "foreclosure", "disappoint", 
		         "law", "suit", "vladimir", "putin", "crisis", "tax", "taxes", "threat", "accident", "crash",
		         "disaster", "hurricane", "tornado", "earthquake", "climate", "iran", "syria", "iraq", "afghanistan",
		         "obama", "clinton", "democrat", "israel"};
		    
			//String[] yay = {"buy", "positive", "award", "hire", "well", "good", "positive", "ethical", "profit", "grow", "earn"};
//			double[] yayVal = {};
			//String[] nay = {"sell", "incompetence", "strike", "fire", "poor", "bad", "negative", "suffer", "downsiz", "debt", "lose"};
//			double[] nayVal = {};
			String[] sites = {"http://www.wsj.com", "http://www.bloomberg.com", "http://www.dailyfx.com", "http://www.financialtimes.com"};
			double[] siteTemps = {3, 5, -1, 0};
			
			System.out.println("Working...");
			System.out.println("Temperature: " + getSimpleMood(sites, yay, nay, siteTemps));
			
		}
		
		public static double getSimpleMood(String[] urlsToCheck, String[] yay, String[] nay, double[] zero) throws IOException {
			double temperature = 0;
			
			for(int i = 0; i < urlsToCheck.length; i++){
				temperature += getPageMood(urlsToCheck[i], yay, nay, zero[i]);
				System.out.println("Crawled a page.");
			}
			
			return temperature;
		}
		
		public static double getMood(String[] urlsToCheck, String[] yay, String[] nay, double[] zero) throws IOException {
			double temperature = 0;
			
			for(int i = 0; i < urlsToCheck.length; i++){
				temperature += getSiteMood(urlsToCheck[i], yay, nay, zero[i]);
			}
			
			return temperature;
		}
		
		public static double getSiteMood(String urlToCheck, String[] yay, String[] nay, double zero) throws IOException {
			
			double temperature = 0;
			String feed = getFeed(urlToCheck);
			ArrayList<String> crawlQueue = new ArrayList<>();
			
			/* Loop through the news feed for instances of items in yay[] and nay[] */
			crawlQueue = addPagesToQueue(crawlQueue, yay, feed);
			crawlQueue = addPagesToQueue(crawlQueue, nay, feed);
			
//			System.out.println(crawlQueue.size());
//			System.out.println(crawlQueue);
			
			for(int i = 0; i < crawlQueue.size(); i++){
				temperature += getPageMood(crawlQueue.get(i), yay, nay, zero);
			}
			
			return temperature;
		}
		
		private static ArrayList<String> addPagesToQueue(ArrayList<String> initial, String toCheck[], String feed){
			
			int atIndex = 0;
			int startIndex = 0;
			
			for(int i = 0; i < toCheck.length; i++){
				while(true){
					//System.out.println(feed.indexOf(keyword, atIndex));
					atIndex = feed.indexOf(toCheck[i], atIndex + 1);
					if(atIndex == -1){
						break;
					}else{
						startIndex = feed.lastIndexOf("http:", atIndex) - 1;
						initial.add(feed.substring(startIndex + 1, feed.indexOf("\"", startIndex + 1)));
						
						if(initial.size() >= 5){
							return initial;
						}
						
					}
				}
			}
			
			return initial;
		}
		
		public static double getPageMood(String urlToCheck, String[] yay, String[] nay, double zero) throws IOException {
			
			String feed = getFeed(urlToCheck);
			
			double yayCount = 0;
			double nayCount = 0;
			
			/* Loop through the news feed for instances of 
			 * items in yay[] and nay[] */
			for(int i = 0; i < yay.length; i++){
				yayCount += wordCounter(feed, yay[i]);
			}
			
			for(int i = 0; i < nay.length; i++){
				nayCount += wordCounter(feed, nay[i]);
			}
			
			//System.out.println("+ " + yayCount + " - " + nayCount);
			return yayCount - nayCount - zero;
			
		}
		
		public static String getFeed(String urlToCheck) throws IOException {
			
			URL url = new URL(urlToCheck);
			String feed = "";
				
			try {
			Scanner feedRead = new Scanner(url.openStream());
				
			while(feedRead.hasNext()){
				feed = feed + "\n" + feedRead.next();
			}
			
			feedRead.close();
			return feed.toLowerCase();
			
			}
			catch(IOException e){
				return "";
			}
		}
		
		public static double wordCounter(String feed, String keyword){
			
			int atIndex = 0;
			double count = 0;
			
			while(true){
				//System.out.println(feed.indexOf(keyword, atIndex));
				atIndex = feed.indexOf(keyword, atIndex + 1);
				if(atIndex == -1){
					break;
				}else{
					count++;
				}
			}
			
			//System.out.println("Counted: " + count + " of " + keyword);
			return count;
			
		}
		
		public static double[] mineData() throws IOException {
			String fullData = getFeed("https://www.google.com/finance?cid=626307");
			int atIndex = 0;
			atIndex = fullData.indexOf(",0n\\", atIndex + 1);
			// CRAWL		https://www.google.com/finance?cid=626307
			// DELIMITER	,0\n1,		,0n\
			return new double[0];
		}
}