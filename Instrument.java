package finalproject;

public class Instrument {

	public static void main(String[] args) {
		System.out.println(shouldBuy(29));
	}
	
	public static int shouldBuy(double temp){
		
		double average = (indicator1() + indicator2() + indicator3() + indicator4(temp)) / 4.0;
		
		if(average > 66){
			return 1;
		}else if(average > 33){
			return 0;
		}else{
			return -1;
		}
		
	}
	
	public static double indicator1(){
		return Math.random() * 100;//0 - 100
	}

	public static double indicator2(){
		return 10 + Math.random() * 90;//10 - 100
	}
	
	public static double indicator3(){
		return Math.random() * 90;//0 - 90
	}
	
	public static double indicator4(double temp){
		return Math.random() * 100 + (temp % 10);//Total nonsense
	}
	
}