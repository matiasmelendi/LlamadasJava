package restrictions;

import utilities.Peso;
import model.Call;

public abstract class Restriction {

	public abstract boolean appliesTo(Call call);
	
	public abstract Peso rate();
}
