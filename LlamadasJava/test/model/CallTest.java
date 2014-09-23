package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.Minutes;
import utilities.Peso;

public class CallTest {

	Client localClient1;
	Client localClient2;
	Company company;
	
	@Before
	public void setUp() throws Exception {
		localClient1= new Client("Jhon");
		localClient2= new Client("Nick");
		company= new Company("CallinManiac");
		company.addClient(localClient1);
		company.addClient(localClient2);	
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
}
