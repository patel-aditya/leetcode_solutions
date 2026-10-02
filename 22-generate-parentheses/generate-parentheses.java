class Solution {
    List<String> result = new ArrayList<>();
    void helper(int n, String str, int count){
        if(str.length() == n * 2){
            if(count == 0) result.add(str);
            return;
        }
        if(count < 0) return;
        helper(n, str + '(', count+1);
        helper(n, str + ')', count-1);
    }
    public List<String> generateParenthesis(int n) {
        helper(n, "", 0);
        return result;
    }
}