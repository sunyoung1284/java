package Kafka.javaKafka;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test2 extends Thread {
	public static void main(String[] args) {
		String url ="http://finance.daum.net/domestic/market_cap";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try
        {
            for(int i = 0 ; i < 99999999 ; i++)
            {
                
        		//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
				Elements element = doc.select("div.leftW");    

				
				//Iterator을 사용하여 하나씩 값 가져오기
				Iterator<Element> ie1 = element.select("span.time").iterator();
				Iterator<Element> ie2 = element.select("a.txt").iterator();
				String result = "========================================================================================================================";
				        
				while (ie1.hasNext()) {
					
					result += "\n"+ie1.next().text()+"\n"+ie2.next().text();
					result +="\n"+"---------------------------------------------------------------" ;
				}
				System.out.println(result);
				Thread.sleep(100000);// 스레드 0.5초동안 대기	
            }
        }catch(InterruptedException e)
        {
            System.out.println(e);
        }
	
		
		

	
		
	}

}
