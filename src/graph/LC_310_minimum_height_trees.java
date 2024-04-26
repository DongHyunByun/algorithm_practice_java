package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_310_minimum_height_trees {
    static class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            int[] inDegree = new int[n];
//            int[][] adjacent = new int[n][n];
            List<Integer>[] graph = new ArrayList[n];
            for (int i=0; i<n; i++) {
                graph[i] = new ArrayList<>();
            }


            for (int[] edge : edges) {
                int node1 = edge[0];
                int node2 = edge[1];

                inDegree[node1]+=1;
                inDegree[node2]+=1;

                graph[node1].add(node2);
                graph[node2].add(node1);
            }

            List<Integer> finalAns = new ArrayList<>();
            List<Integer> ans = new ArrayList<>();
            int[] removedNode = new int[n];

            while (true) {
                // leaf노드 제거
                for (int i=0; i<n; i++) {
                    if (inDegree[i]==1) {
                        inDegree[i]-=1;
                        ans.add(i);
                        removedNode[i]=1;
                    }
                }

                if (ans.isEmpty()) {
//                    System.out.println(Arrays.toString(removedNode));
                    List<Integer> tempRemoveNode = new ArrayList<>();
                    for (int i=0; i<n; i++) {
                        if (removedNode[i]==0) {
                            tempRemoveNode.add(i);
                        }
                    }

                    // 마지막 정답노드가 어디에서 삭제된지 확인한다.
                    if (!tempRemoveNode.isEmpty()) {
                        return tempRemoveNode;
                    } else {
                        return finalAns;
                    }

                } else {
                    for (int removeEdge : ans) {
                        for (int adjNode : graph[removeEdge]) {
                            inDegree[adjNode]-=1;
                        }
                    }
                    finalAns = new ArrayList<>(ans);
                    ans.clear();
                }
            }
        }
    }

    public static void main(String[] args) {
        LC_310_minimum_height_trees.Solution sol = new LC_310_minimum_height_trees.Solution();
        System.out.println(sol.findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
    }
}
