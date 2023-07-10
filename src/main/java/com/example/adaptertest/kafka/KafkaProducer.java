package com.example.adaptertest.kafka;

import com.example.adaptertest.config.KafkaProducerConfig;
import com.example.adaptertest.dto.HeroDto;
import com.example.adaptertest.dto.KafkaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

	@Value("${spring.kafka.producer.topic.start.hero.entry}")
	private String startHeroEntry;

	@Value("${spring.kafka.producer.topic.load.hero.entry}")
	private String statusLoadHeroEntry;
	private final KafkaProducerConfig producerConfig;

	public void startHeroEntryMessage(HeroDto heroDto) {
		producerConfig.getHeroEntryProducerTemplate().send(startHeroEntry, heroDto);
	}

	public void statusLoadHeroEntry(KafkaResponseDto responseDto) {
		producerConfig.getResponseDtoProducerTemplate().send(statusLoadHeroEntry, responseDto);
	}
}
