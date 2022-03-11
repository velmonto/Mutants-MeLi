package co.com.mercadolibre.mutants.persistence.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mercadolibre.mutants.persistence.entity.Dna;
import co.com.mercadolibre.mutants.persistence.repository.DnaRepository;

@Service
public class DnaService {
	
	@Autowired
	private DnaRepository repository;
	
	public void saveDna(ArrayList<String> dna) {
		
		Dna entity = new Dna();
		entity.setDna(dna);
		repository.save(entity);
	}
}
