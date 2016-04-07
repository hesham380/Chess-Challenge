package Pieces;

import java.util.ArrayList;

/**
 * @author hesham380
 * Chess Piece Parent Class
 */
public abstract class ChessPiece implements Comparable<ChessPiece> {
	/**
	 * This variable denotes type of piece ex: K , Q , N , B , R
	 */
	String type;
	int priority;
	
	/**
	 * This function is for checking if a specific piece is added in position (row,col) will not 
	 * threaten any other piece. This method is overridden by every subclass with a different implementation
	 * according to type of piece
	 * @param row 
	 * @param col
	 * @param board
	 * @param pieces
	 * @return
	 */
	public abstract boolean checkThreats(int row, int col, ChessBoard board,
			ArrayList<ChessPiece> pieces);
	
	/** This function is to mark the position that a specific piece attacks
	 * This method is overridden by every subclass with a different implementation
	 * according to type of piece
	 * @param row
	 * @param col
	 * @param board
	 * @param pieces
	 */
	public abstract void addThreats(int row, int col, ChessBoard board,
			ArrayList<ChessPiece> pieces) ;


	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		ChessPiece other = (ChessPiece) obj;
		if (!type.equals(other.type))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ChessPiece p){
		return p.priority - this.priority;
	}
	
	
}
