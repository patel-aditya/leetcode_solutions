class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int count = 0;
        String res = s;
        boolean isTrue = false;
        while (j < n) {
            char c = s.charAt(j);
            if (c == '1')
                count++;
            while (i <= j && count >= k) {
                isTrue = true;
                String curr = s.substring(i, j+1);
                if((j - i + 1) < res.length()) res = curr;
                else if((j - i + 1) == res.length()){
                int compare = curr.compareTo(res);
                if(compare < 0) res = curr;
            }
                if (s.charAt(i) == '1')
                    count--;
                i++;
            }
            j++;
        }

        if (!isTrue)
            return "";

        return res;
    }
}