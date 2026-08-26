class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        int j = 0;
        int count = 0;
        String res = s;
        boolean isTrue = false;
        while (j < n) {
            char c = s.charAt(j);
            sb.append(c);
            if (c == '1')
                count++;
            while (i <= j && count >= k) {
                isTrue = true;
                if((j - i + 1) < res.length()) res = s.substring(i,j+1);
                else if((j - i + 1) == res.length()){
                int compare = s.substring(i, j+1).compareTo(res);
                if(compare < 0) res = s.substring(i, j+1);
            }
                if (s.charAt(i) == '1')
                    count--;
                sb.deleteCharAt(0);
                i++;
            }
            j++;
        }

        if (!isTrue)
            return "";

        return res.toString();
    }
}