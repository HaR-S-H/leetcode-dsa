class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] grid = new int[n][n];
        int INF = 100000000; 
   
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], INF);
            grid[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            grid[u][v] = w;
            grid[v][u] = w;
        }


        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][via] != INF && grid[via][j] != INF) {
                        grid[i][j] = Math.min(grid[i][j], grid[i][via] + grid[via][j]);
                    }
                }
            }
        }

        int minReachable = Integer.MAX_VALUE;
        int city = -1;

        // Count reachable cities within threshold
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && grid[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // Choose city with smaller reachable count,
            // or larger index if tie
            if (count <= minReachable) {
                minReachable = count;
                city = i;
            }
        }

        return city;
    }
}
