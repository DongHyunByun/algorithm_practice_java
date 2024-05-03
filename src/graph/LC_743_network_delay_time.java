package graph;

import java.util.*;

public class LC_743_network_delay_time {
    static class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            Map<Integer, ArrayList<int[]>> graph = new HashMap<>();

            for (int i=1; i<=n; i++) {
                graph.put(i,new ArrayList<int[]>());
            }
            for (int[] edge : times) {
                int u = edge[0];
                int v = edge[1];
                int cost = edge[2];

                graph.get(u).add(new int[]{v,cost});
            }

            int[] dist = new int[n+1];
            int INF = Integer.MAX_VALUE;
            Arrays.fill(dist, INF);

            dist[k]=0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 1번쨰 인덱스를 비교, 낮은값을 반환. 만약 b[1]-a[1]을하면 큰값을 반환함.
            pq.add(new int[]{k, 0});

            while (!pq.isEmpty()) {
                int[] a = pq.remove();
                int nowNode = a[0];
                int cost = a[1];

                if (dist[nowNode]<cost) {
                    continue;
                }

                if (graph.containsKey(nowNode)) {
                    ArrayList<int[]> nextNodeArrays = graph.get(nowNode);
                    for (int[] nextNodeArray: nextNodeArrays) {
                        int nextNode = nextNodeArray[0];
                        int nextCost = nextNodeArray[1];

                        if (nextCost+dist[nowNode]<dist[nextNode]) {
                            dist[nextNode] = nextCost+dist[nowNode];
                            pq.add(new int[]{nextNode,dist[nextNode]});
                        }
                    }
                }
            }

            int ans = -1;
            for (int i=1; i<=n; i++) {
                if (dist[i]==INF)  {
                    return -1;
                } else {
                    ans = Math.max(ans,dist[i]);
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        LC_743_network_delay_time.Solution sol = new LC_743_network_delay_time.Solution();
        System.out.println(sol.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2));
    }
}

