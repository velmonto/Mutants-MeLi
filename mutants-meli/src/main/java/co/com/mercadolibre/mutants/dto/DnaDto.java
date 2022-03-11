package co.com.mercadolibre.mutants.dto;

import java.io.Serializable;
import java.util.ArrayList;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DnaDto implements Serializable{
	
	private ArrayList<String> dna;
}
