package geometria;

public class Retangulo implements FiguraPlana{

	private double base, altura;
	
	public Retangulo( double base, double altura ) {
		this.setAltura( altura );
		this.setBase( base );
	}
	
	@Override
	public double area() {
		return this.base * this.altura;
	}
	
	@Override
	public double perimetro() {
		return 2*this.base + 2*this.altura;
	}

	public void setBase(double base) {
		if( base <= 0 )
			throw new GeometriaException( "A base deve ser positiva!" );
		this.base = base;
	}

	public void setAltura(double altura) {
		if( altura <= 0 )
			throw new GeometriaException( "A altura deve ser positiva!" );
		this.altura = altura;
	}	
	
	public double getBase() { return this.base; }
	
	public double getAltura() { return this.altura; }
	
}
