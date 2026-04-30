package geometria;

public class Cilindro implements FiguraEspacial{

	private Circulo base;
	private double altura;
	
	public Cilindro( Circulo base, double altura ) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double area() {
		return 2*this.base.area() + this.altura*this.base.perimetro();
	}

	@Override
	public double volume() {
		return this.base.area() * this.altura;
	}
	
	public Circulo getBase() { return this.base; }
	
	public double getAltura() {	return this.altura;	}
	
}
