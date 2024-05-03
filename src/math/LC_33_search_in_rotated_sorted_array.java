package math;

public class LC_33_search_in_rotated_sorted_array {
    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length-1;
            int mid;

            while(left<=right) {
                mid = (left+right)/2;

                if (nums[mid]==target) {
                    return mid;
                }
                // if left part is sorted
                if (nums[left]<=nums[mid]) {
                    if (nums[left]<=target&&target<nums[mid]) {
                        right = mid-1;
                    } else {
                        left = mid+1;
                    }
                }
                // if right part is sorted
                else {
                    if (nums[mid]<=target && target<=nums[right]) {
                        left = mid+1;
                    } else {
                        right = mid-1;
                    }
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        LC_33_search_in_rotated_sorted_array.Solution sol = new LC_33_search_in_rotated_sorted_array.Solution();
        System.out.println(sol.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
