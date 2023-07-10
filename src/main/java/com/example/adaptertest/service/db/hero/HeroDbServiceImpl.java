package com.example.adaptertest.service.db.hero;

import static com.example.adaptertest.component.AliasConstant.HERO_SERVICE_GET_FROM_DB_FINISH_REQUEST;
import static com.example.adaptertest.component.AliasConstant.HERO_SERVICE_GET_FROM_DB_START_REQUEST;
import static com.example.adaptertest.component.AliasConstant.HERO_SERVICE_SAVE_TO_DB_FINISH_REQUEST;
import static com.example.adaptertest.component.AliasConstant.HERO_SERVICE_SAVE_TO_DB_START_REQUEST;
import com.example.adaptertest.dto.HeroDto;
import com.example.adaptertest.entity.HeroEntity;
import com.example.adaptertest.exceptions.HeroDbException;
import com.example.adaptertest.exceptions.InvalidInputDataException;
import com.example.adaptertest.mapper.HeroMapper;
import com.example.adaptertest.repository.HeroRepository;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HeroDbServiceImpl implements HeroDbService {

	private final HeroRepository heroRepository;
	private final HeroMapper heroMapper;

	private final Validator validator;

	public HeroDto getHeroById(long id) {
		log.info(HERO_SERVICE_GET_FROM_DB_START_REQUEST, id);
		HeroEntity heroEntity;
		try {
			heroEntity = heroRepository.getReferenceById(id);
		} catch (Exception e) {
			throw new HeroDbException(e.getMessage(), e);
		}

		log.info(HERO_SERVICE_GET_FROM_DB_FINISH_REQUEST, id);
		return heroMapper.fromHeroEntity(heroEntity);
	}

	public HeroDto insertToDb(HeroDto heroDto) {
		validate(heroDto);

		log.info(HERO_SERVICE_SAVE_TO_DB_START_REQUEST, heroDto);

		HeroEntity heroEntity = heroMapper.fromHeroDto(heroDto);
		heroEntity.getSkills().forEach(item -> item.setHeroEntity(heroEntity));
		try {
			heroRepository.save(heroEntity);
			heroRepository.flush();
		} catch (Exception e) {
			throw new HeroDbException(e.getMessage(), e);
		}

		log.info(HERO_SERVICE_SAVE_TO_DB_FINISH_REQUEST, heroEntity);
		return heroMapper.fromHeroEntity(heroEntity);
	}

	private void validate(HeroDto heroDto) {
		if (!validator.validate(heroDto).isEmpty()) {
			throw new InvalidInputDataException(validator.validate(heroDto).toString());
		}
		if (heroDto.getName().length() < 4 || heroDto.getName().length() > 10) {
			throw new InvalidInputDataException("name must be more than 4 characters and less than 10; id :" + heroDto.getId()
					                                    + "; current name: " + heroDto.getName());
		}
	}
}
