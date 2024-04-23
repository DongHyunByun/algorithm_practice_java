import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_685_Redundant_Connection2 {
    static class Solution {
        int size;
        int[] parentNode;

        public int find(int node) {
            if (parentNode[node]==node) {
                return node;
            } else {
                return find(parentNode[node]);
            }
        }

        public void union(int node1, int node2) {
            int node1Parent = find(node1);
            int node2Parent = find(node2);

            parentNode[node2Parent] = node1Parent;
        }

        public int[] findRedundantDirectedConnection(int[][] edges) {
            size = edges.length;

            // check if node got two parents node
            int[] firstParentNode = {-1,-1};
            int[] secondParentNode = {-1,-1};
            int[] edgeIndex = new int[size+1];
            Arrays.fill(edgeIndex,-1);

            for (int i=0; i<size; i++) {
                int u = edges[i][0];
                int v = edges[i][1];

                if (edgeIndex[v]==-1) {
                    edgeIndex[v]=i;
                } else {
                    // 부모2개인 노드가 있다면?
                    firstParentNode = edges[edgeIndex[v]];
                    secondParentNode = edges[i];
                }
            }

//            System.out.println("first"+Arrays.toString(firstParentNode));
//            System.out.println("second"+Arrays.toString(secondParentNode));

            parentNode = new int[size+1];
            for (int i=0; i<=size; i++) {
                parentNode[i]=i;
            }

            for (int[] edge: edges) {
//                System.out.println(Arrays.toString(edge));

                if (Arrays.equals(edge,secondParentNode)) {
                    continue;
                }

                int u = edge[0];
                int v = edge[1];


                // 싸이클이 존재
                if (find(u)==find(v)) {
                    if (Arrays.equals(firstParentNode,new int[]{-1,-1})) { // 부모가 두명이 아니면
                        return edge;
                    } else{ // 부모가 두명이면
                        return firstParentNode;
                    }


                } else {
                    union(u,v);
                }
            }

            return secondParentNode;
        }
    }

    public static void main(String[] args) {
        LC_685_Redundant_Connection2.Solution sol = new LC_685_Redundant_Connection2.Solution();
        System.out.println(Arrays.toString(sol.findRedundantDirectedConnection(new int[][]{{2,1},{3,1},{4,2},{1,4}})));
    }
}
