package graph;

import java.lang.reflect.Array;
import java.util.*;

public class LC_851_loud_and_rich {
    static class Solution {
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            int size = quiet.length;
            int[] minQuiet = new int[size];
            for (int i=0; i<size; i++) {
                minQuiet[i]=i;
            }

            List<Integer>[] degree = new ArrayList[size];
            int[] inDegree = new int[size];

            for (int i=0; i<size; i++) {
                degree[i] = new ArrayList<>();
            }

            for (int[] edge : richer) {
                int u = edge[0];
                int v = edge[1];

                inDegree[v]+=1;
                degree[u].add(v);
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i=0; i<size; i++) {
                if (inDegree[i]==0) {
                    q.add(i);
                }
            }

            while(!q.isEmpty()) {
                int nowNode = q.remove();
                for (int nextNode : degree[nowNode]) {
                    inDegree[nextNode]-=1;
                    if (inDegree[nextNode]==0) {
                        q.add(nextNode);
                    }

                    int nowQuietIndex = minQuiet[nowNode];
                    int nextQuietIndex = minQuiet[nextNode];
                    if (quiet[nowQuietIndex]<quiet[nextQuietIndex]) {
                        minQuiet[nextNode]=nowQuietIndex;
                    }
                }
            }

            return minQuiet;
        }
    }

    public static void main(String[] args) {
        LC_851_loud_and_rich.Solution sol = new LC_851_loud_and_rich.Solution();
        System.out.println(Arrays.toString(sol.loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}}, new int[]{3,2,5,4,6,1,7,0})));
    }
}
