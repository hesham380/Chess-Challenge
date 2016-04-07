package Pieces;

import java.util.ArrayList;

/**
 * @author hesham380
 * Knight Piece Object Class
 */
public class Knight extends ChessPiece {

	public Knight(){
		this.type = "N"; 
		this.priority = 2;
	}
	@Override
	public String toString(){
		return type;
	}
	
	@Override
	public boolean checkThreats(int row, int col, ChessBoard board,
			ArrayList<ChessPiece> pieces) {
		// top moves
		if (row - 2 >= 0) {
			// top left move
			if (col - 1 >= 0) {
				if (board.getGrid()[row - 2][col - 1] != null
						&& !board.getGrid()[row - 2][col - 1].equals("X"))
					return true;
			}
			// top right move
			if (col + 1 < board.getGrid().length) {
				if (board.getGrid()[row - 2][col + 1] != null
						&& !board.getGrid()[row - 2][col + 1].equals("X"))
					return true;
			}
		}

		// bottom moves
		if (row + 2 < board.getGrid().length) {
			// bottom left move
			if (col - 1 >= 0) {
				if (board.getGrid()[row + 2][col - 1] != null
						&& !board.getGrid()[row + 2][col - 1].equals("X"))
					return true;
			}
			// bottom right move
			if (col + 1 < board.getGrid().length) {
				if (board.getGrid()[row + 2][col + 1] != null
						&& !board.getGrid()[row + 2][col + 1].equals("X"))
					return true;
			}
		}

		// left moves
		if (col - 2 >= 0) {
			// left top move
			if (row - 1 >= 0) {
				if (board.getGrid()[row - 1][col - 2] != null
						&& !board.getGrid()[row - 1][col - 2].equals("X"))
					return true;
			}
			// bottom right move
			if (row + 1 < board.getGrid().length) {
				if (board.getGrid()[row + 1][col - 2] != null
						&& !board.getGrid()[row + 1][col - 2].equals("X"))
					return true;
			}
		}

		// right moves
		if (col + 2 < board.getGrid().length) {
			// right top move
			if (row - 1 >= 0) {
				if (board.getGrid()[row - 1][col + 2] != null
						&& !board.getGrid()[row - 1][col + 2].equals("X"))
					return true;
			}
			// right bottom move
			if (row + 1 < board.getGrid().length) {
				if (board.getGrid()[row + 1][col + 2] != null
						&& !board.getGrid()[row + 1][col + 2].equals("X"))
					return true;
			}
		}
		return false;
	}

	@Override
	public void addThreats(int row, int col, ChessBoard board,
			ArrayList<ChessPiece> pieces) {
		// // top moves
		if (row - 2 >= 0) {
			// top left move
			if (col - 1 >= 0) {
				board.getGrid()[row - 2][col - 1] = "X";
			}
			// top right move
			if (col + 1 < board.getGrid().length) {
				board.getGrid()[row - 2][col + 1] = "X";
			}
		}

		// bottom moves
		if (row + 2 < board.getGrid().length) {
			// bottom left move
			if (col - 1 >= 0) {
				board.getGrid()[row + 2][col - 1] = "X";
			}
			// bottom right move
			if (col + 1 < board.getGrid().length) {
				board.getGrid()[row + 2][col + 1] = "X";
			}
		}

		// left moves
		if (col - 2 >= 0) {
			// left top move
			if (row - 1 >= 0) {
				board.getGrid()[row - 1][col - 2] = "X";
			}
			// bottom right move
			if (row + 1 < board.getGrid().length) {
				board.getGrid()[row + 1][col - 2] = "X";
			}
		}

		// right moves
		if (col + 2 < board.getGrid().length) {
			// right top move
			if (row - 1 >= 0) {
				board.getGrid()[row - 1][col + 2] = "X";
			}
			// right bottom move
			if (row + 1 < board.getGrid().length) {
				board.getGrid()[row + 1][col + 2] = "X";
			}
		}

	}

}
