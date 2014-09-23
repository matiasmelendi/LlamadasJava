package restrictions;

import model.Call;
import utilities.Peso;

public class NorthAmericanCall extends InternationalCall {
	
	public NorthAmericanCall(){
		myCods.add(300);
		myCods.add(301);
	}
	
	@Override
	public boolean appliesTo(Call call) {
		return call.isInternational() && this.belongMyCods(call.nationalCodeOfTheReceiver());
	}

	@Override
	public Peso rate() {
		return new Peso(0.7);
	}

}
