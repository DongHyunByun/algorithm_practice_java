package graph;

import java.util.Arrays;

public class LC_787_cheapest_flights_within_stops {
    static class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[] distArray = new int[n];
            int INF = Integer.MAX_VALUE;
            Arrays.fill(distArray, INF);
            distArray[src]=0;

            int edgeSize = flights.length;

            for (int i=1; i<=k+1; i++) {
                int[] temp = Arrays.copyOf(distArray,n);
                for (int j=0; j<edgeSize; j++) {
                    int u = flights[j][0];
                    int v = flights[j][1];
                    int cost = flights[j][2];

                    if (distArray[u]!=INF && (distArray[u]+cost < temp[v])) {
                        temp[v] = distArray[u]+cost;
                    }
                }
                distArray = temp;

//                System.out.println(Arrays.toString(distArray));
            }

            if (distArray[dst]==INF) {
                return -1;
            } else{
                return distArray[dst];
            }
        }
    }

    public static void main(String[] args) {
        LC_787_cheapest_flights_within_stops.Solution sol = new LC_787_cheapest_flights_within_stops.Solution();
        System.out.println(sol.findCheapestPrice(4,new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}},0,3,1));
    }
}
