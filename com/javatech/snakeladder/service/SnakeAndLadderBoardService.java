package com.javatech.snakeladder.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.javatech.snakeladder.model.Ladder;
import com.javatech.snakeladder.model.Player;
import com.javatech.snakeladder.model.Snake;
import com.javatech.snakeladder.model.SnakeAndLadderBoard;

public class SnakeAndLadderBoardService {
	private SnakeAndLadderBoard board;
	private Queue<Player> playersQ;
	private boolean isGameCompleted;
	
	private boolean shouldAllowTillLastPlayer;
	private boolean shouldAllowRepeatSix;
	
	public int numOfDice;
	
	public static int DEFAULT_NO_OF_DICE = 1;
	public static int DEFAULT_BOARD_SIZE = 100;
	
	
	public SnakeAndLadderBoardService(int boardSize) {
		this.board = new SnakeAndLadderBoard(boardSize);
		this.playersQ = new LinkedList<Player>();
		this.numOfDice = SnakeAndLadderBoardService.DEFAULT_NO_OF_DICE; 
	}
	
	public SnakeAndLadderBoardService() {
		this(SnakeAndLadderBoardService.DEFAULT_BOARD_SIZE);
	}
	
//	important setters
	public void setNumOfDice(int numOfDice) {
		this.numOfDice = numOfDice;
	}
	
	public void setShouldAllowRepeatSix(boolean allowRepeat) {
		this.shouldAllowRepeatSix = allowRepeat;
	}
	
	public void setShouldAllowTillLastPlayer(boolean allowTillLastPlayer) {
		this.shouldAllowTillLastPlayer = allowTillLastPlayer;
	}
	
//	setting board
	
//	public void setPlayers
	public void setPlayers(List<Player> players) {
		HashMap<String, Integer> playerPieces = new HashMap<String, Integer>();
		for(Player player: players) {
			playerPieces.put(player.getName(), 0); //initially at 0 position
			this.playersQ.offer(player);
		}
		board.setPlayerPieces(playerPieces);
	}
//	setSnakes
	public void setSnakes(List<Snake> snakes) {
		board.setSnakes(snakes);
	}
//	setLadders
	public void setLadders(List<Ladder> ladder) {
		board.setLadders(ladder);
	}
	
//	core logic of the board
//	make a move
	public void makeAMove(Player player) {
		int oldPosition = board.getPlayerPieces().get(player.getName());
		int diceFace = rollDice();
		int newPosition = oldPosition + diceFace;
		
		if(newPosition > board.getSize()) {
			newPosition = oldPosition; //position is out of range so player stays at same position
		}
		else {
			newPosition = makeMoveWithSnakeLadder(newPosition);
		}
		System.out.println( player.getName() + " rolls a " + diceFace + " moves from "+ oldPosition + " to "+ newPosition);
		board.getPlayerPieces().put(player.getName(), newPosition);
	}
	
//	roll dice
	public int rollDice() {
		//check and update for multiple sixes
		
		return DiceService.roll();
	}
//	make move with snakes and ladder
	public int makeMoveWithSnakeLadder( int newPosition ) {
		int prevPosition;
		do {
			prevPosition = newPosition;
			
			//check if there is a snake in location
			for(Snake snake: board.getSnakes()) {
				if(snake.getBeginPosition() == newPosition) {
					newPosition = snake.getEndPosition();
				}
			}
			//check if there is a snake in location
			for(Ladder ladder: board.getLadders()) {
				if(ladder.getBeginPosition() == newPosition) {
					newPosition = ladder.getEndPosition();
				}
			}
		}while(prevPosition != newPosition);
		return newPosition;
	}
//	isgamecompleted	
	public boolean isGameCompleted(Player player) {
		return board.getPlayerPieces().get(player.getName()) == board.getSize();
	}
	
//	startGame
	public void startGame() {
		while(true) {
			Player player = playersQ.poll();
			makeAMove(player);
			if(isGameCompleted(player)) {
				System.out.println("User "+ player.getName() + " has won the game!");
				break;
			}
			else {
				playersQ.offer(player);
			}
		}
	}
}
