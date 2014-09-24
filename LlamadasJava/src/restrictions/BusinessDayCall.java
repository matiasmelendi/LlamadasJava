package restrictions;

import java.util.Calendar;

import model.Call;
import utilities.Peso;

public class BusinessDayCall extends Restriction {

	
	@Override
	public boolean appliesTo(Call call) {
		return (call.dayOfCall() != Calendar.SATURDAY)&&
				call.dayOfCall() != Calendar.SUNDAY;
	}

	@Override
	public Peso rate() {
		return new Peso(0.1);
	}

}
