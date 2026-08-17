class Solution {
    int n;
    int dp[][][] = new int[2][101][101];
    public int solveForAlice(int[] piles, int person, int idx, int M) {
        if (idx >= n) {
            return 0;
        }
        if(dp[person][idx][M] != -1) return dp[person][idx][M]; 
        int stones = 0;
        int res = (person == 1) ? -1 : Integer.MAX_VALUE;

        for (int x = 1; x <= Math.min(2 * M, n - idx); x++) {
            stones += piles[idx + x - 1];
            if (person == 1) {
                res = Math.max(res, stones + solveForAlice(piles, 0, idx + x, Math.max(x, M)));
            } else {
                res = Math.min(res, solveForAlice(piles, 1, idx + x, Math.max(x, M)));
            }
        }
        dp[person][idx][M] = res;
        return res;
    }

    public int stoneGameII(int[] piles) {
        n = piles.length;
        for(int[][] d: dp){
            for(int[] r: d){
                Arrays.fill(r, -1);
            }
        }
        return solveForAlice(piles, 1, 0, 1);
    }
}