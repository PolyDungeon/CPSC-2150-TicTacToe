package cpsc2150.extendedTicTacToe.models;


import java.util.*;

/**
 * This class contains the game board. It does not print the board to the screen.
 *
 * @author Hayden Copeland
 * @version project 5.0
 *
 * @invariant toWin <= Rows <= rowColMax AND toWin <= Columns <= rowColMax AND minWin <= numToWin <= maxWin
 *
 * @correspondence Rows = #Rows
 * @correspondence Columns = #Columns
 * @correspondence toWin = #toWin
 */

public class GameBoardMem extends AbsGameBoard implements IGameBoard{
    private static int Rows,Columns,toWin;
    public static int turnCount;
    private static Map<Character, List<BoardPosition>> Board = new HashMap<>();


    /**
     * This constructor helps to create the game board although the map will do most of the work.
     *
     * @param row = board height
     * @param column = board width
     * @param toWins = markers needed to win
     *
     * @pre [3 <= row <= 20] and [3 <= column <= 20] and [3 <= toWins <= 20]
     * @post Rows = #row AND Columns = #column AND toWin = #toWins &&
     * game board is a made with the indicating parameters
     */
    public GameBoardMem(int row, int column, int toWins){
        Board = new HashMap<>();
        Rows = row;
        Columns = column;
        toWin = toWins;
    }
    @Override
    public int getNumRows() {return Rows;}

    @Override
    public int getNumColumns() {return Columns;}

    @Override
    public int getNumToWin() {return toWin;}

    /**
     * places the character in marker on the position specified by
     * marker and should not be called if the space is unavailable.
     *
     * @param marker specifies which position the play is put in
     * @param player indicates which player
     *
     *
     * @pre position indicated is a valid space for the player to play
     * @post the specified position is filled with the player's marker
     */
    @Override
    public void placeMarker(BoardPosition marker, char player) {
        if (!Board.containsKey(player))
        {
            List<BoardPosition> spaces = new LinkedList<>();
            Board.put(player,spaces);
        }
        Board.get(player).add(marker);
        turnCount++;
    }
    /**
     * returns what is in the GameBoard at position pos
     * If no marker is there, it returns a blank space char.
     *
     * @param pos a valid board position
     *
     * @return the GameBoard at position pos
     *
     * @pre pos is within the boundaries of the board
     * @post returns a bool
     */
    @Override
    public char whatsAtPos(BoardPosition pos) {
        for (Map.Entry<Character, List<BoardPosition>> m : Board.entrySet()) {
            List<BoardPosition> tempList = Board.get(m.getKey());
            if (tempList.contains(pos)) {
                return m.getKey();
            }
        }
        return ' ';
    }
    /**
     * returns what is in the GameBoard at position pos
     * If no marker is there, it returns a blank space char.
     *
     * @param pos a valid board position
     * @param player indicates which player
     *
     * @return true if the indicated player is at the board position &&
     * @return false if the indicated player is not at the board position
     *
     * @pre pos is within the boundaries of the board
     * @post returns a bool
     */

    @Override
    public boolean isPlayerAtPos(BoardPosition pos, char player) {
        if (Board.containsKey(player)) {
            List<BoardPosition> tempList = Board.get(player);
            return tempList.contains(pos);
        }
        return false;
    }

    //returns the turnCount
    public int getTurn(){
        return turnCount;
    }

}
