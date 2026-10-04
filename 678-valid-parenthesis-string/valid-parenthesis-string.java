class Solution {
    public boolean checkValidString(String s) {
        int count = 0;
        int str = 0;
        for(char c: s.toCharArray()){
            if(c == '(') count++;
            else if(c == '*'){
                str++;

            }else{
                if(count > 0) count--;
                else if(str > 0) str--;
                else return false;
            }
        }

        // if(str == count || count == 0) return true;

        count = 0;
        str = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(c == ')') count++;
            else if(c == '*'){
                str++;

            }else{
                if(count > 0) count--;
                else if(str > 0) str--;
                else return false;
            }
        }
        return true;
    }
}