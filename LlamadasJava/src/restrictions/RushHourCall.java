package restrictions;

import model.Call;
import utilities.HourRange;
import utilities.Peso;

public class RushHourCall extends Restriction {

	private HourRange hourRange;
	
	public RushHourCall(HourRange hourRange){
		this.hourRange=hourRange;
	}

	@Override
	public boolean appliesTo(Call call) {
		return hourRange.belong(call.hour);
	}

	@Override
	public Peso rate() {
		return new Peso(0.2);
	}

}
