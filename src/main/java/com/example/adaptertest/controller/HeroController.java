package com.example.adaptertest.controller;

import com.example.adaptertest.component.AliasConstant;
import com.example.adaptertest.dto.HeroDto;
import com.example.adaptertest.service.db.hero.HeroDbService;
import com.example.adaptertest.service.adapter.HeroAdapterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class HeroController {

	private HeroDbService heroDbService;
	private HeroAdapterService heroAdapterService;

	@Autowired
	public HeroController(HeroDbService heroDbService, HeroAdapterService heroAdapterService) {
		this.heroDbService = heroDbService;
		this.heroAdapterService = heroAdapterService;
	}

	@GetMapping("/getHero/{id}")
	public HeroDto getHero(@PathVariable long id) {
		return heroDbService.getHeroById(id);
	}

	@PostMapping (value = "/addHero",  consumes={"application/json"})
	public long addHero(@RequestBody HeroDto heroDto) {
		return heroDbService.insertToDb(heroDto).getId();
	}

	@PostMapping("/addHeroKafka")
	public void addHeroKafka(@RequestBody HeroDto heroDto) {
		log.info(AliasConstant.POST_CONTROLLER, heroDto.toString());
		heroAdapterService.sendStartHeroEntry(heroDto);
	}
}
