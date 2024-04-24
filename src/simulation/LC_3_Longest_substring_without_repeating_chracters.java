package simulation;

import java.util.HashSet;

public class LC_3_Longest_substring_without_repeating_chracters {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> alphaSet = new HashSet<>();
            int start = 0;
            int fin = 0;
            int maxLength = 0;
            int nowLength = 0;

            int sSize = s.length();

            while(fin!=sSize) {
                char nowChar = s.charAt(fin);

                if (!alphaSet.contains(nowChar)) {
                    alphaSet.add(nowChar);

                    nowLength+=1;
                    if (nowLength>maxLength) {
                        maxLength = nowLength;
                    }
                    fin+=1;
                } else {
                    alphaSet.remove(s.charAt(start));

                    nowLength-=1;
                    start+=1;
                }
            }

            return maxLength;
        }
    }

    public static void main(String[] args) {
        LC_3_Longest_substring_without_repeating_chracters.Solution sol = new LC_3_Longest_substring_without_repeating_chracters.Solution();
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
    }

}
