package hahakafka.consumer;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

import hahakafka.consumer.like.User;
import hahakafka.consumer.like.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaConsumerListener implements MessageListener<String, String> {

	protected final Logger LOG = LoggerFactory.getLogger(KafkaConsumerListener.class);
	private final AtomicInteger logFlag = new AtomicInteger(0);
	private User user = new User();
	@Autowired
	private UserRepository userRepository;

	@Override
	public void onMessage(ConsumerRecord<String, String> record) {
		LOG.info("=============kafkaConsumer开始消费=============");
		// String topic = record.topic();
		// String key = record.key();
		String value = record.value();
		user.setUserId("liuxin" + logFlag.get());
		user.setEmail(value);
		user.setUserName("I am liuxin " + logFlag.get());
		user.setSex("boy");
		user.setBirthday(new Date());
		//userRepository.save(user);
		logFlag.incrementAndGet();
		LOG.info(user.toString());
		// long offset = record.offset();
		// int partition = record.partition();
		// LOG.info("-------------topic:" + topic);
		// LOG.info("-------------value:" + value);
		// LOG.info("-------------key:" + key);
		// LOG.info("-------------offset:" + offset);
		// LOG.info("-------------partition:" + partition);
		// LOG.info("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
	}

}