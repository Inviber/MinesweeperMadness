
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {
	
	JButton[][] userGameBoard;
	GameBoard gameBorad;
	JPanel jpanel;
	
	
	public boolean isGameOver()
	{
		return false;
	}
	
	public void playGame()
	{
		JFrame frame = new JFrame();
		jpanel = new JPanel();
		userGameBoard = new JButton[10][10];
		
		final int FRAME_WIDTH = 600;  //Width of Frame
		final int FRAME_HEIGHT = 600;  //Height of Frame

	    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	    frame.setTitle("Minesweeper Madness");
	    //frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    frame.setVisible(true);
	   
		
	}
	
	
	
	
	

}

