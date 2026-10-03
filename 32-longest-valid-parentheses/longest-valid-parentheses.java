class Solution {
    public int longestValidParentheses(String s) {
        int count = 0;
        int len = 0;
        int maxLen = 0;
        for(char c: s.toCharArray()){
            if(c == '(') count++;
            else count--;
            len++;
            if(count == 0) maxLen = Math.max(maxLen, len);
            else if(count < 0){
                count = 0;
                len = 0;
            }
        }
        len = 0;
        count = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(c == ')') count++;
            else count--;
            len++;
            if(count == 0) maxLen = Math.max(maxLen, len);
            else if(count < 0){
                count = 0;
                len = 0;
            }
        }
        return maxLen;
    }
}