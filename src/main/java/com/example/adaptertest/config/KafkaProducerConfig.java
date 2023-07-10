package com.example.adaptertest.config;

import com.example.adaptertest.dto.HeroDto;
import com.example.adaptertest.dto.KafkaResponseDto;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

@Configuration
@EnableKafka
@RequiredArgsConstructor
public class KafkaProducerConfig {

	private final KafkaCommonConfig commonConfig;
	@Bean
	public Map<String, Object> producerConfigs() {
		return commonConfig.producerConfig();
	}

	@Bean
	public ProducerFactory<Long, HeroDto> producerHeroFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	@Bean
	public KafkaTemplate<Long, HeroDto> getHeroEntryProducerTemplate() {
		KafkaTemplate<Long, HeroDto> template = new KafkaTemplate<>(producerHeroFactory());
		template.setMessageConverter(new StringJsonMessageConverter());
		return template;
	}

	@Bean
	public ProducerFactory<Long, KafkaResponseDto> producerResponseDtoFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	@Bean
	public KafkaTemplate<Long, KafkaResponseDto> getResponseDtoProducerTemplate() {
		KafkaTemplate<Long, KafkaResponseDto> template = new KafkaTemplate<>(producerResponseDtoFactory());
		template.setMessageConverter(new StringJsonMessageConverter());
		return template;
	}
}
