package finalproject;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class CfwPrimary extends JFrame {

	private JPanel mainPanel;
	private LoginPanel loginPanel = new LoginPanel();
	private UserPanel userPanel = new UserPanel();
	private RegisterPanel registerPanel = new RegisterPanel();
	
	private CardLayout cardMain = new CardLayout(0, 0);
	private static ArrayList<Account> accounts = new ArrayList<>();

	public static void main(String[] args) {		
		
		// Account Constructor (String name, char[] pass, double balance, int type, String email, long creditCard)
		accounts.add(new Account("BasicUser", "basicuser", 20000, 0, "isuck@life.com", 321));
		accounts.add(new Account("Investor", "investor", 100000, 1, "ieat@arbys.com", 123456));
		accounts.add(new Account("Administrator", "administrator", 250000, 2, "elitedarklord666@aol.com", 13371337));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CfwPrimary frame = new CfwPrimary();
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
	public CfwPrimary() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CfwPrimary.class.getResource("/finalproject/cfwdicon.png")));
		setTitle("cFwd");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(660, 430);
		this.setLocationRelativeTo(null);
		
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(this.cardMain);
		
		this.mainPanel.add(this.loginPanel, "login");
		this.mainPanel.add(this.userPanel, "user");
		this.mainPanel.add(this.registerPanel, "register");
		
		showCardPanel("login");
		
		getContentPane().add(this.mainPanel);

		this.loginPanel.AddLoginListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Welcome!");
				userPanel.setPermission(loginPanel.getPermission());
				Transaction.setBalance(loginPanel.getBalance());
				UserPanel.setBalanceField(Transaction.getBalance());
				CfwPrimary.this.showCardPanel("user");
			}
		});
		
		this.loginPanel.AddRegisterListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CfwPrimary.this.showCardPanel("register");
			}
		});
		
		this.userPanel.AddLogoutListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CfwPrimary.this.showCardPanel("login");
				JOptionPane.showMessageDialog(null, "Logged out successfully.");
			}
		});
		
		this.registerPanel.AddCancelListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CfwPrimary.this.showCardPanel("login");
			}
		});
		
	}
	
	
	private void showCardPanel(String name){
		this.cardMain.show(mainPanel, name);
	}
	
	public static ArrayList<Account> getAccounts(){
		return accounts;
	}
	
	public static void addAccount(Account newAccount){
		accounts.add(newAccount);
	}
		
}
