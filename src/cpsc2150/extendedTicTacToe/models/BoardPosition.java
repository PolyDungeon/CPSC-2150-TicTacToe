package cpsc2150.extendedTicTacToe.models;

/*
 * This class is used to store the information of a BoardPosition in tic tac toe.
 *
 * @author David Hayden Copeland
 * @version 5.0
 *
 * @correspondence
 * gameBoardArray = board
 *
 * @invariant 0 < row <= 20 and 0 < col <= 20
 */


public class BoardPosition
{
    private int row;
    private int column;
    private String convertString;
    /**
     * constructor creates a new row 5 rows and a new column for 8 columns which represents the slots on the board.
     *
     * @param r the number of rows on the board.
     * @param c the number of columns on the board.
     *
     * @pre r >= 0 AND r <= 4 AND c >= 0 AND c <= 7
     * @post row = #r AND column = #c
     */
    public BoardPosition(int r, int c){
        this.row = r;
        this.column = c;
    }


    /**
     * This method is a getter function that returns the row int.
     *
     *
     * @return the variable row.
     *
     * @pre row >= 0 AND row < 20
     * @post getRow = row AND row = #row
     */
    public int getRow()
    {
        return row;
    }
    /**
     * This method is a getter function that returns the column int.
     *
     *
     * @return the variable column.
     *
     * @pre column >= 0 AND column < 20
     * @post getColumn = column AND column = #column
     */
    public int getColumn()
    {
        return  column;
    }
    /**
     * This method is a function that checks whether two board-positions are equal.
     *
     * @param b The position that this current board position is. AND
     *        column The column that this current board position contains.
     *        YorN
     * @return true or false.
     *
     * @pre column >= 0 AND column <= 20
     *      row >= 0 AND row <= 20
     * @post YorN = (comparePos.row == this.row && comparePos.column == this.column)
     *
     * @Override public String toString(BoardPosition pos)
     */

    public boolean equals(Object b)
    {
        if(!(b instanceof BoardPosition))
        {
            return false;
        }
        boolean returnPos = (row == ((BoardPosition) b).getRow()) && (column == ((BoardPosition) b).getColumn());
        return returnPos;
    }


    /**
     * This method is a function that checks whether two board-positions are equal.
     *
     * convertString the string contains the row and the column to the format t "<row>,<column>."
     *
     * @return the variable convertString .
     *
     * @pre column >= 0 AND column < 20 AND
     *      row >= 0 AND row < 20
     *
     * @post convertString = "[row],[column]" AND
     * row = #row AND column = #column
     *
     *
     */
    @Override
    public String toString()
    {
        convertString = getRow() + "," + getColumn();
        return convertString;
    }

}
