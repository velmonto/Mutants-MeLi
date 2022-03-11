package co.com.mercadolibre.mutants.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.com.mercadolibre.mutants.persistence.entity.Dna;

public interface DnaRepository extends MongoRepository<Dna, String>{
	
	

}
