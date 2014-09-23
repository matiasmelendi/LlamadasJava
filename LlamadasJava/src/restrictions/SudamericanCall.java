package restrictions;

import model.Call;
import utilities.Peso;

public class SudamericanCall extends InternationalCall {
	
	public SudamericanCall(){
		this.myCods.add(100);
		this.myCods.add(101);
	}
	
	@Override
	public boolean appliesTo(Call call) {
		return call.isInternational() && this.belongMyCods(call.nationalCodeOfTheReceiver());
	}

	@Override
	public Peso rate() {
		return new Peso(0.5);
	}

}
