package co.com.mercadolibre.mutants.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.com.mercadolibre.mutants.dto.DnaDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AppControllerTest {
	
	@LocalServerPort
	private int port;

	@Value("/mutants/validator/v1")
	private String path;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void validateMutants() {
		ArrayList<String> dna = new ArrayList<>();
		dna.add("ATGCGA");
		dna.add("CAGTGC");
		dna.add("TTATGT");
		dna.add("AGAAGG");
		dna.add("CCCCTA");
		dna.add("TCACTG");
		String url = "http://localhost:"+port+path;
		log.info("Url: {}", url);
		DnaDto dto = new DnaDto();
		dto.setDna(dna);
		ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity(url, dto, Boolean.class);
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(responseEntity.getBody());
	}
	
	@Test
	void validateMutantsTrue() {
		ArrayList<String> dna = new ArrayList<>();
		dna.add("ATGCGA");
		dna.add("CAGTGC");
		dna.add("TTATTT");
		dna.add("AGACGG");
		dna.add("GCGTCA");
		dna.add("TCACTG");
		String url = "http://localhost:"+port+path;
		log.info("Url: {}", url);
		DnaDto dto = new DnaDto();
		dto.setDna(dna);
		ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity(url, dto, Boolean.class);
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
		assertFalse(responseEntity.getBody());
	}

}
