
public class RunClass {
	public static void main(String[] args) {
		final int GAME_START_NUMBER=1;
		final int GAME_END_NUMBER=100;
		String[] names= {"선영","진희","방구"};
		Person[] players =new Person[names.length];
		for(int i=0; i<names.length; i++) {
			players[i]=new Person(names[i]);
		}
		for(int i=0; i<players.length; i++) {
			players[i].readyGame(players,i,GAME_START_NUMBER,GAME_END_NUMBER);
		}
		players[0].gameStart();
		
		

}}
