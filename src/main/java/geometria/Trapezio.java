package geometria;

public class Trapezio implements FiguraPlana {

	private double baseMaior, baseMenor, altura, ladoEsq, ladoDir;
	
	public Trapezio( double baseMaior, double baseMenor, double altura, double ladoEsq, double ladoDir ) {
		this.setBaseMaior(baseMaior);
		this.setBaseMenor(baseMenor);
		this.setAltura(altura);
		this.setLadoEsq(ladoEsq);
		this.setLadoDir(ladoDir);
	}
	
	public Trapezio( double baseMaior, double baseMenor, double altura ) {
		this.setBaseMaior(baseMaior);
		this.setBaseMenor(baseMenor);
		this.setAltura(altura);
	}
	
	public Trapezio( double baseMaior, double baseMenor, double ladoEsq, double ladoDir ) {
		this.setBaseMaior(baseMaior);
		this.setBaseMenor(baseMenor);
		this.setLadoEsq(ladoEsq);
		this.setLadoDir(ladoDir);
	}
	
	@Override
	public double area() {
		return ((this.baseMaior + this.baseMenor) * this.altura) / 2.0;
	}
	
	@Override
	public double perimetro() {
		return this.baseMaior + this.baseMenor + this.ladoEsq + this.ladoDir;
	}

	public void setBaseMaior(double baseMaior) {
		if( baseMaior <= 0 )
			throw new GeometriaException( "A base maior deve ser positiva!" );
		this.baseMaior = baseMaior;
	}
	
	public void setBaseMenor(double baseMenor) {
		if( baseMenor <= 0 )
			throw new GeometriaException( "A base menor deve ser positiva!" );
		this.baseMenor = baseMenor;
	}
	
	public void setAltura(double altura) {
		if( altura <= 0 )
			throw new GeometriaException( "A altura deve ser positiva!" );
		this.altura = altura;
	}
	
	public void setLadoEsq(double ladoEsq) {
		if( ladoEsq <= 0 )
			throw new GeometriaException( "O lado esquerdo deve ser positiva!" );
		this.ladoEsq = ladoEsq;
	}
	
	public void setLadoDir(double ladoDir) {
		if( ladoDir <= 0 )
			throw new GeometriaException( "A lado direito deve ser positiva!" );
		this.ladoDir = ladoDir;
	}
	
	public double getBaseMaior() { return this.baseMaior; }

	public double getBaseMenor() { return this.baseMenor; }

	public double getAltura() { return this.altura; }

	public double getLadoEsq() { return this.ladoEsq; }

	public double getLadoDir() { return this.ladoDir; }
	
}