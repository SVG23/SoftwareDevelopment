import org.junit.*;
import static org.junit.Assert.*;

/** Initial test case class for Breakthrough
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/
public class TestBreakthrough {
  Breakthrough game;
  /** Fixture */
  
  @Before
  public void setUp() {
    game = new BreakthroughImpl();
    
  }
  @Test
  public void shouldHaveBlackPawnOn00(){
    assertEquals( "Black has pawn on (0,0)",
                  BreakthroughImpl.PieceType.BLACK, game.getPieceAt(0,0) );
  }
  @Test
  public void shouldHaveWhitePawnOn77(){
    assertEquals( "White has pawn on (7,7)",
                  BreakthroughImpl.PieceType.WHITE, game.getPieceAt(7,7) );
  }
  
  @Test
  public void checkWhetherTheChessBoardIsReadyTostartTheGame()
  {
	  // Checking whether the Black pieces are arranged at the 0 and 1 Rows of the Chess Board
	  
	  // There is a black piece present at the position (0,6)
	  assertEquals("Black piece present at position (0,6)",BreakthroughImpl.PieceType.BLACK,game.getPieceAt(0, 6));
	// There is a black piece present at the position (1,5)
	  assertEquals("Black piece present at position (1,5)",BreakthroughImpl.PieceType.BLACK,game.getPieceAt(1, 5));
	  
	 // Checking whether the White pieces are arranged at the 6 and 7 Rows of the Chess Board
	  
	  // There is a White piece present at the position (6,6)
	  assertEquals("White piece present at position (6,6)",BreakthroughImpl.PieceType.WHITE,game.getPieceAt(6, 6));
	// There is a White piece present at the position (7,1)
	  assertEquals("White piece present at position (7,1)",BreakthroughImpl.PieceType.WHITE,game.getPieceAt(7, 1));
	  
  }
  
  @Test // Test getPieceAt() method
  public void testGetPieceAt() {

	  assertEquals("White piece present at position (7,2)",BreakthroughImpl.PieceType.WHITE,game.getPieceAt(7, 2));

	  assertEquals("Black piece present at position (1,7)",BreakthroughImpl.PieceType.BLACK,game.getPieceAt(1, 7));

}

  @Test // Test getPieceAt() method when row index is less than 0
	public void testGetPieceIndexoutofboundsException0(){
		Boolean thrown=false;
		int row= -3;
		int column= 5;

		try {
			game.getPieceAt(row, column);
		} 
		catch (IndexOutOfBoundsException e) 
		{
			thrown = true;
		}

		assertTrue(thrown);
	}
  @Test // Test getPieceAt() method when column index is less than 0
	public void testGetPieceIndexoutofboundsException1(){
		Boolean thrown=false;
		int row= 2;
		int column= -1;

		try {
			game.getPieceAt(row, column);
		} 
		catch (IndexOutOfBoundsException e) 
		{
			thrown = true;
		}

		assertTrue(thrown);
	}
  
  @Test // Test getPieceAt() method when both row and column index are less than 0
	public void testGetPieceIndexoutofboundsException2()
  
  {
		Boolean thrown=false;
		int row= -4;
		int column= -3;

		try 
		{
			game.getPieceAt(row, column);
		} 
		catch (IndexOutOfBoundsException e) 
		{
			thrown = true;
		}

		assertTrue(thrown);
	}
  
  
  @Test // There is a condition here that white player must initiate the game with his first move.
	public void checkWhetherTheWhitePlayerInitiatingTheGame() {
		
		assertEquals("White player will start the game with his first move", Breakthrough.PlayerType.WHITE, game.getPlayerInTurn());
		
	}
  
  @Test // Test getPlayerInTurn() method
  
  public void testPlayerInturn() {
  
	  // White player's turn
	  assertEquals(BreakthroughImpl.PlayerType.WHITE, game.getPlayerInTurn());
	  game.move(6, 6, 5, 6);
	  
	 // Black Player's turn
	  assertEquals(BreakthroughImpl.PlayerType.BLACK, game.getPlayerInTurn());
	  game.move(1, 3, 2, 3);
	
	  // White player's turn
	 assertEquals(BreakthroughImpl.PlayerType.WHITE, game.getPlayerInTurn());
	 
  }
  
  @Test // Test getWinner() method
  
  public void testGetWinnerWhite() {
  
	  assertTrue(game.isMoveValid(6, 4, 5, 5)); // White player starts the game. White player's 1st move.
	  game.move(6, 4, 5, 5);
	  
	  assertTrue(game.isMoveValid(1, 6, 2, 5)); // Black player's 1st move
	  game.move(1, 6, 2, 5);
	  
	  assertTrue(game.isMoveValid(5, 5, 4, 6)); // White player's 2nd move
	  game.move(5, 5, 4, 6);
	  
	  assertTrue(game.isMoveValid(2, 5, 3,4)); // Black player's 2nd move
	  game.move(2, 5, 3,4);
	  
	  assertTrue(game.isMoveValid(4, 6, 3, 7)); // White player's 3rd move
	  game.move(4, 6, 3, 7);
	  
	  assertTrue(game.isMoveValid(1, 7, 2, 7)); // Black player's 3rd move
	  game.move(1, 7, 2, 7);
	 
	  assertTrue(game.isMoveValid(3, 7, 2, 6)); // White player's 4th move
	  game.move(3, 7, 2, 6);
	 
	  assertTrue(game.isMoveValid(2, 7, 3, 6)); // Black player's 4th move
	  game.move(2, 7, 3, 6);
	  
	  assertTrue(game.isMoveValid(2, 6, 1, 6)); // White player's 5th move
	  game.move(2, 6, 1, 6);	
	  
	  assertTrue(game.isMoveValid(3, 4, 4, 3)); // Black player's 5th move
	  game.move(3, 4, 4, 3);
	  
	  assertTrue(game.isMoveValid(1, 6, 0, 7)); // White player's winning move.
	  game.move(1, 6, 0, 7);
	 
	  assertEquals(BreakthroughImpl.PlayerType.WHITE, game.getWinner()); // White Player is the winner.
	  
  }
 
  @Test // Test getWinner() method
  
  public void testGetWinnerBlack()
  {
	 assertTrue(game.isMoveValid(6, 1, 5, 1)); // White player starts the game. White player's 1st move.
	  game.move(6, 1, 5, 1);
	  
	 assertTrue(game.isMoveValid(1, 2, 2, 2)); // Black player's 1st move
	  game.move(1, 1, 2, 2);
	  
	 assertTrue(game.isMoveValid(5, 1, 4, 0)); // White player's 2nd move
	  game.move(5, 1, 4, 0);
	  
	 assertTrue(game.isMoveValid(2, 2, 3, 2)); // Black player's 2nd move
	  game.move(2, 2, 3, 2);
	  
	 assertTrue(game.isMoveValid(7, 1, 6, 1)); // White player's 3rd move
	  game.move(7, 1, 6, 1);
	  
	 assertTrue(game.isMoveValid(3, 2, 4, 1)); // Black player's 3rd move
	 game.move(3, 2, 4, 1);
	 
	 assertTrue(game.isMoveValid(6, 1, 5, 2)); // White player's 4th move
	 game.move(6, 1, 5, 2);
	 
	 assertTrue(game.isMoveValid(4, 1, 5, 1)); // Black player's 4th move
	  game.move(4, 1, 5, 1);
	  
	 assertTrue(game.isMoveValid(5, 2, 4, 3)); // White player's 5th move
	  game.move(5, 2, 4, 3);
	  
	 assertTrue(game.isMoveValid(5, 1, 6,1)); // Black player's 5th move
	  game.move(5, 1, 6,1);
	  
	 assertTrue(game.isMoveValid(4, 3, 3, 4)); // White player's 6th move
	  game.move(4, 3, 3, 4);
	  
	 assertTrue(game.isMoveValid(6, 1, 7, 1)); // Black player's winning move.
	 game.move(6, 1, 7, 1);
	 
	 assertEquals(BreakthroughImpl.PlayerType.BLACK, game.getWinner()); // Black Player is the winner.
	  
  }
  
  @Test // Test isMoveValid() method
  
  public void testIsMoveValidAndMakeAMoveWithNoAttack() {
	  
	 assertFalse(game.isMoveValid(3, 3, 2, 3)); // Since the game did not start yet there should be no piece at position (3,3). 

	//Three Valid moves (one straight and two diagonal) of white pieces (fromRow , fromColumn) to (toRow , toColumn)

	  assertTrue(game.isMoveValid(6, 6, 5, 6)); // A valid move from (6,6) to (5,6)

	  assertTrue(game.isMoveValid(6, 6, 5, 7)); // A valid move from (6,6) to (5,7)

	  assertTrue(game.isMoveValid(6, 6, 5, 5)); // A valid move from (6,6) to (5,5)

	 
	//Invalid moves of white pieces (fromRow, fromColumn) to (toRow, toColumn)

	  assertFalse(game.isMoveValid(6, 6, 4, 7));

	  assertFalse(game.isMoveValid(6, 6, 3, 1));
	  
	  game.move(6, 6, 5, 7); // Finally an white piece is moved from position (6,6) to (5,7)
	  	
     /* White player begins the game. Since white player moved, now its the black player turn. 
	  * So (6,1) is not allowed to move since their will be white piece in that position (6,1) and its black player turn to play the game.*/
	 
	  assertFalse(game.isMoveValid(6, 1, 5, 1));
	  
	 
	//Three Valid moves (one straight and two diagonal) of Black pieces (fromRow , fromColumn) to (toRow , toColumn)
	  
	 assertTrue(game.isMoveValid(1, 6, 2, 6)); // A valid move from (1,6) to (2,6)
	 
	 assertTrue(game.isMoveValid(1, 6, 2, 7)); // A valid move from (1,6) to (2,7)
	 
	 assertTrue(game.isMoveValid(1, 6, 2, 5)); // A valid move from (1,6) to (2,5)
	 
	 
	//Invalid moves of Black pieces (fromRow, fromColumn) to (toRow, toColumn)
	 
	 assertFalse(game.isMoveValid(1, 6, 0, 6));
	 
	 assertFalse(game.isMoveValid(1, 6, 1, 5));
	 
	 game.move(1, 6, 2, 6); // Finally an Black piece is moved from position (1,6) to (2,6)
	  
  }
  
  @Test // Test isMoveValid() method to check if the piece moves backward if the player wants his previous position.
  public void testIsMoveValidBackwards() {
	  
	  // White player moves from (6,1) to (5,1)
	  assertTrue(game.isMoveValid(6, 1, 5, 1));
	  game.move(6, 1, 5, 1);
	  
	// Black player moves from (1,1) to (2,1)
	  assertTrue(game.isMoveValid(1, 1, 2, 1));
	  game.move(1, 1, 2, 1);
	  
	  // White player cannot take his move back from (5,1) to (6,1). It's an invalid move
	  assertFalse(game.isMoveValid(5, 1, 6, 1));
	  
  }
  
  @Test // Test isMoveValid() method
  public void testIsMoveValidAndMakeAMoveWithAnAttackOfBlackPiece() {
	  
	  // White Player starts the game and moves first.
	  assertTrue(game.isMoveValid(6, 6, 5, 6));
	  game.move(6, 6, 5, 6);
	  
	  // Black Player's turn
	  assertTrue(game.isMoveValid(1, 6, 2, 7));
	  game.move(1, 6, 2, 7);
	  
	 // White Player's turn
	  assertTrue(game.isMoveValid(5, 6, 4, 6));
	  game.move(5, 6, 4,6);
	  
	// Black Player's turn
	  assertTrue(game.isMoveValid(2, 7, 3, 7));
	  game.move(2, 7, 3, 7);
	  
	// White Player's turn who attacks the black piece at (3,7)
	 assertTrue(game.isMoveValid(4, 6, 3, 7));
	 game.move(4, 6, 3, 7);
	 
	 // Since white player attacks black player at the position (3,7) there should be white piece at position (3,7)
	 assertEquals("white piece present at the position (3,7)", BreakthroughImpl.PieceType.WHITE, game.getPieceAt(3, 7));
	 assertEquals("No piece present at position (4,6)", BreakthroughImpl.PieceType.NONE, game.getPieceAt(4, 6));
	  
  }
  
  
  @Test // Test isMoveValid() method
  public void testIsMoveValidAndMakeAMoveWithAnAttackOfWhitePiece(){
	  
	// White Player starts the game and moves first.
	  assertTrue(game.isMoveValid(6, 3, 5, 3));
	  game.move(6, 3, 5, 3);
	  
	// Black Player's turn
	  assertTrue(game.isMoveValid(1, 3, 2, 3));
	  game.move(1, 3, 2, 3);
	  
	// White Player's turn
	  assertTrue(game.isMoveValid(5, 3, 4,3));
	  game.move(5, 3, 4,3);
	  
	// Black Player's turn
	  assertTrue(game.isMoveValid(2, 3, 3, 2));
	  game.move(2, 3, 3, 2);
	  
	// White Player's turn
	 assertTrue(game.isMoveValid(6, 6, 5, 7));
	 game.move(6, 6, 5, 7);
	 
	// Black Player's turn who attacks the white piece at (4,3)
	 assertTrue(game.isMoveValid(3, 2, 4, 3));
	 game.move(3, 2, 4, 3);
	 
	// Since black player attacks white player at the position (4,3) there should be black piece at position (4,3)
	 assertEquals("Black piece at 4,3", BreakthroughImpl.PieceType.BLACK, game.getPieceAt(4, 3));
	 assertEquals("no piece at 3,2", BreakthroughImpl.PieceType.NONE, game.getPieceAt(3, 2));
	  
  }
  
  @Test // Test move() Method
  public void testWhitePlayerFrontAndDiagonalMoves()
  {
	  // White player's Front move from (6,5) to (5,5)
	  if(game.isMoveValid(6, 5, 5, 5) == true){
	  game.move(6, 5, 5, 5);
	  }
	  assertEquals(BreakthroughImpl.PieceType.WHITE, game.getPieceAt(5, 5)); // white piece present at position (5,5)
	  assertEquals(BreakthroughImpl.PieceType.NONE, game.getPieceAt(6, 5)); // since move done there will be no piece at (6,5)

	  // Black player's move
	  assertTrue(game.isMoveValid(1, 1, 2, 1));
	  game.move(1, 1, 2, 1);
	  
	  // White player's Diagonal move from (6,3) to (5,4)
	  if(game.isMoveValid(6, 3, 5, 4) == true){
		game.move(6, 3, 5, 4);
		  }
		 assertEquals(BreakthroughImpl.PieceType.WHITE, game.getPieceAt(5, 4)); // white piece present at position (5,4)
		 assertEquals(BreakthroughImpl.PieceType.NONE, game.getPieceAt(6, 3)); // since move done there will be no piece at (6,3)
	  
  }
  
  @Test // Test move() Method
  public void testBlackPlayerFrontAndDiagonalMoves()
  {
  
	  // White player will move first 
	  assertTrue(game.isMoveValid(6, 6, 5, 6));
	  game.move(6, 6, 5, 6);
	  
	// Black player's Front move from (1,5) to (2,5)
		  if(game.isMoveValid(1, 5, 2, 5) == true){
		  game.move(1, 5, 2, 5);
		  }
		  assertEquals(BreakthroughImpl.PieceType.BLACK, game.getPieceAt(2, 5)); // Black piece at position (2,5)
		  assertEquals(BreakthroughImpl.PieceType.NONE, game.getPieceAt(1, 5)); // since move done there will be no piece at (1,5)
		  
		// White player's move
		  assertTrue(game.isMoveValid(6, 2, 5, 2));
		  game.move(6, 2, 5, 2);
	 
	  // Black player's Diagonal move from (1,2) to (2,1)
	  if(game.isMoveValid(1, 2, 2, 1) == true){
	  game.move(1, 2, 2, 1);
	  }
	  assertEquals(BreakthroughImpl.PieceType.BLACK, game.getPieceAt(2, 1)); // Black piece at position (2,1)
	  assertEquals(BreakthroughImpl.PieceType.NONE, game.getPieceAt(1, 2)); // since move done there will be no piece at (1,2)
	  

  }
  
  @Test // Test move() Method to check if there is no move done.
  public void testIfThereIsNoMove() {
	  
	  assertFalse(game.isMoveValid(1, 6, 2, 6));
	  
	  assertEquals(BreakthroughImpl.PieceType.BLACK, game.getPieceAt(1, 6));
	  assertEquals(BreakthroughImpl.PieceType.NONE, game.getPieceAt(2, 6));
	  
  }
  
  @Test // Test move() Method to check whether if the player is getting toggled after each valid move
  public void testAfterAValidMovePlayerTurnChange()
  {
	  // White player will move first 
	  if(game.isMoveValid(6, 6, 5, 6) == true){
	  game.move(6, 6, 5, 6);
	  }
	  assertEquals(BreakthroughImpl.PieceType.WHITE, game.getPieceAt(5, 6));
	  assertEquals(BreakthroughImpl.PieceType.NONE, game.getPieceAt(6, 6));
	 
	  // Black player's turn now
	  assertEquals(game.getPlayerInTurn(),BreakthroughImpl.PlayerType.BLACK);
	  
	  //Black player's move
	  if(game.isMoveValid(1, 3, 2, 3) == true){
		  game.move(1, 3, 2, 3);
		  }
		  assertEquals(BreakthroughImpl.PieceType.BLACK, game.getPieceAt(2, 3));
		  assertEquals(BreakthroughImpl.PieceType.NONE,  game.getPieceAt(1, 3));
		 
		// Again White player's turn 
		  assertEquals(game.getPlayerInTurn(),BreakthroughImpl.PlayerType.WHITE);
  
  }
  
}