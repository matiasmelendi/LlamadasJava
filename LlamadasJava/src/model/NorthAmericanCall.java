package model;

import java.util.ArrayList;
import java.util.List;

import restrictions.Restriction;
import utilities.Peso;

public class NorthAmericanCall extends Restriction {

	List<Integer> myCods= new ArrayList<Integer>();
	
	public NorthAmericanCall(){
		myCods.add(300);
		myCods.add(301);
	}
	
	@Override
	public boolean appliesTo(Call call) {
		return call.isInternational() && this.belongMyCods(call.nationalCodeOfTheReceiver());
	}

	private boolean belongMyCods(Integer aNationalCode) {
		return myCods.contains(aNationalCode);
	}

	@Override
	public Peso rate() {
		return new Peso(0.7);
	}

}
