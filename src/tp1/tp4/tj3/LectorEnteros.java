package tp1.tp4.tj3;

import java.util.Scanner;

public class LectorEnteros {
	private static final String MENSAJE_ERROR_SCANNER_NULL = "Debe recibirse un Scanner.";
	public static final String MENSAJE_CARGA_ENTERO = "Ingrese un numero entero cualquiera";
	private static final String MENSAJE_FUERA_DE_RANGO = "El valor ingresado esta fuera del rango aceptable";

	private Scanner scanner;

	private int cargar(String mensaje) {
		System.out.println(mensaje);
		return Integer.parseInt(scanner.nextLine());
	}
	public LectorEnteros(Scanner scanner) {
		if (scanner == null) {
			throw new IllegalArgumentException(MENSAJE_ERROR_SCANNER_NULL);
		}
		this.scanner = scanner;
	}

	public int pedir(String mensaje) {
		int numero = 0;
		try {
			numero = this.cargar(mensaje);
		} catch (NumberFormatException e) {
			System.out.println("Error. " + "Numero invalido " + e.getMessage());
		}
		return numero;
	}

	public int pedir(String mensaje, int limiteA, int limiteB){
		int numero = 0;
		boolean ok = false;

		while (!ok) {
			try {
				numero = this.cargar(mensaje + " entre " + limiteA + " y " + limiteB);

				if (new RangoDeEnteros(limiteA, limiteB).incluye(numero) || numero != -1) {
					throw new IllegalArgumentException(MENSAJE_FUERA_DE_RANGO);
				}
				ok = true;
			} catch (NumberFormatException e) {
				System.out.println("Error. " + MENSAJE_FUERA_DE_RANGO + e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("Error. " + e.getMessage());
			}
		}
		return numero;
	}

	public int pedir(String mensaje, RangoDeEnteros rangoValido){

		if (rangoValido == null) {
			throw new IllegalArgumentException("El objeto rango no puede ser null");
		}

		int numero = 0;
		boolean ok = false;
		String mensajeFinal = mensaje != null ? mensaje : MENSAJE_CARGA_ENTERO + " entre " + rangoValido.getLimiteInferior() + " y " + rangoValido.getLimiteSuperior();

		while (!ok) {
			try {
				numero = this.cargar(mensajeFinal);

				if (!rangoValido.incluye(numero)) {
					throw new IllegalArgumentException(MENSAJE_FUERA_DE_RANGO);
				}

				ok = true;
			} catch (NumberFormatException e) {
				System.out.println("Error. " + mensajeFinal + e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("Error. " + e.getMessage());
			}
		}
		return numero;
	}
}
