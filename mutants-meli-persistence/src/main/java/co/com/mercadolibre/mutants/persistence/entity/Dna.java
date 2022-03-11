package co.com.mercadolibre.mutants.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dna implements Serializable{
	
	private ArrayList<String> dna;
	@Id
	private String id;
}
