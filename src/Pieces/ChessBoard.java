package Pieces;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author hesham380
 * Object to represent board containing the chess pieces
 */

public class ChessBoard {

	String[][] grid;

	/**
	 * Function print board in readable format
	 */
	public void printBoard() {
		String output = boardToString();
		System.out.println(output);
		FileWriter fw = null;
		File file;
		try {
			file = new File("Chess Output.txt");
			fw = new FileWriter(file, true);
			fw.write(output);
			fw.write("\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.err.println("Error Writing in file");
		}
	}

	/**
	 * Helper Function print board in readable format
	 */
	public String boardToString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				sb.append("|");
				sb.append("---");
			}
			sb.append("|\n");
			for (int col = 0; col < grid[0].length; col++) {
				sb.append("| ");
				if (grid[row][col] == null || grid[row][col].equals("X"))
					sb.append(" ");
				else
					sb.append(grid[row][col]);
				sb.append(" ");
			}
			sb.append("|\n");
		}
		for (int col = 0; col < grid[0].length; col++) {
			sb.append("|");
			sb.append("---");
		}
		sb.append("|\n");

		return sb.toString();
	}

	public ChessBoard(String[][] grid) {
		this.grid = grid;
	}

	public String[][] getGrid() {
		return grid;
	}

	public void setGrid(String[][] grid) {
		this.grid = grid;
	}

}
