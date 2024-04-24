package graph;

import java.util.*;

public class LC_684_Redundant_Connection {
    static class Solution {
        int[] parents;

        public int find(int x) {
            if (parents[x]==x) {
                return x;
            } else {
                parents[x] = find(parents[x]);
                return parents[x];
            }
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            parents[parentX] = parentY;
        }

        public int[] findRedundantConnection(int[][] edges) {
            int nodeSize = edges.length;
            parents = new int[nodeSize+1];

            int[] ans = new int[2];

            for (int i=0; i<=nodeSize; i++) {
                parents[i] = i;
            }

            for (int[] edge : edges) {
                int nodeX = edge[0];
                int nodeY = edge[1];

                if (find(nodeX)==find(nodeY)) {
                    ans = edge;
                    break;
                } else {
                    union(nodeX,nodeY);
                }

            }
            return ans;
        }
    }

    public static void main(String[] args) {
        LC_684_Redundant_Connection.Solution sol = new LC_684_Redundant_Connection.Solution();
        System.out.println(Arrays.toString(sol.findRedundantConnection(new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}})));
    }
}
