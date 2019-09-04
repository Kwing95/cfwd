package finalproject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class Crawler2 {
    private static String[] positive = {"buy", "bull", "positive", "award", "hire", "well", "good",
        "positive", "ethical", "profit", "grow", "earn", "cut", "cheap", "bonus", "higher",
        "success", "record", "propel", "improve", "recover", "surge", "gain", "dividends", "interest", 
        "new", "hit", "up", "above", "benefit", "spike", "best", "rise", "better", "profit",          };
    private static String[] negative = { "sell", "bear", "incompetence", "strike", "fire", "poor",
        "bad", "negative", "suffer", "downsiz", "debt", "lose", "ukraine", "isis", "attack", 
         "hike", "bankrupt", "yellen", "janet", "mario", "draghi", "default", "foreclosure", "disappoint", 
         "law", "suit", "vladimir", "putin", "crisis", "tax", "taxes", "threat", "accident", "crash",
         "disaster", "hurricane", "tornado", "earthquake", "climate", "iran", "syria", "iraq", "afghanistan",
         "obama", "clinton", "democrat", "israel"};
    public static void main(String args[]) throws IOException {
    java.util.Date date = new java.util.Date();
    
        double[] yayVal = {};
        
        double[] nayVal = {};
        double mood = getPageMood("http://www.wsj.com", positive, negative); //www.bloomberg.com, www.money.cnn.com, www.dailyfx.com, www.financialtimes.com, 
                                                                             //add to that admin panel that weighs indicator column fibonacci
        System.out.println("Temperature: "
                + mood);
        
//    Stochastic1.generator();
//    webCrawler_Panel panel = new webCrawler_Panel();
    
    }

//    public static double getMood(String[] urlsToCheck, String[] positive,
//            String[] negative) throws IOException {
//        double temperature = 0;
//        for (int i = 0; i < urlsToCheck.length; i++) {
//            temperature += getSiteMood(urlsToCheck[i], positive, negative);
//        }
//        return temperature;
//    }
//    public static double getSiteMood(String urlToCheck, String[] positive,
//            String[] negative) throws IOException {
//        int atIndex = 0;
//        int startIndex = 0;
//        double temperature = 0;
//        String feed = getFeed(urlToCheck);
//        ArrayList<String> crawlQueue = new ArrayList<>();
//        /* Loop through the news feed for instances of items in positive[] and negative[] */
//        crawlQueue = addPagesToQueue(crawlQueue, positive, feed);
//        crawlQueue = addPagesToQueue(crawlQueue, negative, feed);
//        // System.out.println(crawlQueue.size());
//        // System.out.println(crawlQueue);
//        for (int i = 0; i < crawlQueue.size(); i++) {
//            temperature += getPageMood(crawlQueue.get(i), positive, negative);
//        }
//        return temperature;
//    }

//    public static ArrayList<String> addPagesToQueue(ArrayList<String> initial,
//            String toCheck[], String feed) {
//        int atIndex = 0;
//        int startIndex = 0;
//        for (int i = 0; i < toCheck.length; i++) {
//            while (true) {
//                // System.out.println(feed.indexOf(keyword, atIndex));
//                atIndex = feed.indexOf(toCheck[i], atIndex + 1);
//                if (atIndex == -1) {
//                    break;
//                } else {
//                    startIndex = feed.lastIndexOf("http:", atIndex) - 1;
//                    initial.add(feed.substring(startIndex + 1,
//                            feed.indexOf("\"", startIndex + 1)));
//                    if (initial.size() >= 5) {
//                        return initial;
//                    }
//                }
//            }
//        }
//        return initial;
//    }

    public static double getPageMood(String urlToCheck, String[] positive,
            String[] negative) throws IOException {
        String feed = getFeed(urlToCheck);
        double Positive = 0;
        double Negative = 0;
        /*
         * Loop through the news feed for instances of items in positive[] and negative[]
         */
        for (int i = 0; i < positive.length; i++) {
//            Positive += wordCounter(feed, positive[i]);
            if (feed.indexOf(positive[i]) != 0){
                System.out.println("positive: " + positive[i]);
                
                Positive++;
            }
        
        }
        System.out.println(" ");
        for (int i = 0; i < negative.length; i++) {
//            Negative += wordCounter(feed, negative[i]);
            if (feed.indexOf(negative[i]) != 0){
                System.out.println("negative: " + negative[i]);
                
                Negative++;
            }
            
        }
         System.out.println("+ " + Positive + " - " + Negative);
        return Positive - Negative;
    }

    public static String getFeed(String urlToCheck) throws IOException {
        URL url = new URL(urlToCheck);
        String feed = "";
        Scanner feedRead = new Scanner(url.openStream());
        while (feedRead.hasNext()) {
            feed = feed + "\n" + feedRead.next();
            
        }
        feedRead.close();
        return feed.toLowerCase();
    }
//
//    public static double wordCounter(String feed, String keyword) { ///use this method to get the count for the keywords
//        int atIndex = 0;
//        double count = 0;
//        while (true) {
//             System.out.println(feed.indexOf(keyword, atIndex));
//            atIndex = feed.indexOf(keyword, atIndex + 1);
//            if (atIndex == -1) {
//                break;
//            } else {
//                count++;
//            }
//        }
//         System.out.println("Counted: " + count + " of " + keyword);
//        return count;
//    }
}