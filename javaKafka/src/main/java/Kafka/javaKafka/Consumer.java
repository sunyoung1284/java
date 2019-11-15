package Kafka.javaKafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.Arrays;
import java.util.Properties;

public class Consumer {
	public static void main(String[] args) {
		Properties configs = new Properties();
		// 환경변수 설정
		configs.put("bootstrap.servers", "192.168.0.30:9092,192.168.0.31:9092,192.168.0.32:9092"); // kafka server host
																									// 및 port
		configs.put("session.timeout.ms", "10000"); // session 설정
		configs.put("group.id", "kopo-topic2"); // topic 설정
		configs.put("enable.auto.commit", "true");
		configs.put("auto.offset.reset", "earliest");
		configs.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // key deserializer
		configs.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // value
																										// deserializer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(configs); // consumer 생성
		consumer.subscribe(Arrays.asList("kopo-topic2")); // topic 설정
		int i = 0;
		while (true) { // 계속 loop를 돌면서 producer의 message를 띄운다.
			ConsumerRecords<String, String> records = consumer.poll(500);
			for (ConsumerRecord<String, String> record : records) {
				String s = record.topic();
				if ("kopo-topic2".equals(s)) {
					System.out.println(record.value());
					System.out.println("----------- " + i);
					i++;
				} else {
					throw new IllegalStateException("get message on topic " + record.topic());
				}
			}
		}
	}
}
