class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{'){
                st.add(c);
            }else{
                if(st.isEmpty()) return false;
                char close = st.pop();

                if(close == '(' && c != ')' 
                || close == '[' && c != ']'
                || close == '{' && c != '}'             
                ) return false;
            }
        }
        return st.isEmpty();
    }
}