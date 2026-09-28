class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int max = 0;
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '('){
                count++;
            }else if(s.charAt(i) == ')') count--;

            max = Math.max(count, max);

            i++;
        }
        return max;
    }
}