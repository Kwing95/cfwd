package finalproject;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Font;

public class AaronAdmin extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JTextField textField_17;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AaronAdmin frame = new AaronAdmin();
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
    public AaronAdmin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 630, 265);
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 726, 30);
        getContentPane().add(panel);
        
        JLabel lblWelcomeAdministrator = new JLabel("Welcome Administrator");
        lblWelcomeAdministrator.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblWelcomeAdministrator);
        
        JLabel lblNewLabel = new JLabel("Total Trades:");
        lblNewLabel.setBounds(40, 43, 64, 14);
        getContentPane().add(lblNewLabel);
        
        textField_1 = new JTextField();
        textField_1.setBounds(114, 40, 86, 20);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(114, 68, 86, 20);
        getContentPane().add(textField_2);
        
        JLabel lblDeposit = new JLabel("Deposit:");
        lblDeposit.setHorizontalAlignment(SwingConstants.TRAILING);
        lblDeposit.setBounds(41, 71, 64, 14);
        getContentPane().add(lblDeposit);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(114, 99, 86, 20);
        getContentPane().add(textField_3);
        
        JLabel lblNetProfit = new JLabel("Net Profit:");
        lblNetProfit.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNetProfit.setBounds(41, 102, 64, 14);
        getContentPane().add(lblNetProfit);
        
        textField_4 = new JTextField();
        textField_4.setToolTipText("The Profit Factor measures the factor or Qotient of the total profit and the total loss.Taking into consideration all factors that weigh on the total profit. The higher the number the more successful the Algorithim has performed.");
        textField_4.setColumns(10);
        textField_4.setBounds(114, 130, 86, 20);
        getContentPane().add(textField_4);
        
        JLabel lblProfitFactor = new JLabel("Profit Factor:");
        lblProfitFactor.setToolTipText("The Profit Factor measures the factor or Qotient of the total profit and the total loss.Taking into consideration all factors that weigh on the total profit. The higher the number the more successful the Algorithim has performed.");
        lblProfitFactor.setHorizontalAlignment(SwingConstants.TRAILING);
        lblProfitFactor.setBounds(41, 133, 64, 14);
        getContentPane().add(lblProfitFactor);
        
        textField_5 = new JTextField();
        textField_5.setToolTipText("Drawdown is a measurement of the lowest point between two consecutive highs or peaks. It is the difference between the highest peaks and the troph between the two peaks. If an active trade has been executed it is the maximum amount of unrealized loss that was experienced. ");
        textField_5.setColumns(10);
        textField_5.setBounds(114, 161, 86, 20);
        getContentPane().add(textField_5);
        
        JLabel lblDrawdown = new JLabel("Drawdown:");
        lblDrawdown.setToolTipText("Drawdown is a measurement of the lowest point between two consecutive highs or peaks. It is the difference between the highest peaks and the troph between the two peaks. If an active trade has been executed it is the maximum amount of unrealized loss that was experienced. ");
        lblDrawdown.setHorizontalAlignment(SwingConstants.TRAILING);
        lblDrawdown.setBounds(41, 164, 64, 14);
        getContentPane().add(lblDrawdown);
        
        textField_6 = new JTextField();
        textField_6.setToolTipText("Percentage of Profitable Long Trades.");
        textField_6.setColumns(10);
        textField_6.setBounds(299, 41, 86, 20);
        getContentPane().add(textField_6);
        
        JLabel lbllwTrades = new JLabel("%LW Trades:");
        lbllwTrades.setToolTipText("Percentage of Profitable Long Trades");
        lbllwTrades.setHorizontalAlignment(SwingConstants.TRAILING);
        lbllwTrades.setBounds(210, 44, 80, 14);
        getContentPane().add(lbllwTrades);
        
        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(299, 67, 86, 20);
        getContentPane().add(textField_7);
        
        JLabel lblprofitTrades = new JLabel("%Profit Trades:");
        lblprofitTrades.setHorizontalAlignment(SwingConstants.TRAILING);
        lblprofitTrades.setBounds(210, 70, 80, 14);
        getContentPane().add(lblprofitTrades);
        
        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(299, 95, 86, 20);
        getContentPane().add(textField_8);
        
        JLabel lblLargestProfit = new JLabel("Largest Profit:");
        lblLargestProfit.setHorizontalAlignment(SwingConstants.TRAILING);
        lblLargestProfit.setBounds(210, 98, 80, 14);
        getContentPane().add(lblLargestProfit);
        
        JLabel lblswTrades = new JLabel("%SW Trades:");
        lblswTrades.setToolTipText("Percentage of Unprofitable Long Trades.");
        lblswTrades.setHorizontalAlignment(SwingConstants.TRAILING);
        lblswTrades.setBounds(422, 44, 80, 14);
        getContentPane().add(lblswTrades);
        
        JLabel lbllossTrades = new JLabel("%Loss Trades:");
        lbllossTrades.setHorizontalAlignment(SwingConstants.TRAILING);
        lbllossTrades.setBounds(422, 70, 80, 14);
        getContentPane().add(lbllossTrades);
        
        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(511, 95, 86, 20);
        getContentPane().add(textField_9);
        
        JLabel lblLargestLoss = new JLabel("Largest Loss:");
        lblLargestLoss.setHorizontalAlignment(SwingConstants.TRAILING);
        lblLargestLoss.setBounds(422, 98, 80, 14);
        getContentPane().add(lblLargestLoss);
        
        textField_10 = new JTextField();
        textField_10.setColumns(10);
        textField_10.setBounds(511, 67, 86, 20);
        getContentPane().add(textField_10);
        
        textField_11 = new JTextField();
        textField_11.setToolTipText("Percentage of Unprofitable Long Trades.");
        textField_11.setColumns(10);
        textField_11.setBounds(511, 41, 86, 20);
        getContentPane().add(textField_11);
        
        JLabel lblProfit = new JLabel("# Profit:");
        lblProfit.setHorizontalAlignment(SwingConstants.TRAILING);
        lblProfit.setBounds(210, 126, 80, 14);
        getContentPane().add(lblProfit);
        
        textField_12 = new JTextField();
        textField_12.setColumns(10);
        textField_12.setBounds(299, 123, 86, 20);
        getContentPane().add(textField_12);
        
        JLabel lblLoss = new JLabel("# Loss:");
        lblLoss.setHorizontalAlignment(SwingConstants.TRAILING);
        lblLoss.setBounds(422, 126, 80, 14);
        getContentPane().add(lblLoss);
        
        textField_13 = new JTextField();
        textField_13.setColumns(10);
        textField_13.setBounds(511, 123, 86, 20);
        getContentPane().add(textField_13);
        
        JLabel lblAverageProfit = new JLabel("Average Profit:");
        lblAverageProfit.setHorizontalAlignment(SwingConstants.TRAILING);
        lblAverageProfit.setBounds(210, 154, 80, 14);
        getContentPane().add(lblAverageProfit);
        
        textField_14 = new JTextField();
        textField_14.setColumns(10);
        textField_14.setBounds(299, 151, 86, 20);
        getContentPane().add(textField_14);
        
        JLabel lblAverageLoss = new JLabel("Average Loss:");
        lblAverageLoss.setHorizontalAlignment(SwingConstants.TRAILING);
        lblAverageLoss.setBounds(422, 154, 80, 14);
        getContentPane().add(lblAverageLoss);
        
        textField_15 = new JTextField();
        textField_15.setColumns(10);
        textField_15.setBounds(511, 151, 86, 20);
        getContentPane().add(textField_15);
        
        JLabel lblAverageWins = new JLabel("maxConWins:");
        lblAverageWins.setToolTipText("Maximun Consecutive Profitable Trades.\r\n\t\t\t\t\t\t");
        lblAverageWins.setHorizontalAlignment(SwingConstants.TRAILING);
        lblAverageWins.setBounds(210, 179, 80, 14);
        getContentPane().add(lblAverageWins);
        
        textField_16 = new JTextField();
        textField_16.setToolTipText("Maximun Consecutive Profitable Trades.");
        textField_16.setColumns(10);
        textField_16.setBounds(299, 176, 86, 20);
        getContentPane().add(textField_16);
        
        JLabel lblAverageLoss_1 = new JLabel("maxConsLoss:");
        lblAverageLoss_1.setToolTipText("Maximun Consecutive Unprofitable Trades.");
        lblAverageLoss_1.setHorizontalAlignment(SwingConstants.TRAILING);
        lblAverageLoss_1.setBounds(422, 179, 80, 14);
        getContentPane().add(lblAverageLoss_1);
        
        textField_17 = new JTextField();
        textField_17.setToolTipText("Maximun Consecutive Unprofitable Trades.");
        textField_17.setColumns(10);
        textField_17.setBounds(511, 176, 86, 20);
        getContentPane().add(textField_17);
        
    
        
        
        
        
        
    
    
    }
}