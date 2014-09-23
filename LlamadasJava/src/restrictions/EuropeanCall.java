package restrictions;

import java.util.ArrayList;
import java.util.List;

import model.Call;
import utilities.Peso;

public class EuropeanCall extends Restriction {

	List<Integer> myCods= new ArrayList<Integer>();
	
	public EuropeanCall(){
		myCods.add(200);
		myCods.add(201);
	}
	
	@Override
	public boolean appliesTo(Call call) {
		return call.isInternational() &&this.belongMyCods(call.nationalCodeOfTheReceiver());
	}

	private boolean belongMyCods(Integer aNationalCode) {
		return myCods.contains(aNationalCode);
	}

	@Override
	public Peso rate() {
		return new Peso(0.7);
	}

}
