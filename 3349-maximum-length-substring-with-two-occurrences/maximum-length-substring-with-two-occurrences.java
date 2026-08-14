class Solution {
    public int maximumLengthSubstring(String s) {
        int freq[] = new int[26];
        int i = 0;
        int j = 0;
        int n = s.length();
        int maxLength = 0;
        while (j < n) {
            char c = s.charAt(j);
            freq[c - 'a']++;
            while (freq[c - 'a'] > 2) {
                freq[s.charAt(i) - 'a']--;
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}

// class Solution {
//     public int maximumLengthSubstring(String s) {
//         int freq[] = new int[26];
//         int i = 0;
//         int j = 0;
//         int n = s.length();
//         int maxLength = 0;
//         while (j < n) {
//             freq[s.charAt(j) - 'a']++;
//             while (freq[s.charAt(j) - 'a'] > 2) {
//                 freq[s.charAt(i) - 'a']--;
//                 i++;
//             }
//             maxLength = Math.max(maxLength, j - i + 1);
//             j++;
//         }
//         return maxLength;
//     }
// }

// class Solution {
//     public int maximumLengthSubstring(String s) {  
//         int maxLen = 0;
//         // int len = 0;
//         int j = 0;
//         HashMap<Character, Integer> map = new HashMap<>();
//         for(int i = 0; i< s.length(); i++){
//             map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
//             while(map.get(s.charAt(i)) > 2){
//                 map.put(s.charAt(j), map.get(s.charAt(j))-1);
//                 if(map.get(s.charAt(j)) == 0) map.remove(s.charAt(j));
//                 j++;
//             }
//             // len = i - j + 1;
//             maxLen = Math.max(maxLen, i - j + 1);
//         }
//         return maxLen;
//     }
// }