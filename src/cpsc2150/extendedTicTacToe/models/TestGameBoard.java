package cpsc2150.extendedTicTacToe.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestGameBoard {
    // to allow for rounding issues
    private final int rowMax = 3;
    private final int colMax = 3;
    private final int toWinMax = 3;


    private IGameBoard IGameBoardFast(int row, int col, int toWin){
        return new GameBoard(row, col, toWin);
    }


    @Test
    public void testConstMin() {
        //gameBoardFast constructor for minimum
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);

        String checkString = "    0| 1| 2|\n" + " 0|  |  |  |\n" + " 1|  |  |  |\n" + " 2|  |  |  |\n";

        assertTrue(gameBoardFast.toString().equals(checkString) );
    }

    @Test
    public void testConstDifRowCol() {
        //gameBoardFast constructor for a board with a different amount of rows and columns
        final int rowInp = 4;
        final int colInp = 5;
        final int toWinInp = 3;

        IGameBoard gameBoardFast = IGameBoardFast(rowInp, colInp, toWinInp);

        String checkString = "    0| 1| 2| 3| 4|\n" + " 0|  |  |  |  |  |\n" + " 1|  |  |  |  |  |\n" + " 2|  |  |  |  |  |\n" + " 3|  |  |  |  |  |\n";

        assertTrue(gameBoardFast.toString().equals(checkString) );
    }

    @Test
    public void testConstMultiDig() {
        //gameBoardFast constructor for a board with a double digits to ensure everything lines up correctly
        final int rowInp = 11;
        final int colInp = 11;
        final int toWinInp = 11;

        IGameBoard gameBoardFast = IGameBoardFast(rowInp, colInp, toWinInp);

        String checkString = "    0| 1| 2| 3| 4| 5| 6| 7| 8| 9|10|\n" +
                " 0|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 1|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 2|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 3|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 4|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 5|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 6|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 7|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 8|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 9|  |  |  |  |  |  |  |  |  |  |  |\n" +
                "10|  |  |  |  |  |  |  |  |  |  |  |\n";

        assertTrue(gameBoardFast.toString().equals(checkString) );
    }

    @Test
    public void testCheckSpaceIsThere() {
        ////This check space Test is unique because it checks a space for player one on the smallest board
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');

        String checkString = "    0| 1| 2|\n" + " 0|  |  |  |\n" + " 1|  |X |  |\n" + " 2|  |  |  |\n";


         

        assertTrue(gameBoardFast.toString().equals(checkString) );
    }


    @Test
    public void testCheckSpaceDifferentPlayerType() {
        ////This check space Test is unique because it checks a space with a character other than player one
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');

        BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');

        String checkString = "    0| 1| 2|\n" + " 0|O |  |  |\n" + " 1|  |X |  |\n" + " 2|  |  |  |\n";


        assertTrue(gameBoardFast.toString().equals(checkString) );
    }

    @Test
    public void testCheckSpaceDifferentSizeBoard() {
        //This check space Test is unique because it checks a space on a board that is a bigger with double digits.
        final int rowInp = 11;
        final int colInp = 11;
        final int toWinInp = 11;

        IGameBoard gameBoardFast = IGameBoardFast(rowInp, colInp, toWinInp);

        BoardPosition BP = new BoardPosition(10,10);
        gameBoardFast.placeMarker(BP, 'X');




        String checkString = "    0| 1| 2| 3| 4| 5| 6| 7| 8| 9|10|\n" +
                " 0|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 1|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 2|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 3|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 4|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 5|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 6|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 7|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 8|  |  |  |  |  |  |  |  |  |  |  |\n" +
                " 9|  |  |  |  |  |  |  |  |  |  |  |\n" +
                "10|  |  |  |  |  |  |  |  |  |  |X |\n";


        assertTrue(gameBoardFast.toString().equals(checkString) );
    }

    @Test
    public void testHorizontalWin_smallBoard() {
        //This test case is unique and distinct because it checks for a win when there is a valid horizontal streak of 3 on the small board.
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(0,2);
        gameBoardFast.placeMarker(BP, 'X');



        BP = new BoardPosition(2,1);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');



        assertTrue(gameBoardFast.checkHorizontalWin(BP,'X') );
    }

    @Test
    public void testHorizontalWin_bigBoard_win() {
        //This test case is unique and distinct because it checks for a horizontal win in a different row
        // from the middle of the streak, meaning it has to utilize checking the left and right sides
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 4;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,0);
        gameBoardFast.placeMarker(BP, 'X');



        BP = new BoardPosition(3,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,2);
        gameBoardFast.placeMarker(BP, 'X');

        BP = new BoardPosition(1,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(3,3);
        gameBoardFast.placeMarker(BP, 'X');



        assertTrue(gameBoardFast.checkHorizontalWin(BP,'X') );
    }

    @Test
    public void testHorizontalWin_notWin() {
        ////This check space Test is unique because it checks a space with a character other than player one
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(0,2);
        gameBoardFast.placeMarker(BP, 'X');



        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');



        assertFalse(gameBoardFast.checkHorizontalWin(BP,'X') );
    }

    @Test
    public void testHorizontalWin_different_player_win() {
        //This test case is unique and distinct because it checks that a different player than player 1 has won the game
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 4;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(1,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(0,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,3);
        gameBoardFast.placeMarker(BP, 'X');

        BP = new BoardPosition(0,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,1);
        gameBoardFast.placeMarker(BP, 'O');



        assertTrue(gameBoardFast.checkHorizontalWin(BP,'O') );
    }


    @Test
    public void testVerticalWin_smallBoard() {
        //This test case is unique and distinct because it checks for a win when there is a valid vertical streak of 3 on the small board.
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,0);
        gameBoardFast.placeMarker(BP, 'X');



        BP = new BoardPosition(2,1);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(1,0);
        gameBoardFast.placeMarker(BP, 'X');



        assertTrue(gameBoardFast.checkVerticalWin(BP,'X') );
    }

    @Test
    public void testVerticalWin_bigBoard_win() {
        //This test case is unique and distinct because it checks for a vertical win in a different
        //row from the middle of the streak, meaning it has to utilize checking the left and right sides
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 4;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(1,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(0,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,4);
        gameBoardFast.placeMarker(BP, 'X');


        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,2);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(3,4);
        gameBoardFast.placeMarker(BP, 'X');


        assertTrue(gameBoardFast.checkVerticalWin(BP,'X') );
    }

    @Test
    public void testVerticalWin_no_win() {
        //This test case is unique and distinct because it checks the board for a vertical win streak when there are no valid winning streaks on the board
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(0,1);
        gameBoardFast.placeMarker(BP, 'X');



        BP = new BoardPosition(2,1);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(1,0);
        gameBoardFast.placeMarker(BP, 'X');



        assertFalse(gameBoardFast.checkVerticalWin(BP,'X') );
    }

    @Test
    public void testVerticalWin_different_player_win() {
        //This test case is unique and distinct because it checks that a different player than player 1 has won the game in a vertical streak
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 4;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(1,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(0,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,3);
        gameBoardFast.placeMarker(BP, 'X');

        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,2);
        gameBoardFast.placeMarker(BP, 'O');



        assertTrue(gameBoardFast.checkVerticalWin(BP,'O') );
    }

    @Test
    public void testDiagonalWin_smallBoard() {
        //This test case is unique and distinct because it checks for a win when there
        //is a valid diagonal streak of 3 on the small board going from top left corner to bottom right corner.
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');



        BP = new BoardPosition(2,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,1);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'X');



        assertTrue(gameBoardFast.checkDiagonalWin(BP,'X') );
    }

    @Test
    public void testDiagonalWin_bigBoard_win() {
        //This test case is unique and distinct because it checks for a vertical win in a different
        //row from the middle of the streak, meaning it has to utilize checking the left and right sides
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 4;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,3);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'X');


        BP = new BoardPosition(2,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,1);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,0);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(3,1);
        gameBoardFast.placeMarker(BP, 'X');


        assertTrue(gameBoardFast.checkDiagonalWin(BP,'X') );
    }

    @Test
    public void testDiagonalWin_no_win() {
        //This test case is unique and distinct it checks the board for a diagonal win streak when there are no valid winning streaks on the board
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');



        BP = new BoardPosition(1,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(0,2);
        gameBoardFast.placeMarker(BP, 'X');



        assertFalse(gameBoardFast.checkDiagonalWin(BP,'X') );
    }

    @Test
    public void testDiagonalWin_different_player_win() {
        //This test case is unique and distinct because it checks for a diagonal win for a
        //different player than player one and also on a big board with a smaller win streak
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(3,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,3);
        gameBoardFast.placeMarker(BP, 'X');

        BP = new BoardPosition(2,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,1);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,2);
        gameBoardFast.placeMarker(BP, 'O');



        assertTrue(gameBoardFast.checkDiagonalWin(BP,'O') );
    }

    @Test
    public void testDiagonalWin_right_up_4_win() {
        //This test case is unique and distinct because it checks for a diagonal win for a
        //different player than player one and also on a big board with a smaller win streak
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 4;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(3,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,2);
        gameBoardFast.placeMarker(BP, 'X');

        BP = new BoardPosition(2,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,1);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,2);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(0,3);
        gameBoardFast.placeMarker(BP, 'X');



        assertTrue(gameBoardFast.checkDiagonalWin(BP,'X') );
    }

    @Test
    public void testDiagonalWin_different_kind_of_win() {
        //This test case is unique and distinct because it checks the board for a diagonal win when there is a different kind of win on the board
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,2);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');

        BP = new BoardPosition(2,1);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,2);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(0,1);
        gameBoardFast.placeMarker(BP, 'X');



        assertFalse(gameBoardFast.checkDiagonalWin(BP,'X') );
    }

    @Test
    public void testDiagonalWin_left_down_full_board_win() {
        //This test case is unique and distinct because it checks a win from the top left board all the way down to the bottom left. Also checks this for another player.
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 5;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,3);
        gameBoardFast.placeMarker(BP, 'O');

        BP = new BoardPosition(2,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,2);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,0);
        gameBoardFast.placeMarker(BP, 'X');


        BP = new BoardPosition(4,4);
        gameBoardFast.placeMarker(BP, 'O');




        assertTrue(gameBoardFast.checkDiagonalWin(BP,'O') );
    }


    @Test
    public void testCheckForDraw_smallBoard_draw() {
        //This test case is unique and distinct because it checks for a win when there
        //is a valid diagonal streak of 3 on the small board going from top left corner to bottom right corner.
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');



        BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,1);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,2);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'O');



        assertTrue(gameBoardFast.checkForDraw());
    }

    @Test
    public void testCheckForDraw_no_draw() {
        //This test case is unique and distinct because it checks for a draw when there is not a valid draw on the board
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');

        BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,1);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,2);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'O');



        assertFalse(gameBoardFast.checkForDraw());
    }

    @Test
    public void testCheckForDraw_bigBoard_draw() {
        //This test case is unique and distinct because it checks the board for when there is a proper draw on a big board
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 5;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');



        BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(0,2);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(0,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,3);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,3);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,1);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,2);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,4);
        gameBoardFast.placeMarker(BP, 'O');



        assertTrue(gameBoardFast.checkForDraw());
    }

    @Test
    public void testCheckForDraw_EmptyBoard() {
        //This test case is unique and distinct because it checks for a draw when the board is completely empty
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 5;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);



        assertFalse(gameBoardFast.checkForDraw());
    }


    // WhatsAtPos Tests

    @Test
    public void test_whatsAtPos_smallBoard() {
        //this test case is unique because it checks to see if there's a player at 0,0
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');

        assertEquals(gameBoardFast.whatsAtPos(BP), 'X');
    }

    @Test
    public void test_whatsAtPos_biBoard() {
        //this test case is unique because it checks for a player on a bigger board outside the bounds of a board minimum
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 5;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,3);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,4);
        gameBoardFast.placeMarker(BP, 'X');


        assertEquals(gameBoardFast.whatsAtPos(BP), 'X');
    }

    @Test
    public void test_whatsAtPos_emptySpace() {
        //this test case is unique because it checks an empty space
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 5;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,3);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,2);


        assertEquals(gameBoardFast.whatsAtPos(BP), ' ');
    }

    @Test
    public void test_whatsAtPos_differentPlayer() {
        //this test case is unique because it checks for a board position that contains a player other than player one
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 5;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,3);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,2);
        gameBoardFast.placeMarker(BP, 'O');

        assertEquals(gameBoardFast.whatsAtPos(BP), 'O');
    }

    @Test
    public void test_whatsAtPos_outside_Bounds() {
        //this test case is unique because it checks to make sure that the spots outside the bounds of the board are empty
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 5;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,3);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,4);


        assertEquals(gameBoardFast.whatsAtPos(BP), 'X');
    }

    @Test
    public void testIsPlayerAtPos_smallBoard() {
        //This test case is unique and distinct because it checks to see if a player at a position when it is a small board
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');



        BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,0);
        gameBoardFast.placeMarker(BP, 'X');



        assertTrue(gameBoardFast.isPlayerAtPos(BP,'X'));
    }

    @Test
    public void testIsPlayerAtPos_BigBoard() {
        //This test case is unique and distinct because it checks a different position
        // and different board size to see if a player is there
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 5;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,4);
        gameBoardFast.placeMarker(BP, 'X');


        assertTrue(gameBoardFast.isPlayerAtPos(BP,'X'));
    }

    @Test
    public void testIsPlayerAtPos_no_player() {
        //This test case is unique and distinct because it checks to see if a
        //player is at a position when it isn’t to return false
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(1,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');



        BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,1);



        assertFalse(gameBoardFast.isPlayerAtPos(BP,'X'));
    }

    @Test
    public void testIsPlayerAtPos_Check_Different_Player() {
        //This test case is unique and distinct because it checks the board for
        // a position when the player is a player other than player 1
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 5;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(4,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');



        assertTrue(gameBoardFast.isPlayerAtPos(BP,'O'));
    }

    @Test
    public void testIsPlayerAtPos_different_player_is_in_Position() {
        //This test case is unique and distinct because it checks to see if a player is at a position
        // when a different player is already there
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(1,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');



        BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,1);



        assertFalse(gameBoardFast.isPlayerAtPos(BP,'O'));
    }
    @Test
    public void test_placeMarker_smallBoard_last_Spot()
    {
        //This Test is unique because it places a marker at 2,2 (last spot) on the smallest board
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'X');

        String checkString = "    0| 1| 2|\n" + " 0|  |  |  |\n" + " 1|  |  |  |\n" + " 2|  |  |X |\n";


        assertTrue(gameBoardFast.toString().equals(checkString) );
    }
    @Test
    public void test_placeMarker_ZeroZero() {
        //This Test is unique because it places a marker at 0,0 on the smallest board
        final int  rowPos = 3;
        final int  colPos = 3;
        final int  toWinAmnt = 3;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');

        String checkString = "    0| 1| 2|\n" + " 0|X |  |  |\n" + " 1|  |  |  |\n" + " 2|  |  |  |\n";


        assertTrue(gameBoardFast.toString().equals(checkString) );
    }
    @Test
    public void test_placeMarker_bigBoard()
    {
        //this test case is unique because it places marker outside the bounds of 2,2 (min board size)
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 5;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,3);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,4);


        String testString = "    0| 1| 2| 3| 4|\n" +
                " 0|X |  |  |  |  |\n" +
                " 1|  |  |  |  |  |\n" +
                " 2|  |  |  |  |  |\n" +
                " 3|  |  |  |X |O |\n" +
                " 4|  |  |  |O |  |\n";
        assertEquals(gameBoardFast.toString(),testString);
    }

    @Test
    public void test_placeMarker_ThreePlayers()
    {
        //this test case is unique because it places three different characters on the board
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 5;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,4);
        gameBoardFast.placeMarker(BP, 'U');


        String testString = "    0| 1| 2| 3| 4|\n" +
                " 0|X |  |  |  |  |\n" +
                " 1|  |  |  |  |  |\n" +
                " 2|  |  |  |  |  |\n" +
                " 3|  |  |  |  |O |\n" +
                " 4|  |  |  |  |U |\n";
        assertEquals(gameBoardFast.toString(),testString);
    }

    @Test
    public void test_placeMarker_filledBoard()
    {
        //This test case is unique because it uses enough place markers to fill the board
        final int  rowPos = 5;
        final int  colPos = 5;
        final int  toWinAmnt = 5;

        IGameBoard gameBoardFast = IGameBoardFast( rowPos,  colPos,  toWinAmnt);
        BoardPosition BP = new BoardPosition(0,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(0,2);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(0,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(0,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(1,3);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(1,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(2,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,2);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,3);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(2,4);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,0);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,1);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(3,2);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(3,4);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,0);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,1);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,2);
        gameBoardFast.placeMarker(BP, 'X');
        BP = new BoardPosition(4,3);
        gameBoardFast.placeMarker(BP, 'O');
        BP = new BoardPosition(4,4);
        gameBoardFast.placeMarker(BP, 'O');


        String testString = "    0| 1| 2| 3| 4|\n" +
                " 0|O |X |X |O |O |\n" +
                " 1|X |X |O |X |O |\n" +
                " 2|X |X |X |X |O |\n" +
                " 3|X |X |O |O |X |\n" +
                " 4|O |O |X |O |O |\n";
        assertEquals(gameBoardFast.toString(),testString);
    }
}