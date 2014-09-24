package model;

import utilities.Minutes;

public class Client {

	private String name;
	private TelephonicLine line;
	
	public Client(String name,TelephonicLine line) {
		this.name=name;
		this.line=line;
	}

	public Call call(Client aClient, Minutes minutes) {
		
		return new Call(this,aClient,minutes);
	}

	public AreaCode areaCode() {
		return line.areaCode();
	}


}
