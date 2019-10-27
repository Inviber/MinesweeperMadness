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

public class GameBoard extends JPanel implements MouseListener  {
	
	private Cell cell = new Cell();
	private JButton[][] gameBoardButtons;
	private char[][] gameBoardCharacterArray;
	private ImageIcon mine = new ImageIcon("Mine.jpg");
	private ImageIcon tiles = new ImageIcon("Tile.png");
	
	private ImageIcon number0 = new ImageIcon("Number0.png");
	private ImageIcon number1 = new ImageIcon("Number1.png");
	private ImageIcon number2 = new ImageIcon("Number2.png");
	private ImageIcon number3 = new ImageIcon("Number3.png");
	private ImageIcon number4 = new ImageIcon("Number4.png");
	private ImageIcon number5 = new ImageIcon("Number5.png");
	private ImageIcon number6 = new ImageIcon("Number6.png");
	private ImageIcon number7 = new ImageIcon("Number7.png");
	private ImageIcon number8 = new ImageIcon("Number8.png");
	
	
	
	public GameBoard(int width, int height)
	{
		gameBoardButtons = new JButton[width][height];
		gameBoardCharacterArray = new char[width][height];
		
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
				//gameBoardButtons[i][j].setBackground(Color.WHITE);
				gameBoardButtons[i][j].setIcon(tiles);
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
				
				//System.out.println(xPos + " " + yPos);
				++mineCount;
			}
			
		}
	}
	
	
	private void fillWithCells(int width, int height)
	{
		int countMines = 0; 
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				if(cell.isMine(gameBoardCharacterArray, i, j) != true)
				{
					countMines = cell.getMineCount(gameBoardCharacterArray, i, j);
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
						if(gameBoardCharacterArray[i][j] == '*' )
						{
							gameBoardButtons[i][j].setIcon(mine);
						}
						
						else if(gameBoardCharacterArray[i][j] == '0')
						{
						gameBoardButtons[i][j].setIcon(number0);
						}
						
						else if(gameBoardCharacterArray[i][j] == '1')
						{
						gameBoardButtons[i][j].setIcon(number1);
						}
						
						else if(gameBoardCharacterArray[i][j] == '2')
						{
						gameBoardButtons[i][j].setIcon(number2);
						}
						
						else if(gameBoardCharacterArray[i][j] == '3')
						{
						gameBoardButtons[i][j].setIcon(number3);
						}
						
						else if(gameBoardCharacterArray[i][j] == '4')
						{
						gameBoardButtons[i][j].setIcon(number4);
						}
						
						else if(gameBoardCharacterArray[i][j] == '5')
						{
						gameBoardButtons[i][j].setIcon(number5);
						}
						
						else if(gameBoardCharacterArray[i][j] == '6')
						{
						gameBoardButtons[i][j].setIcon(number6);
						}
						
						else if(gameBoardCharacterArray[i][j] == '7')
						{
						gameBoardButtons[i][j].setIcon(number7);
						}
						
						else if(gameBoardCharacterArray[i][j] == '8')
						{
						gameBoardButtons[i][j].setIcon(number8);
						}
					}
				}
				
				else if(SwingUtilities.isRightMouseButton(e))
				{
					if(e.getSource() == gameBoardButtons[i][j])
					{
						gameBoardButtons[i][j].setBackground(Color.blue);
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
		
		
	
