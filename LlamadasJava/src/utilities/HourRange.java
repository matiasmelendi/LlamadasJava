package utilities;

import exceptions.InvalidRangeException;

public class HourRange {

	private Hour init;
	private Hour end;
	
	public HourRange(Hour init,Hour end) throws InvalidRangeException{
		this.validate(init,end);
		this.init=init;
		this.end=end;
	}
	
	public void validate(Hour init,Hour end) throws InvalidRangeException{
		if(init.time() > end.time())
			throw new InvalidRangeException();
	}

	public boolean belong(Hour hour) {
		return (init.time() < hour.time()) && (hour.time() < end.time());
	}
}
