package com.example.adaptertest.kafka;

import static com.example.adaptertest.component.AliasConstant.CONSUMED_MESSAGE_LOG;
import com.example.adaptertest.dto.HeroDto;
import com.example.adaptertest.dto.KafkaResponseDto;
import com.example.adaptertest.service.adapter.HeroAdapterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

	private final KafkaProducer producer;
	private final HeroAdapterService heroAdapterService;

	@KafkaListener(topics = "${spring.kafka.consumer.topic.start.hero.entry}"
			, containerFactory = "singleFactory")
	public void loadToHero(HeroDto heroDto){
		log.info(CONSUMED_MESSAGE_LOG, heroDto.toString());
		System.out.println(heroDto);
		KafkaResponseDto response = heroAdapterService.getProducerDto(heroDto);

		producer.statusLoadHeroEntry(response);
	}
}
