package co.com.mercadolibre.mutants.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mercadolibre.mutants.dto.DnaDto;
import co.com.mercadolibre.mutants.restclient.DnaRepositoryClient;
import co.com.mercadolibre.mutants.validator.DnaValidator;

@Service
public class DnaService {
	
	@Autowired
	private DnaValidator validator;
	
	@Autowired
	private DnaRepositoryClient repositoryClient;
	
	public boolean isMutant(DnaDto dna) {
		repositoryClient.saveDna(dna.getDna());
		String[] dnaValidate = new String[dna.getDna().size()];
		dna.getDna().toArray(dnaValidate);
		return validator.isMutant(dnaValidate);
	}
}
