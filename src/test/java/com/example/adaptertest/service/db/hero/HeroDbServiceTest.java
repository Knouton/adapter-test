package com.example.adaptertest.service.db.hero;

import static com.example.adaptertest.sample.HeroDtoSample.heroDtoSample1;
import static com.example.adaptertest.sample.HeroEntitySample.heroEntitySample1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.example.adaptertest.config.HeroMapperConfig;
import com.example.adaptertest.dto.HeroDto;
import com.example.adaptertest.dto.SkillDto;
import com.example.adaptertest.entity.HeroEntity;
import com.example.adaptertest.entity.SkillEntity;
import com.example.adaptertest.mapper.HeroMapper;
import com.example.adaptertest.repository.HeroRepository;
import jakarta.validation.Validator;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HeroDbServiceTest {

	@Mock
	HeroRepository heroRepository;
	@Mock
	Validator validator;
	@Spy
	HeroMapper mapper = Mappers.getMapper(HeroMapper.class);
	@InjectMocks
	HeroDbServiceImpl heroDbService;

	HeroDto heroDto = heroDtoSample1;

	HeroEntity heroEntity = heroEntitySample1;
	@BeforeEach
	void init() {
		mapper = spy(new HeroMapperConfig().heroMapper());
	}

	@Test
	void LoadToDbSuccessTest() {
		when(heroRepository.save(heroEntity)).thenReturn(heroEntity);
		HeroDto result;

		result = heroDbService.insertToDb(heroDto);

		verify(heroRepository, times(1)).save(heroEntity);
		assertEquals(result, heroDto);
	}

	@Test
	void getFromDbByIdSuccessTest() {
		when(heroRepository.getReferenceById(1L)).thenReturn(heroEntity);
		HeroDto result;

		result = heroDbService.getHeroById(1L);

		verify(heroRepository, times(1)).getReferenceById(1L);
		assertEquals(result, heroDto);
	}
}
