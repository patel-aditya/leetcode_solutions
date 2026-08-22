class Solution {
    public boolean checkDivisibility(int n) {
        int digSum = 0;
        int product = 1;
        int temp = n;
        while(temp != 0){
            int dig = temp % 10;
            digSum += dig;
            product *= dig;
            temp /= 10;
        }
        int sum = digSum + product;
        return n % sum == 0;
    }
}