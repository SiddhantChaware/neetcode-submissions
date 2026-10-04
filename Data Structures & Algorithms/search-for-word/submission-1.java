class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public boolean isSafe(int r,int c,char[][] board){
        int m = board.length;
        int n = board[0].length;
        if(r < 0 || r >= m || c >= n || c < 0){
            return false;
        }
        return true;
    }
    public boolean solve(char[][] board,int idx,int r,int c,String word){
        if(idx == word.length()){
            return true;
        }

        if(!isSafe(r,c,board)){
            return false;
        }
        if(board[r][c] != word.charAt(idx)){
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '*';

        for(int[] d : dir){
            int new_r = r + d[0];
            int new_c = c + d[1];
            if(solve(board,idx+1,new_r,new_c,word)){
                return true;
            }
        }
        board[r][c] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int r = 0;r < m;r++){
            for(int c = 0;c < n;c++){
                if(solve(board,0,r,c,word)){
                    return true;
                }
            }
        }
        return false;
    }
}
