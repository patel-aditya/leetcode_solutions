class Solution {

    Boolean[][][] dp;

    boolean helper(char[][] grid, int row, int col, int count) {

        int m = grid.length;
        int n = grid[0].length;

        // Out of bounds
        if (row >= m || col >= n) {
            return false;
        }

        // Balance can never become negative
        if (grid[row][col] == '(') {
            count++;
        } else {
            count--;
        }

        if (count < 0) {
            return false;
        }

        // Remaining cells must be enough to close all '('
        int remaining = (m - 1 - row) + (n - 1 - col);
        if (count > remaining) {
            return false;
        }

        // Destination
        if (row == m - 1 && col == n - 1) {
            return count == 0;
        }

        if (dp[row][col][count] != null) {
            return dp[row][col][count];
        }

        boolean result =
            helper(grid, row + 1, col, count) ||
            helper(grid, row, col + 1, count);

        return dp[row][col][count] = result;
    }

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Maximum possible balance is m + n
        dp = new Boolean[m][n][m + n + 1];

        return helper(grid, 0, 0, 0);
    }
}










// class Solution {
//     boolean helper(char[][] grid, int row, int col, int count){
//         int m = grid.length;
//         int n = grid[0].length;
//         if(row >= grid.length || col >= grid[0].length){
//             return false;
//         }
//         if(grid[row][col] == '(') count++;
//         else count--;
//         if(row == m-1 && col == m -1){
//             return count == 0;
//         }
//         if(count < 0) return false;

//         int remaining = (m - 1 - row) + (n - 1 - col);
//         if (count > remaining) {
//             return false;
//         }
//         return helper(grid, row+1, col, count) || helper(grid, row, col+1, count);
//     }

//     public boolean hasValidPath(char[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         return helper(grid, 0, 0, 0);
//     }
// }