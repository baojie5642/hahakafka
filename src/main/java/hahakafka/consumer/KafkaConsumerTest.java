package hahakafka.consumer;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
  
public class KafkaConsumerTest {
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                    "classpath:kafka-consumer.xml");
            context.start();
        } catch (BeansException e) {
            e.printStackTrace();
        }
  
        synchronized (KafkaConsumerTest.class) {
            while (true) {
                try {
                    KafkaConsumerTest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
