package restrictions;

import java.util.ArrayList;
import java.util.List;


public abstract class InternationalCall extends Restriction {

	protected List<Integer> myCods= new ArrayList<Integer>();
	
	protected boolean belongMyCods(Integer aNationalCode) {
		return myCods.contains(aNationalCode); 
	}

}
