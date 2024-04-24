package simulation;

import java.util.Arrays;

public class LC_31_next_permutation {
    static class Solution {
        public void nextPermutation(int[] nums) {
            int size = nums.length;
            for (int i=size-1; i>0; i--) {
                int y = nums[i];
                int x = nums[i-1];

                if (x<y) {
                    nums[i-1] = y;
                    nums[i] = x;
                    return;
                }
            }

            Arrays.sort(nums);
        }
    }
    public static void main(String[] args) {
        LC_31_next_permutation.Solution sol = new LC_31_next_permutation.Solution();
        sol.nextPermutation(new int[]{1,2,3});
    }
}
