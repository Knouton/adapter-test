package com.example.adaptertest.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HeroDto {
	private long id;
	private String name;
	private int level;

	private List<SkillDto> skills;

	public String toString() {
		return "id "+ id + " Name " + name + " level " + level;
	}
}
