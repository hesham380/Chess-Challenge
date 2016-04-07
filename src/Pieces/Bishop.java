package Pieces;

import java.util.ArrayList;

/**
 * @author hesham380
 * Bishop Chess piece Class
 */
public class Bishop extends ChessPiece {

	public Bishop(){
		this.type = "B"; 
		this.priority = 3;
	}
	
	@Override
	public String toString(){
		return type;
	}
	
	@Override
	public boolean checkThreats(int row, int col, ChessBoard board,
			ArrayList<ChessPiece> pieces) {
		// checking pieces in diagonal bottom right
		for (int i = row, j = col; i < board.getGrid().length && j < board.getGrid()[i].length; i++, j++) {
			if (board.getGrid()[i][j] != null && !board.getGrid()[i][j].equals("X"))
				return true;
		}

		// checking pieces in diagonal top left
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board.getGrid()[i][j] != null && !board.getGrid()[i][j].equals("X"))
				return true;
		}

		// checking pieces in diagonal bottom left
		for (int i = row, j = col; i < board.getGrid().length && j >= 0; i++, j--) {
			if (board.getGrid()[i][j] != null && !board.getGrid()[i][j].equals("X"))
				return true;
		}

		// checking pieces in diagonal top right
		for (int i = row, j = col; i >= 0 && j < board.getGrid()[i].length; i--, j++) {
			if (board.getGrid()[i][j] != null && !board.getGrid()[i][j].equals("X"))
				return true;
		}

		return false;
	}

	@Override
	public void addThreats(int row, int col, ChessBoard board,
			ArrayList<ChessPiece> pieces) {
		// checking pieces in diagonal bottom right
		for (int i = row, j = col; i < board.getGrid().length && j < board.getGrid()[i].length; i++, j++) {
			board.getGrid()[i][j] = "X";
		}

		// checking pieces in diagonal top left
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			board.getGrid()[i][j] = "X";
		}

		// checking pieces in diagonal bottom left
		for (int i = row, j = col; i < board.getGrid().length && j >= 0; i++, j--) {
			board.getGrid()[i][j] = "X";
		}

		// checking pieces in diagonal top right
		for (int i = row, j = col; i >= 0 && j < board.getGrid()[i].length; i--, j++) {
			board.getGrid()[i][j] = "X";
		}

	}

}
