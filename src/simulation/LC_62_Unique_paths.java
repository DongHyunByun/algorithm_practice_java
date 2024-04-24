package simulation;

public class LC_62_Unique_paths {
    static class Solution {
        public int uniquePaths(int m, int n) {
            int[] myList = new int[n];

            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (i==0) {
                        myList[j]=1;
                    } else {
                        if (j==0) {
                            myList[j]=1;
                        } else {
                            myList[j] = myList[j-1] + myList[j];
                        }
                    }
                }
            }
            return myList[n-1];
        }
    }

    public static void main(String[] args) {
        LC_62_Unique_paths.Solution sol = new LC_62_Unique_paths.Solution();
        System.out.println(sol.uniquePaths(3,7));
    }
}
