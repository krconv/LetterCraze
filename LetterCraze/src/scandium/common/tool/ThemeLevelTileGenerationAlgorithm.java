package scandium.common.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import scandium.common.model.Board;
import scandium.common.model.BoardSquare;
import scandium.common.model.ThemeLevel;
import scandium.common.model.Tile;

public class ThemeLevelTileGenerationAlgorithm {

	/**
	 * Populates the given level's board with tiles that have a list of words.
	 * 
	 * @param level The ThemeLevel to be populated
	 * @param seed The seed to use for the random algorithm.
	 */
	public static void populateThemeLevelWithTiles(ThemeLevel level, long seed){
		/* Get the Board */
		Board board = level.getBoard();
		
		/* Remove existing tiles from board */
		board.clearExistingTiles();
		
		/* Get The Theme Words and sort them */
		List<String> words = level.getThemeWords();
		if(!words.isEmpty()){
			words = sortWordsByLength(words);
			/* Insert First Word */
			while(!words.isEmpty() && !insertFirstWord(words.remove(0), board));
			
			Random random = new Random(seed);
			/* Insert remaining words */
			for(String w : words){
				insertWord(w, board, random);
			}
		}
		/* Populate empty squares with random tiles */
		board.fillEmptySquares(new LetterDictionary());
	}
	
	/** 
	 * Sorts a list of words by their length.
	 * @param words The words to sort.
	 * @return The sorted list.
	 */
	static List<String> sortWordsByLength(List<String> words){
		List<String> sorted = new ArrayList<String>();
		while(!words.isEmpty()){
			int length = -1;
			String smallest_word = "";
			for(String word : words){
				int temp_length = word.length();
				if(temp_length > length || length == -1){
					length = temp_length;
					smallest_word = word;
				}
			}
			sorted.add(smallest_word);
			words.remove(smallest_word);
		}
		return sorted;
	}
	
