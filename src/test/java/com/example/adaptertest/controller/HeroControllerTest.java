package com.example.adaptertest.controller;

import static com.example.adaptertest.sample.HeroDtoSample.heroDtoSample1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.adaptertest.service.adapter.HeroAdapterServiceImpl;
import com.example.adaptertest.service.db.hero.HeroDbServiceImpl;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class HeroControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	HeroDbServiceImpl heroDbService;
	@MockBean
	HeroAdapterServiceImpl heroAdapterService;
	@Value("classpath:output_sample.json")
	private Resource outputSampleJson;
	@Value("classpath:output_invalid_request.json")
	private Resource outputInvalidRequestJson;

	@SneakyThrows
	@Test
	void getHero() {
		when(heroDbService.getHeroById(1)).thenReturn(heroDtoSample1);

		MvcResult mvcResult = mockMvc.perform(
				get("/api/getHero/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		String result = mvcResult.getResponse().getContentAsString();

		assertNotNull(result);
		assertEquals(result, getResourceAsString(outputSampleJson));
	}

	@SneakyThrows
	private String getResourceAsString(Resource resource) {
		return IOUtils.toString(resource.getInputStream());
	}
}
