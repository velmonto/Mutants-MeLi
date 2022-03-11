package co.com.mercadolibre.mutants.persistence.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.mutants.persistence.entity.Dna;
import co.com.mercadolibre.mutants.persistence.service.DnaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/mutants/persistence/")
public class DnaController {
	
	@Autowired
	private DnaService service;
	
	@PostMapping("v1")
	public ResponseEntity<Boolean> saveDna(@RequestBody ArrayList<String> dna){
		log.info("DNA: {}", dna);
		service.saveDna(dna);
		return ResponseEntity.status(HttpStatus.OK).body(true);
		
	}

}
