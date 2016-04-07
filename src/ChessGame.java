import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import Pieces.Bishop;
import Pieces.ChessBoard;
import Pieces.ChessPiece;
import Pieces.King;
import Pieces.Knight;
import Pieces.PiecePosition;
import Pieces.Queen;
import Pieces.Rook;

/**
 * @author hesham380 Main class for genearting the unique layouts
 */
public class ChessGame {
	// Result List: Contains all result boards
	static ArrayList<ChessBoard> res = new ArrayList<>();
	// piecePositions: contains all positions of pieces in the boards to avoid
	// adding duplicates
	static ArrayList<HashSet<PiecePosition>> piecePositions = new ArrayList<>();

	/**
	 * @param board:
	 *            board containing current board layout representation of the
	 *            pieces
	 * @param pieces:
	 *            list containing all remaining chess pieces Recursive method to
	 *            take one piece at a time and fine all applicable positions for
	 *            this piece and recursively generating new boards with every
	 *            applicable position of this chess piece Checking if board
	 *            already exists in chess board to avoid adding duplicates
	 * 
	 *            return: adding all generated boards to res list
	 */
	public void generate(ChessBoard board, ArrayList<ChessPiece> pieces) {

		ArrayList<ChessBoard> newBoard = new ArrayList<>();

		if (!pieces.isEmpty()) {
			newBoard = findPositions(board, pieces, pieces.get(0));
			if (newBoard.isEmpty())
				return;
			ArrayList<ChessPiece> newPieces = new ArrayList<>(pieces);
			newPieces.remove(0);
			for (int j = 0; j < newBoard.size(); j++) {
				generate(newBoard.get(j), newPieces);
			}
		} else {

			if (!checkIfBoardExists(board)) {
				HashSet<PiecePosition> set = new HashSet<>();
				for (int row = 0; row < board.getGrid().length; row++) {
					for (int col = 0; col < board.getGrid()[row].length; col++) {
						if (board.getGrid()[row][col] != null && !board.getGrid()[row][col].equals("X")) {
							PiecePosition currPos = new PiecePosition(row, col, board.getGrid()[row][col]);
							set.add(currPos);
						}
					}
				}
				piecePositions.add(set);
				res.add(board);
			}
		}
	}

	/**
	 * @param board:
	 *            board containing current board layout representation of the
	 *            pieces
	 * @return: checking if a board already exists in the result list of all
	 *          boards
	 */
	public boolean checkIfBoardExists(ChessBoard board) {

		for (HashSet<PiecePosition> positionSet : piecePositions) {
			boolean flag = true;
			for (int row = 0; row < board.getGrid().length; row++) {
				for (int col = 0; col < board.getGrid()[row].length; col++) {
					if (board.getGrid()[row][col] != null && !board.getGrid()[row][col].equals("X")) {
						PiecePosition currPos = new PiecePosition(row, col, board.getGrid()[row][col]);
						if (!positionSet.contains(currPos)) {
							flag = false;
							break;
						}
					}
				}
				if (!flag)
					break;
			}
			if (flag)
				return true;
		}

		return false;
	}

	/**
	 * @param board:
	 *            board containing current board layout representation of the
	 *            pieces
	 * @param pieces:
	 *            List of chess pieces
	 * @param p:
	 *            the current chess piece that we want to find its applicable
	 *            positions
	 * @return returning all applicable positions of piece p by making sure it
	 *         is added in a place where it is not threatened by any other piece
	 *         and doesn't attack any other piece
	 */
	public ArrayList<ChessBoard> findPositions(ChessBoard board, ArrayList<ChessPiece> pieces, ChessPiece p) {
		ArrayList<ChessBoard> res = new ArrayList<>();
		for (int row = 0; row < board.getGrid().length; row++) {
			for (int col = 0; col < board.getGrid()[row].length; col++) {

				if (board.getGrid()[row][col] == null) {
					if (!p.checkThreats(row, col, board, pieces)) {
						ChessBoard newBoard = new ChessBoard(
								new String[board.getGrid().length][board.getGrid()[0].length]);
						for (int i = 0; i < board.getGrid().length; i++) {
							for (int j = 0; j < board.getGrid()[i].length; j++) {
								newBoard.getGrid()[i][j] = board.getGrid()[i][j];
							}
						}
						p.addThreats(row, col, newBoard, pieces);
						newBoard.getGrid()[row][col] = p.toString();
						res.add(newBoard);
					}
				}
			}
		}

		return res;
	}

	/**
	 * Printing all generated unique boards and adding them to output file
	 * 
	 * @param time
	 * @param j
	 */
	public void printBoards(int num, long time) {
		

		System.out.println("Time taken : " + time + " ms");
		System.out.println("Number of unique configurations : " + res.size());
		
		File file;
		FileWriter fw = null;
		try {
			file = new File("Chess Output.txt");
			fw = new FileWriter(file);
			fw.write("Number of unique configurations : " + num);
			fw.write("\n");
			fw.write("Time taken : " + time + " ms");
			fw.write("\n");
			fw.write("\n");
			fw.flush();
			fw.close();

		} catch (IOException e) {
			System.err.println("Error Writing in file");
		}
		for (int i = 0; i < res.size(); i++) {
			res.get(i).printBoard();
			System.out.println();
		}
		

		System.out.println("Time taken : " + time + " ms");
		System.out.println("Number of unique configurations : " + res.size());
	}

	public static void main(String[] args) {

		ArrayList<ChessPiece> pieces = new ArrayList<>();
		
		King king = new King();
		Queen queen = new Queen();
		Bishop bishop = new Bishop();
		Rook rook = new Rook();
		Knight knight = new Knight();
		
		int rows = 1;
		int cols = 1;
		
		//Example 1
//		rows = 3;
//		cols = 3;
//		pieces.add(king);
//		pieces.add(king);
//		pieces.add(rook);
		
		//Example 2
		rows = 4;
		cols = 4;
		pieces.add(knight);
		pieces.add(knight);
		pieces.add(knight);
		pieces.add(knight);
		pieces.add(rook);
		pieces.add(rook);
		
		String[][] grid = new String[rows][cols];
		ChessBoard chessBoard = new ChessBoard(grid);

		ChessGame chessGame = new ChessGame();

		long time = System.currentTimeMillis();
		try {
			chessGame.generate(chessBoard, pieces);
		} finally {
			time = System.currentTimeMillis() - time;
		}
		chessGame.printBoards(res.size(), time);

	}

}
