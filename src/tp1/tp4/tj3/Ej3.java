package tp1.tp4.tj3;

import tp1.tp4.ej2.Alumno;
import tp1.tp4.ej2.Persona;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Ej3 {
	public static void main(String[] args) {
		int nacimiento = 0;
		int fallecimiento = 0;
		Scanner input = new Scanner(System.in);

		LectorEnteros lectorEnteros = new LectorEnteros(input);

		lectorEnteros.pedir(LectorEnteros.MENSAJE_CARGA_ENTERO);

		nacimiento = lectorEnteros.pedir("Ingrese el anio de nacimiento", Persona.RANGO_ANIO_NACIMIENTO);

		fallecimiento = lectorEnteros.pedir("Ingrese fecha fallecimiento o -1 si aún vive", nacimiento, LocalDateTime.now().getYear());

		Alumno alumno = new Alumno("Pepe", nacimiento, 36091346);

		System.out.println("La edad de la persona es: " + alumno.edad());
		System.out.println("Vive? " + (alumno.vive() ? "SI" : "NO"));

		input.close();
	}
}
