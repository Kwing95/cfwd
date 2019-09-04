/**
 * GUEST: No login, can view graph.
 * USER: Above features plus trading stocks.
 * INVESTOR: Above features plus trigger sells.
 * ADMIN: Above features plus automatic transactions.
 * 
 */

package finalproject;

import javax.swing.*;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.IOException;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPanel extends JPanel {
	
	//wall street, bloomberg, cnn, forexfactory, 
	
	public static final int GUEST = 0;
	public static final int USER = 1;
	public static final int INVESTOR = 2;
	public static final int ADMIN = 3;
	private static int loginPermission = GUEST;
	
	private static GraphTimer graphPnl;
	private static JPanel thermometer;
	private JPanel thermPnl;
	
	private static String[] yay = {"buy", "hire", "ethical", "profit", "grow", "earn"};
	private static String[] nay = {"sell", "incompetence", "strike", "fire", "poor", "negative"};
	private static String[] sites = {"https://www.wellsfargo.com/"};
	private static double[] siteTemps = {1};
	
	private JTextField quantityField = new JTextField();
	private JButton btnBuy;
	private JButton btnSell;
	private JLabel balanceLbl;
	private static JTextField balanceField;
	private static JTextField sharesField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField timeTriggerField;
	private JTextField profitTriggerField;
	private JCheckBox chckbxTrigger;
	private JRadioButton rdbtnTimer;
	private JRadioButton rdbtnProfit;
	private static JTextField timeField;
	private static JLabel thumbLbl;
	private static int globalTemp;
	private JLabel lblSec;
	private JLabel lblProfit;
	private static JTextField currentPriceField;
	private JLabel lblQuantity;
	
	private ActionListener logoutListener = null;
	
	public void AddLogoutListener(ActionListener logoutListener){
		this.logoutListener = logoutListener;
	}	
	
	public int getLoginPermission() {
		return loginPermission;
	}

	public void setLoginPermission(int loginPermission) {
		this.loginPermission = loginPermission;
	}

	public static void main(String[] args) throws IOException {
		
		Transaction.setBalance(100000);
		Transaction.setShares(0);
		 
		JFrame frame = new JFrame();
		frame.getContentPane().add(new UserPanel(3));//0 = GUEST, 1 = USER, 2 = INVESTOR, 3 = ADMIN
		frame.setTitle("cFwd");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminPanel.class.getResource("/finalproject/cfwdicon.png")));
		frame.setResizable(false);
		frame.setSize(660, 440); // Set the frame size (640x400)
		frame.setLocationRelativeTo(null); // Center a frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); // Display the frame
				
		setTemperature((int)(Math.random() * 237));
		
	}
	
	public UserPanel(){
		this(loginPermission);
	}
	
	public UserPanel(int permission) {
		setLayout(null);
		
		JPanel scrollPnl = new ScrollBar();
		scrollPnl.setBackground(Color.LIGHT_GRAY);
		scrollPnl.setBounds(10, 309, 519, 20);
		add(scrollPnl);
		scrollPnl.setLayout(null);
		
		graphPnl = new GraphTimer();
		graphPnl.setBounds(10, 11, 565, 287);
		add(graphPnl);
		graphPnl.setLayout(new GridLayout(1, 0, 0, 0));
		
		thermPnl = new JPanel();
		thermPnl.setBackground(new Color(0, 0, 0));
		thermPnl.setBounds(585, 61, 45, 237);
		add(thermPnl);
		thermPnl.setLayout(null);
		
		thermometer = new JPanel();
		thermometer.setBackground(new Color(128, 0, 0));
		thermometer.setBounds(0, 0, 45, 237);
		thermPnl.add(thermometer);
		thermometer.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(UserPanel.class.getResource("/finalproject/mood.png")));
		label_1.setBounds(0, 0, 45, 287);
		thermometer.add(label_1);
		
		JButton backBtn = new JButton("BACK");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserPanel.this.logoutListener.actionPerformed(arg0);
			}
		});
		backBtn.setBounds(539, 370, 91, 20);
		add(backBtn);
		
		timeField = new JTextField("100s");
		timeField.setBounds(539, 309, 91, 20);
		add(timeField);
		timeField.setEditable(false);
		timeField.setColumns(10);
		
		quantityField = new JFormattedTextField();
		quantityField.setText("1");
		quantityField.setBounds(324, 370, 45, 20);
		add(quantityField);
		quantityField.setColumns(3);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(268, 372, 57, 14);
		add(lblQuantity);
		
		btnBuy = new JButton("BUY");
		btnBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxTrigger.isSelected()){
					if(rdbtnProfit.isSelected()){
						Transaction.setProfitTrigger(Integer.parseInt(quantityField.getText()),
								GraphTimer.getDataSet().get(GraphTimer.getDataSet().size() - 1),
								Double.parseDouble(profitTriggerField.getText()));
					}else if(rdbtnTimer.isSelected()){
						Transaction.setTimerTrigger(Integer.parseInt(quantityField.getText()),
								Integer.parseInt(timeTriggerField.getText()));
					}
				}
				
				Transaction.buyShares(Integer.parseInt(quantityField.getText()),
						GraphTimer.getDataSet().get(GraphTimer.getDataSet().size() - 1));
				
			}
		});
		btnBuy.setBounds(188, 340, 70, 20);
		add(btnBuy);
		
		btnSell = new JButton("SELL");
		btnSell.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Transaction.sellShares(Integer.parseInt(quantityField.getText()),
						GraphTimer.getDataSet().get(GraphTimer.getDataSet().size() - 1));
			}
		});
		btnSell.setBounds(188, 370, 70, 20);
		add(btnSell);
		
		chckbxTrigger = new JCheckBox("Trigger");
		chckbxTrigger.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxTrigger.isSelected()){
					rdbtnTimer.setEnabled(true);
					rdbtnProfit.setEnabled(true);
					timeTriggerField.setEnabled(true);
					profitTriggerField.setEnabled(true);
					lblProfit.setEnabled(true);
					lblSec.setEnabled(true);
				}else{
					rdbtnTimer.setEnabled(false);
					rdbtnProfit.setEnabled(false);
					timeTriggerField.setEnabled(false);
					profitTriggerField.setEnabled(false);
					lblProfit.setEnabled(false);
					lblSec.setEnabled(false);
				}
			}
		});
		chckbxTrigger.setBounds(264, 339, 70, 23);
		add(chckbxTrigger);
		
		balanceLbl = new JLabel("Balance:");
		balanceLbl.setBounds(10, 373, 57, 14);
		add(balanceLbl);
		
		balanceField = new JTextField("$" + Transaction.getBalance());
		balanceField.setEditable(false);
		balanceField.setColumns(10);
		balanceField.setBounds(63, 370, 115, 20);
		add(balanceField);
		
		JLabel sharesLbl = new JLabel("Shares:");
		sharesLbl.setBounds(10, 345, 57, 14);
		add(sharesLbl);
		
		sharesField = new JTextField("0");
		sharesField.setEditable(false);
		sharesField.setColumns(10);
		sharesField.setBounds(63, 342, 115, 20);
		add(sharesField);
		
		JPanel thumbPnl = new JPanel();
		thumbPnl.setBounds(585, 11, 45, 45);
		add(thumbPnl);
		thumbPnl.setLayout(null);
		
		thumbLbl = new JLabel("");
		thumbLbl.setIcon(new ImageIcon(UserPanel.class.getResource("/finalproject/thumbs.png")));
		thumbLbl.setBounds(0, 0, 135, 45);
		thumbPnl.add(thumbLbl);
		
		rdbtnProfit = new JRadioButton("Profit");
		rdbtnProfit.setEnabled(false);
		buttonGroup.add(rdbtnProfit);
		rdbtnProfit.setBounds(375, 369, 63, 23);
		add(rdbtnProfit);
		
		rdbtnTimer = new JRadioButton("Timer");
		rdbtnTimer.setEnabled(false);
		buttonGroup.add(rdbtnTimer);
		rdbtnTimer.setBounds(375, 340, 63, 23);
		add(rdbtnTimer);
		
		timeTriggerField = new JTextField();
		timeTriggerField.setEnabled(false);
		timeTriggerField.setText("300");
		timeTriggerField.setBounds(444, 340, 45, 20);
		add(timeTriggerField);
		timeTriggerField.setColumns(10);
		
		profitTriggerField = new JTextField();
		profitTriggerField.setEnabled(false);
		profitTriggerField.setText("10");
		profitTriggerField.setColumns(10);
		profitTriggerField.setBounds(444, 370, 45, 20);
		add(profitTriggerField);
		
		lblSec = new JLabel("sec");
		lblSec.setEnabled(false);
		lblSec.setBounds(499, 343, 30, 14);
		add(lblSec);
		
		lblProfit = new JLabel("%");
		lblProfit.setEnabled(false);
		lblProfit.setBounds(499, 373, 30, 14);
		add(lblProfit);
		
		currentPriceField = new JTextField("0.0");
		currentPriceField.setEditable(false);
		currentPriceField.setColumns(10);
		currentPriceField.setBounds(539, 340, 91, 20);
		add(currentPriceField);
		
