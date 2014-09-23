package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utilities.Minutes;
import utilities.Peso;

public class CallTest {

	AreaCode localCode;
	AreaCode nationalCode;
	AreaCode sudamericanCode;
	AreaCode europeanCode;
	AreaCode northAmericanCode;
	Client localClient1;
	Client localClient2;
	Client nationalClient;
	Client northAmericanClient;
	Client sudamericanClient;
	Client europeanClient;
	Company company;
	
	@Before
	public void setUp() throws Exception {
		localCode= new AreaCode(10,54);
		nationalCode= new AreaCode(15,54);
		sudamericanCode= new AreaCode(25,100);
		europeanCode= new AreaCode(50,200);
		northAmericanCode= new AreaCode(75,300);
		localClient1= new Client("Jhon",localCode);
		localClient2= new Client("Nick",localCode);
		nationalClient= new Client("James",nationalCode);
		sudamericanClient= new Client("Jim",sudamericanCode);
		europeanClient= new Client("Jim",europeanCode);
		northAmericanClient= new Client("George", northAmericanCode);
		company= new Company("CallinManiac");
		company.addClient(localClient1);
		company.addClient(localClient2);	
		company.addClient(nationalClient);
		company.addClient(sudamericanClient);
		company.addClient(europeanClient);
	}

	@Test
	public void testNewCallBetweenTwoClientsInRushHourForZeroMinutes(){
		Call call=localClient1.call(localClient2,new Minutes(0));
		assertEquals(new Peso(0.0).value(), company.apraise(call).value());
	}

	@Test
	public void testNewCallBetweenTwoClientsInRushHourForTenMinutes(){
		Call call=localClient1.call(localClient2,new Minutes(10));
		assertEquals(new Peso(2.0), company.apraise(call));
	}
	
	/*The RushHour restriction only applies to local calls*/
	@Test
	public void testNacionalCallInRushHourForTenMinutesShouldRate3Pesos(){
		Call call= localClient1.call(nationalClient,new Minutes(10));
		assertEquals(new Peso(3.0), company.apraise(call));
	}
	
	/*The RushHour restriction only applies to local calls*/
	@Test
	public void testInternationalCallInRushHourFor10MintuesToASudamericanClient(){
		Call call=localClient2.call(sudamericanClient, new Minutes(10));
		assertEquals(new Peso(5.0), company.apraise(call));
	}
	
	/*The RushHour restriction only applies to local calls*/
	@Test
	public void testInternationalCallInRushHourFor10MintuesToEuropeanClient(){
		Call call=localClient2.call(europeanClient, new Minutes(10));
		assertEquals(new Peso(7.0), company.apraise(call));
	}
	
	/*The RushHour restriction only applies to local calls*/
	@Test
	public void testInternationalCallInRushHourFor10MinutesToNorthAmericanClient(){
		Call call=localClient2.call(northAmericanClient, new Minutes(10));
		assertEquals(new Peso(7.0), company.apraise(call));
	}
	
	
}
