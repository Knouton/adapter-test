package com.example.adaptertest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(schema = "HEROTESTKAFKA", name = "SKILLS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SkillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "HERO_ID", referencedColumnName = "ID", nullable = false)
	private HeroEntity heroEntity;

	@Column(name = "SKILL_NAME")
	private String name;

	public String toString() {
		return "SkillEntity(id=" + this.getId() + ", name=" + this.getName() + ")";
	}
}
