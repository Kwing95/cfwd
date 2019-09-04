package finalproject;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RegisterPanel extends JPanel {
	private JTextField userField;
	private JPasswordField passwordField;
	private JPasswordField confirmPassField;
	private JTextField emailField;
	private JTextField creditField;
	private JTextField balanceField;
	private JComboBox typeCombo;
	
	private ActionListener cancelListener = null;
	private ActionListener createListener = null;
	
	public void AddCancelListener(ActionListener cancelListener){
		this.cancelListener = cancelListener;
	}
	
	public void AddCreateListener(ActionListener createListener) {
		this.createListener = createListener;
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.getContentPane().add(new RegisterPanel());
		frame.setTitle("cFwd");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminPanel.class.getResource("/finalproject/cfwdicon.png")));
		frame.setResizable(false);
		frame.setSize(660, 420); // Set the frame size (640x400)
		frame.setLocationRelativeTo(null); // Center a frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); // Display the frame
	}

	public RegisterPanel() {
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(195, 150, 250, 235);
		add(panel);
		
		JLabel label_1 = new JLabel("Username");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(20, 14, 69, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(20, 68, 69, 14);
		panel.add(label_2);
		
		JButton button = new JButton("Register");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					ArrayList<Account> accounts = CfwPrimary.getAccounts();
					boolean available = true;
					
					if(available && emailField.getText().length() == 0){
						available = false;
						JOptionPane.showMessageDialog(null, "Please enter an email address.");
					}
					
					if(available && balanceField.getText().length() == 0){
						available = false;
						JOptionPane.showMessageDialog(null, "Please enter a starting balance.");
					}
					
					if(available && creditField.getText().length() == 0){
						available = false;
						JOptionPane.showMessageDialog(null, "Please enter a credit card number.");
					}
					
					if(available && (passwordField.getPassword().length < 5 || userField.getText().length() < 5)){
						available = false;
						JOptionPane.showMessageDialog(null, "Username and password must be at least five characters.");
					}
					
					if(available && !compareCharArray(passwordField.getPassword(), confirmPassField.getPassword())){
						available = false;
						JOptionPane.showMessageDialog(null, "Passwords do not match.");
					}
					
					for(int i = 0; i < accounts.size(); i++){
						if(userField.getText().toLowerCase().equals(accounts.get(i).getUsername().toLowerCase())){
							JOptionPane.showMessageDialog(null, "Username is already in use.");
							available = false;
						}
					}
					
					if(available && !Luhn.isValid(Long.parseLong(creditField.getText()))){
						//available = false;
						JOptionPane.showMessageDialog(null, "Credit card number is invalid. Oh well.");
					}
					
					if(available){
						try{
							Account newAccount = new Account(userField.getText().toLowerCase(), passwordField.getPassword(),
									Double.parseDouble(balanceField.getText()), typeCombo.getSelectedIndex(),
									emailField.getText(), Long.parseLong(creditField.getText()));
							CfwPrimary.addAccount(newAccount);
							JOptionPane.showMessageDialog(null, "Registration successful. " +
									"A non-existent confirmation email has been sent to your inbox.\n" +
									"Please pretend to confirm your account before logging in.");
							RegisterPanel.this.cancelListener.actionPerformed(arg0);
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(null, "Invalid input.");
						}
					}
				
			}
		});
		button.setBounds(134, 201, 86, 23);
		panel.add(button);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterPanel.this.cancelListener.actionPerformed(arg0);
			}
		});
		btnCancel.setBounds(38, 201, 86, 23);
		panel.add(btnCancel);
		
		userField = new JTextField();
		userField.setColumns(10);
		userField.setBounds(109, 11, 131, 20);
		panel.add(userField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(109, 65, 131, 20);
		panel.add(passwordField);
		
		JLabel lblRetype = new JLabel("Confirm Pass");
		lblRetype.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRetype.setForeground(Color.WHITE);
		lblRetype.setBounds(0, 94, 88, 14);
		panel.add(lblRetype);
		
		confirmPassField = new JPasswordField();
		confirmPassField.setBounds(109, 91, 131, 20);
		panel.add(confirmPassField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(109, 117, 131, 20);
		panel.add(emailField);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(20, 120, 69, 14);
		panel.add(lblEmail);
		
		JLabel lblCreditCard = new JLabel("Credit Card");
		lblCreditCard.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditCard.setForeground(Color.WHITE);
		lblCreditCard.setBounds(20, 146, 69, 14);
		panel.add(lblCreditCard);
		
		creditField = new JTextField();
		creditField.setColumns(10);
		creditField.setBounds(109, 143, 131, 20);
		panel.add(creditField);
		
		balanceField = new JTextField();
		balanceField.setColumns(10);
		balanceField.setBounds(109, 169, 131, 20);
		panel.add(balanceField);
		
		JLabel lblStartingBalance = new JLabel("Balance");
		lblStartingBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStartingBalance.setForeground(Color.WHITE);
		lblStartingBalance.setBounds(20, 172, 69, 14);
		panel.add(lblStartingBalance);
		
		JLabel label_3 = new JLabel("Type");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(20, 41, 69, 14);
		panel.add(label_3);
		
		typeCombo = new JComboBox();
		typeCombo.setModel(new DefaultComboBoxModel(new String[] {"User", "Investor*", "Admin*"}));
		typeCombo.setBounds(109, 38, 131, 20);
		panel.add(typeCombo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegisterPanel.class.getResource("/finalproject/cfwdbackground.png")));
		label.setBounds(-10, 0, 660, 400);
		add(label);

	}
	
	public boolean compareCharArray(char[] pass1, char[] pass2){		
		if(pass1.length == pass2.length){
			for(int i = 0; i < pass1.length; i++){ //Check password characters
				if(pass1[i] != pass2[i]){ //Are they the same?
					return false; //Passwords contain different characters
				}
			}
		}else{
			return false; //Passwords are different length
		}
		return true;
	}
	
}
