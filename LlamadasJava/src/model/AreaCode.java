package model;

public class AreaCode {

	private Integer local;
	private Integer national;
	
	public AreaCode(Integer localCode,Integer nationalCode){
		this.local=localCode;
		this.national=nationalCode;
	}

	public Integer localCode() {
		return local;
	}

	public Integer nationalCode() {
		return national;
	}
}
