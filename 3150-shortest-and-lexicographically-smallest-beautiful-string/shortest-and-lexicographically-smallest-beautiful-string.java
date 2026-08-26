class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        List<String> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int count = 0;
        int minLen = 500;
        while (j < n) {
            char c = s.charAt(j);
            sb.append(c);
            if (c == '1')
                count++;
            while (i <= j && count >= k) {
                list.add(sb.toString());
                minLen = Math.min(minLen, sb.length());
                if (s.charAt(i) == '1')
                    count--;
                sb.deleteCharAt(0);
                i++;
            }
            j++;
        }

        if (list.size() == 0)
            return "";

        String res = s;
        for(String str: list){
            if(str.length() < res.length()) res = str;
            else if(str.length() == res.length()){
                int compare = str.compareTo(res);
                if(compare < 0) res = str;
            }
        }

        return res;
    }
}