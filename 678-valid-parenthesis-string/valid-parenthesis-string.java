class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;

        for(char c: s.toCharArray()){
            if(c == '('){
                min  = min + 1;
                max = max + 1;
            }else if(c == ')'){
                min = min - 1;
                max = max - 1;
            }else{
                min = min - 1;
                max = max + 1;
            }

            if(min < 0) min = 0;
            if(max < 0) return false;
        }

        return min == 0;
    }
}

/**
// use DP memoniation learn from striver
// show TLE brute approach exponentional
class Solution {
    public boolean checkValidString(String s) {
        return helper(s, 0, 0);        
    }

    public boolean helper(String s,int i, int cnt){
        if(cnt < 0) return false;
        if(i == s.length()){
            return cnt == 0;
        }

        if(s.charAt(i) == '('){
            return helper(s, i+1, cnt+1);
        }else if(s.charAt(i) == ')'){
            return helper(s, i+1, cnt-1);
        }

        return helper(s, i + 1, cnt-1) || helper(s, i+1, cnt+1) || helper(s, i+1, cnt);
    }
}
 */