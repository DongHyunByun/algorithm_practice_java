public class LC_35_search_insert_position {
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int size = nums.length;
            int ans = size;

            for (int i=0; i<size; i++) {
                if (target<=nums[i]) {
                    ans = i;
                    break;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        LC_35_search_insert_position.Solution sol = new LC_35_search_insert_position.Solution();
        System.out.println(sol.searchInsert(new int[]{1,3,5,6}, 5));
    }
}
