import java.util.Arrays;

public class LC_14_longest_common_prefix {
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            Arrays.sort(strs);
            int size = strs.length;
            String ans = "";

            String first = strs[0];
            String last = strs[size-1];

            for (int i=0; i<Math.min(first.length(), last.length()); i++) {
                if (first.charAt(i)!=last.charAt(i)) {
                    return ans;
                } else {
                    ans = ans+first.charAt(i);
                }

            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
