
public class parenthesesMain {
	public static void main(String[] args) {
		parentheses test = new parentheses();
		int num = 3;
		String[] parentheses = { "(", ")", "(", "(", "(", ")", "(", ")", ")", ")"};
		test.findMate(num, parentheses);
	}
}
