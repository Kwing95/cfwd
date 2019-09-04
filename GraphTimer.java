package finalproject;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.*;

public class GraphTimer extends JPanel {
	
	private static ArrayList<Double> dataSet;
	private static GraphTimer mainPanel;
	private static int skew = 100;
	private GraphPanel stillGraph;
	private final int maxValues = 100; //The maximum amount of points to show, higher values can lag
//	private ScrollBar scroller;
	
	public GraphTimer(){
		
		Timer timer = new Timer(1000, new TimerListener());
		timer.start();
		
		dataSet = DatabaseAL.makeSet(14400, 20);
		//generator liveData = new generator(new GregorianCalendar(2001, 00, 01), new GregorianCalendar(2015, 04, 04));
		//dataSet = liveData.getOpen();
		
		this.setLayout(new GridLayout());
		stillGraph = new GraphPanel(DatabaseAL.getPointIntervals(dataSet, 100, 100));
		add(stillGraph);
//		scroller = new ScrollBar();
//		add(scroller);
		//mainPanel = new GraphPanel(dataSet);
		
	}
	
	public static ArrayList<Double> getDataSet(){
		return dataSet;
	}
	
	public void setSkew(int skew){
		this.skew = skew;
	}
	
	public static void main(String[] args){
		
		skew = 100;
		mainPanel = new GraphTimer();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		
	}
	
	private class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			UserPanel.moveThumb(Instrument.shouldBuy(UserPanel.getGlobalTemp()));
			
			dataSet.add(DatabaseAL.newPoint(dataSet.get(dataSet.size() - 1), 20));
			refreshGraph(dataSet, skew);
			
			Transaction.checkProfitTrigger(dataSet.get(dataSet.size() - 1));
			Transaction.checkTimerTrigger(dataSet.get(dataSet.size() - 1));
			
			UserPanel.setCurrentPriceField();
			
//			if(CFwUser.isCrawlerIdle()) {
//				try {
//					CFwUser.setTemperature();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
			
		}
	}
	
	public void refreshGraph(ArrayList<Double> dataSet, int valuesToShow){
		stillGraph.setScores(DatabaseAL.getPointIntervals(dataSet, valuesToShow, Math.min(valuesToShow, maxValues)));
	}
	
}