package co.com.mercadolibre.mutants.validator;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DnaValidator {
	
	public static final String ERRORLOG = "Error: {}";
	
	
	public boolean isMutant(String[] dna2) {
		try {
			//verifica los arreglos de forma vertical
	        if (validarVertical(dna2)) {
	        	return true;
	        }
	        //verifica los arreglos de forma horizontal
	        if (validarHorizontal(dna2)) {
	        	return true;
	        }
	        //verifica los arreglos de forma diagonal
	        if (validarDiagonal(dna2)) {
	        	return true;
	        }
		} catch (Exception e) {
			log.error(ERRORLOG, e.getMessage(), e);
		}
		return false;
	}
	
	
	private static boolean validarDiagonal(String[] dna) {
		String[][] matriz = crearMatriz(dna);
	    int contador = 1;
		try {

		    for (int i = 0; i < dna.length; i++) {
		        for (int j = 0; j < dna.length; j++) {
		            if (j == 0 && i == 0) {
		            	continue;
		            }
		            //compara con la posicion superior izquierda
		            if (matriz[i - 1][j - 1].equals(matriz[i][j])) {
		            	contador++; 
		            }else {
		            	contador = 1;
		            }
		            //finaliza como verdadero si hay 4 letras iguales consecutivas
		            if (contador == 4) {
		            	return true;
		            }
		        }
		    }
		} catch (Exception e) {
			log.error(ERRORLOG, e.getMessage(), e);
		}
		return false;
	}

	private static boolean validarVertical(String[] dna) {
		int contador = 0;
		String[][] matriz = crearMatriz(dna);
		try {
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					// compara consecutivas desde la segunda posición
					if (j == 0) {
						continue;
					}
					// resetea contado si la letra de arriba no es igual a la de abajo
					if (matriz[j][i].equals(matriz[j - 1][i])) {
						contador++;
					}else {
						contador = 1;
					}
					// finaliza como verdadero si hay 4 letras iguales consecutivas
					if (contador == 4) {
						return true;
					}
						
				}
			}
		} catch (Exception e) {
			log.error(ERRORLOG, e.getMessage(), e);
		}
		return false;
	}

	private static boolean validarHorizontal(String[] dna) {
		int contador = 1;
		
		try {
			for (int j = 0; j < dna.length; j++) {
				String cadena = dna[j];
				char[] dnaChars = cadena.toCharArray();
				for (int i = 0; i < dnaChars.length; i++) {
					// compara consecutivas desde la segunda posición
					if (i == 0) {
						continue;
					}
					// resetea contado si la letra de la derecha no es igual a la de la izquierda
					if (dnaChars[i] == dnaChars[i - 1]) {
						contador++;
					}else {
						contador = 1;
					}
					// finaliza como verdadero si hay 4 letras iguales consecutivas
					if (contador == 4) {
						return true;
					}
				}
			}
	        
		} catch (Exception e) {
			log.error(ERRORLOG, e.getMessage(), e);
		}
		return false;
	}

	private static String[][] crearMatriz(String[] dna2) {
		int filas;
		int columnas;
		String[][] matriz = new String[6][6];
		try {
			for (filas = 0; filas < dna2.length; filas++) {
				String cadena = dna2[filas];
				for (columnas = 0; columnas < cadena.toCharArray().length; columnas++) {
					char[] letra = cadena.toCharArray();
					 matriz[filas][columnas] = String.valueOf(letra[columnas]);
				}
			}
		} catch (Exception e) {
			log.error(ERRORLOG, e.getMessage(), e);
		}
		return matriz;
	}
}
