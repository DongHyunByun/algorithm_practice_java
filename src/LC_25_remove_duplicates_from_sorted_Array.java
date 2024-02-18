import java.util.Arrays;
import java.util.Stack;

public class LC_25_remove_duplicates_from_sorted_Array {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int cnt=1;
            for (int i=1; i<nums.length; i++) {
                if (nums[i] != nums[i-1]) {
                    nums[cnt] = nums[i];
                    cnt+=1;
                }
            }
            return cnt;
        }
    }
    public static void main(String[] args) {
        LC_25_remove_duplicates_from_sorted_Array.Solution sol = new LC_25_remove_duplicates_from_sorted_Array.Solution();
        System.out.println(sol.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
