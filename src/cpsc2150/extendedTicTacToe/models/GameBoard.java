package cpsc2150.extendedTicTacToe.models;

/**
 * This class is used to store the information of a Game board in tic-tac-toe.
 *
 * @author David Hayden Copeland
 * @version 5.0
 *
 * @invariant 0 <= row <=4 AND
 * 0 <= column <= 7
 *
 *
 * @correspondence
 * * gameBoardArray = board
 *
 */
public class GameBoard extends AbsGameBoard implements IGameBoard
{
    public static int rowNum;
    public static int colNum;
    public static int numToWin;
    private char[][] gameBoard = new char[rowColMax][rowColMax];
    public static int turnCount = 0;
    /** initializes the game board to be blank 5x8
     *
     *@param Rows = board height
     *@param Columns = board width
     *@param toWins = markers needed to win
     * @pre [3 <= row <= 20] and [3 <= column <= 20] and [3 <= toWins <= 20]
     * @post game board is a made with the indicating parameters
     */
    public GameBoard(int Rows,int Columns, int toWins)
    {
        rowNum = Rows;
        colNum = Columns;
        numToWin = toWins;
        int i = 0;
        while(i < rowNum)
        {
            for (int j = 0; j < colNum; j++ )
            {
                gameBoard[i][j] = ' ';
            }
            i++;
        }
    }

    /**
     * places the character in marker on the position specified by
     * marker and should not be called if the space is unavailable.
     *
     * @param marker specifies which position the play is put in
     * @param player indicates which player (X or O)
     *
     *
     * @pre position indicated is a valid space for the player to play
     * @post the specified position is filled with the player's marker
     */

    @Override
    public void placeMarker(BoardPosition marker, char player) {
        gameBoard[marker.getRow()][marker.getColumn()] = player;
        turnCount = turnCount + 1;
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
    public char whatsAtPos(BoardPosition pos)
    {
        return gameBoard[pos.getRow()][pos.getColumn()];
    }

    public static int getTurn(){
        return turnCount;
    }
    public int getNumRows(){ return rowNum; }

    public int getNumColumns(){ return colNum; }

    public int getNumToWin(){ return numToWin; }
}
