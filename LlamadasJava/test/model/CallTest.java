package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utilities.Minutes;
import utilities.Peso;

public class CallTest {

	AreaCode localCode;
	AreaCode nationalCode;
	Client localClient1;
	Client localClient2;
	Client nationalClient;
	Company company;
	
	@Before
	public void setUp() throws Exception {
		localCode= new AreaCode(10,54);
		nationalCode= new AreaCode(15,54);
		localClient1= new Client("Jhon",localCode);
		localClient2= new Client("Nick",localCode);
		nationalClient= new Client("James",nationalCode);
		company= new Company("CallinManiac");
		company.addClient(localClient1);
		company.addClient(localClient2);	
		company.addClient(nationalClient);
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
	
	/*The RushHour restriction don't apply to National calls*/
	@Test
	public void testNacionalCallInRushHourForTenMinutesShouldRate3Pesos(){
		Call call= localClient1.call(nationalClient,new Minutes(10));
		Peso companyValue=company.apraise(call);
		assertEquals(new Peso(3.0), companyValue);
	}
}
