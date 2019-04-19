
public class practice2 {
	private int coin;
	public void deposit(int coin, String message) {
		this.coin = this.coin + coin;
		if (message.equals("")) {
			System.out.println("땡그랑");
		} else {
			System.out.println(message);
		}
	}
}
