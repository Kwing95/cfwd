/** The administrator can...
 * 
 * View individual readings from indicators and modify reliability, which states how
 * much bearing an individual instrument has over the ultimate buy/sell signal.
 * 
 * Modify the list of yay and nay keywords, as well as the list of websites which the
 * application crawls and the temperature of the site's interface (which is used to
 * tare the meter and filter out words.)
 * 
 * See different indicies than other users, giving them access to greater quantities of data. */
//////////
/**
 * These are the fields that need to be changed. If you want you can make it a char to display
 * B S or N (buy/sell/neutral) or you can give it quantitive value (0-100). A separate class can
 * then weigh in all of the readings separately and generate a single signal.
 * 
 * fibVField.getText();
 * crawlVField.getText();
 * stoVField.getText();
 * 
 * These are components whose function I do not fully understand. You said you'd take care of this,
 * so I'll just give you the names and leave the rest to you.
 * 
 * indiciesCombo
 * startSpinner
 * endSpinner
 * stoPeriod
 * fibPeriod
 * 
 * */
//////////

package finalproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AdminPanel extends JFrame {

	private JPanel contentPane;
	private JTextField listItemField;

	private static String[] yay = { "buy", "bull", "positive", "award", "hire",
			"well", "good", "positive", "ethical", "profit", "grow", "earn",
			"cut", "cheap", "bonus", "higher", "success", "record", "propel",
			"improve", "recover", "surge", "gain", "dividends", "interest",
			"new", "hit", "up", "above", "benefit", "spike", "best", "rise",
			"better", "profit", };
	private static String[] nay = { "sell", "bear", "incompetence", "strike",
			"fire", "poor", "bad", "negative", "suffer", "downsiz", "debt",
			"lose", "ukraine", "isis", "attack", "hike", "bankrupt", "yellen",
			"draghi", "default", "foreclosure", "disappoint", "law", "suit",
			"putin", "crisis", "tax", "taxes", "threat", "accident", "crash",
			"disaster", "hurricane", "tornado", "earthquake", "climate",
			"iran", "syria", "iraq", "afghanistan", "obama", "clinton",
			"democrat", "israel" };
	private static String[] sites = { "http://www.wsj.com",
			"http://www.bloomberg.com", "http://www.dailyfx.com",
			"http://www.financialtimes.com" };
	private static double[] siteTemps = { 3, 5, -1, 0 };

	private static ArrayList<String> yayAL = new ArrayList<>();
	private static ArrayList<String> nayAL = new ArrayList<>();
	private static ArrayList<String> sitesAL = new ArrayList<>();
	private static ArrayList<Double> tempsAL = new ArrayList<>();

	private JSpinner tareSpinner;
	private JComboBox listListCombo;
	private JList list;
	private JScrollPane scrollPane;
	private int selectedListIndex;
	private JLabel tempLbl;
	private JTextField stoPeriod;
	private JTextField fibPeriod;
	private JComboBox indicesCombo;
	private JTextField fibVField;
	private JTextField crawlVField;
	private JTextField stoVField;
	private JSpinner endSpinner;
	private JSpinner startSpinner;
	private JTextField textField;
	private JTextField totalTradesField;
	private JTextField pSellField;
	private JTextField pWinField;
	private JTextField textField_4;
	private JTextField percentKField;
	private JTextField percentDField;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		// Convert Array to ArrayList<>
		for (int i = 0; i < yay.length; i++) {
			yayAL.add(yay[i]);
		}
		for (int i = 0; i < nay.length; i++) {
			nayAL.add(nay[i]);
		}
		for (int i = 0; i < sites.length; i++) {
			sitesAL.add(sites[i]);
		}
		for (int i = 0; i < siteTemps.length; i++) {
			tempsAL.add(siteTemps[i]);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminPanel() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				AdminPanel.class.getResource("/finalproject/cfwdicon.png")));
		setResizable(false);
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Web Crawler",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 280, 224);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 54, 264, 93);
		panel_1.add(scrollPane);

		list = new JList();
		list.setVisibleRowCount(12);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				selectedListIndex = list.getSelectedIndex();
				if (listListCombo.getSelectedIndex() == 0) {
					if (list.getSelectedIndex() > -1) {
						tareSpinner.setValue(siteTemps[list.getSelectedIndex()]);
					}
				}
			}
		});
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = sites;

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		listListCombo = new JComboBox();
		listListCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				sites = refreshArray(sitesAL);
				yay = refreshArray(yayAL);
				nay = refreshArray(nayAL);

				switch (listListCombo.getSelectedIndex()) {
				case 0:
					list.setModel(new AbstractListModel() {
						String[] values = sites;

						public int getSize() {
							return values.length;
						}

						public Object getElementAt(int index) {
							return values[index];
						}
					});
					tempLbl.setEnabled(true);
					tareSpinner.setEnabled(true);
					break;
				case 1:
					list.setModel(new AbstractListModel() {
						String[] values = yay;

						public int getSize() {
							return values.length;
						}

						public Object getElementAt(int index) {
							return values[index];
						}
					});
					tempLbl.setEnabled(false);
					tareSpinner.setEnabled(false);
					break;
				case 2:
					list.setModel(new AbstractListModel() {
						String[] values = nay;

						public int getSize() {
							return values.length;
						}

						public Object getElementAt(int index) {
							return values[index];
						}
					});
					tempLbl.setEnabled(false);
					tareSpinner.setEnabled(false);
					break;
				}
			}
		});
		listListCombo.setBounds(6, 23, 224, 20);
		panel_1.add(listListCombo);
		listListCombo.setModel(new DefaultComboBoxModel(new String[] {
				"Websites", "Positives", "Negatives" }));

		tempLbl = new JLabel("Taring");
		tempLbl.setHorizontalAlignment(SwingConstants.LEFT);
		tempLbl.setBounds(138, 196, 41, 14);
		panel_1.add(tempLbl);

		tareSpinner = new JSpinner();
		tareSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (list.getSelectedIndex() > -1) {
					siteTemps[list.getSelectedIndex()] = Double
							.parseDouble(tareSpinner.getValue().toString());
				}
			}
		});
		tareSpinner.setBounds(189, 193, 41, 20);
		panel_1.add(tareSpinner);

		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (listListCombo.getSelectedIndex()) {
				case 0:
					sitesAL.add(listItemField.getText());
					tempsAL.add(0.0);
					break;
				case 1:
					yayAL.add(listItemField.getText());
					break;
				case 2:
					nayAL.add(listItemField.getText());
					break;
				}
				sites = refreshArray(sitesAL);
				yay = refreshArray(yayAL);
				nay = refreshArray(nayAL);
				siteTemps = refreshDoubleArray(tempsAL);

				refreshList();
			}
		});
		button.setBounds(189, 165, 41, 23);
		panel_1.add(button);

		JButton button_1 = new JButton("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() > -1) {
					switch (listListCombo.getSelectedIndex()) {
					case 0:
						sitesAL.remove(list.getSelectedIndex());
						tempsAL.remove(list.getSelectedIndex());
						break;
					case 1:
						yayAL.remove(list.getSelectedIndex());
						break;
					case 2:
						nayAL.remove(list.getSelectedIndex());
						break;
					}
					sites = refreshArray(sitesAL);
					yay = refreshArray(yayAL);
					nay = refreshArray(nayAL);
					siteTemps = refreshDoubleArray(tempsAL);

					refreshList();
				}
			}
		});
		button_1.setBounds(138, 165, 41, 23);
		panel_1.add(button_1);

		listItemField = new JTextField();
		listItemField.setColumns(10);
		listItemField.setBounds(6, 165, 122, 20);
		panel_1.add(listItemField);

		JButton btnNewButton = new JButton("Retrieve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "Temperature: "
							+ Crawler.getSimpleMood(sites, yay, nay, siteTemps));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		btnNewButton.setBounds(6, 192, 81, 23);
		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Indicies",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(320, 11, 184, 190);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(6, 52, 46, 14);
		panel_2.add(lblStart);

		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(6, 80, 46, 14);
		panel_2.add(lblEnd);

		endSpinner = new JSpinner();
		endSpinner.setBounds(45, 77, 130, 20);
		panel_2.add(endSpinner);
		endSpinner.setModel(new SpinnerDateModel(new Date(1430370000000L),
				new Date(-631130400000L), null, Calendar.DAY_OF_MONTH));

		startSpinner = new JSpinner();
		startSpinner.setBounds(45, 49, 130, 20);
		panel_2.add(startSpinner);
		startSpinner.setModel(new SpinnerDateModel(new Date(1430283600000L),
				new Date(-631130400000L), null, Calendar.DAY_OF_MONTH));

		JLabel lblStochasticPeriod = new JLabel("Stochastic Period");
		lblStochasticPeriod.setBounds(6, 105, 113, 14);
		panel_2.add(lblStochasticPeriod);

		JLabel lblFibonacciPeriod = new JLabel("Fibonacci Period");
		lblFibonacciPeriod.setBounds(6, 130, 99, 14);
		panel_2.add(lblFibonacciPeriod);

		stoPeriod = new JTextField();
		stoPeriod.setBounds(115, 102, 60, 20);
		panel_2.add(stoPeriod);
		stoPeriod.setColumns(10);

		fibPeriod = new JTextField();
		fibPeriod.setBounds(115, 127, 60, 20);
		panel_2.add(fibPeriod);
		fibPeriod.setColumns(10);

		indicesCombo = new JComboBox();
		indicesCombo.setBounds(6, 21, 169, 20);
		panel_2.add(indicesCombo);
		indicesCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				switch (indicesCombo.getSelectedIndex()) {
				case 0:
					generator.setInstrument("%5EGSPC&");
					break;
				case 1:
					generator.setInstrument("GOLD&");
					break;
				case 2:
					generator.setInstrument("OIL&");
					break;
				case 3:
					generator.setInstrument("DIA&");
					break;
				case 4:
					generator.setInstrument("%5ERUT&");
					break;
				case 5:
					generator.setInstrument("QQQX&");
					break;
					
				}
			}
		});
		indicesCombo.setModel(new DefaultComboBoxModel(new String[] {
				"S&P 500", "Gold", "Oil", "DJIA", "Russel 5k", "Nasdaq" }));

		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Date startDate = (Date) startSpinner.getValue();
				GregorianCalendar startCal = new GregorianCalendar();
				startCal.setTime(startDate);

				Date endDate = (Date) startSpinner.getValue();
				GregorianCalendar endCal = new GregorianCalendar();
				startCal.setTime(endDate);

				generator g = new generator(startCal, endCal);
				GraphPanel.createAndShowGui(g.getOpen(), indicesCombo.getSelectedItem().toString());
				
				double totalTrades = Stochastic.selltradesS + Stochastic.buytradesS;
				totalTradesField.setText(totalTrades + "");
				double winLong = Stochastic.winbuytrades / totalTrades;
				double winShort = Stochastic.winselltrades / totalTrades;
				pWinField.setText(winLong + "");
				pSellField.setText(winShort + "");
				double percentK = Double.parseDouble(Stochastic.preK.get(Stochastic.pred.size() - 1));
				double percentD = Double.parseDouble(Stochastic.pred.get(Stochastic.pred.size() - 1));
				
				
			}
		});
		btnGenerate.setBounds(86, 155, 89, 23);
		panel_2.add(btnGenerate);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Signal",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(320, 212, 184, 179);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblStochastic = new JLabel("Stochastic");
		lblStochastic.setBounds(20, 49, 64, 14);
		panel_3.add(lblStochastic);

		stoVField = new JTextField();
		stoVField.setBounds(94, 46, 30, 20);
		panel_3.add(stoVField);
		stoVField.setEditable(false);
		stoVField.setColumns(10);

		JLabel lblFibonacci = new JLabel("Fibonacci");
		lblFibonacci.setBounds(20, 77, 58, 14);
		panel_3.add(lblFibonacci);

		fibVField = new JTextField();
		fibVField.setBounds(94, 74, 30, 20);
		panel_3.add(fibVField);
		fibVField.setEditable(false);
		fibVField.setColumns(10);

		JLabel lblCrawler = new JLabel("Crawler");
		lblCrawler.setBounds(20, 105, 58, 14);
		panel_3.add(lblCrawler);

		crawlVField = new JTextField();
		crawlVField.setBounds(94, 102, 30, 20);
		panel_3.add(crawlVField);
		crawlVField.setEditable(false);
		crawlVField.setColumns(10);

		JSpinner stochasticSpinner = new JSpinner();
		stochasticSpinner.setBounds(134, 46, 41, 20);
		panel_3.add(stochasticSpinner);

		JSpinner fibonacciSpinner = new JSpinner();
		fibonacciSpinner.setBounds(134, 74, 41, 20);
		panel_3.add(fibonacciSpinner);

		JSpinner crawlerSpinner = new JSpinner();
		crawlerSpinner.setBounds(134, 102, 41, 20);
		panel_3.add(crawlerSpinner);

		JLabel lblToolVerdictWeight = new JLabel(
				"Tool             Verdict   Weight");
		lblToolVerdictWeight.setBounds(20, 23, 155, 14);
		panel_3.add(lblToolVerdictWeight);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCalculate.setBounds(80, 145, 95, 23);
		panel_3.add(btnCalculate);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Statistics", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 246, 300, 145);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 14, 280, 123);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblWins = new JLabel("% Win Longs");
		lblWins.setBounds(0, 53, 80, 14);
		panel_4.add(lblWins);
		
		JLabel lblNetProfit = new JLabel("Net Profit");
		lblNetProfit.setBounds(0, 3, 46, 14);
		panel_4.add(lblNetProfit);
		
		JLabel lblTotalTrades = new JLabel("Total Trades");
		lblTotalTrades.setBounds(0, 28, 60, 14);
		panel_4.add(lblTotalTrades);
		
		JLabel lblWinningSell = new JLabel("% Win Shorts");
		lblWinningSell.setBounds(0, 78, 80, 14);
		panel_4.add(lblWinningSell);
		
		JLabel lblWinningTrades = new JLabel("% Win Trades");
		lblWinningTrades.setBounds(0, 103, 80, 14);
		panel_4.add(lblWinningTrades);
		
		JLabel lblK = new JLabel("% K");
		lblK.setBounds(160, 3, 30, 14);
		panel_4.add(lblK);
		lblK.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblD = new JLabel("% D");
		lblD.setBounds(160, 29, 30, 14);
		panel_4.add(lblD);
		lblD.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblMaxProfit = new JLabel("Best");
		lblMaxProfit.setBounds(144, 54, 46, 14);
		panel_4.add(lblMaxProfit);
		lblMaxProfit.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblWorstTrade = new JLabel("Worst");
		lblWorstTrade.setBounds(144, 80, 46, 14);
		panel_4.add(lblWorstTrade);
		lblWorstTrade.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(74, 0, 60, 20);
		panel_4.add(textField);
		textField.setColumns(10);
		
		totalTradesField = new JTextField();
		totalTradesField.setEditable(false);
		totalTradesField.setBounds(74, 26, 60, 20);
		panel_4.add(totalTradesField);
		totalTradesField.setColumns(10);
		
		pSellField = new JTextField();
		pSellField.setEditable(false);
		pSellField.setBounds(74, 78, 60, 20);
		panel_4.add(pSellField);
		pSellField.setColumns(10);
		
		pWinField = new JTextField();
		pWinField.setEditable(false);
		pWinField.setBounds(74, 52, 60, 20);
		panel_4.add(pWinField);
		pWinField.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(74, 103, 60, 20);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		percentKField = new JTextField();
		percentKField.setEditable(false);
		percentKField.setBounds(200, 0, 60, 20);
		panel_4.add(percentKField);
		percentKField.setColumns(10);
		
		percentDField = new JTextField();
		percentDField.setEditable(false);
		percentDField.setBounds(200, 26, 60, 20);
		panel_4.add(percentDField);
		percentDField.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(200, 52, 60, 20);
		panel_4.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(200, 78, 60, 20);
		panel_4.add(textField_8);
		textField_8.setColumns(10);
	}

	public String[] refreshArray(ArrayList<String> oldArray) {
		String[] retVal = new String[oldArray.size()];
		for (int i = 0; i < retVal.length; i++) {
			retVal[i] = oldArray.get(i);
		}
		return retVal;
	}

	public double[] refreshDoubleArray(ArrayList<Double> oldArray) {
		double[] retVal = new double[oldArray.size()];
		for (int i = 0; i < retVal.length; i++) {
			retVal[i] = oldArray.get(i);
		}
		return retVal;
	}

	public void refreshList() {
		switch (listListCombo.getSelectedIndex()) {
		case 0:
			list.setModel(new AbstractListModel() {
				String[] values = sites;

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});
			tempLbl.setEnabled(true);
			tareSpinner.setEnabled(true);
			break;
		case 1:
			list.setModel(new AbstractListModel() {
				String[] values = yay;

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});
			tempLbl.setEnabled(false);
			tareSpinner.setEnabled(false);
			break;
		case 2:
			list.setModel(new AbstractListModel() {
				String[] values = nay;

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});
			tempLbl.setEnabled(false);
			tareSpinner.setEnabled(false);
			break;
		}
	}
}
