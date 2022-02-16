package com.javatech.snakeladder;

import java.util.ArrayList;
import java.util.HashMap;

public class GameBoard {

	//playGame
	HashMap<Integer, Integer> snakes;
	HashMap<Integer, Integer> ladder = new HashMap<Integer, Integer>();
	HashMap<String, Integer> people = new HashMap<String, Integer>();
	
	public void playGame(HashMap<Integer, Integer> snakes,
			HashMap<Integer, Integer> ladder,
			HashMap<String, Integer> people) {
		this.snakes = snakes;
		this.ladder = ladder;
		this.people = people;
		ArrayList<String> keySet = new ArrayList<String>(people.keySet());
		System.out.println(keySet);
		int count = 0;
		while(true) {
			int playerNumber = (count++ ) % keySet.size();			
			int position = rollDice(keySet.get(playerNumber));
			
			if(position == 100) {
				System.out.println(keySet.get(playerNumber) + " wins the game!");
				break;
			}
		}
	}
	//rollDice
	public int rollDice(String player) {
		int min = 1;
		int max = 12;

		int diceFace = (int) ( Math.random() * ( max - min )) + min;
//		int diceFace = (int) ( Math.random() * 10 ) % max + min;
		System.out.print(player + " rolled a " + diceFace);
		
		return CheckPosition(player, diceFace);
	}
	
	//check next position for player
	public int CheckPosition(String player, int diceFace) {
		int nextPosition = (people.get(player) + diceFace) > 100 ? people.get(player) : people.get(player) + diceFace ;
		
		if(snakes.containsKey(nextPosition)) {
			nextPosition = snakes.get(nextPosition);
		}
		if(ladder.containsKey(nextPosition)) {
			nextPosition = ladder.get(nextPosition);
		}
		
		System.out.println(" and moved from "+ people.get(player) + " to "+ nextPosition );
		people.put(player, nextPosition);
		return nextPosition;
	}
}
