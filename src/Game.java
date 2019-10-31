

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {
	
	private JButton[][] userGameBoardButtons;
	private char[][] uesrGameBoardCharacterArray;
	private GameBoard gameBoard;
	private JPanel panelGameBoard;
	private JPanel panelFormatForFrame;
	
	
	private final int FRAME_WIDTH = 670;  
	private final int FRAME_HEIGHT = 800;
	public int widthOfBoard;
	private int heightOfBoard;
	
	
	
	private void setWidthOfBoard(int widthOfBoard)
	{
		this.widthOfBoard = widthOfBoard;
	}
	
	
	private void setHeightOfBoard(int heightOfBoard)
	{
		this.heightOfBoard = heightOfBoard;
	}
		
	
	public void selectLevel(int levelOption)
	{
		if(levelOption == 1)
		{
			setWidthOfBoard(5);
			setHeightOfBoard(5);
		}
		
		else if(levelOption == 2)
		{
			setWidthOfBoard(7);
			setHeightOfBoard(7);
		}
		
		else if(levelOption == 3)
		{
			setWidthOfBoard(9);
			setHeightOfBoard(9);
		}
	}
	
	
	public void playGame()
	{
		
		JFrame frame = new JFrame();
		panelGameBoard = new JPanel();
		panelFormatForFrame = new JPanel();
		
		selectLevel(1);
		
		userGameBoardButtons = new JButton[widthOfBoard][heightOfBoard];
		uesrGameBoardCharacterArray = new char[widthOfBoard][heightOfBoard];

		
		
	    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	    frame.setTitle("Minesweeper Madness");
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    panelGameBoard.setBackground(Color.DARK_GRAY);
	    panelFormatForFrame.setBackground(Color.DARK_GRAY);
	    
	    frame.setVisible(true);
	    
	    
	    gameBoard = new GameBoard(widthOfBoard, heightOfBoard);
	    
	    
	    panelGameBoard.setLayout(new GridLayout(widthOfBoard, heightOfBoard, 2 , 5));
	    panelFormatForFrame.setLayout(new BorderLayout(1,1));
	    
	    
	    userGameBoardButtons = gameBoard.getGameBoard();
	    uesrGameBoardCharacterArray = gameBoard.getGameBoardCharacterArray();
	    
	    for(int i = 0; i < widthOfBoard; i++)
	    { 
	    	for(int j = 0; j < heightOfBoard; j++)
	    	{
	    		panelGameBoard.add(userGameBoardButtons[i][j]);
	    	}
	    }
	    
	    
	    for(int i = 0; i < widthOfBoard; i++)
	    { 
	    	for(int j = 0; j < heightOfBoard; j++)
	    	{
	    		System.out.print(uesrGameBoardCharacterArray[i][j] + " ");
	    	}
	    	System.out.println();
	    }
	    
	   
	    panelFormatForFrame.add(panelGameBoard, BorderLayout.NORTH);
	    
	    frame.getContentPane().add(panelFormatForFrame);
	    
	    frame.setVisible(true);
	}
	
	
	
	public boolean isGameOver()
	{
		return false;
	}
	
	
	

}
