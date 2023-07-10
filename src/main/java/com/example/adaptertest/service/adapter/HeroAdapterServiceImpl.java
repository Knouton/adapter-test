package com.example.adaptertest.service.adapter;

import static com.example.adaptertest.component.AliasConstant.ADAPTER_SERVICE_LOAD_TO_HERO_ERROR_REQUEST;
import static com.example.adaptertest.component.AliasConstant.ADAPTER_SERVICE_LOAD_TO_HERO_FINISH_REQUEST;
import static com.example.adaptertest.component.AliasConstant.ADAPTER_SERVICE_LOAD_TO_HERO_START_REQUEST;
import com.example.adaptertest.dto.HeroDto;
import com.example.adaptertest.dto.KafkaResponseDto;
import com.example.adaptertest.exceptions.HeroException;
import com.example.adaptertest.kafka.KafkaProducer;
import com.example.adaptertest.service.db.hero.HeroDbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HeroAdapterServiceImpl implements HeroAdapterService {
	private final KafkaProducer producer;
	private final HeroDbService heroDbService;

	@Override
	public KafkaResponseDto getProducerDto (HeroDto heroDto) {
		log.info(ADAPTER_SERVICE_LOAD_TO_HERO_START_REQUEST, heroDto);

		KafkaResponseDto responseDto = new KafkaResponseDto();
		try {
			heroDto = heroDbService.insertToDb(heroDto);
			responseDto.setId(heroDto.getId());
			responseDto.setStatus(1);
		} catch (HeroException e) {
			responseDto.setId(heroDto.getId());
			responseDto.setStatus(0);
			responseDto.setMsgErr(e.getMessage());

			log.error(ADAPTER_SERVICE_LOAD_TO_HERO_ERROR_REQUEST, e.getMessage());
		}

		log.info(ADAPTER_SERVICE_LOAD_TO_HERO_FINISH_REQUEST, responseDto);

		return responseDto;
	}

	@Override
	public void sendStartHeroEntry(HeroDto heroDto) {
		log.info(ADAPTER_SERVICE_LOAD_TO_HERO_START_REQUEST, heroDto);
		try {
			producer.startHeroEntryMessage(heroDto);
		} catch (Exception e) {
			log.error(ADAPTER_SERVICE_LOAD_TO_HERO_ERROR_REQUEST, e.getMessage());
		}
		log.info(ADAPTER_SERVICE_LOAD_TO_HERO_FINISH_REQUEST, heroDto);
	}
}
