package com.example.adaptertest.service.db.hero;

import com.example.adaptertest.dto.HeroDto;

public interface HeroDbService {

	HeroDto getHeroById(long id);

	HeroDto insertToDb(HeroDto heroDto);
}
