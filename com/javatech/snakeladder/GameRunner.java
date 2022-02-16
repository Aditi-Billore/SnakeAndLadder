package com.javatech.snakeladder;


/*
 *  Problem Statement: 
 *  https://workat.tech/machine-coding/practice/snake-and-ladder-problem-zgtac9lxwntg
 *
 */

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		HashMap<Integer, Integer> snakes = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> ladder = new HashMap<Integer, Integer>();
		HashMap<String, Integer> people = new HashMap<String, Integer>();
		
		
		
		int snakeCount = sc.nextInt();
		for(int i =0;i< snakeCount; i++) {
			int begin = sc.nextInt();
			int end = sc.nextInt();
			snakes.put(begin, end);
		}
		int ladderCount = sc.nextInt();
		for(int i =0;i< ladderCount; i++) {
			int begin = sc.nextInt();
			int end = sc.nextInt();
			ladder.put(begin, end);
		}
		int peopleCount = sc.nextInt();
		for(int i =0;i< peopleCount; i++) {
			String name = sc.next();
			people.put(name, 0);
		}
		System.out.println(snakes);
		System.out.println(ladder);
		System.out.println(people);
		GameBoard gm = new GameBoard();
		gm.playGame(snakes, ladder, people);
	}

}
