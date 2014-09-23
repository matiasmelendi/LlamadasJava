package restrictions;

import java.util.ArrayList;
import java.util.List;

import model.Call;
import utilities.Peso;

public class SudamericanCall extends Restriction {

	private List<Integer> myCods= new ArrayList<Integer>();
	
	public SudamericanCall(){
		myCods.add(100);
		myCods.add(101);
	}
	
	@Override
	public boolean appliesTo(Call call) {
		return call.isInternational() && this.belongMyCods(call.nationalCodeOfTheReceiver());
	}

	private boolean belongMyCods(Integer aNationalCode) {
		return myCods.contains(aNationalCode); 
	}

	@Override
	public Peso rate() {
		return new Peso(0.5);
	}

}
