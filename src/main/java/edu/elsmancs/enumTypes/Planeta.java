package edu.elsmancs.enumTypes;

public enum Planeta {
	MERCURY(3.303e+23, 2.4397e6),
	VENUS(4.869e+24, 6.0518e6),
	EARTH(5.976e+24, 6.37814e6),
	MARS(6.421e+23, 3.3972e6),
	JUPITER(1.9e+27,   7.1492e7),
	SATURN(5.688e+26, 6.0268e7),
	URANUS(8.686e+25, 2.5559e7),
	NEPTUNE(1.024e+26, 2.4746e7);
	
	private double masaPlaneta = 0;
	private double radioPlaneta = 0;
	private final double G = 6.67300E-11;
	
	private Planeta(double masa, double radio) {
		this.masaPlaneta = masa;
		this.radioPlaneta = radio;
	}
	
	public double getMasa() {
		return this.masaPlaneta;
	}
	
	public double getRadio() {
		return this.radioPlaneta;
	}
	
	private double getGravedad(Planeta planeta) {
		return this.G * planeta.masaPlaneta / (planeta.radioPlaneta * planeta.radioPlaneta);
	}
	
	private double getMasaObjeto(double pesoObjeto) {
		double gravedadTierra = this.getGravedad(EARTH);
		return pesoObjeto / gravedadTierra;
	}
	
	public double pesoSuperficie(double pesoObjeto) {
		double pesoEnSuperficie = 0.0;
		double gravedadEnSuperficie = this.getGravedad(this);
		double masaObjeto = this.getMasaObjeto(pesoObjeto);
		pesoEnSuperficie = masaObjeto * gravedadEnSuperficie;
		return pesoEnSuperficie;
	}
}
