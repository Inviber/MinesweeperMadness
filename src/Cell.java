public class Cell {
	
	
	
	public Cell()
	{
		
	}
	
	
	public boolean isMine(char gameBoard[][], int rowPos, int columnPos)
	{
		if(gameBoard[rowPos][columnPos] == '*')
		{
			return true;
		}
		else 
		{
			return false;
		}	
	}
	
	
	public boolean isOrb(char gameBoardCopy[][], int rowPos, int columnPos)
	{
		if(gameBoardCopy[rowPos][columnPos] == 'f')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean isValidCell(int rowPos, int columnPos, int widthOfBoard, int heightOfBoard)
	{
		if((rowPos >= 0 && rowPos < widthOfBoard) && (columnPos >= 0 && columnPos < heightOfBoard))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public int getMineCount(char gameBoard[][], int rowPos, int columnPos, int widthOfBoard, int heightOfBoard)
	{
		int count = 0;
		
		//Checking South of Cell to see if there are any mines
		if(isValidCell(rowPos + 1, columnPos, widthOfBoard, heightOfBoard) == true)
		{
			if(isMine(gameBoard, rowPos + 1, columnPos) == true)
			{
				count++;
			}
		}

		//Checking South West of Cell to see if there are any mines
		if(isValidCell(rowPos + 1, columnPos - 1, widthOfBoard, heightOfBoard) == true)
	        {
	                if(isMine(gameBoard, rowPos + 1, columnPos - 1) == true)
	                {
	                        count++;
	                }
	        }

		//Checking West of Cell to see if there are any mines
		if(isValidCell(rowPos, columnPos - 1, widthOfBoard, heightOfBoard) == true)
	        {
	                if(isMine(gameBoard, rowPos, columnPos - 1) == true)
	                {
	                        count++;
	                }
	        }

		//Checking North West of Cell to see if there are any mines
		if(isValidCell(rowPos - 1, columnPos - 1, widthOfBoard, heightOfBoard) == true)
	        {
	                if(isMine(gameBoard, rowPos - 1, columnPos - 1) == true)
	                {
	                        count++;
	                }
	        }

		//Checking North of Cell to see if there are any mines
		if(isValidCell(rowPos - 1, columnPos, widthOfBoard, heightOfBoard) == true)
	        {
	                if(isMine(gameBoard, rowPos - 1, columnPos) == true)
	                {
	                        count++;
	                }
	        }

		//Checking North East of Cell to see if there are any mines
		if(isValidCell(rowPos - 1, columnPos + 1, widthOfBoard, heightOfBoard) == true)
	        {
	                if(isMine(gameBoard, rowPos - 1, columnPos + 1) == true)
	                {
	                        count++;
	                }
	        }

		//Checking East of Cell to see if there are any mines
		if(isValidCell(rowPos, columnPos + 1, widthOfBoard, heightOfBoard) == true)
	        {
	                if(isMine(gameBoard, rowPos, columnPos + 1) == true)
	                {
	                        count++;
	                }
	        }

		//Checking South East of Cell to see if there are any mines
		if(isValidCell(rowPos + 1, columnPos + 1, widthOfBoard, heightOfBoard) == true)
	        {
	                if(isMine(gameBoard, rowPos + 1, columnPos + 1) == true)
	                {
	                        count++;
	                }
	        }

		//Returns Number of mines that are adjacent to cell specified
		return count;			
	}
	
	

}
