package com.demo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.security.InvalidParameterException;

import org.junit.Test;

public class ParkingLotTest {

	private TokenGenerator generator = new TokenGenerator();
	
	@Test
	public void testParkACar() {
		Car car = new Car("MH-01");
		ParkingLot parkingLot = new ParkingLot(generator);
		
		String ticket = parkingLot.park(car);
		
		assertNotNull(ticket);
	}
	
	@Test
	public void testUnParkCar() {
		Car car = new Car("MH-01");
		ParkingLot parkingLot = new ParkingLot(generator);
		String ticket = parkingLot.park(car);

		Car unParkedCar = parkingLot.unPark(ticket);
		
		assertEquals(car, unParkedCar);
	}
	
	@Test(expected=InvalidParameterException.class)
	public void testShouldNotUnparkCarThatWasNotParked() {
		ParkingLot parkingLot = new ParkingLot(generator);
		String ticket = "INVALID_TOKEN";
		
		parkingLot.unPark(ticket);
	}

}
