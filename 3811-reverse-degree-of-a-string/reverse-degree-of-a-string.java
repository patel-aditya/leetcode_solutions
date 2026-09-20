class Solution {
    public int reverseDegree(String s) {
        int res = 0;
        for(int i = 0; i< s.length(); i++){
            res += (123 - s.charAt(i)) * (i+1);//123 - ascii of s.charAt(i) will give reverseOrder numbering of alphabet like 123 - 97 = 26 of 'a'(97 ascii value) 123 - 98 = 25 of 'b'(98 ascii value) 123 - 122 of 'z'(122 ascii value)
        }
        return res;
    }
}