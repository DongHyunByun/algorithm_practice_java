package dp;

import java.util.Arrays;

public class LC_329_Longest_Increasing_Matrix_dfs_dp {
    static class Solution {
        int ans=0;
        int[] dR = {0,0,-1,1};
        int[] dC = {-1,1,0,0};
        int[][] path;
        int m,n;

        public int dfs(int[][] matrix, int[][] visited, int r, int c) {
            if (path[r][c]!=-1) {
                return path[r][c];
            }

            int maxNum=0;
            for (int i=0; i<4; i++) {
                int nextR = r+dR[i];
                int nextC = c+dC[i];

                if (0<=nextR && nextR<m && 0<=nextC && nextC<n && visited[nextR][nextC]==0 && matrix[r][c]<matrix[nextR][nextC]) {
                    visited[nextR][nextC]=1;
                    maxNum = Math.max(maxNum,dfs(matrix, visited,nextR,nextC));
                    visited[nextR][nextC]=0;
                }
            }
            path[r][c]=maxNum+1;

            return maxNum+1;
        }

        public int longestIncreasingPath(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;

            path = new int[m][n];
            for (int i=0; i<m; i++) {
                Arrays.fill(path[i],-1);
            }

            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    int[][] visited = new int[m][n];
                    visited[i][j]=1;
                    int nowAns = dfs(matrix, visited, i,j);
                    ans = Math.max(nowAns,ans);
                }
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        LC_329_Longest_Increasing_Matrix_dfs_dp.Solution sol = new LC_329_Longest_Increasing_Matrix_dfs_dp.Solution();
        System.out.println(sol.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
    }
}
