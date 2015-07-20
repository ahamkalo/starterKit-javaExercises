package com.capgemini.taxi;

public class ServerWroclaw extends Server{
	private static final int NUMBER_OF_TAXIS = 500;
	String city = "Wroclaw";

	@Override
	public void registerNewClient(Observer observer) {
		if("none".equals(observer.getCity())){
			observers.add(observer);
			observer.setCity(city);
		}
	}
	@Override
	public void createTaxis() {
		for (int i = 0; i < NUMBER_OF_TAXIS; i++) {
			taxis.add(new Taxi(i, new Position(rand.nextInt(10000), rand.nextInt(10000))));
			taxis.get(i).start();
		}
	}
}



