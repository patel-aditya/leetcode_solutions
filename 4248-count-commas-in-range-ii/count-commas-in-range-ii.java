class Solution {
    public long countCommas(long n) {
        long count =0;
        long large = 1000000000000L;
        if(n >= 1000) count += n - 1000 + 1;
        if(n >= 1000000) count += (n - 1000000 + 1);
        if(n >= 1000000000) count += (n - 1000000000 + 1);
        if(n >= large) count +=  (n - large + 1);
        if(n == 1000000000000000L) count++;
        return count;
    }
}