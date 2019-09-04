package finalproject;

public class Account {
	
	private String username;
	private char[] password;
	private double balance;
	private int shares;
	private int type;
	private String email;
	private long creditCard;
	
	
	public Account(String name, String pass, double balance, int type){
		this.username = name.toLowerCase();
		this.password = pass.toCharArray();
		this.balance = balance;
		this.type = type + 1;
		this.shares = 0;			
	}
	
	public Account(String name, String pass, double balance, int type, String email, long creditCard){
		this.username = name.toLowerCase();
		this.password = pass.toCharArray();
		this.balance = balance;
		this.type = type + 1;
		this.shares = 0;			
		this.email = email;
		this.creditCard = creditCard;
	}
	
	public Account(String name, char[] pass, double balance, int type, String email, long creditCard){
		this.username = name.toLowerCase();
		this.password = pass;
		this.balance = balance;
		this.type = type + 1;
		this.shares = 0;			
		this.email = email;
		this.creditCard = creditCard;
	}
	
	public String getUsername(){
		return username;
	}
	
	public char[] getPassword(){
		return password;
	}
	
	public int getPermission(){
		return type;
	}
	
	public double getBalance(){
		return balance;
	}
	
}