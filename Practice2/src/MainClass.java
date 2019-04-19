import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		practice2 moneyBox = new practice2();
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < 99999; i++) {
			System.out.print("입금할 금액 : ");
			int coin = scanner.nextInt();
			System.out.print("메세지 : ");
			scanner.nextLine();
			String message = scanner.nextLine();
			moneyBox.deposit(coin, message);
			if (message.equals("crash")) {
				break;
			}
		}

	}
}
