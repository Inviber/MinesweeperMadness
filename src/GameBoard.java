import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

 class GameBoard implements MouseListener  {
	
	private JButton[][] gameBoardButtons;
	private char[][] gameBoardCharacterArray;
	private char[][] gameBoardCharacterArrayCopy; //Use to Determine if GameBoard is cleared
	private char[][] zeroFillArray; //Used to determine which cells have been checked for a cascading reveal
	private int widthOfBoard;
	private int heightOfBoard;
	private int currentLevel;
	private JFrame gameFrame;
	
	private Cell cell = new Cell();
	private ImageClass image = new ImageClass();
	private PlayAgain playAgainMenu = new PlayAgain();
	
	
	public GameBoard(int width, int height, int currentLevel, JFrame frame)
	{
		gameBoardButtons = new JButton[width][height];
		gameBoardCharacterArray = new char[width][height];
		gameBoardCharacterArrayCopy = new char[width][height];
		zeroFillArray = new char[width][height];
		this.currentLevel = currentLevel;
		widthOfBoard = width;
		heightOfBoard = height;
		gameFrame = frame;
		
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
		int maxRange = width;
		int range = maxRange;
		
		for(int mineCount = 0; mineCount <= maxRange;)
		{
			xPos = (int)(Math.random() * range);
			yPos = (int)(Math.random() * range);
			
			if(!cell.isMine(gameBoardCharacterArray, xPos, yPos))
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
	
	
	public void explode()
	{
		int val;
		
		for (int i = 0; i < gameBoardButtons.length; i++)
		{
			for (int j = 0; j < gameBoardButtons[0].length; j++)
			{
				val = cell.explode(gameBoardCharacterArray, i, j);
				
				if(val == -1)
					gameBoardButtons[i][j].setIcon(image.getMineImage());
				else if(val == 0)
					gameBoardButtons[i][j].setIcon(image.getNumber0Image());
				else if(val == 1)
					gameBoardButtons[i][j].setIcon(image.getNumber1Image());
				else if(val == 2)
					gameBoardButtons[i][j].setIcon(image.getNumber2Image());
				else if(val == 3)
					gameBoardButtons[i][j].setIcon(image.getNumber3Image());
				else if(val == 4)
					gameBoardButtons[i][j].setIcon(image.getNumber4Image());
				else if(val == 5)
					gameBoardButtons[i][j].setIcon(image.getNumber5Image());
				else if(val == 6)
					gameBoardButtons[i][j].setIcon(image.getNumber6Image());
				else if(val == 7)
					gameBoardButtons[i][j].setIcon(image.getNumber7Image());
				else if(val == 8)
					gameBoardButtons[i][j].setIcon(image.getNumber8Image());
			}
			
		}
		gameOver();
	}
	
	public void gameOver()
	{
		JOptionPane.showMessageDialog(null, "Game Over!");
		gameFrame.dispose();
		playAgainMenu.gameOver(currentLevel);
		
	}
	
	
	
	private void zeroFill(int cellX, int cellY) {
		if(cellX < 0 || cellX >= gameBoardButtons.length || cellY < 0 || cellY >= gameBoardButtons.length 
				|| zeroFillArray[cellX][cellY] == 'z') return;

		if(gameBoardCharacterArray[cellX][cellY] == '0') {
			zeroFillArray[cellX][cellY] = 'z';
			gameBoardButtons[cellX][cellY].setIcon(image.getNumber0Image());
			gameBoardCharacterArrayCopy[cellX][cellY] = '0';

			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY >= 0 && cellY < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY] == '1') {
					gameBoardButtons[cellX-1][cellY].setIcon(image.getNumber1Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY] = '1';
				}
			}

			if(cellX >= 0 && cellX < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX][cellY-1] == '1') {
					gameBoardButtons[cellX][cellY-1].setIcon(image.getNumber1Image());
					gameBoardCharacterArrayCopy[cellX][cellY-1] = '1';
				}
			}

			if(cellX >= 0 && cellX < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX][cellY+1] == '1') {
					gameBoardButtons[cellX][cellY+1].setIcon(image.getNumber1Image());
					gameBoardCharacterArrayCopy[cellX][cellY+1] = '1';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY >= 0 && cellY < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY] == '1') {
					gameBoardButtons[cellX+1][cellY].setIcon(image.getNumber1Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY] = '1';
				}
			}
			
			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY-1] == '1') {
					gameBoardButtons[cellX-1][cellY-1].setIcon(image.getNumber1Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY-1] = '1';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY-1] == '1') {
					gameBoardButtons[cellX+1][cellY-1].setIcon(image.getNumber1Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY-1] = '1';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY+1] == '1') {
					gameBoardButtons[cellX+1][cellY+1].setIcon(image.getNumber1Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY+1] = '1';
				}
			}

			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY+1] == '1') {
					gameBoardButtons[cellX-1][cellY+1].setIcon(image.getNumber1Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY+1] = '1';
				}
			}

			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY >= 0 && cellY < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY] == '2') {
					gameBoardButtons[cellX-1][cellY].setIcon(image.getNumber2Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY] = '2';
				}
			}

			if(cellX >= 0 && cellX < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX][cellY-1] == '2') {
					gameBoardButtons[cellX][cellY-1].setIcon(image.getNumber2Image());
					gameBoardCharacterArrayCopy[cellX][cellY-1] = '2';
				}
			}

			if(cellX >= 0 && cellX < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX][cellY+1] == '2') {
					gameBoardButtons[cellX][cellY+1].setIcon(image.getNumber2Image());
					gameBoardCharacterArrayCopy[cellX][cellY+1] = '2';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY >= 0 && cellY < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY] == '2') {
					gameBoardButtons[cellX+1][cellY].setIcon(image.getNumber2Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY] = '2';
				}
			}
			
			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY-1] == '2') {
					gameBoardButtons[cellX-1][cellY-1].setIcon(image.getNumber2Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY-1] = '2';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY-1] == '2') {
					gameBoardButtons[cellX+1][cellY-1].setIcon(image.getNumber2Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY-1] = '2';
				}
			}

			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY+1] == '2') {
					gameBoardButtons[cellX-1][cellY+1].setIcon(image.getNumber2Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY+1] = '2';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY+1] == '2') {
					gameBoardButtons[cellX+1][cellY+1].setIcon(image.getNumber2Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY+1] = '2';
				}
			}
			

			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY >= 0 && cellY < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY] == '3') {
					gameBoardButtons[cellX-1][cellY].setIcon(image.getNumber3Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY] = '3';
					//++clickedCells;
				}
			}

			if(cellX >= 0 && cellX < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX][cellY-1] == '3') {
					gameBoardButtons[cellX][cellY-1].setIcon(image.getNumber3Image());
					gameBoardCharacterArrayCopy[cellX][cellY-1] = '3';
					//++clickedCells;
				}
			}

			if(cellX >= 0 && cellX < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX][cellY+1] == '3') {
					gameBoardButtons[cellX][cellY+1].setIcon(image.getNumber3Image());
					gameBoardCharacterArrayCopy[cellX][cellY+1] = '3';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY >= 0 && cellY < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY] == '3') {
					gameBoardButtons[cellX+1][cellY].setIcon(image.getNumber3Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY] = '3';
				}
			}

			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY-1] == '3') {
					gameBoardButtons[cellX-1][cellY-1].setIcon(image.getNumber3Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY-1] = '3';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY-1] == '3') {
					gameBoardButtons[cellX+1][cellY-1].setIcon(image.getNumber3Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY-1] = '3';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY+1] == '3') {
					gameBoardButtons[cellX+1][cellY+1].setIcon(image.getNumber3Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY+1] = '3';
				}
			}

			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY+1] == '3') {
					gameBoardButtons[cellX-1][cellY+1].setIcon(image.getNumber3Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY+1] = '3';
				}
			}
			
			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY >= 0 && cellY < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY] == '4') {
					gameBoardButtons[cellX-1][cellY].setIcon(image.getNumber4Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY] = '4';
				}
			}

			if(cellX >= 0 && cellX < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX][cellY-1] == '4') {
					gameBoardButtons[cellX][cellY-1].setIcon(image.getNumber4Image());
					gameBoardCharacterArrayCopy[cellX][cellY-1] = '4';
				}
			}

			if(cellX >= 0 && cellX < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX][cellY+1] == '4') {
					gameBoardButtons[cellX][cellY+1].setIcon(image.getNumber4Image());
					gameBoardCharacterArrayCopy[cellX][cellY+1] = '4';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY >= 0 && cellY < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY] == '4') {
					gameBoardButtons[cellX+1][cellY].setIcon(image.getNumber4Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY] = '4';
				}
			}
			
			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY-1] == '4') {
					gameBoardButtons[cellX-1][cellY-1].setIcon(image.getNumber4Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY-1] = '4';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY-1] == '4') {
					gameBoardButtons[cellX+1][cellY-1].setIcon(image.getNumber4Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY-1] = '4';
				}
			}

			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY+1] == '4') {
					gameBoardButtons[cellX-1][cellY+1].setIcon(image.getNumber4Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY+1] = '4';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY+1] == '4') {
					gameBoardButtons[cellX+1][cellY+1].setIcon(image.getNumber4Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY+1] = '4';
				}
			}

			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY >= 0 && cellY < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY] == '5') {
					gameBoardButtons[cellX-1][cellY].setIcon(image.getNumber5Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY] = '5';
				}
			}

			if(cellX >= 0 && cellX < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX][cellY-1] == '5') {
					gameBoardButtons[cellX][cellY-1].setIcon(image.getNumber5Image());
					gameBoardCharacterArrayCopy[cellX][cellY-1] = '5';
				}
			}

			if(cellX >= 0 && cellX < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX][cellY+1] == '5') {
					gameBoardButtons[cellX][cellY+1].setIcon(image.getNumber5Image());
					gameBoardCharacterArrayCopy[cellX][cellY+1] = '5';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY >= 0 && cellY < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY] == '5') {
					gameBoardButtons[cellX+1][cellY].setIcon(image.getNumber5Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY] = '5';
				}
			}
			
			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY-1] == '5') {
					gameBoardButtons[cellX-1][cellY-1].setIcon(image.getNumber5Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY-1] = '5';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY-1] == '5') {
					gameBoardButtons[cellX+1][cellY-1].setIcon(image.getNumber5Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY-1] = '5';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY+1] == '5') {
					gameBoardButtons[cellX+1][cellY+1].setIcon(image.getNumber5Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY+1] = '5';
				}
			}

			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY+1] == '5') {
					gameBoardButtons[cellX-1][cellY+1].setIcon(image.getNumber5Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY+1] = '5';
				}
			}

			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY >= 0 && cellY < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY] == '6') {
					gameBoardButtons[cellX-1][cellY].setIcon(image.getNumber6Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY] = '6';
				}
			}

			if(cellX >= 0 && cellX < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX][cellY-1] == '6') {
					gameBoardButtons[cellX][cellY-1].setIcon(image.getNumber6Image());
					gameBoardCharacterArrayCopy[cellX][cellY-1] = '6';
				}
			}

			if(cellX >= 0 && cellX < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX][cellY+1] == '6') {
					gameBoardButtons[cellX][cellY+1].setIcon(image.getNumber6Image());
					gameBoardCharacterArrayCopy[cellX][cellY+1] = '6';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY >= 0 && cellY < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY] == '6') {
					gameBoardButtons[cellX+1][cellY].setIcon(image.getNumber6Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY] = '6';
				}
			}
			
			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY-1] == '6') {
					gameBoardButtons[cellX-1][cellY-1].setIcon(image.getNumber6Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY-1] = '6';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY-1 >= 0 && cellY-1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY-1] == '6') {
					gameBoardButtons[cellX+1][cellY-1].setIcon(image.getNumber6Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY-1] = '6';
				}
			}

			if(cellX-1 >= 0 && cellX-1 < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX-1][cellY+1] == '6') {
					gameBoardButtons[cellX-1][cellY+1].setIcon(image.getNumber6Image());
					gameBoardCharacterArrayCopy[cellX-1][cellY+1] = '6';
				}
			}

			if(cellX+1 >= 0 && cellX+1 < gameBoardButtons.length && cellY+1 >= 0 && cellY+1 < gameBoardButtons.length) {
				if(gameBoardCharacterArray[cellX+1][cellY+1] == '6') {
					gameBoardButtons[cellX+1][cellY+1].setIcon(image.getNumber6Image());
					gameBoardCharacterArrayCopy[cellX+1][cellY+1] = '6';
				}
			}
			
			zeroFill(cellX+1, cellY);
			zeroFill(cellX-1, cellY);
			zeroFill(cellX, cellY+1);
			zeroFill(cellX, cellY-1);
			zeroFill(cellX+1, cellY+1);
			zeroFill(cellX-1, cellY-1);
			zeroFill(cellX-1, cellY+1);
			zeroFill(cellX+1, cellY-1);
		} 
		else 
		{
			return;
		}
	}

	
	public void isAllClear()
	{
		int count = 0;
		
		for(int i = 0; i < widthOfBoard; i++)
		{
			for(int j = 0; j < heightOfBoard; j++)
			{
				if(gameBoardCharacterArray[i][j] != gameBoardCharacterArrayCopy[i][j])
				{
					count = 1;
				}
			}
		}
		
		if(count != 1)
		{
			JOptionPane.showMessageDialog(null, "Congragulations");
			gameFrame.dispose();
			playAgainMenu.continueGame(currentLevel);
		}
		
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		for(int i = 0; i < widthOfBoard; i++)
		{
			for(int j = 0; j < heightOfBoard; j++)
			{
				if(SwingUtilities.isLeftMouseButton(e))
				{
					if(e.getSource() == gameBoardButtons[i][j])
					{
						
						if(gameBoardButtons[i][j].getIcon() != image.getOrbImage())
						{
							
							if(cell.isMine(gameBoardCharacterArray, i, j))
							{
								gameBoardButtons[i][j].setIcon(image.getMineImage());
								explode();
							}
							
							else if(cell.isNumber0(gameBoardCharacterArray, i, j))
							{
								gameBoardButtons[i][j].setIcon(image.getNumber0Image());
								zeroFill(i, j);
								gameBoardCharacterArrayCopy[i][j] = '0';
								isAllClear();
							}
						
							else if(cell.isNumber1(gameBoardCharacterArray, i, j))
							{
								gameBoardButtons[i][j].setIcon(image.getNumber1Image());
								gameBoardCharacterArrayCopy[i][j] = '1';
								isAllClear();
							}
						
							else if(cell.isNumber2(gameBoardCharacterArray, i, j))
							{
								gameBoardButtons[i][j].setIcon(image.getNumber2Image());
								gameBoardCharacterArrayCopy[i][j] = '2';
								isAllClear();
							}
						
							else if(cell.isNumber3(gameBoardCharacterArray, i, j))
							{
								gameBoardButtons[i][j].setIcon(image.getNumber3Image());
								gameBoardCharacterArrayCopy[i][j] = '3';
								isAllClear();
							}
						
							else if(cell.isNumber4(gameBoardCharacterArray, i, j))
							{
								gameBoardButtons[i][j].setIcon(image.getNumber4Image());
								gameBoardCharacterArrayCopy[i][j] = '4';
								isAllClear();
							}
						
							else if(cell.isNumber5(gameBoardCharacterArray, i, j))
							{
								gameBoardButtons[i][j].setIcon(image.getNumber5Image());
								gameBoardCharacterArrayCopy[i][j] = '5';
								isAllClear();
							}
						
							else if(cell.isNumber6(gameBoardCharacterArray, i, j))
							{
								gameBoardButtons[i][j].setIcon(image.getNumber6Image());
								gameBoardCharacterArrayCopy[i][j] = '6';
								isAllClear();
							}
						
							else if(cell.isNumber7(gameBoardCharacterArray, i, j))
							{
								gameBoardButtons[i][j].setIcon(image.getNumber7Image());
								gameBoardCharacterArrayCopy[i][j] = '7';
								isAllClear();
							}
						
							else if(cell.isNumber8(gameBoardCharacterArray, i, j))
							{
								gameBoardButtons[i][j].setIcon(image.getNumber8Image());
								gameBoardCharacterArrayCopy[i][j] = '8';
								isAllClear();
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
							isAllClear();
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
							
							gameBoardCharacterArrayCopy[i][j] = '*';
							isAllClear();
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