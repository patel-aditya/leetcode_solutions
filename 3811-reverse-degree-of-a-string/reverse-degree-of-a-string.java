class Solution {
    public int reverseDegree(String s) {
        int res = 0;
        int i = 1;

        for(char c: s.toCharArray()){
            res += Math.abs(c-'a' - 26)* i++;
        }
        return res;
    }
}