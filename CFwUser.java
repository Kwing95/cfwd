package finalproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.MouseInfo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

public class CFwUser extends JFrame {

	private JPanel contentPane;
	private static GraphTimer graphPnl;
	private JPanel thermPnl;
	private static JPanel thermometer;
	private static boolean crawlerIdle = true;
	
	private static String[] yay = {"buy", "positive", "award", "hire", "well", "good", "positive", "ethical", "profit", "grow", "earn"};
	private static String[] nay = {"sell", "incompetence", "strike", "fire", "poor", "bad", "negative", "suffer", "downsiz", "debt", "lose"};
	//private static String[] sites = {"http://www.forbes.com/", "https://www.wellsfargo.com/", "http://www.cnn.com/", "http://www.nbcnews.com/"};
	private static String[] sites = {"https://www.wellsfargo.com/"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CFwUser frame = new CFwUser();
					frame.setVisible(true);
					//Can this be called AFTER the graph is displayed?
					//frame.setTemperature();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public CFwUser() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		graphPnl = new GraphTimer();
		graphPnl.setBounds(10, 11, 525, 259);
		contentPane.add(graphPnl);
		
		JPanel scrollPnl = new ScrollBar();
		scrollPnl.setBackground(Color.LIGHT_GRAY);
		scrollPnl.setBounds(10, 281, 525, 20);
		contentPane.add(scrollPnl);
		
		thermPnl = new JPanel();
		thermPnl.setBackground(new Color(0, 0, 0));
		thermPnl.setBounds(545, 11, 29, 290);
		contentPane.add(thermPnl);
		thermPnl.setLayout(null);
		
		thermometer = new JPanel();
		thermometer.setBounds(0, 0, 29, 290);
		thermometer.setBackground(new Color(128, 0, 0));
		thermPnl.add(thermometer);
				
	}
	
	public static boolean isCrawlerIdle(){
		return crawlerIdle;
	}
	
	public static void setCrawlerIdle(boolean i){
		crawlerIdle = i;
	}
	
	public static void setTemperature() throws IOException {
		
		setCrawlerIdle(false);
		//int globalTemp = (int)Crawler.getMood(sites, yay, nay);
		//System.out.println(globalTemp);
		//thermometer.setLocation(0, (int)(290 - globalTemp));
		setCrawlerIdle(true);
		
	}
	
	public static void draggedPeg(int pegX){
		graphPnl.setSkew(pegX);
		graphPnl.refreshGraph(GraphTimer.getDataSet(), pegX);
	}
}
