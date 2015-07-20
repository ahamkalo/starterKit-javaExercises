package com.capgemini.taxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

abstract class Server extends Thread {
	ArrayList<Observer> observers;
	ArrayList<Taxi> taxis;
	Random rand;
	ArrayList<Taxi> nearestTaxis;
	
	public Server(){
		observers = new ArrayList<Observer>();
		taxis = new ArrayList<Taxi>();
		rand = new Random();
	}

	public void run() {
		while (true) {
			try {
				for (Observer observer : observers) {
					nearestTaxis = new ArrayList<Taxi>();

					for (Taxi taxi : taxis) {
						taxi.setDistance(distanceToClient(taxi, observer));
					}
					Collections.sort(taxis, new TaxiComparator());

					for (int i = 0; nearestTaxis.size() < 5 && i < taxis.size(); i++) {
						if (taxis.get(i).isAvailability() && taxis.get(i).getDistance() < 1000) {
							nearestTaxis.add(taxis.get(i));
						}
					}

					notify(observer, nearestTaxis);
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void notify(Observer observer, ArrayList<Taxi> nearestTaxis) {
		observer.update(nearestTaxis);
	}

	public void removeClient(Observer observer) {
		observers.remove(observers.indexOf(observer));
		observer.setCity("none");
	}

	private int distanceToClient(Taxi taxi, Observer observer) {
		int xDistance = taxi.getPosition().getXPosition() - observer.getPosition().getXPosition();
		int yDistance = taxi.getPosition().getYPosition() - observer.getPosition().getYPosition();
		int taxiDistance = (int) Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
		return taxiDistance;
	}

	public void registerNewClient(Observer observer) {
	}

	public void createTaxis() {
	}
}
