//정렬
public class PlayerVO implements Comparable<PlayerVO>{
	private String name;
	private String position;
	private int regYear;
	
	public PlayerVO(String name, String position, int regYear) {
		this.name= name;
		this.position =position;
		this.regYear= regYear;
	}
	public String toString() {
		return name+":"+position+":"+regYear;
	}
	@Override
	public int compareTo(PlayerVO otherPlayer) {
		System.out.println("정렬시도");
		return this.name.compareTo(otherPlayer.name);//이름 순으로 정렬
	}

}
