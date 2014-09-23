package restrictions;

import model.Call;
import utilities.Peso;

public class EuropeanCall extends InternationalCall {

	public EuropeanCall(){
		myCods.add(200);
		myCods.add(201);
	}
	
	@Override
	public boolean appliesTo(Call call) {
		return call.isInternational() &&this.belongMyCods(call.nationalCodeOfTheReceiver());
	}

	@Override
	public Peso rate() {
		return new Peso(0.7);
	}

}
