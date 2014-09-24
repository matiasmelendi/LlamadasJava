package restrictions;

import java.util.ArrayList;
import java.util.List;

import model.Call;
import utilities.HourRange;
import utilities.Peso;

public class RushHourBusinessDayCall extends Restriction {


	private List<Restriction> restrictions= new ArrayList<Restriction>();
	private CompositeRestriction restriction;
	
	public RushHourBusinessDayCall(HourRange rushHour){
		restrictions.add(new BusinessDayCall());
		restrictions.add(new RushHourCall(rushHour));
		this.restriction= new CompositeRestriction(restrictions);
	}
	
	@Override
	public boolean appliesTo(Call call) {
		return restriction.appliesTo(call);
	}

	@Override
	public Peso rate() {
		return restriction.rate();
	}

}
