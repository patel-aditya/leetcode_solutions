class Solution {
    public int longestSubsequence(int[] nums) {
        
        int xor = 0;
        int nonZero = 0;
        for(int num: nums){
            xor ^= num;
            if(num != 0) nonZero++;
        }
        if(nonZero == 0) return 0;
        if(xor != 0) return nums.length;
        return nums.length - 1;
    }
} 


/**

class Solution {
int maxLength = 0;
    void generateSubsequence(int[] nums, int idx, int xor, int length){
        if(idx >= nums.length){
            if(xor != 0) maxLength =Math.max(maxLength, length);
            return;
        }
        if(xor != 0){
            maxLength = Math.max(maxLength, length);
            return;
        }
        generateSubsequence(nums, idx + 1, xor ^ nums[idx], length -1);
        generateSubsequence(nums, idx + 1, xor, length);
    }

    public int longestSubsequence(int[] nums) {
        
        int xor = 0;
        int nonZero = 0;
        for(int num: nums){
            xor ^= num;
            if(num != 0) nonZero++;
        }
        if(nonZero == 0) return 0;
        if(xor != 0) return nums.length;
        generateSubsequence(nums, 0, xor, nums.length);
        return maxLength;
    }
} 

 */