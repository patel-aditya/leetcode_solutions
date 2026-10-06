class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int res =0;
        for(char c: s.toCharArray()){
            if(c == '(') count++;
            else count--;

            if(count < 0){
                res++;
                count = 0;
            }
        }

        res += count;
        return res;
    }
}