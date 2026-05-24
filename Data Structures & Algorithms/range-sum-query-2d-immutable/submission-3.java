class NumMatrix {
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Use rows+1 and cols+1 to handle edge cases (index 0) easily
        prefixSum = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] 
                                + prefixSum[i - 1][j] 
                                + prefixSum[i][j - 1] 
                                - prefixSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Adjusting indices because prefixSum is 1-indexed for convenience
        return prefixSum[row2 + 1][col2 + 1] 
             - prefixSum[row1][col2 + 1] 
             - prefixSum[row2 + 1][col1] 
             + prefixSum[row1][col1];
    }
}
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */