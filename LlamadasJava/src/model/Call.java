package model;

import java.util.Calendar;
import utilities.Hour;
import utilities.Minutes;

public class Call {

	private Client caller;
	private Client receiver;
	private Minutes duration;
	public Hour hour;
	
	public Call(Client caller, Client receiver, Minutes minutes) {
		this.caller=caller;
		this.receiver=receiver;
		this.duration=minutes;
		this.hour=new Hour(Calendar.HOUR);
	}
	
	public int duration(){
		return this.duration.value();
	}

}
