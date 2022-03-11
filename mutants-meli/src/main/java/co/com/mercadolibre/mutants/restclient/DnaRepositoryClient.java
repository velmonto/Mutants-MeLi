package co.com.mercadolibre.mutants.restclient;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Component
public class DnaRepositoryClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${persistence.url:http://localhost:8002/mutants/persistence/v1}")
	private String url;
	
	public void saveDna(@RequestBody ArrayList<String> dna){
		restTemplate.postForObject(url, dna, Boolean.class);
	}

}
