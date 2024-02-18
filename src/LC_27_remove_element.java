public class LC_27_remove_element {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            int cnt = 0;
            for (int i=0; i<nums.length; i++) {
                if (nums[i]!=val) {
                    nums[cnt] = nums[i];
                    cnt += 1;
                }
            }
            return cnt;
        }
    }
    public static void main(String[] args) {
        LC_27_remove_element.Solution sol = new LC_27_remove_element.Solution();
        System.out.println(sol.removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }
}
