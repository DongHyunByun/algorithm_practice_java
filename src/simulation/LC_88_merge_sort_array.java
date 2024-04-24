package simulation;

public class LC_88_merge_sort_array {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m-1;
            int j = n-1;

            while(i>=0 && j>=0) {
                if (nums1[i]<=nums2[j]) {
                    nums1[i+j+1] = nums2[j];
                    j-=1;
                } else {
                    nums1[i+j+1] = nums1[i];
                    i-=1;
                }
            }

            if (i==-1) {
                for (int k=j; k>=0; k-- ) {
                    nums1[k] = nums2[k];
                }
            }

            for (int x=0; x<=m+n-1; x++) {
                System.out.println(nums1[x]);
            }
        }
    }

    public static void main(String[] args) {
        LC_88_merge_sort_array.Solution sol = new LC_88_merge_sort_array.Solution();
        sol.merge(new int[]{0},0,new int[]{1},1);
    }
}
