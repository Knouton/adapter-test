package com.example.adaptertest.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(schema = "HEROTESTKAFKA", name = "HEROES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class HeroEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private long id;

	@Column(name =  "NAME")
	private String name;

	@Column(name = "LEVEL")
	private int level;

	@OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY, mappedBy = "heroEntity")
	private List<SkillEntity> skills;

	public String toString() {
		return "HeroEntity(id=" + this.getId() + ", name=" + this.getName() + ", level=" + this.getLevel() + ", skills=" + this.getSkills() + ")";
	}
}
