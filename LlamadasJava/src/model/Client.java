package model;

import utilities.Minutes;

public class Client {

	private String name;
	public AreaCode areaCode;
	
	public Client(String name,AreaCode areaCode) {
		this.name=name;
		this.areaCode=areaCode;
	}

	public Call call(Client aClient, Minutes minutes) {
		
		return new Call(this,aClient,minutes);
	}

	public AreaCode areaCode() {
		return areaCode;
	}


}
