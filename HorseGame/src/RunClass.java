import java.util.HashMap;
import java.util.Map;


public class RunClass {
	public static void main(String[] args) throws InterruptedException {
					
		
		Jenny jenny = new Jenny(null);							// jenny ��ü ����
		Fury fury = new Fury(null);								// fury ��ü ����
		Athus athus = new Athus(null);							// athus ��ü ����
		
		
		int maxDistance = jenny.maxDistance;									// track�� ����		
		
		System.out.println("�������մϴ�..");
		
		for (int i=3; i>0; i--) {								// ī��Ʈ�ٿ�
            Thread.sleep(1000);
            System.out.println(i);
        }
		
        Thread.sleep(1000);
        System.out.println("땡!!!!");
        Thread.sleep(1000);
		
        while(true) {        	
        	Thread.sleep(50);
        	for (int i = 0; i < 30; i++) {						// 30�پ� �о ���� �þ�°�ó�� ���̰�, ������ Ʈ��
				System.out.println();
			}        	
        	jenny.moving();
        	fury.moving();
        	athus.moving();    		
    		System.out.println(jenny.moveMotion + jenny.name);
    		System.out.println(fury.moveMotion + fury.name);
    		System.out.println(athus.moveMotion + athus.name);
			 
			if(jenny.horseCurDistance>=maxDistance && fury.horseCurDistance>=maxDistance && athus.horseCurDistance>=maxDistance) {	// ��� ��ü�� Ʈ���� ���� �ٴٸ��� while�� ����
				Thread.sleep(1000);
				break;
			}
			
        }

        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        resultMap.put(jenny.name, jenny.winningTurn);
        resultMap.put(fury.name, fury.winningTurn);
        resultMap.put(athus.name, athus.winningTurn);
        
        PrintResult print = new PrintResult();
        print.printResult(resultMap);
        
	}

}
