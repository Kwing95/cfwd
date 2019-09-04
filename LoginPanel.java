package finalproject;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class LoginPanel extends JPanel {
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private int permission;
	private double balance;
	
	// Account Constructor (String name, char[] pass, double balance, int type, String email, long creditCard)
//	Account a1 = new Account("Loser", "spitballs", 20000, 0);
//	Account a2 = new Account("AverageJoe", "123456", 100000, 1);
//	Account a3 = new Account("Alpha", "wolf", 250000, 2);
//	Account[] accounts = {a1, a2, a3};
	ArrayList<Account> accountList = new ArrayList<>();
	
	private ActionListener loginListener = null;
	private ActionListener registerListener = null;
	
	public void AddLoginListener(ActionListener loginListener){
		this.loginListener = loginListener;
	}
	
	public void AddRegisterListener(ActionListener registerListener) {
		this.registerListener = registerListener;
	}
	
	public LoginPanel() {
		
		setLayout(null);
		
		JPanel loginPnl = new JPanel();
		loginPnl.setOpaque(false);
		loginPnl.setBounds(277, 185, 86, 204);
		add(loginPnl);
		loginPnl.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(0, 34, 86, 14);
		loginPnl.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.WHITE);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(0, 82, 86, 14);
		loginPnl.add(lblPassword);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSignup = new JButton("Register");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(LoginPanel.this.registerListener != null){
					LoginPanel.this.registerListener.actionPerformed(arg0);
				}
			}
		});
		btnSignup.setBounds(0, 170, 86, 23);
		loginPnl.add(btnSignup);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(0, 136, 86, 23);
		loginPnl.add(btnNewButton);
		
		usernameField = new JTextField();
		usernameField.setBounds(0, 51, 86, 20);
		loginPnl.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(0, 99, 86, 20);
		loginPnl.add(passwordField);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkLogin(usernameField.getText().toLowerCase(), passwordField.getPassword())){

					if(LoginPanel.this.loginListener != null){
						LoginPanel.this.loginListener.actionPerformed(arg0);
					}

				}else{
					JOptionPane.showMessageDialog(null, "Invalid login.");
				}
			}
		});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginPanel.class.getResource("/finalproject/cfwdbackground.png")));
		label.setBounds(-10, 0, 660, 400);
		add(label);

	}
	
	public boolean checkLogin(String username, char[] password){
		
		accountList = CfwPrimary.getAccounts();
		
		for(int i = 0; i < accountList.size(); i++){ //Check accounts
			if(username.equals(accountList.get(i).getUsername())){ //If username exists...
				if(password.length == accountList.get(i).getPassword().length){ //Check password length
					for(int j = 0; j < password.length; j++){ //Check password characters
						if(password[j] != accountList.get(i).getPassword()[j]){ //Are they the same?
							return false; //Invalid password
						}
					}
					permission = accountList.get(i).getPermission();
					balance = accountList.get(i).getBalance();
					return true; //Logged in!
				}
			}
		}
		return false; //Account does not exist
	}
	
	public int getPermission(){
		return permission;
	}
	
	public double getBalance(){
		return balance;
	}
	
}