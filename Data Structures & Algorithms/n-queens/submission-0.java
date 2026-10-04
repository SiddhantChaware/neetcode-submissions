class Solution {
    public void solve(List<String> board,int row,List<List<String>> res){
        if(row == board.size()){
            res.add(new ArrayList<>(board));
            return;
        }

        for(int i = 0;i < board.size();i++){
            if(isValid(board,row,i)){
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(i, 'Q');
                board.set(row,newRow.toString());

                solve(board,row+1,res);

                newRow.setCharAt(i,'.');
                board.set(row,newRow.toString());
            }
        }
    }

    public boolean isValid(List<String> board,int row,int col){
        for(int i = row;i >= 0;i--){
            if(board.get(i).charAt(col) == 'Q'){
                return false;
            }
        }

        //left diagonal
        for(int i = row,j = col;i >= 0 && j >= 0;i--,j--){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        //right diagonal
        for(int i = row,j = col;i >= 0 && j < board.size();i--,j++){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for(int i = 0;i < n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j < n;j++){
                sb.append(".");
            }
            board.add(sb.toString());
        }
        List<List<String>> res = new ArrayList<>();
        solve(board,0,res);
        return res;
    }
}
