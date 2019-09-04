package finalproject;

import javax.swing.JOptionPane;

public class Transaction {
	
	private static double balance;
	private static int shares;
	
	private static int timerCounter;//How many seconds until selling?
	private static int timerQuantity;//How many to sell?
	private static boolean timerActive = false;
	
	private static double profitGoal;//What price to sell at?
	private static int profitQuantity;//How many to sell?
	private static boolean profitActive = false;

	public static void main(String[] args) {
		//System.out.println(Math.abs(-23));
		//Transaction t1 = new Transaction(1000, 0);
		Transaction.buyShares(10, 50);
		System.out.println("Shares: " + Transaction.getShares() + " Balance: " + Transaction.getBalance());
		Transaction.sellShares(10, 100);
		System.out.println("Shares: " + Transaction.getShares() + " Balance: " + Transaction.getBalance());
	}
	
//	public Transaction(double balance, int shares){
//		this.balance = balance;
//		this.shares = shares;
//	}
	
	public static void setBalance(double amount){
		balance = amount;
	}
	
	public static void setShares(int amount){
		shares = amount;
	}
	
	public static void setProfitTrigger(int amount, double price, double percent){
		profitGoal = price * ((100 + percent) / 100.0);
		profitQuantity = amount;
		profitActive = true;
	}
	
	public static void setTimerTrigger(int amount, int count){
		timerCounter = count;
		timerQuantity = amount;
		timerActive = true;
	}
	
	public static double getBalance() {		return balance;	}
	public static int getShares() {		return shares;	}
	public static boolean isProfitActive(){		return profitActive;	}
	public static boolean isTimerActive(){		return timerActive;	}
	
	public static void checkProfitTrigger(double price){
		if(price >= profitGoal && profitActive){
			sellShares(profitQuantity, price);
			profitActive = false;
		}
	}
	
	public static void checkTimerTrigger(double price){
		if(timerCounter <= 0 && timerActive){
			sellShares(timerQuantity, price);
			timerActive = false;
		}else{
			timerCounter--;
		}
	}
	
	public static void buyShares(int amount, double price){
		if(balance >= price * amount && amount > 0){
			balance -= price * amount;
			shares += amount;
			UserPanel.setBalanceField(Math.round(balance * 100) / 100.0);
			UserPanel.setSharesField(shares);
		}else{
			JOptionPane.showMessageDialog(null, "Insufficient funds or invalid input.");
		}
	}
	
	public static void sellShares(int amount, double price){
		if(shares >= amount && amount > 0){
			balance += price * amount;
			shares -= amount;
			UserPanel.setBalanceField(Math.round(balance * 100) / 100.0);
			UserPanel.setSharesField(shares);
		}else{
			JOptionPane.showMessageDialog(null, "Insufficient shares or invalid input.");
		}
	}

}
