package co.com.mercadolibre.mutants.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.mercadolibre.mutants.dto.DnaDto;
import co.com.mercadolibre.mutants.service.DnaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/mutants/validator")
public class AppController {

	@Autowired
	private DnaService dnaService;
	
	@PostMapping("v1")
	public ResponseEntity<Boolean> validateMutants(@RequestBody DnaDto dna){
		log.info("DNA: {}", dna);
		boolean isMutant = dnaService.isMutant(dna);
		if (isMutant) {
			return ResponseEntity.status(HttpStatus.OK).body(isMutant);
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(isMutant);
		}
		
		
	}
	
}
