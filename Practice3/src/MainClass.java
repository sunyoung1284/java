//5명의 데이터 이름 (국어,영어,수학) 총점 평균 구하고, 전체 데이터를 출력
public class MainClass {
	public static void main(String[] args) {
		Practice3 []arr =new Practice3[5];
		for(int i=0; i<5; i++) {
			arr[i]=new Practice3();
			arr[i].inputScore();
			
		}
		int KorTotal=0;
		int engTotal=0;
		int mathTotal=0;
		double kortotalaverage=0;
		double engtotalaverage=0;
		double mathtotalaverage=0;
		
		for(int i=0; i<arr.length; i++) {
			KorTotal=KorTotal+arr[i].korScore;
			engTotal=engTotal+arr[i].engScore;
			mathTotal=mathTotal+arr[i].mathScore;
			}
		kortotalaverage=(double)KorTotal/arr.length;
		System.out.println("국어 총점은:"+KorTotal+"국어총점평균은:"+kortotalaverage);
		engtotalaverage=(double)engTotal/arr.length;
		System.out.println("영어 총점은:"+engTotal+"국어총점평균은:"+engtotalaverage);
		mathtotalaverage=(double)mathTotal/arr.length;
		System.out.println("수학 총점은:"+mathTotal+"국어총점평균은:"+mathtotalaverage);
			
		}
		
	}


