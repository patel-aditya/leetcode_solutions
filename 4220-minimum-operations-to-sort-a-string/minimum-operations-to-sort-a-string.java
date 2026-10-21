class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char min = s.charAt(0), max = s.charAt(0);
        boolean sorted = true;
        int[] freq = new int[26];
        int count = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i > 0 && c < s.charAt(i - 1)) sorted = false;
            if (freq[c - 'a']++ == 0) count++;
            min = (char) Math.min(min, c);
            max = (char) Math.max(max, c);
        }

        if (sorted) return 0;
        if (n == 2) return -1;
        if (min == s.charAt(n - 1) && max == s.charAt(0) && count >= 3) {
            for (int i = 1; i < n - 1; i++)
                if (s.charAt(i) == min || s.charAt(i) == max) return 2;
            return 3;
        }
        return min == s.charAt(0) || max == s.charAt(n - 1) ? 1 : 2;
    }
}