class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            if(sum <= 9){
                sb.append(sum);
                sum -= sum;
                num--;
            }else{
                sb.append(9);
                sum -= 9;
                num--;
            }

            if(num == 0 && sum != 0) return "";
        }
        return sb.toString();
    }
}