package Pieces;

import java.util.ArrayList;

/**
 * @author hesham380
 * King Piece Object Class
 */
public class King extends ChessPiece{
	
	public King(){
		this.type = "K";
		this.priority = 1;
	}
	
	@Override
	public String toString(){
		return type;
	}
	
	@Override
	public boolean checkThreats(int row, int col, ChessBoard board,
			ArrayList<ChessPiece> pieces) {
		
		// checking cell top & bottom
				if (row == 0) {
					if (board.getGrid()[row + 1][col] != null && !board.getGrid()[row + 1][col].equals("X"))
						return true;
				} else if (row == board.getGrid().length - 1) {
					if (board.getGrid()[row - 1][col] != null && !board.getGrid()[row - 1][col].equals("X"))
						return true;
				} else {
					if (board.getGrid()[row + 1][col] != null && !board.getGrid()[row + 1][col].equals("X"))
						return true;
					if (board.getGrid()[row - 1][col] != null && !board.getGrid()[row - 1][col].equals("X"))
						return true;
				}

				// checking cell left & right
				if (col == 0) {
					if (board.getGrid()[row][col + 1] != null && !board.getGrid()[row][col + 1].equals("X"))
						return true;
				} else if (col == board.getGrid()[0].length - 1) {
					if (board.getGrid()[row][col - 1] != null && !board.getGrid()[row][col - 1].equals("X"))
						return true;
				} else {
					if (board.getGrid()[row][col + 1] != null && !board.getGrid()[row][col + 1].equals("X"))
						return true;

					if (board.getGrid()[row][col - 1] != null && !board.getGrid()[row][col - 1].equals("X"))
						return true;
				}

				// checking cell diagonal
				if (col == 0 && row == 0) {
					if (board.getGrid()[row + 1][col + 1] != null
							&& !board.getGrid()[row + 1][col + 1].equals("X"))
						return true;
				} else if (col == board.getGrid()[0].length - 1 && row == 0) {
					if (board.getGrid()[row + 1][col - 1] != null
							&& !board.getGrid()[row + 1][col - 1].equals("X"))
						return true;
				} else if (col == 0 && row == board.getGrid().length - 1) {
					if (board.getGrid()[row - 1][col + 1] != null
							&& !board.getGrid()[row - 1][col + 1].equals("X"))
						return true;
				} else if (col == board.getGrid()[0].length - 1 && row == board.getGrid().length - 1) {
					if (board.getGrid()[row - 1][col - 1] != null
							&& !board.getGrid()[row - 1][col - 1].equals("X"))
						return true;
				} else if (row == 0) {
					if (board.getGrid()[row + 1][col - 1] != null
							&& !board.getGrid()[row + 1][col - 1].equals("X"))
						return true;
					if (board.getGrid()[row + 1][col + 1] != null
							&& !board.getGrid()[row + 1][col + 1].equals("X"))
						return true;
				} else if (col == 0) {
					if (board.getGrid()[row - 1][col + 1] != null
							&& !board.getGrid()[row - 1][col + 1].equals("X"))
						return true;
					if (board.getGrid()[row + 1][col + 1] != null
							&& !board.getGrid()[row + 1][col + 1].equals("X"))
						return true;
				} else if (row == board.getGrid().length - 1) {
					if (board.getGrid()[row - 1][col - 1] != null
							&& !board.getGrid()[row - 1][col - 1].equals("X"))
						return true;
					if (board.getGrid()[row - 1][col + 1] != null
							&& !board.getGrid()[row - 1][col + 1].equals("X"))
						return true;
				} else if (col == board.getGrid().length - 1) {
					if (board.getGrid()[row + 1][col - 1] != null
							&& !board.getGrid()[row + 1][col - 1].equals("X"))
						return true;
					if (board.getGrid()[row - 1][col - 1] != null
							&& !board.getGrid()[row - 1][col - 1].equals("X"))
						return true;
				}
				return false;
	}

	@Override
	public void addThreats(int row, int col, ChessBoard board,
			ArrayList<ChessPiece> pieces) {
		// checking cell top & bottom
		if (row == 0) {
			board.getGrid()[row + 1][col] = "X";

		} else if (row == board.getGrid().length - 1) {
			board.getGrid()[row - 1][col] = "X";
		} else {
			board.getGrid()[row + 1][col] = "X";
			board.getGrid()[row - 1][col] = "X";
		}

		// checking cell left & right
		if (col == 0) {
			board.getGrid()[row][col + 1] = "X";
		} else if (col == board.getGrid()[0].length - 1) {
			board.getGrid()[row][col - 1] = "X";
		} else {
			board.getGrid()[row][col + 1] = "X";
			board.getGrid()[row][col - 1] = "X";
		}

		// checking cell diagonal
		if (col == 0 && row == 0) {
			board.getGrid()[row + 1][col + 1] = "X";
		} else if (col == board.getGrid()[0].length - 1 && row == 0) {
			board.getGrid()[row + 1][col - 1] = "X";
		} else if (col == 0 && row == board.getGrid().length - 1) {
			board.getGrid()[row - 1][col + 1] = "X";
		} else if (col == board.getGrid()[0].length - 1 && row == board.getGrid().length - 1) {
			board.getGrid()[row - 1][col - 1] = "X";
		} else if (row == 0) {
			board.getGrid()[row + 1][col - 1] = "X";
			board.getGrid()[row + 1][col + 1] = "X";
		} else if (col == 0) {
			board.getGrid()[row - 1][col + 1] = "X";
			board.getGrid()[row + 1][col + 1] = "X";
		} else if (row == board.getGrid().length - 1) {
			board.getGrid()[row - 1][col - 1] = "X";
			board.getGrid()[row - 1][col + 1] = "X";
		} else if (col == board.getGrid().length - 1) {
			board.getGrid()[row + 1][col - 1] = "X";
			board.getGrid()[row - 1][col - 1] = "X";
		}
		
	}

}
