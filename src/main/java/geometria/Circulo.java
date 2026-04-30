package geometria;

public class Circulo implements FiguraPlana {
	
	private double raio;
	
	public Circulo( double raio ) {
		this.setRaio(raio);
	}
	
	@Override
	public double area() {
		return Math.PI * Math.pow( this.raio , 2);
	}
	
	@Override
	public double perimetro() {
		return Math.PI * 2*this.raio;
	}
	
	public void setRaio(double raio) {
		if( raio <= 0 )
			throw new GeometriaException( "A base deve ser positiva!" );
		this.raio = raio;
	}
	
	public double getRaio() { return this.raio; }
	
}
