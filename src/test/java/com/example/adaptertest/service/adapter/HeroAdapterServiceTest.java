package com.example.adaptertest.service.adapter;

import static com.example.adaptertest.sample.HeroDtoSample.heroDtoInvalidName1;
import static com.example.adaptertest.sample.HeroDtoSample.heroDtoSample1;
import static com.example.adaptertest.sample.KafkaResponseDtoSample.successfulResponseDtoSample1;
import static com.example.adaptertest.sample.KafkaResponseDtoSample.unsuccessfulValidateNameResponseDtoSample1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import com.example.adaptertest.config.HeroMapperConfig;
import com.example.adaptertest.dto.HeroDto;
import com.example.adaptertest.dto.KafkaResponseDto;
import com.example.adaptertest.exceptions.InvalidInputDataException;
import com.example.adaptertest.kafka.KafkaProducer;
import com.example.adaptertest.service.db.hero.HeroDbServiceImpl;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HeroAdapterServiceTest {

	@Mock
	private KafkaProducer producer;
	@Mock
	private HeroDbServiceImpl dbService;
	@InjectMocks
	private HeroAdapterServiceImpl adapterService;

	@Mock
	private Validator validator;
	HeroDto heroDto1 = heroDtoSample1;
	HeroDto heroDtoInvalidName = heroDtoInvalidName1;
	KafkaResponseDto responseSuccessful1 = successfulResponseDtoSample1;
	KafkaResponseDto responseUnsuccessful1 = unsuccessfulValidateNameResponseDtoSample1;


	@Test
	void getProducerDtoSuccessfulTest(){
		KafkaResponseDto result;
		when(dbService.insertToDb(heroDto1)).thenReturn(heroDto1);

		result = adapterService.getProducerDto(heroDto1);

		assertEquals(result, responseSuccessful1);
	}

	@Test
	void getProducerDtoUnsuccessfulTest() {
		when(dbService.insertToDb(heroDtoInvalidName))
				.thenThrow(
						new InvalidInputDataException("name must be more than 4 characters and less than 10; " +
								                              "id :" + heroDtoInvalidName.getId() + "; " +
								                              "current name: " + heroDtoInvalidName.getName()));
		KafkaResponseDto result;

		result = adapterService.getProducerDto(heroDtoInvalidName);

		assertEquals(result, responseUnsuccessful1);
	}
}
