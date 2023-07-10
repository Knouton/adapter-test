package com.example.adaptertest.config;

import com.example.adaptertest.mapper.HeroMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroMapperConfig {
	@Bean
	public HeroMapper heroMapper() {
		return Mappers.getMapper(HeroMapper.class);
	}
}
