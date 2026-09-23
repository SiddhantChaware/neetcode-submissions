class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];

        for(int r = 0;r < board.length;r++){
            for(int c = 0;c < board[0].length;c++){
                if(board[r][c] == '.'){
                    continue;
                }

                int boxid = (r/3) * 3 + (c/3);
                int val = board[r][c] - '0';
                int mask = 1 << val;

                if((row[r] & mask) != 0 || (col[c] & mask) != 0 || 
                (box[boxid] & mask) != 0){
                    return false;
                }

                row[r] = row[r] | mask;
                col[c] = col[c] | mask;
                box[boxid] = box[boxid] | mask;
            }
        }
        return true;
    }
}
