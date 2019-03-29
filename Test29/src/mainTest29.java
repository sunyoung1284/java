import java.util.Scanner;

public class mainTest29 {
	public static void main(String[] args) {
		Test29 moneybox = new Test29();
		Scanner scanner= new Scanner(System.in);
		moneybox.depositMoney(100,"");
		moneybox.depositMoney(100,"hello");
		
		for(int i=0;i<99999; i++) {
			System.out.print("메뉴선택1.입금,2.입금+메세지:,3.종료:");
			int selectMenu =scanner.nextInt();
			if(selectMenu==1) {	
				System.out.println("입금할 금액:");
				int inputCoin=scanner.nextInt();
				moneybox.depositMoney(inputCoin,"");
			}else if (selectMenu==2){
				System.out.println("입금할 금액:");
				int inputCoin=scanner.nextInt();
				scanner.nextLine();
				String inputMessage=scanner.nextLine();
			}else if (selectMenu==3) {
				moneybox.crash();
				break;
	
			}
			
		}
			
	
}

}
