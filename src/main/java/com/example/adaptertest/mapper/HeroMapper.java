package com.example.adaptertest.mapper;

import com.example.adaptertest.dto.HeroDto;
import com.example.adaptertest.entity.HeroEntity;
import org.mapstruct.Mapper;

@Mapper
public interface HeroMapper {
	HeroDto fromHeroEntity(HeroEntity heroEntity);
	HeroEntity fromHeroDto(HeroDto heroDto);
}
