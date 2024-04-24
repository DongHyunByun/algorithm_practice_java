package math;

import java.util.HashSet;

public class LC_128_longest_consecutive_sequence {
    static class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> s = new HashSet<Integer>();
            for (int num : nums) {
                s.add(num);
            }
            int longestNum = 0;

            for (int num : s) {
                if (s.contains(num-1)) {
                    continue;
                } else {
                    int nowCnt = 1;
                    while(true) {
                        num+=1;
                        if (s.contains(num)) {
                            nowCnt+=1;
                        } else {
                            longestNum = Math.max(longestNum,nowCnt);
                            break;
                        }
                    }
                }
            }

            return longestNum;
        }
    }

    public static void main(String[] args) {
        LC_128_longest_consecutive_sequence.Solution sol = new LC_128_longest_consecutive_sequence.Solution();
        System.out.println(sol.longestConsecutive(new int[]{1,2,3,4}));
    }
}

