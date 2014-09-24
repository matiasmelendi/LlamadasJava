package restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Call;
import utilities.Peso;

public class CompositeRestriction extends Restriction {

	private List<Restriction> restrictions= new ArrayList<Restriction>();

	public CompositeRestriction(List<Restriction> restrictions) {
		this.restrictions=restrictions;
	}

	@Override
	public boolean appliesTo(Call call) {
		return restrictions.stream().allMatch(r -> r.appliesTo(call));
	}

	@Override
	public Peso rate() {
		return restrictions.stream().map(Restriction::rate).collect(Collectors.reducing(new Peso(0.0),Peso::sum));
	}

}
