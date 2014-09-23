package utilities;

public class Peso {

	private Double value;
	
	public Double value() {
		return value;
	}

	public Peso(Double value) {
		this.value=value;
	}
	
	public Peso sum(Peso anotherPeso){
		return new Peso(this.value + anotherPeso.value);
	}
	
	@Override
	public boolean equals(Object anotherPeso){
		return this.value.equals(((Peso) anotherPeso).value());
	}
	
	public Peso mult(int anInteger){
		return new Peso(this.value * anInteger);
	}

}
