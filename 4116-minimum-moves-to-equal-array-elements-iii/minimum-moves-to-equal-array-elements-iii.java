class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        for(int num: nums){
            max = Math.max(num, max);
        }

        int res = 0;
        for(int num: nums){
            res += Math.abs(max - num);
        }
        return res;
    }
}