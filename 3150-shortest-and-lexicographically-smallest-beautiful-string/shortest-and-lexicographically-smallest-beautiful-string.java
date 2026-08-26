class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        int j = 0;
        int count = 0;
        int minLen = 500;
        StringBuilder res = new StringBuilder(s);
        boolean isTrue = false;
        while (j < n) {
            char c = s.charAt(j);
            sb.append(c);
            if (c == '1')
                count++;
            while (i <= j && count >= k) {
                isTrue = true;
                if(sb.length() < res.length()) res = new StringBuilder(sb);
                else if(sb.length() == res.length()){
                int compare = sb.toString().compareTo(res.toString());
                if(compare < 0) res = new StringBuilder(sb);
            }
                minLen = Math.min(minLen, sb.length());
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