	/**
	 * Inserts the given word into the given board.
	 * 
	 * @param word The String word to be inserted into the board
	 * @param board The Board to insert the word into.
	 * @param random The random generator to use.
	 * @return Whether the word was inserted or not.
	 */
	static boolean insertWord(String word, Board board, Random random){
		ArrayList<Tile> tiles = convertToTiles(word);
		if(numberOfEmptySquares(board) < tiles.size()) return false;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				boolean[][] word_inserts = new boolean[6][6];
				if(random.nextBoolean() || random.nextBoolean()) continue;
				for(int m = 0; m < 6; m++){
					for(int n = 0; n < 6; n++){
						word_inserts[m][n] = false;
					}
				}
				if(insertTilesAt(i, j, tiles, board, word_inserts)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Inserts the first word.
	 * 
	 * @param word The given word to insert into the board.
	 * @param board The board to insert the given word into.
	 * @return Whether the word was inserted or not.
	 */
	static boolean insertFirstWord(String word, Board board){
		ArrayList<Tile> tiles = convertToTiles(word);
		if(numberOfEmptySquares(board) < tiles.size()) return false;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(insertFirstTilesAt(i, j, tiles, board)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Inserts the given word into the board at the given row and column.
	 * It will insert tiles onto BoardSquares that already has tiles.
	 * The old tiles are moved down, such that gravity will reform them during game play. 
	 * Tiles are placed pseudo-randomly.
	 * @param row The row to try to insert this word into
	 * @param col The column to try to insert this word into
	 * @param tiles The ArrayList of tiles representing the word
	 * @param board The Board in which to insert the word
	 * @param word_inserts. A 2 Dimensional Array of boolean showing where this word has been placed. 
	 * (can't place tiles on BoardSquares populated from this word)
	 * @return Whether the word was inserted or not. 
	 */
	static boolean insertTilesAt(int row, int col, ArrayList<Tile> tiles, Board board, boolean[][] word_inserts){
		/* Determine if the entire word has been placed */
		if(tiles.isEmpty()) return true;
		/* Determine if its okay to add a tile to this BoardSquare */
		if(row < 0 || row > 5 || col < 0 || col > 5) return false;
		if(word_inserts[row][col]) return false;
		BoardSquare square = board.getSquare(row, col);
		if(!square.isEnabled()) return false;
		if(!canInsertIntoSquare(row, col, board)) return false;
		
		/* Get tile for this board Square and remove it from the ArrayList */
		Tile tile = tiles.remove(0);
		
		/* Add tile to square */
		boolean gravity = false;
		if(!square.isEmpty()){
			gravity = true;
			applyGravity(row, col, board, word_inserts);
		}
		square.setTile(tile);
		word_inserts[row][col] = true;
		
		/* Try to continue inserting tiles */
		boolean canInsert = false;
		if(!canInsert) canInsert = insertTilesAt(row-1, col, tiles, board, word_inserts);
		if(!canInsert) canInsert = insertTilesAt(row-1, col+1, tiles, board, word_inserts);
		if(!canInsert) canInsert = insertTilesAt(row-1, col-1, tiles, board, word_inserts);
		if(!canInsert) canInsert = insertTilesAt(row, col+1, tiles, board, word_inserts);
		if(!canInsert) canInsert = insertTilesAt(row, col-1, tiles, board, word_inserts);
		if(!canInsert) canInsert = insertTilesAt(row+1, col+1, tiles, board, word_inserts);
		if(!canInsert) canInsert = insertTilesAt(row+1, col, tiles, board, word_inserts);
		if(!canInsert) canInsert = insertTilesAt(row+1, col-1, tiles, board, word_inserts);
		
		
		/* Insert this tile back into the list */
		tiles.add(0, tile);
		
		/* If can't Insert */
		if(!canInsert){
			word_inserts[row][col] = false;
			if(gravity){
				removeGravity(row, col, board, word_inserts);
			}else
				square.setTile(null);
			return false;
		}
		return true;
	}
	
	/** 
	 * Inserts the first word into the board at the given row and column. 
	 * It works recursively to insert all tiles. It will only insert tiles into
	 * empty BoardSquares.  It returns false if the word
	 * could not be inserted at this location. 
	 * @param row The row to try to insert this word into 
	 * @param col The column to try to insert this word into 
	 * @param tiles The ArrayList of tiles representing the word
	 * @param board The board in which to insert the word
	 * @return Whether the word was inserted or not.
	 */
	static boolean insertFirstTilesAt(int row, int col, ArrayList<Tile> tiles, Board board){
		if(tiles.isEmpty()) return true;
		/* Determine if its okay to add a tile to this boardSquare */
		if(row < 0 || row > 5 || col < 0 || col > 5) return false;
		BoardSquare square = board.getSquare(row, col);
		if(!square.isEnabled()) return false;
		if(!square.isEmpty()) return false;
		
		/* Get tile for this board Square and remove it from the ArrayList */
		Tile tile = tiles.remove(0);
		
		/* Add tile to square */
		square.setTile(tile);
		
		/* Try to continue inserting tiles */
		boolean canInsert = false;
		if(!canInsert) canInsert = insertFirstTilesAt(row-1, col, tiles, board);
		if(!canInsert) canInsert = insertFirstTilesAt(row-1, col+1, tiles, board);
		if(!canInsert) canInsert = insertFirstTilesAt(row-1, col-1, tiles, board);
		if(!canInsert) canInsert = insertFirstTilesAt(row, col+1, tiles, board);
		if(!canInsert) canInsert = insertFirstTilesAt(row, col-1, tiles, board);
		if(!canInsert) canInsert = insertFirstTilesAt(row+1, col+1, tiles, board);
		if(!canInsert) canInsert = insertFirstTilesAt(row+1, col, tiles, board);
		if(!canInsert) canInsert = insertFirstTilesAt(row+1, col-1, tiles, board);
		
		/* Insert this tile back into list */
		tiles.add(0, tile);
		
		/* If can't insert */
		if(!canInsert){
			square.setTile(null);
			return false;
		}
		
		return true;
	}	
	
	/**
	 * Applies gravity to the given column above a given row in the given
	 * board. It does this so that a word can be inserted at this tile.
	 * @param row The row above which to apply gravity
	 * @param col The column which to apply gravity
	 * @param board The Board to apply gravity to
	 * @param word_inserts The word inserts.
	 */
	static void applyGravity(int row, int col, Board board, boolean[][] word_inserts){
		for(int i = 5; i > row; i--){
			BoardSquare insertee = board.getSquare(i, col);
			if(insertee.isEnabled() && !word_inserts[i][col]){
				for(int j = i-1; j >= row; j--){
					BoardSquare inserter = board.getSquare(j, col);
					if(inserter.isEnabled() && !word_inserts[j][col]){
						Tile tile = inserter.getTile();
						inserter.setTile(null);
						insertee.setTile(tile);
						break;
					}
				}
			}
		}
	}
	
	/**
	 * Removes the effects of applying gravity. 
	 * It is used when gravity was applied, but it turns out the tile could not be inserted. 
	 * @param row The row above which gravity was applied
	 * @param col The column in which gravity was applied
	 * @param board The board in which gravity was applied
	 * @param word_inserts The word inserts.
	 */
	static void removeGravity(int row, int col, Board board, boolean[][] word_inserts){
		for(int i = row; i < 5; i++){
			BoardSquare insertee = board.getSquare(i, col);
			if(insertee.isEnabled() && !word_inserts[i][col]){
				for(int j = i+1; j < 6; j++){
					BoardSquare inserter = board.getSquare(j, col);//thing
					if(inserter.isEnabled() && !word_inserts[j][col]){
						Tile tile = inserter.getTile();
						inserter.setTile(null);
						insertee.setTile(tile);
						break;
					}
				}
			}
		}
	}
	
	/**
	 * Determines if a tile can be inserted into the board at the given row and
	 * column.
	 * 
	 * @param row
	 *            The row of the board square
	 * @param col
	 *            The col of the board Square
	 * @param board
	 *            The board to be inserted into
	 * @return Returns true if the BoardSquare is empty, or if the BoardSquare
	 *         is occupied and their is an empty BoardSquare below it in the
	 *         same column. Otherwise it returns false.
	 */
	static boolean canInsertIntoSquare(int row, int col, Board board){
		for(int i = row; i < 6; i++){
			BoardSquare square = board.getSquare(i, col);
			if(square.isEmpty() && square.isEnabled()) return true;
		}
		return false;
	}
	
	/** 
	 * Determines the number of open squares in the Board.
	 * @param board The board in question
	 * @return the number of empty squares
	 */
	static int numberOfEmptySquares(Board board){
		int count = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(board.getSquare(i, j).isEmpty() && board.getSquare(i, j).isEnabled()) count++;
			}
		}
		return count;
	}
	
	/**
	 * Converts the given word into an ArrayList of tiles. 
	 * @param word The word to be converted into tiles.
	 * @return the tiles created from this word
	 */
	static ArrayList<Tile> convertToTiles(String word){
		LetterDictionary dictionary = new LetterDictionary();
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		String contents = word.toUpperCase();
		
		while(contents.length() > 0){
			String letter;
			int score;
			if(contents.length() >= 2){
				letter = contents.substring(0, 2);
				if(letter.equals("QU")){
					score = dictionary.getLetterScore(letter);
					tiles.add(new Tile(letter, score));
					contents = contents.substring(2, contents.length());
					continue;
				}
			}
			letter = contents.substring(0, 1);
			score = dictionary.getLetterScore(letter);
			tiles.add(new Tile(letter, score));
			contents = contents.substring(1, contents.length());
		}
		return tiles;
	}
	
}
