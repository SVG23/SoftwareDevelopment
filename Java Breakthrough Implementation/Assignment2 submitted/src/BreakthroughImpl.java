/** Implementation stub.

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
public class BreakthroughImpl implements Breakthrough {
	private PieceType[][] ChessBoard = new PieceType[8][8];
	public PlayerType playerInTurn = PlayerType.WHITE;
	public static final int WHITE_HOMEROW = 0;
	public static final int BLACK_HOMEROW = 7;
	public PlayerType presentWinner = null;
	public BreakthroughImpl()
	{
		// Initial positions of breakthrough
		// Arranging all the black pieces at rows 0 and 1
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				ChessBoard[i][j] = Breakthrough.PieceType.BLACK;
			}
		}
		
		// Arranging all the white pieces at rows 6 and 7
		for (int i = 6; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				ChessBoard[i][j] = Breakthrough.PieceType.WHITE;
			}
		}
	}
	
	// getPieceAt() method to return the type of piece present at the position given.
  public PieceType getPieceAt( int row, int column ) {
	  
	  if(row<0 ||row>7 || column<0 ||column>7)    // Row and column has index range from 0 to 7.  
		  throw new IndexOutOfBoundsException();   // for all the other index throw an exception
	  
	  if (ChessBoard[row][column] == Breakthrough.PieceType.BLACK
				|| ChessBoard[row][column] == Breakthrough.PieceType.WHITE) {
		  return ChessBoard[row][column];   // Return the piece type at a given position.
		}

		else {
			return PieceType.NONE; // If no piece present at the given position return none.
		}
	  
	 
	  }
	 
  public PlayerType getPlayerInTurn() {
    return playerInTurn;  // Returns the player's turn that who should play the game
  }

  public PlayerType getWinner() {
    return presentWinner;   // returns the final winner of the game.
  }

  /* isMoveValid() method used to verify whether the given row and column combination is a valid move on the chess board or not.
   * It Validates a move from a given location (fromRow, fromColumn) to a new location (toRow, toColumn). 
   * A move is invalid if we try to move our opponent's pieces. */
  
  public boolean isMoveValid(int fromRow, int fromColumn,
          int toRow, int toColumn) {
	  	if(fromRow<0 ||fromRow>7 || fromColumn<0 ||fromColumn>7 ||toRow<0 ||toRow>7 || toColumn<0 ||toColumn>7)
	  					throw new IndexOutOfBoundsException();

	  		if ((getPieceAt(fromRow, fromColumn).toString() == playerInTurn
	  								.toString()) && (ChessBoard[fromRow][fromColumn]==Breakthrough.PieceType.WHITE)) {
	  				
	  		   if ((fromColumn == toColumn&& toRow==fromRow-1 && this.getPieceAt(toRow, toColumn) == PieceType.NONE)) {
	  					
	  									return true;
	  													}
	  			   if ((toColumn == fromColumn + 1 || toColumn == fromColumn - 1)&& (toRow==fromRow-1)
	  							&& ((this.getPieceAt(toRow, toColumn) !=  this.getPieceAt(fromRow, fromColumn))))
	  								{
	  						return true;
			 						}

	  				}

	      if ((getPieceAt(fromRow, fromColumn).toString() == playerInTurn
	  								.toString()) && (ChessBoard[fromRow][fromColumn]==Breakthrough.PieceType.BLACK)) {

	  		  if ((fromColumn == toColumn&& toRow==fromRow+1 && this.getPieceAt(toRow, toColumn) == PieceType.NONE)) {
	  									return true;
	  													}
	  				if ((toColumn == fromColumn + 1 || toColumn == fromColumn - 1)&& (toRow==fromRow+1)
	  							&& ((this.getPieceAt(toRow, toColumn) !=  this.getPieceAt(fromRow, fromColumn))))
	  								{
	  						return true;
			 						}

	  				}
	  			return false;
  }
  
  /* Moves a piece from a given location (fromRow, fromColumn) to a new location (toRow, toColumn). */
  public void move(int fromRow, int fromColumn,
                   int toRow, int toColumn) {
	  if(isMoveValid(fromRow,fromColumn,toRow,toColumn)) // checks whether the move is a valid move or not
	  {
	  Breakthrough.PieceType pieceToMove = this.getPieceAt(fromRow,
				fromColumn);

		ChessBoard[fromRow][fromColumn] = PieceType.NONE;
		ChessBoard[toRow][toColumn] = pieceToMove; // If it is a valid move, that particular piece is moved to the given position.
		this.isThereAWinner();  // It checks for the winner if there is a winner present.
		if(presentWinner != null){
			return;  // Returns if there is a winner of the game.
		}
		this.togglePlayer(); // if there is no winner yet, the turn shifts to the next player
	  }
  }
  
  // isThereAWinner() method checks whether there is a winner present in the game.
  private void isThereAWinner() {
		for(int i = 0; i < 8; i++){
			if(this.getPieceAt(WHITE_HOMEROW, i) == PieceType.WHITE){
				presentWinner = PlayerType.WHITE;
			}
		}
		for(int i = 0; i < 8; i++){
			if(this.getPieceAt(BLACK_HOMEROW, i) == PieceType.BLACK){
				presentWinner = PlayerType.BLACK;
			}
		}
		
	}

  // togglePlayer() method used to toggle the player after every valid move.
	private void togglePlayer() {
		if (playerInTurn == PlayerType.WHITE) {
			playerInTurn = PlayerType.BLACK;
			return;
		}
		if (playerInTurn == PlayerType.BLACK) {
			playerInTurn = PlayerType.WHITE;
			return;
		}
	}
}
