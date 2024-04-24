package simulation;

import java.util.LinkedList;
import java.util.Queue;

public class LC_45_jump_game_2 {
    static class Solution {
        public int jump(int[] nums) {
            int numsSize = nums.length;
            Queue<int[]> q= new LinkedList<>();
            boolean[] visited = new boolean[numsSize];
//            q.offer(intArray);
            int ans=0;

            int indx = 0;
            int cnt = 0;
            q.offer(new int[]{indx,cnt});
            visited[indx] = true;

            while (q.peek()!=null) {
                int[] tempArray = q.poll();

                indx = tempArray[0];
                cnt = tempArray[1];

                if (indx==numsSize-1) {
                    ans = cnt;
                }

                for (int j=1; j<=nums[indx]; j++) {
                    int nextIndx = indx+j;
                    if (nextIndx<numsSize && !visited[nextIndx]) {
                        q.offer(new int[]{nextIndx,cnt+1});
                        visited[nextIndx] = true;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        LC_45_jump_game_2.Solution sol = new LC_45_jump_game_2.Solution();
        System.out.println(sol.jump(new int[]{4,3,0,1,4}));
    }
}
