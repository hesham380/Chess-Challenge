package Pieces;

import java.util.ArrayList;

/**
 * @author hesham380
 * Queen Piece Object Class
 */
public class Queen extends ChessPiece {

	public Queen(){
		this.type = "Q"; 
		this.priority = 5;
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
		// checking pieces in same row
		for (int i = 0; i < board.getGrid()[row].length; i++) {
			board.getGrid()[row][i] = "X";
		}

		// checking pieces in same col
		for (int i = 0; i < board.getGrid().length; i++) {
			board.getGrid()[i][col] = "X";
		}

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
