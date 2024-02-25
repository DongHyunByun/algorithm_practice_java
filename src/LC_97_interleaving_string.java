import java.util.Arrays;
import java.util.HashMap;

public class LC_97_interleaving_string {
    static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int s1Size = s1.length();
            int s2Size = s2.length();
            int s3Size = s3.length();

            if (s1Size+s2Size != s3Size) {
                return false;
            }
            boolean[][] dp = new boolean[s1Size+1][s2Size+1];
//            Arrays.fill(dp, false);

            for (int i=0; i<s1Size+1; i++) {
                for (int j=0; j<s2Size+1; j++) {
                    if (i==0 & j==0) {
                        dp[i][j] = true;
                        continue;
                    }

                    if (j>=1) {
                        if (dp[i][j-1]) {
                            if (s2.charAt(j-1)==s3.charAt(i+j-1)) {
                                dp[i][j] = true;
                            }
                            else {
                                dp[i][j] = false;
                            }
                        }
                    }

                    if (i>=1) {
                        if (dp[i-1][j]) {
                            if (s1.charAt(i-1)==s3.charAt(i+j-1)) {
                                dp[i][j] = true;
                            }
                            else {
                                dp[i][j] = false;
                            }
                        }
                    }
                }
            }

            return dp[s1Size][s2Size];
        }
    }

    public static void main(String[] args) {
        LC_97_interleaving_string.Solution sol = new LC_97_interleaving_string.Solution();
        System.out.println(sol.isInterleave("","",""));
    }
}
