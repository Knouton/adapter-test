package com.example.adaptertest.service.adapter;

import com.example.adaptertest.dto.HeroDto;
import com.example.adaptertest.dto.KafkaResponseDto;

public interface HeroAdapterService {

	KafkaResponseDto getProducerDto (HeroDto heroDto);

	void sendStartHeroEntry(HeroDto dto);
}
