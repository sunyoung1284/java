import java.util.Random;
public class Random2 extends Random{
	@Override
	public int nextInt(int range) {
		int newRandomNumber = super.nextInt(range)+100;
		return newRandomNumber;
	}}