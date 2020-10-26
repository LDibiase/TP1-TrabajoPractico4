package tp1.tp4.ej2;

import tp1.tp4.tj3.RangoDeEnteros;

public class Alumno extends Persona {

	private static final RangoDeEnteros RANGO_NRO_DOCUMENTO = new RangoDeEnteros(1000000, 999999999);

	public Alumno(String nombreCompleto, int anioNacimiento, int numeroLegajo) {
		super(nombreCompleto, anioNacimiento);

		if (RANGO_NRO_DOCUMENTO.incluye(numeroLegajo)) {
			this.numeroLegajo = numeroLegajo;
		} else {
			throw new IllegalArgumentException("Legajo fuera de rango");
		}
	}

	public Alumno(String nombreCompleto, int anioNacimiento, int anioFallecimiento, int numeroLegajo) {
		super(nombreCompleto, anioNacimiento, anioFallecimiento);
		this.numeroLegajo = numeroLegajo;
	}

	private int numeroLegajo;

	public int getNumeroLefajo() {
		return numeroLegajo;
	}

	public void setNumeroLegajo(int numeroLegajo) {
		this.numeroLegajo = numeroLegajo;
	}

	@Override
	public String toString() {
		return "Alumno" + super.toString() +
				", numeroLegajo=" + numeroLegajo +
				'}';
	}

	@Override
	public boolean vive() {
		return getAnioFallecimiento() == 0;
	}

	public int edad() {
		return getAnioActual() - getAnioNacimiento();
	}
}
