
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {
	
	JButton[][] userGameBoard;
	GameBoard gameBoard;
	JPanel jpanel;
	
	public boolean isGameOver()
	{
		return false;
	}
	
	public void playGame()
	{
		JFrame frame = new JFrame();
		jpanel = new JPanel();
		userGameBoard = new JButton[5][5];
		
		final int FRAME_WIDTH = 600;  //Width of Frame
		final int FRAME_HEIGHT = 600;  //Height of Frame

	    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	    frame.setTitle("Minesweeper Madness");
	    //frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    
	    frame.setVisible(true);
	    
	    gameBoard = new GameBoard(5, 5);
	    
	    
	    //gameBoard.setGameBoard(userGameBoard);
	    
	    userGameBoard = gameBoard.getGameBoard();
	    
	    for(int i = 0; i < 5; i++)
	    { 
	    	for(int j = 0; j < 5; j++)
	    	{
	    		jpanel.add(userGameBoard[i][j]);
	    	}
	    }
	    
	    
	    frame. add(jpanel);
	    
	    frame.setVisible(true);
	   
	   
		
	}
	
	
	
	
	

}

