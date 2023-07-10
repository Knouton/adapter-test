package com.example.adaptertest.config;

import com.example.adaptertest.dto.HeroDto;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.BatchMessagingMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;


@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {
	private final KafkaCommonConfig commonConfig;

	@Bean
	public Map<String, Object> consumerConfigs() {
		return commonConfig.consumerConfig();
	}

	@Bean
	public KafkaListenerContainerFactory<?> batchFactory() {
		ConcurrentKafkaListenerContainerFactory<Long, HeroDto> factory =
				new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setBatchListener(true);
		factory.setMessageConverter(new BatchMessagingMessageConverter(converter()));
		return factory;
	}

	@Bean
	public KafkaListenerContainerFactory<?> singleFactory() {
		ConcurrentKafkaListenerContainerFactory<Long, HeroDto> factory =
				new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setBatchListener(false);
		factory.setMessageConverter(new StringJsonMessageConverter());
		return factory;
	}

	@Bean
	public ConsumerFactory<Long, HeroDto> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}

	@Bean
	public StringJsonMessageConverter converter() {
		return new StringJsonMessageConverter();
	}
}
