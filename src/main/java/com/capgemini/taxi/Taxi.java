package com.capgemini.taxi;

import java.util.Random;

public class Taxi extends Thread {
	private int id;
	private boolean availability = true;
	private Position position;
	private int distance;

	Random rand = new Random();

	public Taxi(int id, Position position) {
		this.position = position;
		this.setIdNumber(id);
	}

	public void run() {
		int i = 0;
		while (true) {
			i++;
			try {
				Thread.sleep(1000);
				setPosition(position.getXPosition() + rand.nextInt(21) - 10,
						position.getYPosition() + rand.nextInt(21) - 10);
				if (i == 10) {
					setAvailability(rand.nextBoolean());
					i = 0;
				}

			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public int getIdNumber() {
		return id;
	}

	public void setIdNumber(int id) {
		this.id = id;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(int xPosition, int yPosition) {
		this.position.setXPosition(xPosition);
		this.position.setYPosition(yPosition);
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
