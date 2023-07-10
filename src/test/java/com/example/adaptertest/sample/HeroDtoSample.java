package com.example.adaptertest.sample;

import com.example.adaptertest.dto.HeroDto;
import com.example.adaptertest.dto.SkillDto;
import java.util.ArrayList;

public class HeroDtoSample {

	public static HeroDto heroDtoSample1 = generateHeroDto(1);
	public static HeroDto heroDtoInvalidName1 = generateHeroDto(22222);

	private static HeroDto generateHeroDto(int num) {
		HeroDto heroDto = new HeroDto();
		heroDto.setId(num);
		heroDto.setName("TestName" + num);
		heroDto.setLevel(num);

		ArrayList<SkillDto> skillsDto = new ArrayList<>();
		skillsDto.add(generateSkillDto(1));
		skillsDto.add(generateSkillDto(2));
		skillsDto.add(generateSkillDto(3));

		heroDto.setSkills(skillsDto);

		return heroDto;
	}

	private static SkillDto generateSkillDto(int num) {
		SkillDto skill = new SkillDto();
		skill.setId(num);
		skill.setName("TestSkill"+ num);

		return skill;
	}

}
