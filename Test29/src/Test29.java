
public class Test29 {
	private int inputCoin;
	public void depositMoney(int inputCoin,String inputMessage) {
		this.inputCoin=this.inputCoin+inputCoin;
		if (inputMessage.equals("")) {
			System.out.println("딸그랑");
		}else {
			System.out.println(inputMessage);
		}
	}
	public void crash() {
		System.out.println("전체코인"+ inputCoin+ "이 출급되었습니다.");
		this.inputCoin=0;
	}

}


