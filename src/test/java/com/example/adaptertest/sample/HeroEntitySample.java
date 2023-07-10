package com.example.adaptertest.sample;

import com.example.adaptertest.entity.HeroEntity;
import com.example.adaptertest.entity.SkillEntity;
import java.util.ArrayList;

public class HeroEntitySample {

	public static HeroEntity heroEntitySample1 = generateHeroEntity(1);

	private static HeroEntity generateHeroEntity(int num) {
		HeroEntity heroEntity = new HeroEntity();
		heroEntity.setId(num);
		heroEntity.setName("TestName" + num);
		heroEntity.setLevel(num);

		ArrayList<SkillEntity> skillsEntity = new ArrayList<>();
		skillsEntity.add(generateSkillEntity(1));
		skillsEntity.add(generateSkillEntity(2));
		skillsEntity.add(generateSkillEntity(3));

		heroEntity.setSkills(skillsEntity);

		return heroEntity;
	}

	private static SkillEntity generateSkillEntity(int num) {
		SkillEntity skill = new SkillEntity();
		skill.setId(num);
		skill.setName("TestSkill"+ num);

		return skill;
	}
}
