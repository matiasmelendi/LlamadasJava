package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidRangeException;
import utilities.Peso;

public class Company {
	private Apraiser apraiser;
	private List<Client> clients;
	
	public Company(String name) throws InvalidRangeException {
		apraiser= new Apraiser();
		clients=new ArrayList<Client>();
	}

	public void addClient(Client aClient) {
		this.clients.add(aClient);
	}

	public Peso apraise(Call call) {
		return apraiser.apraise(call);
	}

}
