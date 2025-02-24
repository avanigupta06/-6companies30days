import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;
        }

        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1], dist = edge[2];
            distance[node1][node2] = dist;
            distance[node2][node1] = dist;
        }

        for (int midle = 0; midle < n; midle++) {
            for (int source = 0; source < n; source++) {
                for (int destination = 0; destination < n; destination++) {
                    if (distance[source][midle] < Integer.MAX_VALUE && distance[midle][destination] < Integer.MAX_VALUE) {
                        distance[source][destination] = Math.min(
                            distance[source][destination], distance[source][midle] + distance[midle][destination]
                        );
                    }
                }
            }
        }

        int minimum_number = n;
        int res = -1;

        for (int source = 0; source < n; source++) {
            int source_count = 0;
            for (int destination = 0; destination < n; destination++) {
                if (distance[source][destination] <= distanceThreshold) {
                    source_count++;
                }
            }

            if (source_count <= minimum_number) {
                minimum_number = source_count;
                res = source;
            }
        }

        return res;
    }
}
// Time Complexity: O(n^3)
// Space Complexity: O(n^2)