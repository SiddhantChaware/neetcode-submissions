class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] boxes = new int[9];

        for(int r = 0;r < board.length;r++){
            for(int c = 0;c < board.length;c++){
                if(board[r][c] == '.'){
                    continue;
                }

                int boxidx = (r/3) * 3 + (c/3);
                int val = board[r][c] - '0';
                int mask = 1 << val;

                if((row[r] & mask) != 0 || (col[c] & mask) != 0 ||
                    (boxes[boxidx] & mask) != 0){
                        return false;
                    }

                row[r] = row[r] | mask;
                col[c] = col[c] | mask;
                boxes[boxidx] = boxes[boxidx] | mask;
            }
        }
        return true;
    }
}
