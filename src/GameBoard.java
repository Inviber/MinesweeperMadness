import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameBoard extends JPanel implements MouseListener  {
	
	JButton[][] gameBoard;
	
	
	public GameBoard(int width, int height)
	{
		gameBoard = new JButton[width][height];
		
		createGameBoard(width, height);
			
	}
	
	
	private void createGameBoard(int width, int height)
	{
		
		for(int i =0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				gameBoard[i][j] = new JButton();
				gameBoard[i][j].setPreferredSize(new Dimension(10, 80));
				gameBoard[i][j].setBackground(Color.WHITE);
				gameBoard[i][j].addMouseListener(this);
			}
		}
		
	}
	

	public JButton[][] getGameBoard()
	{
		return gameBoard;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < gameBoard.length; i++)
		{
			for(int j = 0; j < gameBoard.length; j++)
			{
				if(SwingUtilities.isLeftMouseButton(e))
				{
					if(e.getSource() == gameBoard[i][j])
					{
						gameBoard[i][j].setBackground(Color.red);
					}
				}
				
				else if(SwingUtilities.isRightMouseButton(e))
				{
					if(e.getSource() == gameBoard[i][j])
					{
						gameBoard[i][j].setBackground(Color.blue);
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

		
		
	
