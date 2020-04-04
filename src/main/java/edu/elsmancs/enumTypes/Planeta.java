package edu.elsmancs.enumTypes;

import java.util.ArrayList;
import java.util.List;

public enum Planeta {
	MERCURY(3.303e+23, 2.4397e6, "terrestre"),
	VENUS(4.869e+24, 6.0518e6, "terrestre"),
	EARTH(5.976e+24, 6.37814e6, "terrestre"),
	MARS(6.421e+23, 3.3972e6, "terrestre"),
	JUPITER(1.9e+27,   7.1492e7, "gaseoso"),
	SATURN(5.688e+26, 6.0268e7, "gaseoso"),
	URANUS(8.686e+25, 2.5559e7, "gaseoso"),
	NEPTUNE(1.024e+26, 2.4746e7, "gaseoso");
	
	private double masaPlaneta = 0;
	private double radioPlaneta = 0;
	private String tipoPlaneta = "";
	private final double G = 6.67300E-11;
	
	private Planeta(double masaPlaneta, double radioPlaneta, String tipoPlaneta) {
		this.masaPlaneta = masaPlaneta;
		this.radioPlaneta = radioPlaneta;
		this.tipoPlaneta = tipoPlaneta;
	}
	
	public double getMasa() {
		return this.masaPlaneta;
	}
	
	public double getRadio() {
		return this.radioPlaneta;
	}
	
	public String getTipo() {
		return this.tipoPlaneta;
	}
	
	public static List<Planeta> getPlanetasTerrestres() {
		List<Planeta> planetasTerrestres = new ArrayList<Planeta>();
		for (Planeta planeta : Planeta.values()) {
			if (planeta.getTipo().equals("terrestre")) {
				planetasTerrestres.add(planeta);
			}
		}
		return planetasTerrestres;
	}
	
	public static List<Planeta> getGigantesGaseosos() {
		List<Planeta> planetasTerrestres = new ArrayList<Planeta>();
		for (Planeta planeta : Planeta.values()) {
			if (planeta.getTipo().equals("gaseoso")) {
				planetasTerrestres.add(planeta);
			}
		}
		return planetasTerrestres;
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
