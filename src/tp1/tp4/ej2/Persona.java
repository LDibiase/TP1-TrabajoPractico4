package tp1.tp4.ej2;

import tp1.tp4.tj3.RangoDeEnteros;

import java.time.LocalDateTime;

public abstract class Persona {

	private static final int VALOR_AUN_VIVE = -9999;
	public static final RangoDeEnteros RANGO_ANIO_NACIMIENTO = new RangoDeEnteros(1900, 2019);

	private String nombreCompleto;
	private int anioNacimiento;
	private int anioFallecimiento;
	private int anioActual;

	public Persona(String nombreCompleto, int anioNacimiento) {
		this.nombreCompleto = nombreCompleto;
		nacimiento(anioNacimiento);
		this.anioActual = LocalDateTime.now().getYear();
	}

	public Persona(String nombreCompleto, int anioNacimiento, int anioFallecimiento) {
		this.nombreCompleto = nombreCompleto;
		nacimiento(anioNacimiento);
		this.anioFallecimiento = anioFallecimiento;
	}

	private void nacimiento(int anioNacimiento) {
		if (RANGO_ANIO_NACIMIENTO.incluye(anioNacimiento)) {
			this.anioNacimiento = anioNacimiento;
		} else {
			throw new IllegalArgumentException("Anio nacimiento invalido");
		}
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	private void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getAnioNacimiento() {
		return anioNacimiento;
	}

	private void setAnioNacimiento(int anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	public int getAnioFallecimiento() {
		return anioFallecimiento;
	}

	public void setAnioFallecimiento(int anioFallecimiento) {
		this.anioFallecimiento = anioFallecimiento;
	}

	public int getAnioActual() {
		return anioActual;
	}

	private void setAnioActual(int anioActual) {
		this.anioActual = anioActual;
	}

	public abstract boolean vive();

	@Override
	public String toString() {
		return "{" +
				"nombreCompleto='" + nombreCompleto + '\'' +
				", anioNacimiento=" + anioNacimiento +
				", anioFallecimiento=" + anioFallecimiento +
				", anioActual=" + anioActual;
	}
}
