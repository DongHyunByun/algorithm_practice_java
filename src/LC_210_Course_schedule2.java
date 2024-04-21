import java.util.*;

public class LC_210_Course_schedule2 {
    static class Solution {
        int[] preNodeCnt;
        int size;
        List<Integer>[] graph;


        public ArrayList topologicSort() {
            Queue<Integer> q = new LinkedList<>();
            ArrayList<Integer> ans = new ArrayList<>();

            for (int i=0; i<size; i++) {
                if (preNodeCnt[i]==0) {
                    q.add(i);
                }
            }

            while(!q.isEmpty()) {
                int nowNode = q.poll();
                ans.add(nowNode);

                if (graph[nowNode]==null) {continue;}

                for (int toNode:graph[nowNode]) {
                    preNodeCnt[toNode]-=1;
                    if (preNodeCnt[toNode]==0) {
                        q.add(toNode);
                    }
                }
            }

            return ans;
        }

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            preNodeCnt = new int[numCourses];
            size = numCourses;
            graph = new List[numCourses];

            for (int[] a:prerequisites) {
                int toNode = a[0];
                int fromNode = a[1];

                preNodeCnt[toNode] +=1;
                if (graph[fromNode]==null) {
                    graph[fromNode] = new ArrayList<>();
                }

                graph[fromNode].add(toNode);
            }

            ArrayList<Integer> topoSort = topologicSort();

            if (topoSort.size()==numCourses) {
                int[] ans = new int[numCourses];
                int i=0;
                for (Integer node : topoSort) {
                    ans[i] = node;
                    i+=1;
                }
                return ans;
            } else {
                return new int[]{};
            }
        }
    }

    public static void main(String[] args) {
        LC_210_Course_schedule2.Solution sol = new LC_210_Course_schedule2.Solution();
        System.out.println(Arrays.toString(sol.findOrder(4,new int[][] {{1,0},{2,0},{3,1},{3,2}})));
    }
}
