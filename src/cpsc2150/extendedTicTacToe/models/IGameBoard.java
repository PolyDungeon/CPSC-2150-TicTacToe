package cpsc2150.extendedTicTacToe.models;
/**
 * This class contains the game board interface. GameBoard and GameBoardMem implement the methods in this class to create varying types of
 * board types based on either arrays or a hash
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

public interface IGameBoard
{
    public static final int rowColMax = 100;
    public static final int minWin = 3;
    public static final int maxWin = 25;
    /**
     * returns true if the position specified in pos is available;
     * false otherwise. If a space is not in bounds, then it is not available
     *
     * @param pos is position that is going to be checked whether it's available or not
     *
     * @return The availability of the position specified
     *
     * @pre pos = [a valid object according to BoardPosition]
     * @post pos = #pos
     *
     */

    default public boolean checkSpace(BoardPosition pos)
    {
        if (whatsAtPos(pos) == ' ')
        {
            return true;
        }
        else
        {
            return false;
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
    public void placeMarker(BoardPosition marker, char player);

    /**
     * this function will check to see if the lastPos placed resulted
     * in a winner. If so it will return true, otherwise false.
     * Passing in the last position will help limit the possible
     * places to check for a win condition since you can assume that any win
     * condition that did not include the most recent play made would have
     * been caught earlier.
     *
     * @param lastPos the position of the last move
     *
     * @return whether or a not a play has won the game
     *
     * @pre lastPos = [a valid object according to BoardPosition]
     * @post returns a bool value
     */

    default public boolean checkForWinner(BoardPosition lastPos)
    {
        char player = whatsAtPos(lastPos);

        if (player == ' ')
            return false;
        if (checkDiagonalWin(lastPos, player))
        {
            return true;
        }
        if (checkHorizontalWin(lastPos, player))
        {
            return true;
        }
        if(checkVerticalWin(lastPos, player))
        {
            return true;
        }
        else
            return false;


    }


    /**
     * this function will check to see if the game has resulted in a
     * tie. A game is tied if there are no free board positions remaining.
     * You do not need to check for any potential wins because we can assume
     * that the players were checking for win conditions as they played the
     * game. It will return true if the game is tied and false otherwise.
     *
     *
     * @return whether the two players have tied or not
     *
     * @pre NONE
     * @post checkForDraw() = true iff there are no board positions left that equal == ' '] OR checkForDraw() = false iff any [pos = ' ']
     */
    default public boolean checkForDraw()
    {
        int i = 0;
        while(i < getNumRows())
        {
            for (int j = 0; j < getNumColumns(); j++ )
            {
                char checkBP = whatsAtPos(new BoardPosition(i, j));
                if (checkBP == ' ')
                {
                    return false;
                }


            }
            i++;
        }
        return true;
    }
    /**
     * checks to see if the last marker placed resulted in 5 in a row
     * horizontally. Returns true if it does, otherwise false
     *
     * @param lastPos the position of the last move
     * @param player indicates which player (X or O)
     *
     * @return checkHorizontalWin = true OR checkHorizontalWin = false
     *
     * @pre lastPos is within the boundaries of the board
     * @post (checkHorizontalWin = true iff there are numToWin  OR checkHorizontalWin = false) AND
     * board = #board
     */
    default public boolean checkHorizontalWin(BoardPosition lastPos, char player)
    {
        int colNum = getNumColumns();
        int untilWin = 0;
        final int numtoWin = getNumToWin();
        int i = lastPos.getColumn(); // i is where the column is
        for (int col = 0; col < colNum; col++)
        {
            if (whatsAtPos(new BoardPosition(lastPos.getRow(), col)) == player)
            {
                untilWin++;
            }
            if (whatsAtPos(new BoardPosition(lastPos.getRow(), col)) != player)
            {
                untilWin = 0;
            }
            if (untilWin == numtoWin)
            {
                return true;
            }
        }
        return false;
    }
    /**
     * checks to see if the last marker placed resulted in 5 in a row
     * vertically. Returns true if it does, otherwise false
     *
     * @param lastPos the position of the last move
     * @param player indicates which player (X or O)
     *
     * @return checkVerticalWin = true OR checkVerticalWin = false
     *
     * @pre lastPos is within the boundaries of the board
     * @post (checkVerticalWin = true OR checkVerticalWin = false) AND
     * board = #board
     */
    default public boolean checkVerticalWin(BoardPosition lastPos, char player)
    {
        int rowNum = getNumRows();
        int untilWin = 0;
        final int numtoWin = getNumToWin();
        int col = lastPos.getColumn(); // i is where the column is
        for (int row = 0; row < rowNum; row++)
        {
            if (whatsAtPos(new BoardPosition(row, col)) == player)
            {
                untilWin++;
            }
            if (whatsAtPos(new BoardPosition(row, col)) != player)
            {
                untilWin = 0;
            }
            if (untilWin == numtoWin)
            {
                return true;
            }
        }
        return false;
    }
    /**
     * checks to see if the last marker placed resulted in 5 in a row
     * diagonally. Returns true if it does, otherwise false
     *
     * @param lastPos the position of the last move
     * @param player indicates which player (X or O)
     *
     * @return checkDiagonalWin = true OR checkDiagonalWin = false
     *
     * @pre lastPos is within the boundaries of the board
     * @post (checkDiagonalWin = true OR checkDiagonalWin = false) AND
     * board = #board
     */
    default public boolean checkDiagonalWin(BoardPosition lastPos, char player)
    {
        int rowNum = getNumRows();
        int colNum = getNumColumns();
        char startChar = whatsAtPos(new BoardPosition(lastPos.getRow(),lastPos.getColumn()));
        if (player == ' ')
        {
            return false;
        }
        if (startChar == player) {
            //check to the right
            int i = lastPos.getRow(); // i is where the column is
            int j = lastPos.getColumn();
            while (i >= 0 && j >= 0 && i < rowNum && j < colNum) //move board position to check to the farthest right of the board that matches player
            {
                if ((i - 1) >= 0 && (j + 1) <= (colNum - 1) && whatsAtPos(new BoardPosition(i - 1, j + 1)) == player)
                {
                    i--;
                    j++;
                }
                else
                    break;
            }
            int iFive = (i) + (getNumToWin() - 1);
            int jFive = (j) - (getNumToWin() - 1);

            if(jFive >= 0 && iFive < rowNum)
            {

                while (i < rowNum && j >= 0 && whatsAtPos(new BoardPosition(i, j)) == player) // iterates through i as many times as position i matches player. makes sure it doesn't go past 7
                { // to the top right
                    if ((j - 1) >= 0 && (i + 1) < rowNum) {
                        i++;
                        j--;
                    }
                    if (i == iFive && j == jFive && whatsAtPos(new BoardPosition(i, j)) == player) {
                        return true;
                    }
                }

            }

            //check to the left
            i = lastPos.getRow(); // i is where the column is
            j = lastPos.getColumn();
            while (i >= 0 && j >= 0 && i < rowNum && j < rowNum) //move board position to check to the farthest left of the board that matches player
            {
                if ((j - 1) >= 0 && (i - 1) >= 0 && whatsAtPos(new BoardPosition(i - 1, j - 1)) == player)
                {
                    i--;
                    j--;
                }
                else
                {
                    break;
                }
            }
            iFive = (i) + (getNumToWin() - 1);
            jFive = (j) + (getNumToWin() - 1);
            if(jFive < colNum && iFive < rowNum)
            {
                while (i < rowNum && j < colNum && whatsAtPos(new BoardPosition(i, j)) == player) // iterates through i as many times as position i matches player. makes sure it doesn't go past 7
                { // to the top right

                    if ((j + 1) < colNum && (i + 1) < rowNum) {
                        i++;
                        j++;
                    }
                    if (i == iFive && j == jFive && whatsAtPos(new BoardPosition(i, j)) == player) {
                        return true;
                    }

                }

            }
        }
        return false;
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
    public char whatsAtPos(BoardPosition pos);

    /**
     * returns true if the player is at pos; otherwise, it returns false
     *
     * @param pos position that is going to be checked whether the player has a marker there or not
     * @param player indicates which player (X or O)
     *
     * @return isPlayerAtPos = true OR isPlayerAtPos = false
     *
     * @pre NON
     * @post pos = #pos AND player = #player
     */

    default public boolean isPlayerAtPos(BoardPosition pos, char player)
    {
        if (whatsAtPos(pos) == player)
            return true;
        else
            return false;
    }


    /**
     * @description getter for number of rows
     *
     * @return rowMax
     *
     * @pre NONE
     * @post rowMax = #rowMax
     */
    public int getNumRows();

    /**
     * @description getter for number of columns
     *
     * @return columnMax
     *
     * @pre NONE
     * @post columnMax = #columnMax
     */
    public int getNumColumns();

    /**
     * @description getter for number needed to win
     *
     * @return numToWin
     *
     * @pre NONE
     * @post numToWin = #numToWin
     */
    public int getNumToWin();
}
