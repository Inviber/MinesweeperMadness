package com.medievalmadness;

public class Game {
	
	public static int selected_level = 1;
	public static Player[] gladiators;
	public static Player currentSpot;
	public boolean isGameOver = false;
	
	
	GameBoard gameBoard = new GameBoard();
	
	public void setPlayer(Player PLAYER_TYPE_SWORD, Player PLAYER_TYPE_SPEAR, Player PLAYER_TYPE_ARCHER)
	{
		gladiators[0] = PLAYER_TYPE_SWORD;
		gladiators[1] = PLAYER_TYPE_SPEAR;
		gladiators[2] = PLAYER_TYPE_ARCHER;
		
	}
	
	
	public boolean isGameOver()
	{
        return isGameOver;

	}
	
	public void GameOver(boolean isGameOver)
	{
		this.isGameOver = isGameOver;
	}
   
	public boolean isSelectedLevel()
	{
		return true;
	}
	
	public void playGame()
	{
		
	}
	
}
