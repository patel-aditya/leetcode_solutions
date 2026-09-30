class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];

        for(int num: nums1){
            freq[num]++;
        }

        int[] freq2 = new int[1001];
        for(int num: nums2){
            freq2[num]++;
        }

        int[] intersection = new int[1001];

        int count = 0;
        for(int i = 0; i < 1001; i++){
            intersection[i] = Math.min(freq[i], freq2[i]);
            count += Math.min(freq[i], freq2[i]);
        }

        int res[] = new  int[count];
        int x = 0;
        for(int i = 0; i < 1001; i++){
            while(intersection[i] > 0){
                res[x++] = i;
                intersection[i] = intersection[i] - 1;
            }
        }
        return res;
    }
}