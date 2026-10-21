class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char small = s.charAt(0);
        char large = s.charAt(n - 1);
        boolean sorted = true;
        char prev = s.charAt(0);
        int[] freq = new int[26];
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c - 'a' < prev - 'a') {
                sorted = false;
            }
            if (freq[c - 'a'] == 0)
                count++;
            freq[c - 'a']++;
            prev = c;
            if ((small - 'a') > (c - 'a'))
                small = c;
            if (large - 'a' < c - 'a')
                large = c;
        }

        if (!sorted && n == 2)
            return -1;

        if (!sorted && small == s.charAt(n - 1) && large == s.charAt(0) && count >= 3) {
            for (int i = 1; i < n - 1; i++) {
                if (s.charAt(i) == small || s.charAt(i) == large)
                    return 2;
            }
            return 3;
        }

        if (!sorted && (small == s.charAt(0) || large == s.charAt(n - 1)))
            return 1;

        if (!sorted && small != s.charAt(0) && large != s.charAt(n - 1))
            return 2;

        return 0;
    }
}