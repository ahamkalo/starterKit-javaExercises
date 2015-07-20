package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.List;

public class Deal {
	private List<Hand> hands = new ArrayList<Hand>();
	
	public Deal(Hand firstPlayerHand, Hand secondPlayerHand) {
		hands.add(firstPlayerHand);
		hands.add(secondPlayerHand);
	}
	
	public List<Hand> getHands(){
		return hands;
	}

	public Result getWinner(){
		int result = hands.get(0).compareTo(hands.get(1));
		if(result > 0){
			return Result.FIRST_PLAYER_WIN;
		}else if(result < 0){
			return Result.SECOND_PLAYER_WIN;
		}
		else{
			return Result.TIE;
		}
	}
}


