package com.capgemini.pokerHands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	static String path = "C:\\Users\\ahamkalo\\Desktop\\Workspace\\javaExercises\\src\\main\\java\\com\\capgemini\\pokerHands\\poker.txt";

	public static void main(String[] args) {
		System.out.println("Player 1 won " + getNumberOfFirstPlayerWins(createDeals(getLinesFromFile(path))) + " games.");
	}
	
	public static int getNumberOfFirstPlayerWins(List<Deal> deals) {
		int wins = 0;

		for (Deal deal : deals) {
			if(deal.getWinner() == Result.FIRST_PLAYER_WIN){
				wins++;	
			}
		}

		return wins;
	}

	public static List<Deal> createDeals(List<String> lines) {
		List<Deal> deals = new ArrayList<Deal>();

		for (String line : lines) {
			Deal deal = new Deal(new Hand(line.substring(0, 14)), new Hand(line.substring(15, 29)));
			deals.add(deal);
		}

		return deals;
	}
	
	private static List<String> getLinesFromFile(String path) {
		List<String> lines = new ArrayList<String>();

		try {
			File file = new File(path);
			Scanner readData = new Scanner(file);

			while (readData.hasNext()) {
				lines.add(readData.nextLine());
			}

			readData.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}

		return lines;
	}
}
