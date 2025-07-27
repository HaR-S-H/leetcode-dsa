class Solution {
    public int removeStones(int[][] stones) {
        boolean visited[]=new boolean[stones.length];
        int component=0;
        for(int i=0;i<stones.length;i++){
            if(!visited[i]){
                dfs(i,visited,stones);
                component++;
            }
        }
        return stones.length-component;
    }
    public static void dfs(int index,boolean visited[],int stones[][]){
        visited[index]=true;
        for(int i=0;i<stones.length;i++){
                int row=stones[index][0];
                int col=stones[index][1];
            if(!visited[i] && (stones[i][0]==row ||stones
            [i][1]==col) ){
                dfs(i,visited,stones);
            }
        }
    }
}