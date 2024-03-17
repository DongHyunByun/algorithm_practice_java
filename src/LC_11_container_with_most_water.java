public class LC_11_container_with_most_water {
    static class Solution {
        public int maxArea(int[] height) {
            int i=0;
            int size = height.length;
            int j = size-1;

            int ans = 0;
            while(i<j) {
                int minHeight = Math.min(height[i],height[j]);
                int width = j-i;

                int nowAns = minHeight*width;
                if (nowAns>ans) {
                    ans=nowAns;
                }

                if (height[i]<height[j]) {
                    i+=1;
                } else {
                    j-=1;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        LC_11_container_with_most_water.Solution sol = new LC_11_container_with_most_water.Solution();
        System.out.println(sol.maxArea(new int[]{1,1}));
    }

}
