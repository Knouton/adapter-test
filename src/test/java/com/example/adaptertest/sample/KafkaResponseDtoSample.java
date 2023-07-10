package com.example.adaptertest.sample;

import static com.example.adaptertest.sample.HeroDtoSample.heroDtoInvalidName1;
import com.example.adaptertest.dto.KafkaResponseDto;

public class KafkaResponseDtoSample {
	public static final KafkaResponseDto successfulResponseDtoSample1 = generateSuccessfulStatusResponse(1);
	public static final KafkaResponseDto unsuccessfulValidateNameResponseDtoSample1 = generateUnsuccessfulValidateNameResponse(22222);
	private static KafkaResponseDto generateSuccessfulStatusResponse(int num) {
		KafkaResponseDto response = new KafkaResponseDto();
		response.setStatus(1);
		response.setId(num);
		return response;
	}

	private static KafkaResponseDto generateUnsuccessfulValidateNameResponse(int num) {
		KafkaResponseDto response = new KafkaResponseDto();
		response.setStatus(0);
		response.setId(num);
		String msgErr = String.format("name must be more than 4 characters and less than 10; id :%d; current name: %s"
				, heroDtoInvalidName1.getId(), heroDtoInvalidName1.getName());
		response.setMsgErr(msgErr);
		return response;
	}
}
