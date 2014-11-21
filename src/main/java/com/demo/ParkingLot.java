package com.demo;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class ParkingLot {

	Map<String, Car> cars = new HashMap<String, Car>();
	
	TokenGenerator tokenGenerator;
	
	public ParkingLot(TokenGenerator tokenGenerator) {
		this.tokenGenerator = tokenGenerator;
	}

	public String park(Car car) {
		String token = tokenGenerator.nextToken();
		cars.put(token, car);
		return token;
	}

	public Car unPark(String ticket) {
		Car car = cars.get(ticket);
		if (car == null)
			throw new InvalidParameterException("No car found for the given ticker");
		return car;
	}

}

class TokenGenerator{
	
	public String nextToken() {
		return UUID.randomUUID().toString();
	}
}
