package com.capgemini.taxi;

import java.util.ArrayList;

public class TaxiSystem {
	static ServerWroclaw wroclaw = new ServerWroclaw();
	static ServerWarszawa warszawa = new ServerWarszawa();
	
	static ArrayList<Server> servers = new ArrayList<Server>();
	
	static FemaleClient Anna = new FemaleClient(new Position(5000, 5000), "Anna");
	static FemaleClient Magda = new FemaleClient(new Position(2000, 2000), "Magda");
	static MaleClient Marek = new MaleClient(new Position(8000, 8000), "Marek");

	public static void main(String[] args) throws InterruptedException {
		servers.add(wroclaw);
		servers.add(warszawa);
		for (Server server : servers) {
			server.createTaxis();
			try {
				server.start();
			} catch (OutOfMemoryError e) {
				System.out.println(e.getMessage());
			}
		}
		wroclaw.registerNewClient(Anna);
		warszawa.registerNewClient(Magda);
		wroclaw.registerNewClient(Magda);
		wroclaw.registerNewClient(Marek);
		Thread.sleep(5000);
	}
}
