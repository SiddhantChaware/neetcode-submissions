class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(rows[i]){
                    matrix[i][j] = 0;
                }
                if(cols[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
