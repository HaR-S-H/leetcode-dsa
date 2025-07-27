class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean visited[]=new boolean[n];
        int component=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,graph,visited);
                component++;
            }
        }
        return component-1;
    }
    public static void dfs(int s,ArrayList<ArrayList<Integer>>graph,boolean visited[]){
        visited[s]=true;
        ArrayList<Integer>nbr_list=graph.get(s);
        for(Integer nbr:nbr_list){
            if(!visited[nbr])
            dfs(nbr,graph,visited);
        }
    }
}