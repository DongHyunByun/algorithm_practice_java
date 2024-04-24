package math;

import java.util.Arrays;

public class LC_16_3sum_closet {
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int size = nums.length;
            int diff = 987654321;
            int ans = 0;

            for (int i=0; i<size; i++) {
                int j = i+1;
                int k = size-1;
                while (j<k) {
                    // System.out.printf("i:%d, j:%d, k:%d %n",i,j,k);
                    int threeSum = nums[i] + nums[j] + nums[k];
                    int nowDiff = Math.abs(threeSum - target);
                    // System.out.println(nowDiff);
                    if (nowDiff < diff) {
                        diff=nowDiff;
                        ans = threeSum;
                    }

                    if (threeSum < target) {
                        j += 1;
                    } else if (threeSum > target) {
                        k -= 1;
                    } else {
                        return target;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        LC_16_3sum_closet.Solution sol = new LC_16_3sum_closet.Solution();
        System.out.println(sol.threeSumClosest(new int[]{0,0,0},1));
    }

}
