package model;

import utilities.Minutes;

public class Client {

	private String name;
	
	public Client(String name) {
		this.name=name;
	}

	public Call call(Client aClient, Minutes minutes) {
		
		return new Call(this,aClient,minutes);
	}

}
