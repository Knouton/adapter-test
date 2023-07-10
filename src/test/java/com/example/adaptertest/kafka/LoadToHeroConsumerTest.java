package com.example.adaptertest.kafka;

import static com.example.adaptertest.sample.HeroDtoSample.heroDtoSample1;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.example.adaptertest.dto.KafkaResponseDto;
import com.example.adaptertest.service.adapter.HeroAdapterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LoadToHeroConsumerTest {

	@Mock
	private KafkaProducer producer;

	@Mock
	private HeroAdapterService adapterService;

	@InjectMocks
	private KafkaConsumer kafkaConsumer;

	@Test
	void loadToHeroConsumerSuccessTest() {
		KafkaResponseDto response = new KafkaResponseDto();
		response.setId(1);
		response.setStatus(0);
		when(adapterService.getProducerDto(heroDtoSample1)).thenReturn(response);

		kafkaConsumer.loadToHero(heroDtoSample1);

		verify(producer).statusLoadHeroEntry(response);
	}
}