//		switch(permission){
//		case 0:
//			btnBuy.setEnabled(false);
//			btnSell.setEnabled(false);
//			quantityField.setEnabled(false);
//			lblQuantity.setEnabled(false);
//		case 1:
//			chckbxTrigger.setEnabled(false); break;
//		case 3:
//			AdminPanel.main(new String[0]);
//		}

	}
	
	public void setPermission(int permission){
		switch(permission){
		case 0:
			btnBuy.setEnabled(false);
			btnSell.setEnabled(false);
			quantityField.setEnabled(false);
			lblQuantity.setEnabled(false);
		case 1:
			chckbxTrigger.setEnabled(false);
			break;
		case 3:
			AdminPanel.main(new String[0]);
		}
	}
	
	public static void setBalanceField(double balance){
		balanceField.setText("$" + balance);
	}
	
	public static void setSharesField(int shares){
		sharesField.setText("" + shares);
	}
	
	public static int getGlobalTemp(){
		return globalTemp;
	}
	
	public static void setTemperature(int i) throws IOException {
		
		//setCrawlerIdle(false);
		globalTemp = (int)Crawler.getMood(sites, yay, nay, siteTemps);
		//int globalTemp = i;
		//System.out.println(globalTemp);
		//Dividing by 2 means that a 1/2 full bar is neutral, multiplying scales the effects
		thermometer.setLocation(0, (237 / 2) - (globalTemp * 3));
		//setCrawlerIdle(true);
		
	}
	
	public static void moveThumb(int where){
		switch(where){
		case -1: thumbLbl.setLocation(-90, 0); break;
		case 0: thumbLbl.setLocation(-45, 0); break;
		case 1: thumbLbl.setLocation(0, 0); break;
		}
	}
	
	public static void setCurrentPriceField(){
		currentPriceField.setText("$" + GraphTimer.getDataSet().get(GraphTimer.getDataSet().size() - 1));
	}
	
	public static void draggedPeg(int pegX){
		
		if(pegX < 60){
			timeField.setText(pegX + "s");
		}else if(pegX < 3600){
			timeField.setText((Math.round(pegX/0.6)/100.0) + "m");
		}else{
			timeField.setText((Math.round(pegX/36.0)/100.0) + "h");
		}

		graphPnl.setSkew(pegX);
		graphPnl.refreshGraph(GraphTimer.getDataSet(), pegX);
		
	}
	
	public static void checkTriggers(){
		
	}

}
