import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {
	
	Cell cell;

	
	@BeforeEach
	void createCell()
	{
		cell = new Cell();
	}

	
	@Test
	void testingAstericCharacterIfIsMineCharacter() {
		
		char array[][] = new char[1][1];
		array[0][0] = '*';
		boolean result = cell.isMine(array, 0, 0);
		
		assertEquals(result, true);
	}
	
	@Test
	void testingAtCharacterIfIsMineCharacter() {
		
		char array[][] = new char[1][1];
		array[0][0] = '@';
		boolean result = cell.isMine(array, 0, 0);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingNumberCharacterIfIsMineCharacter() {
		
		char array[][] = new char[1][1];
		array[0][0] = '1';
		boolean result = cell.isMine(array, 0, 0);
		
		assertEquals(result, false);
	}


	@Test
	void testingfCharacterifIsOrbCharacter() {
		char array[][] = new char[1][1];
		array[0][0] = 'f';
		boolean result = cell.isOrb(array, 0, 0);
		
		assertEquals(result, true);
	}
	
	@Test
	void testingAstericsCharacterifIsOrbCharacter() {
		char array[][] = new char[1][1];
		array[0][0] = '*';
		boolean result = cell.isOrb(array, 0, 0);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingNumberCharacterifIsOrbCharacter() {
		char array[][] = new char[1][1];
		array[0][0] = '3';
		boolean result = cell.isOrb(array, 0, 0);
		
		assertEquals(result, false);
	}

	
	@Test
	void testingOneOverColumnBoundaryRangeIfCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(4, 9, rowRange, columnRange);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingTwoOverColumnBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(4, 10, rowRange, columnRange);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingColumnBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(4, 8, rowRange, columnRange);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingOneUnderColumnBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(4, 7, rowRange, columnRange);
		
		assertEquals(result, true);
	}
	
	@Test
	void testingOneOverRowBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(6, 7, rowRange, columnRange);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingTwoOverRowBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(7, 7, rowRange, columnRange);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingRowBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(5, 7, rowRange, columnRange);
		
		assertEquals(result, false);
	}
	
	
	@Test
	void testingOneUnderRowBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(4, 7, rowRange, columnRange);
		
		assertEquals(result, true);
	}
	
	@Test
	void testingOneOverRowAndColumnBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(6, 8, rowRange, columnRange);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingTwoOverRowAndColumnBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(7, 10, rowRange, columnRange);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingRowAndColumnBoundaryRangesifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(5, 8, rowRange, columnRange);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingOneUnderRowAndColumnBoundaryRangesifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(4, 7, rowRange, columnRange);
		
		assertEquals(result, true);
	}
	
	@Test
	void testingNegativeRowAndColumnBoundaryRangesifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(-6, -8, rowRange, columnRange);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingNegativeRowBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(-6, 7, rowRange, columnRange);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingNegativeColumnBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(4, -8, rowRange, columnRange);
		
		assertEquals(result, false);
	}
	
	@Test
	void testingZeroRowBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(0, 7, rowRange, columnRange);
		
		assertEquals(result, true);
	}
	
	@Test
	void testingZeroColumnBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(4, 0, rowRange, columnRange);
		
		assertEquals(result, true);
	}
	
	@Test
	void testingZeroRowAndColumnBoundaryRangeifCellisValid() {
		
		int rowRange = 5;
		int columnRange = 8;
		
		boolean result = cell.isValidCell(0, 0, rowRange, columnRange);
		
		assertEquals(result, true);
	}
	

	
	@Test
	void testingZeroMinesSoMineCountShouldReturnZero() {
		int rowRange = 2;
		int columnRange = 2;
		char array[][] = new char[rowRange][columnRange];
		array[0][0] = '0';
		array[0][1] = '1';
		array[1][0] = '3';
		array[1][1] = '4';
		int result = cell.getMineCount(array, 0, 0, rowRange, columnRange);
		
		assertEquals(result, 0);
	}
	
	@Test
	void testingOneMineSoMineCountShouldReturnOneMineAdjacentToSelectedMine() {
		int rowRange = 2;
		int columnRange = 2;
		char array[][] = new char[rowRange][columnRange];
		array[0][0] = '0';
		array[0][1] = '*';
		array[1][0] = '3';
		array[1][1] = '4';
		int result = cell.getMineCount(array, 0, 0, rowRange, columnRange);
		
		assertEquals(result, 1);
	}
	
	@Test
	void testingThreeMineButMineCountShouldReturnOnlyTwoMinesAdjacentToSelectedMine() {
		int rowRange = 3;
		int columnRange = 3;
		char array[][] = new char[rowRange][columnRange];
		array[0][0] = '0';
		array[0][1] = '*';
		array[0][2] = '*';
		array[1][0] = '*';
		array[1][1] = '4';
		int result = cell.getMineCount(array, 0, 0, rowRange, columnRange);
		
		assertEquals(result, 2);
	}
	

	@Test
	void testingExplodeMethodToSeeIfItReturnstheCorrectNumberCorrelatingWithTheMineCharacter() {
	
		char array[][] = new char[1][1];
		array[0][0] = '*';
		int result = cell.explode(array, 0, 0);
		
		assertEquals(result, -1);
	}
	
	@Test
	void testingExplodeMethodToSeeIfItReturnstheCorrectNumberCorrelatingWithTheZeroCharacter() {
	
		char array[][] = new char[1][1];
		array[0][0] = '0';
		int result = cell.explode(array, 0, 0);
		
		assertEquals(result, 0);
	}
	
	@Test
	void testingExplodeMethodToSeeIfItReturnstheCorrectNumberCorrelatingWithTheOneCharacter() {
	
		char array[][] = new char[1][1];
		array[0][0] = '1';
		int result = cell.explode(array, 0, 0);
		
		assertEquals(result, 1);	
	}
	
	@Test
	void testingExplodeMethodToSeeIfItReturnstheCorrectNumberCorrelatingWithTheTwoCharacter() {
	
		char array[][] = new char[1][1];
		array[0][0] = '2';
		int result = cell.explode(array, 0, 0);
		
		assertEquals(result, 2);	
	}
	
	@Test
	void testingExplodeMethodToSeeIfItReturnstheCorrectNumberCorrelatingWithTheThreeCharacter() {
	
		char array[][] = new char[1][1];
		array[0][0] = '3';
		int result = cell.explode(array, 0, 0);
		
		assertEquals(result, 3);	
	}
	
	@Test
	void testingExplodeMethodToSeeIfItReturnstheCorrectNumberCorrelatingWithTheFourCharacter() {
	
		char array[][] = new char[1][1];
		array[0][0] = '4';
		int result = cell.explode(array, 0, 0);
		
		assertEquals(result, 4);	
	}
	
	@Test
	void testingExplodeMethodToSeeIfItReturnstheCorrectNumberCorrelatingWithTheFiveCharacter() {
	
		char array[][] = new char[1][1];
		array[0][0] = '5';
		int result = cell.explode(array, 0, 0);
		
		assertEquals(result, 5);	
	}
	
	@Test
	void testingExplodeMethodToSeeIfItReturnstheCorrectNumberCorrelatingWithTheSixCharacter() {
	
		char array[][] = new char[1][1];
		array[0][0] = '6';
		int result = cell.explode(array, 0, 0);
		
		assertEquals(result, 6);	
	}
	
	@Test
	void testingExplodeMethodToSeeIfItReturnstheCorrectNumberCorrelatingWithTheSevenCharacter() {
	
		char array[][] = new char[1][1];
		array[0][0] = '7';
		int result = cell.explode(array, 0, 0);
		
		assertEquals(result, 7);	
	}
	
	@Test
	void testingExplodeMethodToSeeIfItReturnstheCorrectNumberCorrelatingWithTheEightCharacter() {
	
		char array[][] = new char[1][1];
		array[0][0] = '8';
		int result = cell.explode(array, 0, 0);
		
		assertEquals(result, 8);	
	}
	
	@Test
	void testingExplodeMethodToSeeIfItReturnstheCorrectNumberCorrelatingWithTheAtCharacter() {
	
		char array[][] = new char[1][1];
		array[0][0] = '@';
		int result = cell.explode(array, 0, 0);
		
		assertEquals(result, -2);	
	}
	
	

}
