class Solution {
    public boolean checkString(String s) {
        // int a = 0;
        // int b = 0;
        // for(char c: s.toCharArray()){
        //     if(c == 'a') a++;
        //     else b++;

        //     if(c == 'a' && b != 0) return false;
        // }

        // if(s.contains("ba")) return false;
        if(s.indexOf("ba") != -1) return false;

        return true;
    }
}