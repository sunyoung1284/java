
public class Test28 {
	public int totalCoin =0;
	private String name;
	
	public void setName(String name) {
		this.name =name;
		
	}
	public void deposit(int inputCoin) {
		totalCoin =totalCoin + inputCoin;
	}
	public void withdraw() {
		System.out.println(name+"출금액:"+totalCoin);
		totalCoin=0;
	
	}
}
