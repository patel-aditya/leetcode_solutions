class Solution {

    void dfs(char[][] res, int i, int j, int m, int n){
        if(i >= m || j >= n) return;

        res[i][j] = '.';

        if(i == m -1 && j == n-1) return;
        dfs(res, i, j+1, m, n);
        if(res[m-1][n-1] == '.') return;
        dfs(res, i+1, j, m, n);
        if(res[m-1][n-1] == '.') return;

    }
    public String[] createGrid(int m, int n) {
        char[][] res = new char[m][n];
        for(int i = 0; i< m; i++){
            Arrays.fill(res[i], '#');
        }
        dfs(res, 0, 0, m, n);
        String[] ans = new String[m];
        for(int i = 0; i< m; i++){
            // StringBuilder sb = new StringBuilder();
            // for(int j = 0; j < n; j++){
            //     sb.append(res[i][j]);
            // }
            // ans[i] = sb.toString();
            ans[i] = String.valueOf(res[i]);
        }
        return ans;        
    }
}