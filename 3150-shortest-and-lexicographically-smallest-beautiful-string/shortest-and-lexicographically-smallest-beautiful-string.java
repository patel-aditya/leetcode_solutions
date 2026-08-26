class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        TreeSet<String> set = new TreeSet<>((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < n) {
            char c = s.charAt(j);
            sb.append(c);
            if (c == '1')
                count++;
            while (i <= j && count >= k) {
                set.add(sb.toString());
                if (s.charAt(i) == '1')
                    count--;
                sb.deleteCharAt(0);
                i++;
            }
            j++;
        }

        if (set.size() == 0)
            return "";

        return set.first();
    }
}