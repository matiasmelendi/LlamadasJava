package model;

import java.util.Calendar;
import java.util.Date;

import utilities.Hour;
import utilities.Minutes;

public class Call {

	private Client caller;
	private Client receiver;
	private Minutes duration;
	private Hour hour;
	private Date date;
	
	public Call(Client caller, Client receiver, Minutes minutes) {
		this.caller=caller;
		this.receiver=receiver;
		this.duration=minutes;
		this.hour=new Hour(Calendar.HOUR);
		this.date=Calendar.getInstance().getTime();
	}
	
	public Hour hour() {
		return hour;
	}

	public Date date(){
		return date;
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

	public boolean isInternational() {
		return !isLocal()&& !isNational();
	}

	public Integer nationalCodeOfTheReceiver() {
		return receiver.areaCode().nationalCode();
	}

	public int dayOfCall() {
		return Calendar.DAY_OF_MONTH;
	}

}
