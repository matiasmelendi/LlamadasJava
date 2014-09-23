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

	public boolean isNational() {
		return !caller.areaCode().localCode().equals(receiver.areaCode().localCode())
				&& caller.areaCode().nationalCode().equals(receiver.areaCode().nationalCode()) ;
	}

	public boolean isLocal() {
		return caller.areaCode().equals(receiver.areaCode()); 
	}

}
