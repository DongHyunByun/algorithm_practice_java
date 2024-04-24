package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 유향 그래프의 사이클이 있는지 확인하는 방식으로 풀었다. 문제의 요구사항은 유향그래프에서 트리를 만들라는 것이지, 사이클을 검증하라는 것이 아니다.
public class LC_685_redundant_connection2_error {
    static class Solution {
        int size;

        public boolean dfs(int node, boolean[] visited, boolean[] fin, List<Integer>[] graph) {
            visited[node] = true;
            if (graph[node]!=null) {
                for (int nextNode:graph[node]) {
                    if (visited[nextNode]==false) {
                        if (!dfs(nextNode, visited, fin, graph)) {
                            return false;
                        }
                    }  else if (fin[nextNode]==false){
                        return false;
                    }
                }
            }

            fin[node] = true;
            return true;
        }

        public boolean isCycle(List<Integer>[] graph) {
            boolean[] visited = new boolean[size+1];
            boolean[] fin = new boolean[size+1];
            for (int i=1; i<=size; i++) {
//                System.out.println(i);
                if (visited[i]==false) {
                    if (!dfs(i,visited,fin,graph)) {
//                        System.out.println(Arrays.toString(visited));
//                        System.out.println(Arrays.toString(fin));
                        return false;
                    }
                }
//                System.out.println(Arrays.toString(visited));
//                System.out.println(Arrays.toString(fin));
            }
            return true;
        }

        public int[] findRedundantDirectedConnection(int[][] edges) {
            size = edges.length;
            List<Integer>[] graph = new List[size+1];
            int[] ans = new int[2];
            int[] cntParent = new int[size+1];

            for (int i=0; i<size; i++) {
//                System.out.println("=========="+Arrays.toString(edges[i])+"==========");
                int fromNode = edges[i][0];
                int toNode = edges[i][1];

                cntParent[toNode]+=1;
                if (cntParent[toNode]==2) {
                    ans=edges[i];
                    break;
                }

                if (graph[fromNode]==null) {
                    graph[fromNode] = new ArrayList<>();
                }

                graph[fromNode].add(toNode);


                if (!isCycle(graph)) {
                    ans = edges[i];
                    break;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        LC_685_redundant_connection2_error.Solution sol = new LC_685_redundant_connection2_error.Solution();
        System.out.println(Arrays.toString(sol.findRedundantDirectedConnection(new int[][]{{1,2},{1,3},{2,3}})));
    }
}
