	
	import java.awt.Dimension;

	import javax.swing.JButton;
	import javax.swing.JPanel;

	public class GameBoard extends JPanel {
		
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
					gameBoard[i][j] = new JButton("B");
					gameBoard[i][j].setPreferredSize(new Dimension(50, 50));
				}
			}
			
		}
		
		
		public JButton[][] getGameBoard()
		{
			return gameBoard;
		}
		
		


}
