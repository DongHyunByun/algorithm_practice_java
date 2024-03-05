public class LC_1221_Split_a_string_in_balanced_strings {
    static class Solution {
        public int balancedStringSplit(String s) {
            int sSize = s.length();
            int lSize = 0;
            int rSize = 0;
            int ans = 0;

            for (int i=0; i<sSize; i++) {
                if (s.charAt(i)=='L') {
                    lSize+=1;
                } else {
                    rSize+=1;
                }
                if (lSize==rSize) {
                    ans+=1;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        LC_1221_Split_a_string_in_balanced_strings.Solution sol = new LC_1221_Split_a_string_in_balanced_strings.Solution();
        System.out.println(sol.balancedStringSplit("LRLR"));
    }
}
