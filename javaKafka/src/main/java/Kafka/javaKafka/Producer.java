package Kafka.javaKafka;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Producer extends Thread {
	public static void main(String[] args) throws IOException {
		
		Properties configs = new Properties();
		configs.put("bootstrap.servers", "192.168.0.30:9092,192.168.0.31:9092,192.168.0.32:9092"); // kafka host 및
																									// server 설정
		configs.put("acks", "all"); // 자신이 보낸 메시지에 대해 카프카로부터 확인을 기다리지 않습니다.
		configs.put("block.on.buffer.full", "true"); // 서버로 보낼 레코드를 버퍼링 할 때 사용할 수 있는 전체 메모리의 바이트수
		configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); // serialize 설정
		configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); // serialize 설정

		// producer 생성
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configs);
	
		String url ="https://datalab.naver.com/keyword/realtimeList.naver?where=main";
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
				Elements element = doc.select("div.jcarousel._realtime_new_list_carousel.carousel_line_r");    

				//Iterator을 사용하여 하나씩 값 가져오기
				Iterator<Element> ie1 = element.select("strong.rank_title.v2").iterator();
				Iterator<Element> ie2 = element.select("ul.rank_list.v2").iterator();
				String result = "================================================================================";        
				while (ie1.hasNext()) {
					result += "\n"+ie1.next().text()+"\n"+ie2.next().text();
					result +="\n"+"------------------------------------------------------------------------------" ;
					producer.send(new ProducerRecord<String, String>("kopo-topic2",result));
					System.out.println(result);
					result ="";
				}
				
				Thread.sleep(60000);// 스레드 1분동안 대기	
            }
        }catch(InterruptedException e)
        {
            System.out.println(e);
        }
	
		producer.flush();
		producer.close();
	}
}
