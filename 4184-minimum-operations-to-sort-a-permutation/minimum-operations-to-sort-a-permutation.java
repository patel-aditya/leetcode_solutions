class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int minIdx = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                minIdx = i;
            }
        }

        boolean isSorted = true;
        int prev = min;
        int count = 0;
        int i = minIdx;

        while (count < n) {
            count++;
            if (nums[i] < prev) {
                isSorted = false;
                break;
            }
            prev = nums[i];
            i++;
            if (i == n)
                i = 0;
        }
        if (isSorted) {
            return Math.min(minIdx, n - minIdx + 3-1);
        }
        i = minIdx;
        isSorted = true;
        count = 0;
        prev = min;
        while (count < n) {
            count++;
            if (nums[i] < prev) {
                isSorted = false;
                break;
            }
            prev = nums[i];
            i--;
            if (i < 0)
                i = n - 1;
        }
        if (isSorted) {
            int m = Math.min(minIdx + 1, n - minIdx -1);
            return m + 1;
        }
        return -1;
    }
}