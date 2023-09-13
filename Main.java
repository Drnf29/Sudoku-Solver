import java.awt.*;

public class Main {
    public static void main(String[] args) {
        int [] [] board = { {3,4,0,7,0,6,0,0,1},
                            {8,7,0,0,0,0,9,0,6},
                            {0,0,0,8,9,1,0,0,3},
                            {0,0,0,0,0,3,5,6,8},
                            {6,8,0,0,5,4,0,0,7},
                            {9,1,0,6,0,0,0,0,0},
                            {0,3,0,4,0,0,0,8,0},
                            {5,9,0,0,0,0,7,3,0},
                            {7,0,0,5,3,8,0,1,9},
        };
        if(solve(board)){
            printGrid(board);
        }

    }

    private static void printGrid(int[][] board){
        for(int i = 0; i < 9; i++){
            for ( int j = 0; j<9; j++){
                if(j % 3 == 0 && j != 0){
                    System.out.print("|");
                }
                System.out.print(board[i][j]);
            }
            System.out.println("\n------------");
        }
    }

    private static boolean numInRow(int [][] board, int number, int row){
        for(int i = 0; i < 9; i++) {
            if(number == board[row][i]){
                return true;
            }
        }
        return false;
    }

    private static boolean numInColumn(int[][] board, int number, int column){
        for(int i = 0; i < 9; i++) {
            if(number == board[i][column]){
                return true;
            }
        }
        return false;
    }

    private static boolean numInGrid(int[][] board, int number, int row, int column){
        int localRow = 0;
        int localColumn = 0;

        if ((row + 1) % 3 == 1 ){
            localRow = row;
        } else if ((row + 1) % 3 == 2){
            localRow = row - 1;
        } else{
            localRow = row - 2;
        }

        if ((column + 1) % 3 == 1 ){
            localColumn = column;
        } else if ((column + 1) % 3 == 2){
            localColumn = column - 1;
        } else{
            localColumn = column - 2;

        }


        for (int i = localRow; i < localRow + 3; i++){
            for (int j = localColumn; j < localColumn + 3; j++){
                if (number == board[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check(int[][]board, int number, int row, int column){
        if(numInRow(board,number,row) == true){
            return false;
        } else if (numInColumn(board,number,column) == true){
            return false;
        } else if (numInGrid(board,number,row,column)){
            return false;
        } else {
            return true;
        }
    }

    private static boolean solve(int[][]board){
        for(int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == 0){
                    for(int x = 1; x <=9; x++){
                        if(check(board, x, i, j)){
                            board[i][j] = x;

                            if(solve(board)){
                                return true;
                            } else {
                                board[i][j] = 0;
                            }


                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}

