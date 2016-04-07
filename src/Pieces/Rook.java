package Pieces;

import java.util.ArrayList;

/**
 * @author hesham380
 * Rook Piece Object Class
 */
public class Rook extends ChessPiece{

	public Rook(){
		this.type = "R"; 
	}
	@Override
	public String toString(){
		return type;
	}
	
	@Override
	public boolean checkThreats(int row, int col, ChessBoard board,
			ArrayList<ChessPiece> pieces) {
		// checking pieces in same row
		for (int i = 0; i < board.getGrid()[row].length; i++) {
			if (board.getGrid()[row][i] != null && !board.getGrid()[row][i].equals("X"))
				return true;
		}

		// checking pieces in same col
		for (int i = 0; i < board.getGrid().length; i++) {
			if (board.getGrid()[i][col] != null && !board.getGrid()[i][col].equals("X"))
				return true;
		}
		return false;
	}

	@Override
	public void addThreats(int row, int col, ChessBoard board,
			ArrayList<ChessPiece> pieces) {
		// 		// checking pieces in same row
		for (int i = 0; i < board.getGrid()[row].length; i++) {
			board.getGrid()[row][i] = "X";
		}

		// checking pieces in same col
		for (int i = 0; i < board.getGrid().length; i++) {
			board.getGrid()[i][col] = "X";
		}
		
	}

}
