package com.javatech.snakeladder.service;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javatech.snakeladder.model.Ladder;
import com.javatech.snakeladder.model.Player;
import com.javatech.snakeladder.model.Snake;

public class GameRunnerService {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int boardSize = sc.nextInt();
		List<Snake> snakes = new ArrayList<Snake>();
		List<Ladder> ladder = new ArrayList<Ladder>();
		List<Player> players = new ArrayList<Player>();

		int snakeCount = sc.nextInt();
		for (int i = 0; i < snakeCount; i++) {
			int begin = sc.nextInt();
			int end = sc.nextInt();
			snakes.add(new Snake(begin, end));
		}
		int ladderCount = sc.nextInt();
		for (int i = 0; i < ladderCount; i++) {
			int begin = sc.nextInt();
			int end = sc.nextInt();
			ladder.add(new Ladder(begin,end));
		}
		int peopleCount = sc.nextInt();
		for (int i = 0; i < peopleCount; i++) {
			String name = sc.next();
			players.add(new Player(name));
		}
		SnakeAndLadderBoardService boardService = new SnakeAndLadderBoardService(boardSize);
		boardService.setPlayers(players);
		boardService.setLadders(ladder);
		boardService.setSnakes(snakes);
		boardService.startGame();
	}

}
