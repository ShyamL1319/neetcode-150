class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean rows[][] = new boolean[9][9];
        boolean cols[][] = new boolean[9][9];
        boolean boxes[][] = new boolean[9][9];
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                int val = board[r][c];
                if(val == '.') continue;
                int num = val-'1';
                int boxId = (r/3)*3 + c/3;
                if(rows[r][num] || cols[c][num] || boxes[boxId][num]){
                    return false;
                }
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxId][num] = true;
            }
        }
        // for(int row = 0; row<rows; row++){
        //     if(!checkRowOrColumnValid(board, row, true)) return false;
        // }

        // for(int col = 0; col<cols; col++){
        //     if(!checkRowOrColumnValid(board, col, false)) return false;
        // }

        // for(int row=0; row<rows; row+=3){
        //     for(int col=0; col<cols; col+=3){
        //         if(!check3X3BoxValid(board, row, col)) return false;
        //     }
        // }

        return true;
    }

    public boolean checkRowOrColumnValid(char[][] board, int rowOrCol, boolean isRow){
        HashSet<Character> hs = new HashSet();
        for(int i=0; i<9; i++){
            if(isRow) {
                char ele = board[i][rowOrCol];
                if(ele != '.' && hs.contains(ele)){
                    return false;
                }
                hs.add(ele);
            }else{
                char ele = board[rowOrCol][i];
                if(ele != '.' && hs.contains(ele)){
                    return false;
                }
                hs.add(ele);
            }
        }
        return true;
    }

    public boolean check3X3BoxValid(char[][] board, int srow, int scol){
        HashSet<Character> hs = new HashSet();

        for(int row=srow; row< srow+3; row++){
            for(int col=scol; col < scol+3; col++){
                char ele = board[row][col];
                if(ele != '.' && hs.contains(ele)) return false;
                hs.add(ele);
            }
        }
        return true;
    }
}
