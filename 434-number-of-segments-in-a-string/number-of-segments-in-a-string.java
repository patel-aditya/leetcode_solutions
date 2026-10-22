class Solution {
    public int countSegments(String s) {
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char c: s.toCharArray()){
            if(c != ' ')sb.append(c);
            else{
                if(sb.length() != 0) count++;
                sb = new StringBuilder();
            }
        }
        if(sb.length() != 0) count++;

        return count;
    }
}