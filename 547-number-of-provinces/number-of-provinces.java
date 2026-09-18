class Solution {

    void dfs(int val, int[][] isConnected, boolean[] visit){
        visit[val] = true;
        for(int i =  0; i < isConnected.length; i++){
            if(isConnected[val][i] == 1 && visit[i] == false){
                dfs(i, isConnected, visit);
            }
        }

    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];

        int count = 0;

        for(int i = 0; i< n; i++){
            if(!visit[i]){
                count++;
                dfs(i, isConnected, visit);
            }
        }
    return count;
    }
}