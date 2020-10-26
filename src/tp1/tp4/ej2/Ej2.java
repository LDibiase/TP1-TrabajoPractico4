package tp1.tp4.ej2;

import java.util.Scanner;

import tp1.tp4.tj3.LectorEnteros;
import tp1.tp4.tj3.RangoDeEnteros;

public class Ej2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LectorEnteros lector = new LectorEnteros(input);
		final RangoDeEnteros RANGO_NRO_DOCUMENTO = new RangoDeEnteros(1000000, 99999999);
		final RangoDeEnteros RANGO_ANIO_NACIMIENTO = new RangoDeEnteros(1900, 2019);
		Alumno alu = null;
		int dni = 0, anioNacimiento = 0;
		String nombreCompleto = null;

		while (alu == null) {

			System.out.println("Ingrese el nombre completo");
			nombreCompleto = input.nextLine();

			do {
				dni = pedirNumeroEntero(input, "Ingrese numero de documento");
				if (!RANGO_NRO_DOCUMENTO.incluye(dni)) {
					System.out.println("Numero de documento invalido");
				}
			} while(!RANGO_NRO_DOCUMENTO.incluye(dni));

			do {
				anioNacimiento = pedirNumeroEntero(input, "Ingrese el año de nacimiento");

				if (!RANGO_ANIO_NACIMIENTO.incluye(anioNacimiento)) {
					System.out.println("Anio de nacimiento invalido");
				}
			} while(!RANGO_ANIO_NACIMIENTO.incluye(anioNacimiento));

			alu = new Alumno(nombreCompleto, anioNacimiento, dni);
		}
		input.close();
		System.out.println(alu.toString());

		if (alu.vive()) {
			System.out.println("La persona vive");
		} else {
			System.out.println("La persona no vive");
		}

	}

	public static int pedirNumeroEntero(Scanner input, String mensaje) {
		int numero = 0;
		boolean ok = false;
		while (!ok) {
			try {
				System.out.println(mensaje);
				numero = Integer.parseInt(input.nextLine());
				ok = true;
			} catch (NumberFormatException e) {
				System.out.println("Error. Ingrese un numero correcto");
			}
		}
		return numero;
	}
}