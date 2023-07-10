package com.example.adaptertest.dto;

import lombok.Data;

@Data
public class KafkaResponseDto {
	private long id;
	private int status;
	private String msgErr;
}
