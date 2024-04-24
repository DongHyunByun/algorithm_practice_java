package graph;

import java.util.ArrayList;
import java.util.List;

public class LC_207_course_schedule {
    static class Solution {
        public boolean dfs(int node, boolean visited[], boolean fin[], List<Integer>[] graph) {
            visited[node] = true;
            boolean returnBool = true;

            if (graph[node]!=null) {
                for (int nextNode : graph[node]) {
                    if (visited[nextNode]==false) {
                        if (!dfs(nextNode, visited, fin, graph)) {
                            returnBool = false;
                            break;
                        }
                    } else if (fin[nextNode]==false) {
                        returnBool = false;
                        break;
                    }
                }
            }

            if (returnBool) {
                fin[node] = true;
                return returnBool;
            } else {
                return returnBool;
            }

        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new List[numCourses];

            int size = prerequisites.length;
            for (int i=0; i<size; i++) {
                int fromNode = prerequisites[i][0];
                int toNode = prerequisites[i][1];

                if (graph[fromNode]==null) {
                    graph[fromNode] = new ArrayList<>();
                }
                graph[fromNode].add(toNode);
            }

            boolean[] visited = new boolean[numCourses];
            boolean[] fin = new boolean[numCourses];

            for (int i=0; i<numCourses; i++) {
                if (!visited[i]) {
//                    System.out.println("-----"+i+"------");

                    if (!dfs(i,visited,fin,graph)) {
//                        System.out.println(Arrays.toString(visited));
//                        System.out.println(Arrays.toString(fin));
//                        System.out.println(i+"에서 return false");
                        return false;
                    }
//                    System.out.println(Arrays.toString(visited));
//                    System.out.println(Arrays.toString(fin));
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        LC_207_course_schedule.Solution sol = new LC_207_course_schedule.Solution();
        System.out.println(sol.canFinish(7,new int[][] {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}}));
    }
}
