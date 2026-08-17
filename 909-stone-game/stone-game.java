class Solution {
    public boolean stoneGame(int[] piles) {
        Arrays.sort(piles);
        int cnt1 = 0;
        int cnt2 = 0;
        int n = piles.length;
        for(int i= 0; i < n; i++){
            if(i % 2 == 0) cnt1 += piles[i];
            else cnt2 += piles[i];
        }

        return cnt1 < cnt2;
    }
}