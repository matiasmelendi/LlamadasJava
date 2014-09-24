package model;

public class TelephonicLine{

	private AreaCode areaCode;
	private Integer number;

	public TelephonicLine(AreaCode areaCode,Integer telephoneNumber){
		this.areaCode=areaCode;
		this.number=telephoneNumber;
	}

	public AreaCode areaCode() {
		return areaCode;
	}
}
