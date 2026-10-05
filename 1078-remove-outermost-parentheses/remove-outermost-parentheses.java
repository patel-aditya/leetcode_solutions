class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0;
        int oIdx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                open--;
            }
            if (open == 0) {
                sb.append(s.substring(oIdx + 1, i));
                oIdx = i+1;
            }
        }
        return sb.toString();
    }
}