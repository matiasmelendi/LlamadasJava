package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import exceptions.InvalidRangeException;
import restrictions.BusinessDayCall;
import restrictions.EuropeanCall;
import restrictions.NationalCall;
import restrictions.NorthAmericanCall;
import restrictions.Restriction;
import restrictions.RushHourBusinessDayCall;
import restrictions.RushHourCall;
import restrictions.SudamericanCall;
import utilities.Hour;
import utilities.HourRange;
import utilities.Peso;

public class Apraiser {
	private List<Restriction> restrictions=new ArrayList<Restriction>();
	
	public Apraiser() throws InvalidRangeException{
		HourRange rushHour=new HourRange(new Hour(8),new Hour(20));
		this.restrictions.add(new NationalCall());
		this.restrictions.add(new SudamericanCall());
		this.restrictions.add(new EuropeanCall());
		this.restrictions.add(new NorthAmericanCall());
		this.restrictions.add(new RushHourBusinessDayCall(rushHour));
	}
	
	public Peso apraise(Call call){
		return this.calculatePrice(restrictionsFor(call)).mult(call.duration());
	}

	private List<Restriction> restrictionsFor(Call call) {
		return this.restrictions.stream().filter(r -> r.appliesTo(call)).collect(Collectors.toList());
	}
	
	private Peso calculatePrice(List<Restriction> restrictions){
		return restrictions.stream().map(Restriction::rate).collect(Collectors.reducing(new Peso(0.0),Peso::sum));
	}
	
	
}
