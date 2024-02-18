public class LC_28_FInd_the_index_of_first_occurrence {
    static class Solution {
        public int strStr(String haystack, String needle) {
            int statckSize = haystack.length();
            int needleSize = needle.length();

            int ans = -1;

            for (int i=0; i<=statckSize-needleSize; i++) {
                if (needle.equals(haystack.substring(i,i+needleSize))) {
                    ans = i;
                    break;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        LC_28_FInd_the_index_of_first_occurrence.Solution sol = new LC_28_FInd_the_index_of_first_occurrence.Solution();
        System.out.println(sol.strStr("sadbutsad","sad"));
    }
}
