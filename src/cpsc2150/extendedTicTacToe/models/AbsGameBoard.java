package cpsc2150.extendedTicTacToe.models;


/**
 * This method provides a string representation of the GameBoard.
 *
 * @return A string that represents the GameBoard.
 *
 * @pre
 * @post toString = [A string that represents the GameBoard] AND board[4][7] = #board[4][7]
 */
public abstract class AbsGameBoard implements IGameBoard
{

    /**
     * creates one string that shows the entire game board.
     *
     *
     *
     * @return  row and column separated by a comma
     *
     */


    @Override
    public String toString()
    {
        int rowInput = getNumRows();
        int colInput = getNumColumns();
        String returnString = "   ";

        for (int k = 0; k < colInput; k++)
        {
            returnString = returnString.concat(String.format("%2d|", k));
        }
        returnString = returnString.concat("\n");
        int i = 0;
        while(i < rowInput)
        {
            for (int j = 0; j < colInput; j++ )
            {
                BoardPosition pos = new BoardPosition(i, j);
                if(j == 0) {
                    returnString = returnString.concat(String.format("%2d", i));
                }
                returnString = returnString.concat("|");
                returnString = returnString.concat(String.valueOf(whatsAtPos(pos)));
                returnString  = returnString.concat(" ");
            }
            returnString = returnString.concat("|");
            returnString = returnString.concat("\n");
            i++;
        }
        return returnString;
    }
}
