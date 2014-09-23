package restrictions;

import model.Call;
import utilities.Peso;

public class NationalCall extends Restriction {

	@Override
	public boolean appliesTo(Call call) {
		return call.isNational();
	}

	@Override
	public Peso rate() {
		return new Peso(0.3);
	}

}
