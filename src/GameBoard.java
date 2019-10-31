import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameBoard extends JPanel implements MouseListener  {
	
	private Cell cell = new Cell();
	private JButton[][] gameBoardButtons;
	private char[][] gameBoardCharacterArray;
	private char[][] gameBoardCharacterArrayCopy; //Use to Determine if GameBoard is cleared
	
	
	ImageClass image = new ImageClass();
	
	public GameBoard(int width, int height)
	{
		gameBoardButtons = new JButton[width][height];
		gameBoardCharacterArray = new char[width][height];
		gameBoardCharacterArrayCopy = new char[width][height];
		
		createGameBoard(width, height);	
		
		randomMinePlacement(width, height);
		
		fillWithCells(width, height);
		
	}
	
	
	private void createGameBoard(int width, int height)
	{
		
		for(int i =0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				
				gameBoardButtons[i][j] = new JButton();
				gameBoardButtons[i][j].setPreferredSize(new Dimension(10, 80));
				gameBoardButtons[i][j].setIcon(image.getTileImage());
				gameBoardButtons[i][j].addMouseListener(this);		
			}
		}	
	}
	
	
	
	private void randomMinePlacement(int width, int height)
	{
		int xPos;
		int yPos;
		int maxRange = width - 1;
		int range = maxRange;
		
		for(int mineCount = 0; mineCount <= width - 1;)
		{
			xPos = (int)(Math.random() * range);
			yPos = (int)(Math.random() * range);
			
			if(gameBoardCharacterArray[xPos][yPos] != '*')
			{
				gameBoardCharacterArray[xPos][yPos] = '*';
				
				++mineCount;
			}
			
		}
	}
	
	
	private void fillWithCells(int widthOfBoard, int heightOfBoard)
	{
		int countMines = 0; 
		
		for(int i = 0; i < widthOfBoard; i++)
		{
			for(int j = 0; j < heightOfBoard; j++)
			{
				if(cell.isMine(gameBoardCharacterArray, i, j) != true)
				{
					countMines = cell.getMineCount(gameBoardCharacterArray, i, j, widthOfBoard, heightOfBoard);
					gameBoardCharacterArray[i][j] = (char)(countMines + '0');
				}
			}
		}
		
	}
	

	
	public JButton[][] getGameBoard()
	{
		return gameBoardButtons;
	}
	
	
	
	public char[][] getGameBoardCharacterArray()
	{
		return gameBoardCharacterArray;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < gameBoardButtons.length; i++)
		{
			for(int j = 0; j < gameBoardButtons.length; j++)
			{
				if(SwingUtilities.isLeftMouseButton(e))
				{
					if(e.getSource() == gameBoardButtons[i][j])
					{
						
						if(gameBoardButtons[i][j].getIcon() != image.getOrbImage())
						{
							
							if(gameBoardCharacterArray[i][j] == '*' )
							{
								gameBoardButtons[i][j].setIcon(image.getMineImage());
							}
							
							else if(gameBoardCharacterArray[i][j] == '0')
							{
								gameBoardButtons[i][j].setIcon(image.getNumber0Image());
							}
						
							else if(gameBoardCharacterArray[i][j] == '1')
							{
								gameBoardButtons[i][j].setIcon(image.getNumber1Image());
							}
						
							else if(gameBoardCharacterArray[i][j] == '2')
							{
								gameBoardButtons[i][j].setIcon(image.getNumber2Image());
							}
						
							else if(gameBoardCharacterArray[i][j] == '3')
							{
								gameBoardButtons[i][j].setIcon(image.getNumber3Image());
							}
						
							else if(gameBoardCharacterArray[i][j] == '4')
							{
								gameBoardButtons[i][j].setIcon(image.getNumber4Image());
							}
						
							else if(gameBoardCharacterArray[i][j] == '5')
							{
								gameBoardButtons[i][j].setIcon(image.getNumber5Image());
							}
						
							else if(gameBoardCharacterArray[i][j] == '6')
							{
								gameBoardButtons[i][j].setIcon(image.getNumber6Image());
							}
						
							else if(gameBoardCharacterArray[i][j] == '7')
							{
								gameBoardButtons[i][j].setIcon(image.getNumber7Image());
							}
						
							else if(gameBoardCharacterArray[i][j] == '8')
							{
								gameBoardButtons[i][j].setIcon(image.getNumber8Image());
							}
						}
					}
				}
				
				else if(SwingUtilities.isRightMouseButton(e))
				{
					if(e.getSource() == gameBoardButtons[i][j])
					{
						
						if(gameBoardButtons[i][j].getIcon() == image.getOrbImage())
						{
							gameBoardButtons[i][j].setIcon(image.getTileImage());
							
							gameBoardCharacterArrayCopy[i][j] = ' ';
						}
						
						else if(gameBoardButtons[i][j].getIcon() != image.getNumber0Image() 
								&& gameBoardButtons[i][j].getIcon() != image.getNumber1Image()
								&& gameBoardButtons[i][j].getIcon() != image.getNumber2Image() 
								&& gameBoardButtons[i][j].getIcon() != image.getNumber3Image()
								&& gameBoardButtons[i][j].getIcon() != image.getNumber4Image()
								&& gameBoardButtons[i][j].getIcon() != image.getNumber5Image()
								&& gameBoardButtons[i][j].getIcon() != image.getNumber6Image()
								&& gameBoardButtons[i][j].getIcon() != image.getNumber7Image()
								&& gameBoardButtons[i][j].getIcon() != image.getNumber8Image()
								&& gameBoardButtons[i][j].getIcon() != image.getMineImage())
						{
							gameBoardButtons[i][j].setIcon(image.getOrbImage());
							
							
							gameBoardCharacterArrayCopy[i][j] = 'f';
						}
						
					}
				}
			}
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
