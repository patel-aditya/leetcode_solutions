class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == ')'){
                List<Character> list = new ArrayList<>();
                while(st.peek() != '('){
                    list.add(st.pop());
                }
                st.pop();
                for(char c: list){
                    st.add(c);
                }
            }
            else{
                st.add(s.charAt(i));
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}