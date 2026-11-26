class Solution {
    public boolean canAliceWin(int n) {
        boolean isAliceTurn = true;
        int start = 10;

        while(n >= start){
            n -= start;
            start--;
            isAliceTurn = !isAliceTurn;
        }

        if(!isAliceTurn && n >= 0){
            return true;
        }
        
        return false;
    }
}