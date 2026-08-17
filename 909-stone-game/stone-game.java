class Solution {
    public boolean stoneGame(int[] piles) {
     int n = piles.length;

     int[][] dp = new int[n+2][n+2];
     for(int size = 1; size <= n; size++){
        for(int i = 0; i + size <= n; i++){
            int j = i + size -1;
            int parity = (j + i + n) % 2;
            if(parity == 1){
                dp[i+1][j+1] = Math.max(piles[i] + dp[i+2][j+1], piles[j] + dp[i+1][j]);
            }
            else{
                dp[i+1][j+1] = Math.min(-piles[i] + dp[i+2][j+1], -piles[j] + dp[i+1][j]);
            }
        }
     }  
     return dp[1][n] > 0;
    }
}

/**

class Solution {
    public boolean stoneGame(int[] piles) {
        // Mathmatically appraoch
        return true;
    }
}

Greedy Approach
class Solution {
    public boolean stoneGame(int[] piles) {
        // Arrays.sort(piles);
        // int cnt1 = 0;
        // int cnt2 = 0;
        // int n = piles.length;
        // for(int i= 0; i < n; i++){
        //     if(i % 2 == 0) cnt1 += piles[i];
        //     else cnt2 += piles[i];
        // }

        // return cnt1 < cnt2;
    }
}

 */